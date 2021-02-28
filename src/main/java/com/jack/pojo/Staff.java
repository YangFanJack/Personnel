package com.jack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    //编号
    private int id;
    //姓名
    private String name;
    //性别
    private int gender;
    //身份证号
    private String identityId;
    //入职时间
    private String enterTime;
    //用工形式
    private int workType;
    //人员来源
    private int from;
    //政治面貌
    private int org;
    //籍贯
    private String home;
    //联系电话
    private String phone;
    //最高学历
    private int qualif1;
    //最高学位
    private int qualif2;
    //毕业院校
    private String university;
    //所学专业
    private String major;
    //是否入职
    private int isEnter;
    //是否离职
    private int isQuit;

    //所属部门
    private Department departmentId;
    //所属岗位
    private Job jobId;
}
