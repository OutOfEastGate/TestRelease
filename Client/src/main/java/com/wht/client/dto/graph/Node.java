package com.wht.client.dto.graph;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @author wanghongtao
 * @data 2024/2/16 15:56
 */
@Builder
@Data
public class Node {
    String shape;
    String id;
    String x;
    String y;
    String width;
    String height;
    String label;
    Map<String, Object> attrs;
}
