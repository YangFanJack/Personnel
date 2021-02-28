package com.jack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProbInfo {
    //编号
    private int id;
    //考核结果(1通过，2延长，3通过)
    private int probResult;
    //员工试用开始日期
    private String probBeginTime;
    //员工试用结束时间
    private String probEndTime;
    //处理日期
    private String executeTime;

    //员工id
    private Staff staffId;
}
