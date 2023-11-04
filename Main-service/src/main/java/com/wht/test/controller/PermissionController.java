package com.wht.test.controller;

import com.alibaba.fastjson.JSON;
import com.wht.client.Result;
import com.wht.client.dto.fga.AllStoresRes;
import com.wht.test.service.FgaService;
import lombok.AllArgsConstructor;
import openfga.v1.OpenFGAServiceGrpc;
import openfga.v1.Openfga;
import openfga.v1.OpenfgaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    private final FgaService fgaService;

    private final OpenFGAServiceGrpc.OpenFGAServiceBlockingStub fgaServiceBlockingStub;


    @GetMapping("/getAllStores")
    public Result<AllStoresRes> getAllStores() {
        return Result.success(fgaService.getAllStores());
    }

    @GetMapping("/{store_id}/getAllModels")
    public Result<Object> getAllModels(@PathVariable("store_id") String store_id) {
        return Result.success(fgaService.getAllModels(store_id));
    }

    @GetMapping("/grpc/getAllStores")
    public Result<List<Openfga.Store>> grpcGetAllStores() {
        OpenfgaService.ListStoresRequest listStoresRequest = OpenfgaService.ListStoresRequest.newBuilder()
                .build();
        OpenfgaService.ListStoresResponse listStoresResponse = fgaServiceBlockingStub.listStores(listStoresRequest);
        List<Openfga.Store> storesList = listStoresResponse.getStoresList();
        return Result.success(storesList);
    }
}
