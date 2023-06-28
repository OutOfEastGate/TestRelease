package com.wht.client.obj;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("users")
@Data
public class UserDo {
    @TableId(type = IdType.AUTO)
    Long id;

    String userName;

    String displayName;

    String mail;

    String phone;

    String tag;

    String address;

    Date createTime;
}
