package com.wht.test.repository;


import com.wht.client.obj.WebsiteDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<WebsiteDo, String> {
}
