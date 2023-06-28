package com.wht.client.dto.fga;

import lombok.Data;

@Data
public class AllStoresRes {
    Store[] stores;

    String continuation_token;
}
