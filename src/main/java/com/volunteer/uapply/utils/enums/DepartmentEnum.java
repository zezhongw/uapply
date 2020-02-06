package com.volunteer.uapply.utils.enums;

/**
 * 部门枚举类
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 9:49
 */
public enum DepartmentEnum {

        GZS(0,"网络技术工作室"),
        TSB(1,"统事部"),
        ZJB(2,"支教部"),
        HBB(3,"环保部"),
        HDB(4,"活动部"),
        HSZ(5,"红十字会"),
        JLB(6,"交流部"),
        PXB(7,"培训部"),
        XCB(8,"宣传部"),
        XMB(9,"项目部");

        private Integer departmentId;

        private String departmentName;

        public static String getDepartmentNameById(Integer departmentId){
             String name;
            switch (departmentId){
                    case 0: name = GZS.getDepartmentName();
                            break;
                    case 1: name = TSB.getDepartmentName();
                            break;
                    case 2: name = ZJB.getDepartmentName();
                            break;
                    case 3: name = HBB.getDepartmentName();
                            break;
                    case 4: name = HDB.getDepartmentName();
                            break;
                    case 5: name = HSZ.getDepartmentName();
                            break;
                    case 6: name = JLB.getDepartmentName();
                            break;
                    case 7: name = PXB.getDepartmentName();
                            break;
                    case 8: name = XCB.getDepartmentName();
                            break;
                    case 9: name = XMB.getDepartmentName();
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
