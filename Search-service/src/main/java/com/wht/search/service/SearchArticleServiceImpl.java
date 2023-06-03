package com.wht.search.service;

import com.wht.client.Result;
import com.wht.client.dto.AllArticlesDto;
import com.wht.client.servcice.SearchArticleService;
import com.wht.search.repository.EsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:45
 */
@Service
public class SearchArticleServiceImpl implements SearchArticleService {
    @Autowired
    EsRepository esRepository;

    public Mono<Result> searchArticle(String text) {
        Flux<AllArticlesDto> articlesDtoFlux = esRepository.searchArticle(text);
        List<AllArticlesDto> res = new ArrayList<>();
        articlesDtoFlux.subscribe(allArticlesDto -> {
            res.add(allArticlesDto);
        });
        return Mono.just(Result.success(res));
    }

    public void deleteArticle(String id) {
        esRepository.deleteArticle(id);
    }

    public void addArticle(String id) {
        esRepository.addOrUpdateArticle(id);
    }
}
