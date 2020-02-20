package com.volunteer.uapply.service;

import com.github.pagehelper.PageInfo;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:41
 */
public interface ManagerService {
    /**
     * 管理员Pc端登录
     * @param userTel
     * @param userPwd
     * @return
     */
    UniversalResponseBody<TokenPO> userPcLogin(String userTel, String userPwd);


    /**
     * 管理员与部员PC端用户激活
     *
     * @param user
     * @param inviteCode
     * @return
     */
    UniversalResponseBody userPcActivation(User user, String inviteCode);


    /**
     * 查询部门所有成员
     *
     * @param departmentId
     * @return
     */
    UniversalResponseBody<PageInfo<User>> allMembers(Integer departmentId, Integer pageNum, Integer pageSize);

    /**
     * 导出部员信息为excel
     *
     * @param departmentId
     * @param response
     * @return
     */
    void exportMembersExcel(Integer departmentId, HttpServletResponse response);
}
