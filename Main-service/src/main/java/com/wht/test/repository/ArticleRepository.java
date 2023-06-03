package com.wht.test.repository;

import com.wht.client.obj.ArticleDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 13:35
 */
@Repository
public interface ArticleRepository extends MongoRepository<ArticleDo, String> {
}
