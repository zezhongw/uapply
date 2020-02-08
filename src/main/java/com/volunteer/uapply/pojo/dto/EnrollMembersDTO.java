package com.volunteer.uapply.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author 桂乙侨
 * @Date 2020/2/8 18:48
 * @Version 1.0
 * 创建 dto 对象，方便接收 json 参数
 */
@Data
public class EnrollMembersDTO {
    private Integer[] userId;

    private Integer departmentId;
}
