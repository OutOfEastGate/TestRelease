package com.wht.test.repository;

import com.wht.client.obj.IpDo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:19
 */
public interface IpRepository extends MongoRepository<IpDo,String> {
    IpDo findIpDoByIP(String ip);
}
