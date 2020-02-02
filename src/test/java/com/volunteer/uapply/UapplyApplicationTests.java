package com.volunteer.uapply;

import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.ApiDataDictionary;
import com.power.doc.model.ApiErrorCodeDictionary;
import com.volunteer.uapply.utils.enums.ExceptionEnum;
import com.volunteer.uapply.utils.enums.PermissionIdEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
                ApiErrorCodeDictionary.dict().setEnumClass(ExceptionEnum.class)
                        .setCodeField("code") //错误码值字段名
                        .setDescField("msg")//错误码描述
        );
        //导出数据字典
        config.setDataDictionaries(
                ApiDataDictionary.dict().setTitle("用户权限").setEnumClass(PermissionIdEnum.class)
                        .setCodeField("permissionId") //字典码值字段名
                        .setDescField("permissionName") //字段码
        );

        //生成Markdown文件
        ApiDocBuilder.buildApiDoc(config);
    }

}
