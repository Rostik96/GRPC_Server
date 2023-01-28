package com.rost;

import java.io.IOException;

import com.rost.services.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(GreetingServiceImpl.instance())
                .build();

        server.start();
        System.out.println("Server has started! ;)");
        server.awaitTermination();
    }
}
