package com.volunteer.uapply.pojo.info;

import lombok.Data;

/**
 * 短信内容参数对象
 * 模板信息:
 * ${name}同学您好，${department}已收到您的报名信息，感谢你的报名。
 * ${activity}安排如下： 时间：${timeSlot} 。地点：${place} 。如因故不能及时到达，请及时与我们联系${telNo}
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 20:25
 */
@Data
public class AliyunRequsetParamInfo {

    /**
     * 接收人手机号码
     */
    private String PhoneNumbers;

    /**
     * 接收人姓名
     */
    private String name;

    /**
     * 部门，后面将部门id改为字符
     */
    private Integer departmentId;



    /**
     * 时间
     */
    private String timeSlot;

    /**
     * 地点
     */
    private String place;

    /**
     * 联系电话
     */
    private String telNo;
}
