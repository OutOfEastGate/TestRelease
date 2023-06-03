package com.wht.search.repository;

import com.wht.client.obj.ArticleDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<ArticleDo, String> {
}