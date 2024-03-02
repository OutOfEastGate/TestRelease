package com.wht.client.dto.graph;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author wanghongtao
 * @data 2024/2/16 15:54
 */
@Builder
@Data
public class GraphDto {
    List<Node> nodes;
    List<Edge> edges;
}
