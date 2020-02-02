package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.ToLog;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.impl.UserServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:35
 */
@RestController
public class LoginController {

    private UserServiceImpl userService;

    @ToLog("用户首次登录")
    @PostMapping("/login")
    public UniversalResponseBody<User> userLogin(@RequestBody String code){
        return userService.userWxLogin(code);
    }

}
