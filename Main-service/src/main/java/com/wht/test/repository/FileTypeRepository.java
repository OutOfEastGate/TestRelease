package com.wht.test.repository;

import com.wht.client.obj.FileTypeDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/10 21:21
 */
@Repository
public interface FileTypeRepository extends MongoRepository<FileTypeDo, String> {
}
