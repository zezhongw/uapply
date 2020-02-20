# U报名第二代开发文档

## 功能

### 微信小程序

#### 1.登录(已完成)

前端传进code，调用微信的接口，得到回应，插入数据库，生成唯一的userId，以及token然后返回给前端。

#### 2.报名

接受用户传进来的ApplyMessage对象，然后将userId，userName,userTel，user_sex、user_profession、user_college插入usermessage数据库，并把premissionId设置为默认的已经报名。同时将Applymessage插入applymessage数据库，其余的数据库都自动设置为默认值

#### 3. 查询面试状态

根据applymessage里面的一志愿状态和二志愿状态进行查询，二面有二面状态

#### 4.	查询面试数据

涉及到总的报名人数，各部门报名人数，以及个部门跨部的人数，男女人数，已经一面的人数，这些都在redis中完成。

#### 5.	查询简历

前端传进来用户的电话，根据电话去查usermessage里面的tel、sex、profession、college,然后根据电话去applymessage里面查用户的爱好，自我介绍组装成applymessage对象返回给前端。

#### 6.	简历打分(已完成)

将前端传过来的interviewmessage直接插入数据库，然后根据departmentId去查是第一志愿还是第二志愿，并修改相应的status

#### 7.二面签到

根据UserId将secondDepartmentId设置为departmentid

### PC端

#### 1. 登录(已完成)

检查有无token，前端传进来userTel和userPwd，去usermessage里面查对不对，如果对了，去token数据库里面查，返回token。

#### 2.管理员激活(已完成)

前端传进来user的信息和激活码，根据部门ID对比激活码，激活码一致，将信息插入usermessage数据库  

#### 3.	查看我的部员

在usermessage里面，根据departmentId和premessionId查询

#### 4.	发送录取通知(已完成)

用数组传进来电话或者userId，然后遍历数组，查询姓名，然后发送短信

#### 5.	查看一面待面

根据部门id和面试的status，返回applymessage对象

#### 6.	发送面试短信(已完成)

用数组传进来电话或者userId，然后遍历数组，查询姓名，然后发送短信

#### 7.	查询一面已面

根据部门二面，查询未面试的，然后根据userid遍历查询，各个部门一面的评价(评级以及各项评分)，组装成SearchInterview对象返回

#### 8.	通过一面

根据部门id，更改对应志愿status

#### 9.	淘汰一面

根据部门id，更改对应志愿status

#### 10.查询二面待面试

根据部门二面，查询未面试的，然后根据userid遍历查询，各个部门一面的评价(评级以及各项评分)，组装成SearchInterview对象返回

#### 11.发送二面通知短信(已完成)

用数组传进来电话或者userId，然后遍历数组，查询姓名，然后发送短信

#### 12.查询二面已经面试

根据部门二面，查询未面试的，然后根据userid遍历查询，各个部门一面的评价(评级以及各项评分)，组装成SearchInterview对象返回

#### 13.录取

更改二面的status，同时更改usemeassage里面的部门，以及premission

#### 14.淘汰

更改status

## 数据库

### user(存储用户基本信息)

* user_id 用户全局唯一id
* user_name 用户姓名
* user_sex 用户性别
* user_tel 用户电话
* permission_id(权限id)
* department_id(部门id)
* user_pwd(用户密码)
* user_college 学院
* user_profession 用户专业

### wxresponse(微信返回结果数据表)

此表存储调用微信接口返回的openid，session_key等一系列数据

* user_id 用户全局唯一id
* openid
* session_key
* unionid

### usertoken(存储用户token)

* user_id 用户全局唯一id
* token token

### invitecode(存储邀请码)

* invite_code 邀请码
* department_id 邀请码对应的部门

这两个在该数据库中都是唯一的

### applymessage(存储报名信息)

* user_id
* user_name
* user_tel
* user_sex 性别
* userStu_num 用户学号
* user_qq 用户qq
* user_college 学院
* user_profession 专业
* user_hobby 爱好
* user_introduction 自我介绍
* firstIntention_id 第一志愿的部门id
* first_status 第一志愿的状态
* secondIntention_id 第二志愿的部门id
* second_status 第二志愿的状态
* secondDepartment_id 二面在哪一个部门面试
* secondInterview_status 二面的状态

### interviewmessge(存储面试信息)

* user_id
* department_id
* character 性格
* param_score1
* param_score2
* param_score3
* param_score4
* param_score5
* param_score6
* note 备注
* overview 综合评价
* user_name 评价人姓名