package com.slimanigames.service;

import com.slimanigames.stubs.Game;
import com.slimanigames.stubs.GameServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    private int number = (int)(Math.random()*1000);
    private HashMap<String, StreamObserver<Game.response>> userList = new HashMap<>();
    private boolean isGameOver = false;

    public GameService(){
        System.out.println("The game started. The number is " + number);
    }

    @Override
    public StreamObserver<Game.request> session(StreamObserver<Game.response> responseObserver) {
        return new StreamObserver<Game.request>() {
            @Override
            public void onNext(Game.request request) {
                String userName = request.getUserName();
                int guessedNumber = request.getGuessedNumber();
                Game.RequestType requestType = request.getRequestType();

                // Check if the user is new
                if(!userList.containsKey(userName) || requestType == Game.RequestType.NEW_USER){
                    userList.put(userName, responseObserver);
                    System.out.println("|New user just joined| Name : " + userName);
                    // Respond to user
                    Game.response response = Game.response.newBuilder()
                            .setServerResponse("Welcome to Guess The Number game\n Try to guess a number from 0 to 1000")
                            .setResponseType(Game.ResponseType.WELCOME)
                            .build();
                    responseObserver.onNext(response);
                }
                else {
                    // Check if guessedNumber correct
                    if (number == guessedNumber) {
                        // Change game status
                        isGameOver = true;

                        // Respond to the winner
                        Game.response response = Game.response.newBuilder()
                                .setServerResponse("Congrats! You win the game.")
                                .setResponseType(Game.ResponseType.YOU_WIN)
                                .build();
                        responseObserver.onNext(response);

                        // Respond to the rest of users
                        userList.forEach((user, streamObserver) -> {
                            if (!userName.equals(user)) {
                                String serverResponse = "The game is over. The winner is " + userName;
                                Game.response response1 = Game.response.newBuilder()
                                        .setServerResponse(serverResponse)
                                        .setResponseType(Game.ResponseType.GAME_IS_OVER)
                                        .build();
                                streamObserver.onNext(response1);
                            }
                        });

                        // End the game
                        onCompleted();
                    } else {
                        // Create the response
                        String serverResponse;
                        if (number > guessedNumber) {
                            serverResponse = "The number is higher than " + guessedNumber;
                        } else {
                            serverResponse = "The number is lower than " + guessedNumber;
                        }

                        // Send the response
                        Game.response response = Game.response.newBuilder()
                                .setServerResponse(serverResponse)
                                .setResponseType(Game.ResponseType.YOU_MISSED_THE_NUMBER)
                                .build();
                        responseObserver.onNext(response);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                // Terminate session with users
                userList.forEach((user, streamObserver) -> {
                    streamObserver.onCompleted();
                });

                // Clear the list of users
                userList.clear();

                // Generate a new number
                number = (int)(Math.random()*1000);
                System.out.println("New number is " + number);
            }
        };
    }
}
