package com.jack.dao;

import com.jack.pojo.PageBean;
import com.jack.pojo.ProbInfo;
import com.jack.pojo.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface StaffDao {
    /**
     * 新增人才一枚
     * @return
     */
    @Insert("INSERT INTO staff (`name`,`gender`,`identityId`,`from`,`org`,`home`,`phone`,`qualif1`,`qualif2`,`university`,`major`,`isEnter`)" +
            "VALUES(#{name},#{gender},#{identityId},#{from},#{org},#{home},#{phone},#{qualif1},#{qualif2},#{university},#{major},#{isEnter})")
    public int insertStaff(Staff staff);

    /**
     * 显示所有正式员工
     * @return
     */
    public List<Staff> showSeletedStaffByPage(Map<String,Object> parameters);
    public int showSelectStaffByPageCount(Map<String,Object> parameters);

    /**
     * 显示某部门所有正式员工
     * @return
     */
    public List<Staff> showSeletedStaffByDepartmentByPage(Map<String,Object> parameters);
    public int showSeletedStaffByDepartmentByPageCount(Map<String,Object> parameters);

    /**
     * 显示某岗位所有正式员工
     * @return
     */
    public List<Staff> showSeletedStaffByJobByPage(Map<String,Object> parameters);
    public int showSeletedStaffByJobByPageCount(Map<String,Object> parameters);

    /**
     * 显示所有入职员工
     * @return
     */
    public List<Staff> showEnterStaffByPage(Map<String,Object> parameters);
    public int showEnterStaffByPageCount(Map<String,Object> parameters);

    /**
     * 显示所有未入职员工
     * @param parameters
     * @return
     */
    public List<Staff> showEmployeeByPage(Map<String,Object> parameters);
    public int showEmployeeByPageCount(Map<String,Object> parameters);

    /**
     * 从人才库选择进入公司试用
     * @return
     */
    @Update("UPDATE `staff` SET `departmentId` = #{departmentId}, `jobId` = #{jobId}, `enterTime` = #{enterTime}, `workType` = #{workType}, `isEnter` = #{isEnter}, `isQuit` = #{isQuit} WHERE `id` = #{staffId}")
    public int getEmployeeEnter(Map<String,Object> parameters);
    @Insert("INSERT INTO `probinfo` (`staffId`,`probBeginTime`,`probEndTime`) VALUES(#{staffId},#{probBeginTime},#{probEndTime})")
    public int insertProb(Map<String,Object> parameters);

    /**
     * 显示所有试用期员工
     * @return
     */
    public List<ProbInfo> showProbStaffByPage(Map<String,Object> parameters);
    public int showProbStaffByPageCount(Map<String,Object> parameters);

    /**
     * 给试用期员工一个试用结果
     * @return
     */
    @Update("UPDATE `staff` SET `workType` = #{workType} WHERE `id` = #{staffId}")
    public int getProbPassResult1(Map<String,Object> parameters);
    @Update("UPDATE `probinfo` SET `probResult`=1, `executeTime`=#{executeTime} WHERE staffId = #{staffId}")
    public int getProbPassResult2(Map<String,Object> parameters);
    @Update("UPDATE `probinfo` SET `probEndTime`=#{probEndTime}, `probResult`=2, `executeTime`=#{executeTime} WHERE staffId = #{staffId}")
    public int getProbProlongResult(Map<String,Object> parameters);
    @Update("UPDATE `staff` SET `isEnter`=1,`isQuit`=2 WHERE `id` = #{staffId}")
    public int getProbOutResult1(Map<String,Object> parameters);
    @Delete("DELETE FROM `probinfo` WHERE staffId = #{staffId}")
    public int getProbOutResult2(Map<String,Object> parameters);

    /**
     * 员工离职1（删除）
     * @return
     */
    @Delete("delete from staff where id  = #{id}")
    public int quitJob1(Map<String,Object> parameters);

    /**
     * 员工离职2（更新,新增）
     * @return
     */
    @Update("insert into leaveinfo(staffId,quitTime,type,isResume) values(#{id},#{quitTime},#{type},#{isResume})")
    public int quitJob2a(Map<String,Object> parameters);
    @Update("update staff set isQuit=2,isEnter=1 where id=#{id}")
    public int quitJob2b(Map<String,Object> parameters);
    @Delete("DELETE FROM `probinfo` WHERE staffId = #{id}")
    public int quitJob2c(Map<String,Object> parameters);
}
