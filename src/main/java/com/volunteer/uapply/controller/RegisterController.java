package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.ToLog;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 郭树耸
 * @version 1.0
 * @date 2020/1/31 10:54
 */
@RestController
@Slf4j
public class RegisterController {


    /**
     * 用户注册
     * @param user
     * @return
     */
    @ToLog("用户注册")
    @PostMapping("/register")
    public UniversalResponseBody<User> userRegister(@RequestBody User user){
        return null;
    }
}
