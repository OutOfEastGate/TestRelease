package com.wht.client.dto;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:41
 */
@Data
public class IpQueryDto {
    String status;
    String country;
    String countryCode;
    String city;
    String timezone;
}
