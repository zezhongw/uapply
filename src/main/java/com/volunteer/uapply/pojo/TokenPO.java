package com.volunteer.uapply.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * token数据库实体类
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 20:53
 */
@Data
public class TokenPO {


    private User user;

    private String token;

    public TokenPO(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
