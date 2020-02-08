package com.volunteer.uapply;

import com.aliyuncs.exceptions.ClientException;
import com.power.common.util.DateTimeUtil;
import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiDataDictionary;
import com.power.doc.model.ApiErrorCodeDictionary;
import com.power.doc.model.ApiReqHeader;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.enums.PermissionIdEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UapplyApplicationTests {

    @Test
    void contextLoads() {

    }

    //生成API-Markdown文件的测试类
    @Test
    public void ApiBuild(){
        ApiConfig config = new ApiConfig();
        //当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);
        //Set the api document output path.
        config.setOutPath("C:\\Users\\24605\\Desktop\\uapply");
        config.setPackageFilters("com.volunteer.uapply.controller");
        //1.7.9 优化了错误码处理，用于下面替代遍历枚举设置错误码
        config.setErrorCodeDictionaries(
                ApiErrorCodeDictionary.dict().setEnumClass(ResponseResultEnum.class)
                        .setCodeField("code") //错误码值字段名
                        .setDescField("msg")//错误码描述
        );
        //导出权限Id数据字典
        config.setDataDictionaries(
                ApiDataDictionary.dict().setTitle("用户权限Id").setEnumClass(PermissionIdEnum.class)
                        .setCodeField("permissionId") //字典码值字段名
                        .setDescField("permissionName") //字段码
        );

        config.setDataDictionaries(
                ApiDataDictionary.dict().setTitle("部门Id").setEnumClass(DepartmentEnum.class)
                        .setCodeField("departmentId") //字典码值字段名
                        .setDescField("departmentName") //字段码
        );
        //生成Markdown文件
        ApiDocBuilder.buildApiDoc(config);
    }

    //生成API-H5文档
    @Test
    public void testBuilderControllersApi() {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://localhost:8080");

        //设置为严格模式，Smart-doc将降至要求每个Controller暴露的接口写上标准文档注释
        config.setStrict(true);

        //当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);

        //HTML5文档，建议直接放到src/main/resources/static/doc下，Smart-doc提供一个配置常量HTML_DOC_OUT_PATH
        config.setOutPath(DocGlobalConstants.HTML_DOC_OUT_PATH);

        // 设置接口包扫描路径过滤，如果不配置则Smart-doc默认扫描所有的接口类
        // 配置多个报名有英文逗号隔开
        config.setPackageFilters("com.volunteer.uapply.controller");

        //设置公共请求头.如果不需要请求头，则无需设置
        config.setRequestHeaders(
                ApiReqHeader.header().setName("token").setType("string")
                        .setDesc("Basic auth credentials").setRequired(true),
                ApiReqHeader.header().setName("userId").setType("Integer").setDesc("用户全局Id")
        );

        //1.7.9 优化了错误码处理，用于下面替代遍历枚举设置错误码
        config.setErrorCodeDictionaries(
                ApiErrorCodeDictionary.dict().setEnumClass(ResponseResultEnum.class)
                        .setCodeField("code") //错误码值字段名
                        .setDescField("msg")//错误码描述
        );

        //导出权限Id数据字典
        config.setDataDictionaries(
                ApiDataDictionary.dict().setTitle("用户权限Id").setEnumClass(PermissionIdEnum.class)
                        .setCodeField("permissionId") //字典码值字段名
                        .setDescField("permissionName") //字段码
        );

        config.setDataDictionaries(
                ApiDataDictionary.dict().setTitle("部门Id").setEnumClass(DepartmentEnum.class)
                        .setCodeField("departmentId") //字典码值字段名
                        .setDescField("departmentName") //字段码
        );


        long start = System.currentTimeMillis();
        //生成HTML5文件
        HtmlApiDocBuilder.buildApiDoc(config);
        //since 1.8.1版本开始入口方法有变更
        HtmlApiDocBuilder.buildApiDoc(config);
        long end = System.currentTimeMillis();
        DateTimeUtil.printRunTime(end, start);
    }


    @Test
    public void MessageTest() throws ClientException {

    }

}
