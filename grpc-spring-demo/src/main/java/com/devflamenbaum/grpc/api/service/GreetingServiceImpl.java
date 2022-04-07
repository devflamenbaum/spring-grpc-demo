package com.devflamenbaum.grpc.api.service;

import com.devflamenbaum.grpc.api.GreetingRequest;
import com.devflamenbaum.grpc.api.GreetingResponse;
import com.devflamenbaum.grpc.api.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);

        GreetingResponse response = GreetingResponse.newBuilder()
                                            .setMessage("Received your " + message +". Hello from server")
                                            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
