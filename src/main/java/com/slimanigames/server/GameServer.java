package com.slimanigames.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.slimanigames.service.GameService;

import java.io.IOException;

public class GameServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8088).addService(new GameService()).build();
        server.start();
        System.out.println("The server is running on port " + server.getPort());
        server.awaitTermination();
    }
}
