package com.volunteer.uapply.mapper;

/**
 * 管理员相关的mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/6 15:22
 */
public interface ManaggerMapper {

    /**
     * 插入邀请码(我认为此功能可能没什么用，但是我还是要写出来，免得PM提需求)
     */
    int insertInviteCode(String inviteCode, Integer departmentId);


    /**
     * 查询部门激活码
     */
    String searchCodeByDepartId(Integer departmentId);
}
