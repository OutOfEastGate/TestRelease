package com.wht.search.repository;

import com.alibaba.fastjson.JSON;
import com.wht.client.dto.AllArticlesDto;
import com.wht.client.obj.ArticleDo;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:58
 */
@Repository
public class EsRepository {
    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Autowired
    ArticleRepository articleRepository;

    public Flux<AllArticlesDto> searchArticle(String text) {
        if (text == null || "".equals(text)) return Flux.empty();

        MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(text, "title","content","description");
        SearchRequest request = new SearchRequest("article");
        request.source().query(query);
        SearchResponse searchRes = null;
        try {
            searchRes = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchHits searchHits = searchRes.getHits();
        List<AllArticlesDto> res = new ArrayList<>();
        Flux.fromIterable(Arrays.asList(searchHits.getHits())).subscribe(hit->{
            AllArticlesDto articlesDto = JSON.parseObject(hit.getSourceAsString(), AllArticlesDto.class);
            res.add(articlesDto);
        });

        return Flux.fromIterable(res);
    }

    public boolean deleteArticle(String id) {
        if (id == null || "".equals(id)) return false;

        DeleteRequest deleteRequest = new DeleteRequest("article");
        deleteRequest.id(id);
        try {
            restHighLevelClient.delete(deleteRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addOrUpdateArticle(String id) {
        Optional<ArticleDo> articleDoOptional = articleRepository.findById(id);
        if (!articleDoOptional.isPresent()) return false;

        IndexRequest request = new IndexRequest("article");
        request.id(id);
        request.source(JSON.toJSONString(articleDoOptional.get()), XContentType.JSON);
        try {
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
