package com.volunteer.uapply.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.volunteer.uapply.mapper.ManaggerMapper;
import com.volunteer.uapply.mapper.TokenMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.mapper.WxResponseMapper;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.ManagerService;
import com.volunteer.uapply.utils.ExcelUtil;
import com.volunteer.uapply.utils.Object2Map;
import com.volunteer.uapply.utils.Tokenutil;
import com.volunteer.uapply.utils.WeChatUtil;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:41
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private Tokenutil tokenutil;
    @Resource
    private TokenMapper tokenMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ManaggerMapper managgerMapper;

    @Override
    public UniversalResponseBody<TokenPO> userPcLogin(String userTel, String userPwd) {
        User user = userMapper.findUserByUserTel(userTel);
        if(user == null){
            return new UniversalResponseBody(ResponseResultEnum.USER_LOGIN_ERROR.getCode(),ResponseResultEnum.USER_LOGIN_ERROR.getMsg());
        }
        Integer userId = user.getUserId();
        String truePwd = user.getUserPwd();
        //密码相同
        if (truePwd.equals(userPwd)){
            String trueToken = tokenMapper.findTokenByUserId(userId);
            //已经存在该用户的token
            if (trueToken!=null){
                return new UniversalResponseBody<TokenPO>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(),new TokenPO(userId,trueToken));
            }else{
                String token = tokenutil.TokenByUserId(userId);
                TokenPO tokenPO = new TokenPO(userId,token);
                tokenMapper.insertToken(tokenPO);
                //返回token和userId
                return new UniversalResponseBody<TokenPO>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(),tokenPO);
            }
        }else{
            return new UniversalResponseBody(ResponseResultEnum.USER_LOGIN_ERROR.getCode(), ResponseResultEnum.USER_LOGIN_ERROR.getMsg());
        }
    }

    @Override
    public UniversalResponseBody userPcActivation(User user,String inviteCode) {
        String trueInviteCode = managgerMapper.searchCodeByDepartId(user.getDepartmentId());
        if (trueInviteCode.equals(inviteCode)){
            if (userMapper.InsertUser(user) > 0){
                return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
            } else {
                //添加用户失败
                return new UniversalResponseBody(ResponseResultEnum.USER_INSERT_FAILED.getCode(), ResponseResultEnum.USER_INSERT_FAILED.getMsg());
            }
        } else {
            //激活码无效
            return new UniversalResponseBody(ResponseResultEnum.CODE_IS_INVALID.getCode(), ResponseResultEnum.CODE_IS_INVALID.getMsg());
        }
    }


    @Override

    public UniversalResponseBody<PageInfo<User>> allMembers(Integer departmentId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(managgerMapper.allMembers(departmentId));
        if (pageInfo.getTotal() != 0) {
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), pageInfo);
        } else {
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg());
        }
    }

    @Override
    public void exportMembersExcel(Integer departmentId, HttpServletResponse response) {
        //获取部门名称
        String departmentName = DepartmentEnum.getDepartmentNameById(departmentId);

        List<Map<String, Object>> memberList = Object2Map.object2MapList(managgerMapper.allMembers(departmentId));
        ExcelUtil.templateExportExcel("/root/message" + "/MemberMessageTemp.xls", memberList, departmentName + "部员详细信息.xls", response);
    }
}
