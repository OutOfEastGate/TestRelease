package com.wht.test.client.dto;

import lombok.Data;
import org.casbin.casdoor.entity.CasdoorUser;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 13:07
 */
@Data
public class LoginResultDto {
    String token;

    CasdoorUser casdoorUser;
}
