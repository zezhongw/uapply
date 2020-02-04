# uapply
U报名第二代后端代码

## U报名简介

1.由西电青鸢工作室设计开发的校园组织招新、面试、信息管理一体化解决方案

2.采用SpringBoot(2.2.4.RELEASE)(JDK版本11)框架

依赖:
* [Mybatis-plus](https://mp.baomidou.com/guide/#%E7%89%B9%E6%80%A7)
* [Smart-doc](https://gitee.com/sunyurepository/smart-doc/wikis/Home?sort_id=1652800)
* validation参数校验框架
* Redis
* JWT
* Lombok
* SpringAOP(进行日志记录)
* fastJSON

## 项目进度

1.微信小程序登录功能(已完成，待测试)

2.PC端登录功能(已经完成测试)

## 项目部署

## 数据库设计

### user(存储用户基本信息)
* user_id 用户全局唯一id
* user_name
* user_tel
* permission_id(权限id)
* department_id(部门id)
* user_pwd(用户密码)

### wxresponse(微信返回结果数据表)

此表存储调用微信接口返回的openid，session_key等一系列数据
* user_id 用户全局唯一id
* openid
* session_key
* unionid

### usertoken(存储用户token)

* user_id 用户全局唯一id
* token token