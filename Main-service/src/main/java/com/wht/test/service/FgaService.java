package com.wht.test.service;

import com.wht.client.dto.fga.AllStoresRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(url = "${wht.fga.url}", name = "openFga")
public interface FgaService {
    @GetMapping("/stores")
    AllStoresRes getAllStores();
}
