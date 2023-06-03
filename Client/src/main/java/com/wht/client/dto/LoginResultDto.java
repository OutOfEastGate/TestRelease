package com.wht.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.casbin.casdoor.entity.CasdoorUser;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 13:07
 */
@AllArgsConstructor
@Data
public class LoginResultDto {
    String token;

    CasdoorUser casdoorUser;

    public LoginResultDto() {
    }
}
