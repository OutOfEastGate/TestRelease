// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: openfga/v1/openapi.proto

package openfga.v1;

public final class Openapi {
  private Openapi() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030openfga/v1/openapi.proto\022\nopenfga.v1\032." +
      "protoc-gen-openapiv2/options/annotations" +
      ".protoB\323\004\222A\317\004\022\200\002\n\007OpenFGA\022uA high perfor" +
      "mance and flexible authorization/permiss" +
      "ion engine built for developers and insp" +
      "ired by Google Zanzibar.\"5\n\007OpenFGA\022\023htt" +
      "ps://openfga.dev\032\025community@openfga.dev*" +
      "B\n\nApache-2.0\0224https://github.com/openfg" +
      "a/openfga/blob/main/LICENSE2\0030.1*\001\0022\020app" +
      "lication/json:\020application/jsonR]\n\003400\022V" +
      "\n$Request failed due to invalid input.\022." +
      "\n,\032*.openfga.v1.ValidationErrorMessageRe" +
      "sponseR_\n\003404\022X\n%Request failed due to i" +
      "ncorrect path.\022/\n-\032+.openfga.v1.PathUnkn" +
      "ownErrorMessageResponseRc\n\003500\022\\\n,Reques" +
      "t failed due to internal server error.\022," +
      "\n*\032(.openfga.v1.InternalErrorMessageResp" +
      "onseb\006proto3"
    };
//    descriptor = com.google.protobuf.Descriptors.FileDescriptor
//      .internalBuildGeneratedFileFrom(descriptorData,
//        new com.google.protobuf.Descriptors.FileDescriptor[] {
//          grpc.gateway.protoc_gen_openapiv2.options.Annotations.getDescriptor(),
//        });
//    com.google.protobuf.ExtensionRegistry registry =
//        com.google.protobuf.ExtensionRegistry.newInstance();
//    registry.add(grpc.gateway.protoc_gen_openapiv2.options.Annotations.openapiv2Swagger);
//    com.google.protobuf.Descriptors.FileDescriptor
//        .internalUpdateFileDescriptor(descriptor, registry);
//    grpc.gateway.protoc_gen_openapiv2.options.Annotations.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
