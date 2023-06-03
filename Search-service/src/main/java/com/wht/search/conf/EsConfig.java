package com.wht.search.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:31
 */
@Configuration
public class EsConfig {
    @Value("${spring.elasticsearch.uri}")
    String esUri;
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(HttpHost.create(esUri)));
        return restHighLevelClient;
    }
}
