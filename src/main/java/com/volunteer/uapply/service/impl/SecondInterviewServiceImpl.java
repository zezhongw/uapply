package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 桂乙侨
 * @version 2.0
 * @date 2020/2/8 13:54
 */
@Service
public class SecondInterviewServiceImpl implements SecondInterviewService {

    @Resource
    private ApplyMsgMapper applyMsgMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UniversalResponseBody SecondCheck(String userTel, Integer departmentId) {
        if (applyMsgMapper.UpdateSecondDepartment(userTel,departmentId)>0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

    @Override
    public UniversalResponseBody<List<User>> listUserUnSecondInterview(Integer departmentId) {
        List<User> users = applyMsgMapper.listUserUnSecondInterview(departmentId);
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),users);
    }

    @Override
    public UniversalResponseBody<List<User>> listUserSecondedInterviewed(Integer departmentId) {
        List<User> users = applyMsgMapper.listUserSecondedInterviewed(departmentId);
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),users);
    }

    @Override
    public UniversalResponseBody EnrollMembers(Integer[] userId,Integer departmentId) {
        List<User> users = applyMsgMapper.listUserEnrollMembers(userId,departmentId);
        Optional.ofNullable(users).orElseThrow(()->new RuntimeException("你未选中录取的部员！"));
        userMapper.insertBatch(users);
        return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
    }

    @Override
    public UniversalResponseBody SecondEliminate(Integer userId, Integer departmentId) {
        applyMsgMapper.SecondEliminate(userId,departmentId);
        return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
    }
}
