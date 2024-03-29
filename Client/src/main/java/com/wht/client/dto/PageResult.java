package com.wht.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/13 11:07
 */
@AllArgsConstructor
@Data
public class PageResult<T> {
    Integer currentPage;
    Integer pageSize;
    Long total;
    T data;
}
