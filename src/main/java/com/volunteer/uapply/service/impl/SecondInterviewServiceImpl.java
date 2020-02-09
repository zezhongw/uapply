package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 桂乙侨
 * @version 1.0
 * @date 2020/2/8 13:54
 */
@Service
@Slf4j
public class SecondInterviewServiceImpl implements SecondInterviewService {

    @Resource
    private ApplyMsgMapper applyMsgMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public UniversalResponseBody SecondCheck(String userTel, Integer departmentId) {
        if (applyMsgMapper.UpdateSecondDepartment(userTel,departmentId)>0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            log.error("二面签到服务处，数据库更新出错！");
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

    @Override
    public UniversalResponseBody<List<User>> listUserUnSecondInterview(Integer departmentId) {
        List<User> users = applyMsgMapper.listUserUnSecondInterview(departmentId);
        if(users == null){
            //可能查询结果 实际为空
            log.error("查询二面待面试人员失败，数据库查询结果为0；查询结果可能 实际为空 或 数据库查询错误！");
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),users);
    }

    @Override
    public UniversalResponseBody<List<User>> listUserSecondedInterviewed(Integer departmentId) {
        List<User> users = applyMsgMapper.listUserSecondedInterviewed(departmentId);
        if(users == null){
            //可能查询结果 实际为空
            log.error("查询二面待面试人员失败，数据库查询结果为0；查询结果可能 实际为空 或 数据库查询错误！");
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),users);
    }

    @Override
    public UniversalResponseBody EnrollMembers(Integer[] userId,Integer departmentId) {
        List<User> users = applyMsgMapper.listUserEnrollMembers(userId,departmentId);
        if(users == null) {
            log.error("录取部员服务方法，根据用户ids和部门id查询结果为空，可能为参数不合法，或数据库查询出错！");
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg());
        }
        if(userMapper.insertBatch(users) > 0) {
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
        }else {
            log.error("录取部员服务方法，数据库批量插入出错！");
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

    @Override
    public UniversalResponseBody SecondEliminate(Integer userId, Integer departmentId) {
        if(applyMsgMapper.SecondEliminate(userId,departmentId) > 0) {
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
        }
        log.error("二面淘汰方法，数据库更新状态失败");
        return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
    }
}
