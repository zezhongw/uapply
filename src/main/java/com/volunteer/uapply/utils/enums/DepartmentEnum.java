package com.volunteer.uapply.utils.enums;

/**
 * 部门枚举类
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 9:49
 */
public enum DepartmentEnum {

        GZS(0,"网络技术工作室");

        private Integer departmentId;

        private String departmentName;

        public static String getDepartmentNameById(Integer departmentId){
             String name;
            switch (departmentId){
                    case 0: name = GZS.getDepartmentName();
                            break;
                    default:
                            throw new IllegalStateException("Unexpected value: " + departmentId);
            }
            return name;
        }

        DepartmentEnum(){

        }

        DepartmentEnum(Integer departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        }

        public Integer getDepartmentId() {
                return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
                this.departmentId = departmentId;
        }

        public String getDepartmentName() {
                return departmentName;
        }

        public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
        }
}
