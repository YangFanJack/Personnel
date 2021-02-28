package com.jack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveInfo {
    //编号
    private int id;
    //离职日期
    private String quitTime;
    //离职类型(1主动辞职，2辞退，3退休，4开除)
    private int type;
    //是否进入人才库
    private int isResume;

    //员工id
    private Staff staffId;
}
