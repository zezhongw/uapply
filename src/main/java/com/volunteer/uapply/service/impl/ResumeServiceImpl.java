package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.ResumeService;
import com.volunteer.uapply.utils.enums.PermissionIdEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 简历相关
 * @author 赵益江
 * @version 1.0
 * @date 2020/2/9 13:42
 */
@Service
@Slf4j
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ApplyMsgMapper applyMsgMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 用户报名
     *
     * @param applyPO
     * @return
     */
    @Override
    public UniversalResponseBody applyMessage(ApplyPO applyPO) {
        User user = new User();
        user.setUserId(applyPO.getUserId());
        user.setUserName(applyPO.getUserName());
        user.setUserSex(applyPO.getUserSex());
        user.setUserTel(applyPO.getUserSex());
        user.setUserCollege(applyPO.getCollege());
        user.setUserProfession(applyPO.getProfession());
        user.setPermissionId(PermissionIdEnum.PENDING_APPLY.getPermissionId());
        //判断usermessage表插入信息是否成功
        if (userMapper.InsertUser(user) > 0) {
            //判断applymessage表信息插入是否成功
            if (applyMsgMapper.insertApplyMsg(applyPO) > 0) {
                return new UniversalResponseBody(ResponseResultEnum.SUCCEED_APPLY.getCode(), ResponseResultEnum.SUCCEED_APPLY.getMsg());
            } else {
                log.error("数据库插入applymessage信息失败");
                return new UniversalResponseBody(ResponseResultEnum.NOT_APPLY.getCode(), ResponseResultEnum.NOT_APPLY.getMsg());
            }
        } else {
            log.error("数据库插入usermessage信息失败");
            return new UniversalResponseBody(ResponseResultEnum.NOT_APPLY.getCode(), ResponseResultEnum.NOT_APPLY.getMsg());
        }

    }

    /**
     * 查看简历
     * @param userTel
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody viewApplyMessage(int departmentId,String userTel) {
        ApplyPO applyPO = applyMsgMapper.findApplyMsgByUserTel(userTel);
        //查询用户是否存在
        if(applyPO == null){
            return new UniversalResponseBody(ResponseResultEnum.USER_LOGIN_ERROR.getCode(),ResponseResultEnum.USER_LOGIN_ERROR.getMsg(),"用户不存在");
        }else {
            //判断用户是否是二面
            if(applyPO.getSecondDepartmentId() == null){
                //一面查看简历
                if (departmentId == applyPO.getFirstIntentionId() || departmentId == applyPO.getSecondIntentionId()) {
                    return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), applyPO);
                } else {
                    return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg(), "未报本部门志愿");
                }

            }else {
                //二面查看简历
                if(departmentId == applyPO.getSecondDepartmentId()){
                    return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),applyPO);
                }else {
                    return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg(),"二面不属于本部");
                }
            }
        }

    }

    /**
     * 查看面试状态
     * @param userId
     * @return
     */
    @Override
    public UniversalResponseBody viewApplyStatus(int userId) {
        ApplyPO applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
        if(applyPO == null){
            //未报名
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg(), null);
        }else {
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), applyPO);
        }
    }
}
