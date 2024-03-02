package com.wht.client.dto.graph;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wanghongtao
 * @data 2024/2/16 15:56
 */
@Builder
@Data
public class Edge {
    String source;
    String target;
    String shape;
    Map<String, Object> attrs;
    List<Map<String, Object>> labels;
}
