package com.volunteer.uapply.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


/**
 * 用户对象
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/1 13:26
 */
@Data
public class User {

    /**
     * 用户唯一id
     * @required
     */
    private Integer userId;


    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 电话
     */
    private String userTel;

    /**
     * 权限Id
     */
    private Integer permissionId;

    /**
     * 部门Id
     */
    private Integer departmentId;

    /**
     * PC端登录密码
     */
    private String userPwd;
}
