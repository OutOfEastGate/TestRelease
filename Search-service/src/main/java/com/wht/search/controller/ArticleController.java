package com.wht.search.controller;

import com.wht.client.Result;
import com.wht.client.servcice.SearchArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:34
 */
@RequestMapping("/api/search")
@RestController
public class ArticleController {
    @Autowired
    SearchArticleService searchArticleService;

    /**
     * 搜索文章
     * @param text
     * @return
     */
    @GetMapping("/article")
    public Mono<Result> searchArticle(String text) {
        return searchArticleService.searchArticle(text);
    }

    @PostMapping("/deleteArticle")
    public Mono<Result> deleteArticle(String id) {
        searchArticleService.deleteArticle(id);
        return Mono.just(Result.success());
    }

    @PostMapping("/addArticle")
    public Mono<Result> addArticle(String id) {
        searchArticleService.addArticle(id);
        return Mono.just(Result.success());
    }
}
