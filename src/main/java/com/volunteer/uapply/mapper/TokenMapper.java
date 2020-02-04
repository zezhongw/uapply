package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.TokenPO;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/3 15:56
 */
public interface TokenMapper {

    /**
     * 将token插入数据库
     * @param tokenPO
     * @return
     */
    int insertToken(TokenPO tokenPO);
}
