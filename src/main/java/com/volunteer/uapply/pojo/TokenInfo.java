package com.volunteer.uapply.pojo;

import lombok.Data;

/**
 * 返回token实体类
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 20:53
 */
@Data
public class TokenInfo<T> {

    private String token;

    private T data;

    public TokenInfo(String token, T data) {
        this.token = token;
        this.data = data;
    }

    public TokenInfo(String token) {
        this.token = token;
    }
}
