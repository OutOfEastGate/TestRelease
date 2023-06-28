package openfga.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
//@javax.annotation.Generated(
//    value = "by gRPC proto compiler (version 1.56.0)",
//    comments = "Source: openfga/v1/openfga_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OpenFGAServiceGrpc {

  private OpenFGAServiceGrpc() {}

  public static final String SERVICE_NAME = "openfga.v1.OpenFGAService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadRequest,
      openfga.v1.OpenfgaService.ReadResponse> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = openfga.v1.OpenfgaService.ReadRequest.class,
      responseType = openfga.v1.OpenfgaService.ReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadRequest,
      openfga.v1.OpenfgaService.ReadResponse> getReadMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadRequest, openfga.v1.OpenfgaService.ReadResponse> getReadMethod;
    if ((getReadMethod = OpenFGAServiceGrpc.getReadMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getReadMethod = OpenFGAServiceGrpc.getReadMethod) == null) {
          OpenFGAServiceGrpc.getReadMethod = getReadMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ReadRequest, openfga.v1.OpenfgaService.ReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("Read"))
              .build();
        }
      }
    }
    return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteRequest,
      openfga.v1.OpenfgaService.WriteResponse> getWriteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Write",
      requestType = openfga.v1.OpenfgaService.WriteRequest.class,
      responseType = openfga.v1.OpenfgaService.WriteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteRequest,
      openfga.v1.OpenfgaService.WriteResponse> getWriteMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteRequest, openfga.v1.OpenfgaService.WriteResponse> getWriteMethod;
    if ((getWriteMethod = OpenFGAServiceGrpc.getWriteMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getWriteMethod = OpenFGAServiceGrpc.getWriteMethod) == null) {
          OpenFGAServiceGrpc.getWriteMethod = getWriteMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.WriteRequest, openfga.v1.OpenfgaService.WriteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Write"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("Write"))
              .build();
        }
      }
    }
    return getWriteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CheckRequest,
      openfga.v1.OpenfgaService.CheckResponse> getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Check",
      requestType = openfga.v1.OpenfgaService.CheckRequest.class,
      responseType = openfga.v1.OpenfgaService.CheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CheckRequest,
      openfga.v1.OpenfgaService.CheckResponse> getCheckMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CheckRequest, openfga.v1.OpenfgaService.CheckResponse> getCheckMethod;
    if ((getCheckMethod = OpenFGAServiceGrpc.getCheckMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getCheckMethod = OpenFGAServiceGrpc.getCheckMethod) == null) {
          OpenFGAServiceGrpc.getCheckMethod = getCheckMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.CheckRequest, openfga.v1.OpenfgaService.CheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Check"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.CheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.CheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("Check"))
              .build();
        }
      }
    }
    return getCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ExpandRequest,
      openfga.v1.OpenfgaService.ExpandResponse> getExpandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Expand",
      requestType = openfga.v1.OpenfgaService.ExpandRequest.class,
      responseType = openfga.v1.OpenfgaService.ExpandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ExpandRequest,
      openfga.v1.OpenfgaService.ExpandResponse> getExpandMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ExpandRequest, openfga.v1.OpenfgaService.ExpandResponse> getExpandMethod;
    if ((getExpandMethod = OpenFGAServiceGrpc.getExpandMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getExpandMethod = OpenFGAServiceGrpc.getExpandMethod) == null) {
          OpenFGAServiceGrpc.getExpandMethod = getExpandMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ExpandRequest, openfga.v1.OpenfgaService.ExpandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Expand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ExpandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ExpandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("Expand"))
              .build();
        }
      }
    }
    return getExpandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest,
      openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> getReadAuthorizationModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadAuthorizationModels",
      requestType = openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest.class,
      responseType = openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest,
      openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> getReadAuthorizationModelsMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest, openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> getReadAuthorizationModelsMethod;
    if ((getReadAuthorizationModelsMethod = OpenFGAServiceGrpc.getReadAuthorizationModelsMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getReadAuthorizationModelsMethod = OpenFGAServiceGrpc.getReadAuthorizationModelsMethod) == null) {
          OpenFGAServiceGrpc.getReadAuthorizationModelsMethod = getReadAuthorizationModelsMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest, openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadAuthorizationModels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ReadAuthorizationModels"))
              .build();
        }
      }
    }
    return getReadAuthorizationModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelRequest,
      openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> getReadAuthorizationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadAuthorizationModel",
      requestType = openfga.v1.OpenfgaService.ReadAuthorizationModelRequest.class,
      responseType = openfga.v1.OpenfgaService.ReadAuthorizationModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelRequest,
      openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> getReadAuthorizationModelMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAuthorizationModelRequest, openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> getReadAuthorizationModelMethod;
    if ((getReadAuthorizationModelMethod = OpenFGAServiceGrpc.getReadAuthorizationModelMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getReadAuthorizationModelMethod = OpenFGAServiceGrpc.getReadAuthorizationModelMethod) == null) {
          OpenFGAServiceGrpc.getReadAuthorizationModelMethod = getReadAuthorizationModelMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ReadAuthorizationModelRequest, openfga.v1.OpenfgaService.ReadAuthorizationModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadAuthorizationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAuthorizationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAuthorizationModelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ReadAuthorizationModel"))
              .build();
        }
      }
    }
    return getReadAuthorizationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAuthorizationModelRequest,
      openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> getWriteAuthorizationModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteAuthorizationModel",
      requestType = openfga.v1.OpenfgaService.WriteAuthorizationModelRequest.class,
      responseType = openfga.v1.OpenfgaService.WriteAuthorizationModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAuthorizationModelRequest,
      openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> getWriteAuthorizationModelMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAuthorizationModelRequest, openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> getWriteAuthorizationModelMethod;
    if ((getWriteAuthorizationModelMethod = OpenFGAServiceGrpc.getWriteAuthorizationModelMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getWriteAuthorizationModelMethod = OpenFGAServiceGrpc.getWriteAuthorizationModelMethod) == null) {
          OpenFGAServiceGrpc.getWriteAuthorizationModelMethod = getWriteAuthorizationModelMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.WriteAuthorizationModelRequest, openfga.v1.OpenfgaService.WriteAuthorizationModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteAuthorizationModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteAuthorizationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteAuthorizationModelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("WriteAuthorizationModel"))
              .build();
        }
      }
    }
    return getWriteAuthorizationModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAssertionsRequest,
      openfga.v1.OpenfgaService.WriteAssertionsResponse> getWriteAssertionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteAssertions",
      requestType = openfga.v1.OpenfgaService.WriteAssertionsRequest.class,
      responseType = openfga.v1.OpenfgaService.WriteAssertionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAssertionsRequest,
      openfga.v1.OpenfgaService.WriteAssertionsResponse> getWriteAssertionsMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.WriteAssertionsRequest, openfga.v1.OpenfgaService.WriteAssertionsResponse> getWriteAssertionsMethod;
    if ((getWriteAssertionsMethod = OpenFGAServiceGrpc.getWriteAssertionsMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getWriteAssertionsMethod = OpenFGAServiceGrpc.getWriteAssertionsMethod) == null) {
          OpenFGAServiceGrpc.getWriteAssertionsMethod = getWriteAssertionsMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.WriteAssertionsRequest, openfga.v1.OpenfgaService.WriteAssertionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteAssertions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteAssertionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.WriteAssertionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("WriteAssertions"))
              .build();
        }
      }
    }
    return getWriteAssertionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAssertionsRequest,
      openfga.v1.OpenfgaService.ReadAssertionsResponse> getReadAssertionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadAssertions",
      requestType = openfga.v1.OpenfgaService.ReadAssertionsRequest.class,
      responseType = openfga.v1.OpenfgaService.ReadAssertionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAssertionsRequest,
      openfga.v1.OpenfgaService.ReadAssertionsResponse> getReadAssertionsMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadAssertionsRequest, openfga.v1.OpenfgaService.ReadAssertionsResponse> getReadAssertionsMethod;
    if ((getReadAssertionsMethod = OpenFGAServiceGrpc.getReadAssertionsMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getReadAssertionsMethod = OpenFGAServiceGrpc.getReadAssertionsMethod) == null) {
          OpenFGAServiceGrpc.getReadAssertionsMethod = getReadAssertionsMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ReadAssertionsRequest, openfga.v1.OpenfgaService.ReadAssertionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadAssertions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAssertionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadAssertionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ReadAssertions"))
              .build();
        }
      }
    }
    return getReadAssertionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadChangesRequest,
      openfga.v1.OpenfgaService.ReadChangesResponse> getReadChangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadChanges",
      requestType = openfga.v1.OpenfgaService.ReadChangesRequest.class,
      responseType = openfga.v1.OpenfgaService.ReadChangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadChangesRequest,
      openfga.v1.OpenfgaService.ReadChangesResponse> getReadChangesMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ReadChangesRequest, openfga.v1.OpenfgaService.ReadChangesResponse> getReadChangesMethod;
    if ((getReadChangesMethod = OpenFGAServiceGrpc.getReadChangesMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getReadChangesMethod = OpenFGAServiceGrpc.getReadChangesMethod) == null) {
          OpenFGAServiceGrpc.getReadChangesMethod = getReadChangesMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ReadChangesRequest, openfga.v1.OpenfgaService.ReadChangesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadChanges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ReadChangesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ReadChanges"))
              .build();
        }
      }
    }
    return getReadChangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CreateStoreRequest,
      openfga.v1.OpenfgaService.CreateStoreResponse> getCreateStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStore",
      requestType = openfga.v1.OpenfgaService.CreateStoreRequest.class,
      responseType = openfga.v1.OpenfgaService.CreateStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CreateStoreRequest,
      openfga.v1.OpenfgaService.CreateStoreResponse> getCreateStoreMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.CreateStoreRequest, openfga.v1.OpenfgaService.CreateStoreResponse> getCreateStoreMethod;
    if ((getCreateStoreMethod = OpenFGAServiceGrpc.getCreateStoreMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getCreateStoreMethod = OpenFGAServiceGrpc.getCreateStoreMethod) == null) {
          OpenFGAServiceGrpc.getCreateStoreMethod = getCreateStoreMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.CreateStoreRequest, openfga.v1.OpenfgaService.CreateStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.CreateStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.CreateStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("CreateStore"))
              .build();
        }
      }
    }
    return getCreateStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.UpdateStoreRequest,
      openfga.v1.OpenfgaService.UpdateStoreResponse> getUpdateStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStore",
      requestType = openfga.v1.OpenfgaService.UpdateStoreRequest.class,
      responseType = openfga.v1.OpenfgaService.UpdateStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.UpdateStoreRequest,
      openfga.v1.OpenfgaService.UpdateStoreResponse> getUpdateStoreMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.UpdateStoreRequest, openfga.v1.OpenfgaService.UpdateStoreResponse> getUpdateStoreMethod;
    if ((getUpdateStoreMethod = OpenFGAServiceGrpc.getUpdateStoreMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getUpdateStoreMethod = OpenFGAServiceGrpc.getUpdateStoreMethod) == null) {
          OpenFGAServiceGrpc.getUpdateStoreMethod = getUpdateStoreMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.UpdateStoreRequest, openfga.v1.OpenfgaService.UpdateStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.UpdateStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.UpdateStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("UpdateStore"))
              .build();
        }
      }
    }
    return getUpdateStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.DeleteStoreRequest,
      openfga.v1.OpenfgaService.DeleteStoreResponse> getDeleteStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStore",
      requestType = openfga.v1.OpenfgaService.DeleteStoreRequest.class,
      responseType = openfga.v1.OpenfgaService.DeleteStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.DeleteStoreRequest,
      openfga.v1.OpenfgaService.DeleteStoreResponse> getDeleteStoreMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.DeleteStoreRequest, openfga.v1.OpenfgaService.DeleteStoreResponse> getDeleteStoreMethod;
    if ((getDeleteStoreMethod = OpenFGAServiceGrpc.getDeleteStoreMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getDeleteStoreMethod = OpenFGAServiceGrpc.getDeleteStoreMethod) == null) {
          OpenFGAServiceGrpc.getDeleteStoreMethod = getDeleteStoreMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.DeleteStoreRequest, openfga.v1.OpenfgaService.DeleteStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.DeleteStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.DeleteStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("DeleteStore"))
              .build();
        }
      }
    }
    return getDeleteStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.GetStoreRequest,
      openfga.v1.OpenfgaService.GetStoreResponse> getGetStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStore",
      requestType = openfga.v1.OpenfgaService.GetStoreRequest.class,
      responseType = openfga.v1.OpenfgaService.GetStoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.GetStoreRequest,
      openfga.v1.OpenfgaService.GetStoreResponse> getGetStoreMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.GetStoreRequest, openfga.v1.OpenfgaService.GetStoreResponse> getGetStoreMethod;
    if ((getGetStoreMethod = OpenFGAServiceGrpc.getGetStoreMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getGetStoreMethod = OpenFGAServiceGrpc.getGetStoreMethod) == null) {
          OpenFGAServiceGrpc.getGetStoreMethod = getGetStoreMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.GetStoreRequest, openfga.v1.OpenfgaService.GetStoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.GetStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.GetStoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("GetStore"))
              .build();
        }
      }
    }
    return getGetStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListStoresRequest,
      openfga.v1.OpenfgaService.ListStoresResponse> getListStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStores",
      requestType = openfga.v1.OpenfgaService.ListStoresRequest.class,
      responseType = openfga.v1.OpenfgaService.ListStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListStoresRequest,
      openfga.v1.OpenfgaService.ListStoresResponse> getListStoresMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListStoresRequest, openfga.v1.OpenfgaService.ListStoresResponse> getListStoresMethod;
    if ((getListStoresMethod = OpenFGAServiceGrpc.getListStoresMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getListStoresMethod = OpenFGAServiceGrpc.getListStoresMethod) == null) {
          OpenFGAServiceGrpc.getListStoresMethod = getListStoresMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ListStoresRequest, openfga.v1.OpenfgaService.ListStoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ListStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ListStoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ListStores"))
              .build();
        }
      }
    }
    return getListStoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.StreamedListObjectsRequest,
      openfga.v1.OpenfgaService.StreamedListObjectsResponse> getStreamedListObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamedListObjects",
      requestType = openfga.v1.OpenfgaService.StreamedListObjectsRequest.class,
      responseType = openfga.v1.OpenfgaService.StreamedListObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.StreamedListObjectsRequest,
      openfga.v1.OpenfgaService.StreamedListObjectsResponse> getStreamedListObjectsMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.StreamedListObjectsRequest, openfga.v1.OpenfgaService.StreamedListObjectsResponse> getStreamedListObjectsMethod;
    if ((getStreamedListObjectsMethod = OpenFGAServiceGrpc.getStreamedListObjectsMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getStreamedListObjectsMethod = OpenFGAServiceGrpc.getStreamedListObjectsMethod) == null) {
          OpenFGAServiceGrpc.getStreamedListObjectsMethod = getStreamedListObjectsMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.StreamedListObjectsRequest, openfga.v1.OpenfgaService.StreamedListObjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamedListObjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.StreamedListObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.StreamedListObjectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("StreamedListObjects"))
              .build();
        }
      }
    }
    return getStreamedListObjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListObjectsRequest,
      openfga.v1.OpenfgaService.ListObjectsResponse> getListObjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListObjects",
      requestType = openfga.v1.OpenfgaService.ListObjectsRequest.class,
      responseType = openfga.v1.OpenfgaService.ListObjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListObjectsRequest,
      openfga.v1.OpenfgaService.ListObjectsResponse> getListObjectsMethod() {
    io.grpc.MethodDescriptor<openfga.v1.OpenfgaService.ListObjectsRequest, openfga.v1.OpenfgaService.ListObjectsResponse> getListObjectsMethod;
    if ((getListObjectsMethod = OpenFGAServiceGrpc.getListObjectsMethod) == null) {
      synchronized (OpenFGAServiceGrpc.class) {
        if ((getListObjectsMethod = OpenFGAServiceGrpc.getListObjectsMethod) == null) {
          OpenFGAServiceGrpc.getListObjectsMethod = getListObjectsMethod =
              io.grpc.MethodDescriptor.<openfga.v1.OpenfgaService.ListObjectsRequest, openfga.v1.OpenfgaService.ListObjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListObjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ListObjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  openfga.v1.OpenfgaService.ListObjectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OpenFGAServiceMethodDescriptorSupplier("ListObjects"))
              .build();
        }
      }
    }
    return getListObjectsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OpenFGAServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceStub>() {
        @java.lang.Override
        public OpenFGAServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OpenFGAServiceStub(channel, callOptions);
        }
      };
    return OpenFGAServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OpenFGAServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceBlockingStub>() {
        @java.lang.Override
        public OpenFGAServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OpenFGAServiceBlockingStub(channel, callOptions);
        }
      };
    return OpenFGAServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OpenFGAServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OpenFGAServiceFutureStub>() {
        @java.lang.Override
        public OpenFGAServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OpenFGAServiceFutureStub(channel, callOptions);
        }
      };
    return OpenFGAServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void read(openfga.v1.OpenfgaService.ReadRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     */
    default void write(openfga.v1.OpenfgaService.WriteRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteMethod(), responseObserver);
    }

    /**
     */
    default void check(openfga.v1.OpenfgaService.CheckRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
    }

    /**
     */
    default void expand(openfga.v1.OpenfgaService.ExpandRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ExpandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExpandMethod(), responseObserver);
    }

    /**
     */
    default void readAuthorizationModels(openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAuthorizationModelsMethod(), responseObserver);
    }

    /**
     */
    default void readAuthorizationModel(openfga.v1.OpenfgaService.ReadAuthorizationModelRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAuthorizationModelMethod(), responseObserver);
    }

    /**
     */
    default void writeAuthorizationModel(openfga.v1.OpenfgaService.WriteAuthorizationModelRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteAuthorizationModelMethod(), responseObserver);
    }

    /**
     */
    default void writeAssertions(openfga.v1.OpenfgaService.WriteAssertionsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAssertionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteAssertionsMethod(), responseObserver);
    }

    /**
     */
    default void readAssertions(openfga.v1.OpenfgaService.ReadAssertionsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAssertionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadAssertionsMethod(), responseObserver);
    }

    /**
     */
    default void readChanges(openfga.v1.OpenfgaService.ReadChangesRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadChangesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadChangesMethod(), responseObserver);
    }

    /**
     */
    default void createStore(openfga.v1.OpenfgaService.CreateStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CreateStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateStoreMethod(), responseObserver);
    }

    /**
     */
    default void updateStore(openfga.v1.OpenfgaService.UpdateStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.UpdateStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStoreMethod(), responseObserver);
    }

    /**
     */
    default void deleteStore(openfga.v1.OpenfgaService.DeleteStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.DeleteStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStoreMethod(), responseObserver);
    }

    /**
     */
    default void getStore(openfga.v1.OpenfgaService.GetStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.GetStoreResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStoreMethod(), responseObserver);
    }

    /**
     */
    default void listStores(openfga.v1.OpenfgaService.ListStoresRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListStoresResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListStoresMethod(), responseObserver);
    }

    /**
     */
    default void streamedListObjects(openfga.v1.OpenfgaService.StreamedListObjectsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.StreamedListObjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamedListObjectsMethod(), responseObserver);
    }

    /**
     */
    default void listObjects(openfga.v1.OpenfgaService.ListObjectsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListObjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListObjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OpenFGAService.
   */
  public static abstract class OpenFGAServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OpenFGAServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OpenFGAService.
   */
  public static final class OpenFGAServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OpenFGAServiceStub> {
    private OpenFGAServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenFGAServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OpenFGAServiceStub(channel, callOptions);
    }

    /**
     */
    public void read(openfga.v1.OpenfgaService.ReadRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void write(openfga.v1.OpenfgaService.WriteRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void check(openfga.v1.OpenfgaService.CheckRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void expand(openfga.v1.OpenfgaService.ExpandRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ExpandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExpandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAuthorizationModels(openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAuthorizationModelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAuthorizationModel(openfga.v1.OpenfgaService.ReadAuthorizationModelRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAuthorizationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeAuthorizationModel(openfga.v1.OpenfgaService.WriteAuthorizationModelRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteAuthorizationModelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeAssertions(openfga.v1.OpenfgaService.WriteAssertionsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAssertionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteAssertionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readAssertions(openfga.v1.OpenfgaService.ReadAssertionsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAssertionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadAssertionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readChanges(openfga.v1.OpenfgaService.ReadChangesRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadChangesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadChangesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createStore(openfga.v1.OpenfgaService.CreateStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CreateStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStore(openfga.v1.OpenfgaService.UpdateStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.UpdateStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteStore(openfga.v1.OpenfgaService.DeleteStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.DeleteStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStore(openfga.v1.OpenfgaService.GetStoreRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.GetStoreResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listStores(openfga.v1.OpenfgaService.ListStoresRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListStoresResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStoresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamedListObjects(openfga.v1.OpenfgaService.StreamedListObjectsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.StreamedListObjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamedListObjectsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listObjects(openfga.v1.OpenfgaService.ListObjectsRequest request,
        io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListObjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListObjectsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OpenFGAService.
   */
  public static final class OpenFGAServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OpenFGAServiceBlockingStub> {
    private OpenFGAServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenFGAServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OpenFGAServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ReadResponse read(openfga.v1.OpenfgaService.ReadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.WriteResponse write(openfga.v1.OpenfgaService.WriteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.CheckResponse check(openfga.v1.OpenfgaService.CheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ExpandResponse expand(openfga.v1.OpenfgaService.ExpandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExpandMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse readAuthorizationModels(openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAuthorizationModelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ReadAuthorizationModelResponse readAuthorizationModel(openfga.v1.OpenfgaService.ReadAuthorizationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAuthorizationModelMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.WriteAuthorizationModelResponse writeAuthorizationModel(openfga.v1.OpenfgaService.WriteAuthorizationModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteAuthorizationModelMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.WriteAssertionsResponse writeAssertions(openfga.v1.OpenfgaService.WriteAssertionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteAssertionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ReadAssertionsResponse readAssertions(openfga.v1.OpenfgaService.ReadAssertionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadAssertionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ReadChangesResponse readChanges(openfga.v1.OpenfgaService.ReadChangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadChangesMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.CreateStoreResponse createStore(openfga.v1.OpenfgaService.CreateStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.UpdateStoreResponse updateStore(openfga.v1.OpenfgaService.UpdateStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.DeleteStoreResponse deleteStore(openfga.v1.OpenfgaService.DeleteStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.GetStoreResponse getStore(openfga.v1.OpenfgaService.GetStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ListStoresResponse listStores(openfga.v1.OpenfgaService.ListStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStoresMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<openfga.v1.OpenfgaService.StreamedListObjectsResponse> streamedListObjects(
        openfga.v1.OpenfgaService.StreamedListObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamedListObjectsMethod(), getCallOptions(), request);
    }

    /**
     */
    public openfga.v1.OpenfgaService.ListObjectsResponse listObjects(openfga.v1.OpenfgaService.ListObjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListObjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OpenFGAService.
   */
  public static final class OpenFGAServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OpenFGAServiceFutureStub> {
    private OpenFGAServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenFGAServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OpenFGAServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ReadResponse> read(
        openfga.v1.OpenfgaService.ReadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.WriteResponse> write(
        openfga.v1.OpenfgaService.WriteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.CheckResponse> check(
        openfga.v1.OpenfgaService.CheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ExpandResponse> expand(
        openfga.v1.OpenfgaService.ExpandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExpandMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse> readAuthorizationModels(
        openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAuthorizationModelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ReadAuthorizationModelResponse> readAuthorizationModel(
        openfga.v1.OpenfgaService.ReadAuthorizationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAuthorizationModelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.WriteAuthorizationModelResponse> writeAuthorizationModel(
        openfga.v1.OpenfgaService.WriteAuthorizationModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteAuthorizationModelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.WriteAssertionsResponse> writeAssertions(
        openfga.v1.OpenfgaService.WriteAssertionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteAssertionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ReadAssertionsResponse> readAssertions(
        openfga.v1.OpenfgaService.ReadAssertionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadAssertionsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ReadChangesResponse> readChanges(
        openfga.v1.OpenfgaService.ReadChangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadChangesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.CreateStoreResponse> createStore(
        openfga.v1.OpenfgaService.CreateStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.UpdateStoreResponse> updateStore(
        openfga.v1.OpenfgaService.UpdateStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.DeleteStoreResponse> deleteStore(
        openfga.v1.OpenfgaService.DeleteStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.GetStoreResponse> getStore(
        openfga.v1.OpenfgaService.GetStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ListStoresResponse> listStores(
        openfga.v1.OpenfgaService.ListStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStoresMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<openfga.v1.OpenfgaService.ListObjectsResponse> listObjects(
        openfga.v1.OpenfgaService.ListObjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListObjectsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ = 0;
  private static final int METHODID_WRITE = 1;
  private static final int METHODID_CHECK = 2;
  private static final int METHODID_EXPAND = 3;
  private static final int METHODID_READ_AUTHORIZATION_MODELS = 4;
  private static final int METHODID_READ_AUTHORIZATION_MODEL = 5;
  private static final int METHODID_WRITE_AUTHORIZATION_MODEL = 6;
  private static final int METHODID_WRITE_ASSERTIONS = 7;
  private static final int METHODID_READ_ASSERTIONS = 8;
  private static final int METHODID_READ_CHANGES = 9;
  private static final int METHODID_CREATE_STORE = 10;
  private static final int METHODID_UPDATE_STORE = 11;
  private static final int METHODID_DELETE_STORE = 12;
  private static final int METHODID_GET_STORE = 13;
  private static final int METHODID_LIST_STORES = 14;
  private static final int METHODID_STREAMED_LIST_OBJECTS = 15;
  private static final int METHODID_LIST_OBJECTS = 16;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READ:
          serviceImpl.read((openfga.v1.OpenfgaService.ReadRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadResponse>) responseObserver);
          break;
        case METHODID_WRITE:
          serviceImpl.write((openfga.v1.OpenfgaService.WriteRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteResponse>) responseObserver);
          break;
        case METHODID_CHECK:
          serviceImpl.check((openfga.v1.OpenfgaService.CheckRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CheckResponse>) responseObserver);
          break;
        case METHODID_EXPAND:
          serviceImpl.expand((openfga.v1.OpenfgaService.ExpandRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ExpandResponse>) responseObserver);
          break;
        case METHODID_READ_AUTHORIZATION_MODELS:
          serviceImpl.readAuthorizationModels((openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse>) responseObserver);
          break;
        case METHODID_READ_AUTHORIZATION_MODEL:
          serviceImpl.readAuthorizationModel((openfga.v1.OpenfgaService.ReadAuthorizationModelRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAuthorizationModelResponse>) responseObserver);
          break;
        case METHODID_WRITE_AUTHORIZATION_MODEL:
          serviceImpl.writeAuthorizationModel((openfga.v1.OpenfgaService.WriteAuthorizationModelRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAuthorizationModelResponse>) responseObserver);
          break;
        case METHODID_WRITE_ASSERTIONS:
          serviceImpl.writeAssertions((openfga.v1.OpenfgaService.WriteAssertionsRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.WriteAssertionsResponse>) responseObserver);
          break;
        case METHODID_READ_ASSERTIONS:
          serviceImpl.readAssertions((openfga.v1.OpenfgaService.ReadAssertionsRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadAssertionsResponse>) responseObserver);
          break;
        case METHODID_READ_CHANGES:
          serviceImpl.readChanges((openfga.v1.OpenfgaService.ReadChangesRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ReadChangesResponse>) responseObserver);
          break;
        case METHODID_CREATE_STORE:
          serviceImpl.createStore((openfga.v1.OpenfgaService.CreateStoreRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.CreateStoreResponse>) responseObserver);
          break;
        case METHODID_UPDATE_STORE:
          serviceImpl.updateStore((openfga.v1.OpenfgaService.UpdateStoreRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.UpdateStoreResponse>) responseObserver);
          break;
        case METHODID_DELETE_STORE:
          serviceImpl.deleteStore((openfga.v1.OpenfgaService.DeleteStoreRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.DeleteStoreResponse>) responseObserver);
          break;
        case METHODID_GET_STORE:
          serviceImpl.getStore((openfga.v1.OpenfgaService.GetStoreRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.GetStoreResponse>) responseObserver);
          break;
        case METHODID_LIST_STORES:
          serviceImpl.listStores((openfga.v1.OpenfgaService.ListStoresRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListStoresResponse>) responseObserver);
          break;
        case METHODID_STREAMED_LIST_OBJECTS:
          serviceImpl.streamedListObjects((openfga.v1.OpenfgaService.StreamedListObjectsRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.StreamedListObjectsResponse>) responseObserver);
          break;
        case METHODID_LIST_OBJECTS:
          serviceImpl.listObjects((openfga.v1.OpenfgaService.ListObjectsRequest) request,
              (io.grpc.stub.StreamObserver<openfga.v1.OpenfgaService.ListObjectsResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ReadRequest,
              openfga.v1.OpenfgaService.ReadResponse>(
                service, METHODID_READ)))
        .addMethod(
          getWriteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.WriteRequest,
              openfga.v1.OpenfgaService.WriteResponse>(
                service, METHODID_WRITE)))
        .addMethod(
          getCheckMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.CheckRequest,
              openfga.v1.OpenfgaService.CheckResponse>(
                service, METHODID_CHECK)))
        .addMethod(
          getExpandMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ExpandRequest,
              openfga.v1.OpenfgaService.ExpandResponse>(
                service, METHODID_EXPAND)))
        .addMethod(
          getReadAuthorizationModelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ReadAuthorizationModelsRequest,
              openfga.v1.OpenfgaService.ReadAuthorizationModelsResponse>(
                service, METHODID_READ_AUTHORIZATION_MODELS)))
        .addMethod(
          getReadAuthorizationModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ReadAuthorizationModelRequest,
              openfga.v1.OpenfgaService.ReadAuthorizationModelResponse>(
                service, METHODID_READ_AUTHORIZATION_MODEL)))
        .addMethod(
          getWriteAuthorizationModelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.WriteAuthorizationModelRequest,
              openfga.v1.OpenfgaService.WriteAuthorizationModelResponse>(
                service, METHODID_WRITE_AUTHORIZATION_MODEL)))
        .addMethod(
          getWriteAssertionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.WriteAssertionsRequest,
              openfga.v1.OpenfgaService.WriteAssertionsResponse>(
                service, METHODID_WRITE_ASSERTIONS)))
        .addMethod(
          getReadAssertionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ReadAssertionsRequest,
              openfga.v1.OpenfgaService.ReadAssertionsResponse>(
                service, METHODID_READ_ASSERTIONS)))
        .addMethod(
          getReadChangesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ReadChangesRequest,
              openfga.v1.OpenfgaService.ReadChangesResponse>(
                service, METHODID_READ_CHANGES)))
        .addMethod(
          getCreateStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.CreateStoreRequest,
              openfga.v1.OpenfgaService.CreateStoreResponse>(
                service, METHODID_CREATE_STORE)))
        .addMethod(
          getUpdateStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.UpdateStoreRequest,
              openfga.v1.OpenfgaService.UpdateStoreResponse>(
                service, METHODID_UPDATE_STORE)))
        .addMethod(
          getDeleteStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.DeleteStoreRequest,
              openfga.v1.OpenfgaService.DeleteStoreResponse>(
                service, METHODID_DELETE_STORE)))
        .addMethod(
          getGetStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.GetStoreRequest,
              openfga.v1.OpenfgaService.GetStoreResponse>(
                service, METHODID_GET_STORE)))
        .addMethod(
          getListStoresMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ListStoresRequest,
              openfga.v1.OpenfgaService.ListStoresResponse>(
                service, METHODID_LIST_STORES)))
        .addMethod(
          getStreamedListObjectsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.StreamedListObjectsRequest,
              openfga.v1.OpenfgaService.StreamedListObjectsResponse>(
                service, METHODID_STREAMED_LIST_OBJECTS)))
        .addMethod(
          getListObjectsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              openfga.v1.OpenfgaService.ListObjectsRequest,
              openfga.v1.OpenfgaService.ListObjectsResponse>(
                service, METHODID_LIST_OBJECTS)))
        .build();
  }

  private static abstract class OpenFGAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OpenFGAServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return openfga.v1.OpenfgaService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OpenFGAService");
    }
  }

  private static final class OpenFGAServiceFileDescriptorSupplier
      extends OpenFGAServiceBaseDescriptorSupplier {
    OpenFGAServiceFileDescriptorSupplier() {}
  }

  private static final class OpenFGAServiceMethodDescriptorSupplier
      extends OpenFGAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OpenFGAServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OpenFGAServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OpenFGAServiceFileDescriptorSupplier())
              .addMethod(getReadMethod())
              .addMethod(getWriteMethod())
              .addMethod(getCheckMethod())
              .addMethod(getExpandMethod())
              .addMethod(getReadAuthorizationModelsMethod())
              .addMethod(getReadAuthorizationModelMethod())
              .addMethod(getWriteAuthorizationModelMethod())
              .addMethod(getWriteAssertionsMethod())
              .addMethod(getReadAssertionsMethod())
              .addMethod(getReadChangesMethod())
              .addMethod(getCreateStoreMethod())
              .addMethod(getUpdateStoreMethod())
              .addMethod(getDeleteStoreMethod())
              .addMethod(getGetStoreMethod())
              .addMethod(getListStoresMethod())
              .addMethod(getStreamedListObjectsMethod())
              .addMethod(getListObjectsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
