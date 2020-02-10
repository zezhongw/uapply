package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * 表applymessage相关的mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:29
 */
@Mapper
public interface ApplyMsgMapper {

    int UpdateSecondDepartment(String userTel,Integer departmentId);

    User GetUserByUserId(Integer userId);

    List<ApplyPO> listApplyPOUnSecondInterview(Integer departmentId);

    List<ApplyPO> listApplyPOSecondedInterviewed(Integer departmentId);

    List<User> listUserEnrollMembers(@Param("ids") Integer[] userId,@Param("departmentId") Integer departmentId);

    int SecondEliminate(@Param("userId") Integer userId,@Param("departmentId") Integer departmentId);

    int insertApplyMsg(ApplyPO applyPO);

    ApplyPO findApplyMsgByUserTel(String userTel);

    ApplyPO findApplyMsgByUserId(int userId);
}
