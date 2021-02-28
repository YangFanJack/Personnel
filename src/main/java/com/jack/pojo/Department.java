package com.jack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    //编号
    private int id;
    //名称
    private String name;
    //电话
    private String phone;
    //描述
    private String detail;
    //成立时间
    private String beginTime;
}
