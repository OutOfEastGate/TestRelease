package com.wht.test.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wht.client.obj.UserDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDo> {
}