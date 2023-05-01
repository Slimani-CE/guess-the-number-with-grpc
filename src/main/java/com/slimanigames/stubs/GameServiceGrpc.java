package com.slimanigames.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: game.proto")
public final class GameServiceGrpc {

  private GameServiceGrpc() {}

  public static final String SERVICE_NAME = "GameService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.request,
      com.slimanigames.stubs.Game.response> getSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "session",
      requestType = com.slimanigames.stubs.Game.request.class,
      responseType = com.slimanigames.stubs.Game.response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.request,
      com.slimanigames.stubs.Game.response> getSessionMethod() {
    io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.request, com.slimanigames.stubs.Game.response> getSessionMethod;
    if ((getSessionMethod = GameServiceGrpc.getSessionMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getSessionMethod = GameServiceGrpc.getSessionMethod) == null) {
          GameServiceGrpc.getSessionMethod = getSessionMethod = 
              io.grpc.MethodDescriptor.<com.slimanigames.stubs.Game.request, com.slimanigames.stubs.Game.response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "GameService", "session"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.slimanigames.stubs.Game.request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.slimanigames.stubs.Game.response.getDefaultInstance()))
                  .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("session"))
                  .build();
          }
        }
     }
     return getSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.Empty,
      com.slimanigames.stubs.Game.Empty> getBlablaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "blabla",
      requestType = com.slimanigames.stubs.Game.Empty.class,
      responseType = com.slimanigames.stubs.Game.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.Empty,
      com.slimanigames.stubs.Game.Empty> getBlablaMethod() {
    io.grpc.MethodDescriptor<com.slimanigames.stubs.Game.Empty, com.slimanigames.stubs.Game.Empty> getBlablaMethod;
    if ((getBlablaMethod = GameServiceGrpc.getBlablaMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getBlablaMethod = GameServiceGrpc.getBlablaMethod) == null) {
          GameServiceGrpc.getBlablaMethod = getBlablaMethod = 
              io.grpc.MethodDescriptor.<com.slimanigames.stubs.Game.Empty, com.slimanigames.stubs.Game.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GameService", "blabla"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.slimanigames.stubs.Game.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.slimanigames.stubs.Game.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("blabla"))
                  .build();
          }
        }
     }
     return getBlablaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameServiceStub newStub(io.grpc.Channel channel) {
    return new GameServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GameServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GameServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GameServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.request> session(
        io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.response> responseObserver) {
      return asyncUnimplementedStreamingCall(getSessionMethod(), responseObserver);
    }

    /**
     */
    public void blabla(com.slimanigames.stubs.Game.Empty request,
        io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getBlablaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSessionMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.slimanigames.stubs.Game.request,
                com.slimanigames.stubs.Game.response>(
                  this, METHODID_SESSION)))
          .addMethod(
            getBlablaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.slimanigames.stubs.Game.Empty,
                com.slimanigames.stubs.Game.Empty>(
                  this, METHODID_BLABLA)))
          .build();
    }
  }

  /**
   */
  public static final class GameServiceStub extends io.grpc.stub.AbstractStub<GameServiceStub> {
    private GameServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.request> session(
        io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSessionMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void blabla(com.slimanigames.stubs.Game.Empty request,
        io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBlablaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GameServiceBlockingStub extends io.grpc.stub.AbstractStub<GameServiceBlockingStub> {
    private GameServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.slimanigames.stubs.Game.Empty blabla(com.slimanigames.stubs.Game.Empty request) {
      return blockingUnaryCall(
          getChannel(), getBlablaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GameServiceFutureStub extends io.grpc.stub.AbstractStub<GameServiceFutureStub> {
    private GameServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GameServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GameServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.slimanigames.stubs.Game.Empty> blabla(
        com.slimanigames.stubs.Game.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getBlablaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BLABLA = 0;
  private static final int METHODID_SESSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BLABLA:
          serviceImpl.blabla((com.slimanigames.stubs.Game.Empty) request,
              (io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SESSION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.session(
              (io.grpc.stub.StreamObserver<com.slimanigames.stubs.Game.response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.slimanigames.stubs.Game.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameService");
    }
  }

  private static final class GameServiceFileDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier {
    GameServiceFileDescriptorSupplier() {}
  }

  private static final class GameServiceMethodDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameServiceFileDescriptorSupplier())
              .addMethod(getSessionMethod())
              .addMethod(getBlablaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
