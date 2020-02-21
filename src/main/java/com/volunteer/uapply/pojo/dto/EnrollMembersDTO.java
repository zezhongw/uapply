package com.volunteer.uapply.pojo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 创建 dto 对象，方便接收 json 参数
 *
 * @Author 桂乙侨
 * @Date 2020/2/8 18:48
 * @Version 1.0
 */
@Data
public class EnrollMembersDTO {
    @NotNull(message = "用户id参数不能为空")
    private Integer[] userId;
    @NotNull(message = "部门参数不能为空")
    @Min(value = 1, message = "部门参数无效")
    @Max(value = 9, message = "部门参数无效")
    private Integer departmentId;
}
