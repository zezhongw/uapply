package com.volunteer.uapply.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 微信用户对象
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/1 13:26
 */
@Data
public class User {

    /**
     * 数据递增Id
     * @ignore
     */
    @JSONField(serialize = false)
    private Integer userId;

    /**
     * 用户唯一标识
     */
    private String openid;


    /**
     * 权限Id
     */
    private Integer permissionId;
}
