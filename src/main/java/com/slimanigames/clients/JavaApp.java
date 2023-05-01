package com.slimanigames.clients;

import com.slimanigames.service.GameService;
import com.slimanigames.stubs.Game;
import com.slimanigames.stubs.GameServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class JavaApp {
    private static String userName;
    private static GameServiceGrpc.GameServiceStub stub;
    private static StreamObserver<Game.request> requestObserver;
    private static Scanner sc;
    private static boolean isGameOver;

    public static void main(String[] args) {
        // Connect to server
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8088).usePlaintext().build();
        stub = GameServiceGrpc.newStub(managedChannel);
        sc = new Scanner(System.in);
        isGameOver = false;
        while (!isGameOver){
            System.out.println("1: Enter the game");
            System.out.println("2: Exit game");
            System.out.print("Enter your choice: ");
            int answer = sc.nextInt();
            switch (answer){
                case 1 : startSession(); break;
                case 2 : isGameOver = true; break;
                default:
                    System.out.println("Command not valid!!");
            }
        }
        sc.close();
    }

    // Start new session with the service
    private static void startSession() {
        isGameOver = false;
        requestObserver = stub.session(new StreamObserver<Game.response>() {
            @Override
            public void onNext(Game.response response) {
                String serverResponse = response.getServerResponse();
                Game.ResponseType responseType = response.getResponseType();
                System.out.println(serverResponse);
                if(responseType == Game.ResponseType.GAME_IS_OVER || responseType == Game.ResponseType.YOU_WIN){
                    isGameOver = true;
                    // Exit session
                    onCompleted();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                requestObserver.onCompleted();
            }
        });

        // Enter the session
        System.out.print("Enter your name: ");
        userName = sc.next();
        System.out.println("test");
        Game.request request = Game.request.newBuilder()
                .setRequestType(Game.RequestType.NEW_USER)
                .setUserName(userName)
                .build();
        requestObserver.onNext(request);

        while(!isGameOver){
            System.out.print("Guess a number: ");
            int guessedNumber = sc.nextInt();
            request = Game.request.newBuilder()
                    .setUserName(userName)
                    .setRequestType(Game.RequestType.GUESSING_NUMBER)
                    .setGuessedNumber(guessedNumber)
                    .build();
            requestObserver.onNext(request);

            // Wait for server response
            while (!isGameOver) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isGameOver) {
                    break;
                }
            }
        }
    }
}
