package com.wht.test.repository;

import com.wht.client.obj.FileInfoDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 17:08
 */
@Repository
public interface FileInfoRepository extends MongoRepository<FileInfoDo,String> {
    FileInfoDo findByUrl(String url);

    List<FileInfoDo> findAllByObjectType(String type);

    Long deleteByUrl(String url);

}
