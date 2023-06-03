package com.wht.client.servcice;

import com.wht.client.Result;
import reactor.core.publisher.Mono;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 15:44
 */
public interface SearchArticleService {
    Mono<Result> searchArticle(String text);

    void deleteArticle(String id);

    void addArticle(String id);
}
