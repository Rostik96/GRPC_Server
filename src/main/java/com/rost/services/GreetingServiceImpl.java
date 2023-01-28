package com.rost.services;

import com.rost.grpc.GreetingServiceGrpc;
import com.rost.grpc.GreetingServiceOuterClass.HelloRequest;
import com.rost.grpc.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest req, StreamObserver<HelloResponse> respObserver) {
        System.out.println(req);
        HelloResponse resp = HelloResponse.newBuilder()
                .setGreeting("Hello from server, " + req.getName())
                .build();
        respObserver.onNext(resp);
        respObserver.onCompleted();
    }
}
