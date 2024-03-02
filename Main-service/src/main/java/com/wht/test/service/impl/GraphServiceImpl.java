package com.wht.test.service.impl;

import com.wht.client.dto.graph.Edge;
import com.wht.client.dto.graph.GraphDto;
import com.wht.client.dto.graph.Node;
import com.wht.test.service.GraphService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghongtao
 * @data 2024/2/16 15:52
 */
@Service
public class GraphServiceImpl implements GraphService {

    @Override
    public GraphDto getGraphView() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(Node.builder()
                        .shape("ellipse")
                        .id("node1")
                        .label("WHT")
                        .x("1")
                        .y("2")
                        .width("80")
                        .height("40")
                        .attrs(getNodeAttrs())
                        .build());
        nodes.add(Node.builder()
                .shape("ellipse")
                .id("node2")
                .x("1")
                .y("2")
                .width("80")
                .height("40")
                .label("快手")
                .attrs(getNodeAttrs())
                .build());
        List<Edge> edges = new ArrayList<>();
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("line", Map.of("stroke", "#ccc"));
        edges.add(Edge.builder()
                        .source("node1")
                        .target("node2")
                        .shape("custom-edge-label")
                        .attrs(attrs)
                .build());
        return GraphDto.builder()
                .nodes(nodes)
                .edges(edges)
                .build();
    }

    private Map<String, Object> getNodeAttrs() {
        return Map.of("body", Map.of("fill", "#efdbff", "stroke", "#9254de"));
    }
}
