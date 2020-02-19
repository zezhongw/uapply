package com.volunteer.uapply.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @Excel(name = "用户Id", orderNum = "0")
    private Integer userId;


    /**
     * 用户姓名
     */
    @Excel(name = "姓名", orderNum = "1")
    private String userName;


    /**
     * 用户性别
     */
    @Excel(name = "姓名", orderNum = "2")
    private String userSex;

    /**
     * 电话
     */
    @Excel(name = "电话", orderNum = "3")
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

    /**
     * 用户专业
     */
    @Excel(name = "专业", orderNum = "5")
    private String userProfession;

    /**
     * 学院
     */
    @Excel(name = "学院", orderNum = "4")
    private String userCollege;
}
