package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * 简历
 * @author 赵益江
 * @version 1.0
 * @date 2020/2/9 13:20
 */
public interface ResumeService {

    UniversalResponseBody applyMessage(ApplyPO applyPO);

    UniversalResponseBody viewApplyMessage(int departmentId,String userTel);

    UniversalResponseBody viewApplyStatus(int userId);

}
