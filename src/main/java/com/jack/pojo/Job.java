package com.jack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    //编号
    private int id;
    //名称
    private String name;

    //所属部门
    private Department departmentId;
}
