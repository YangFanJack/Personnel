package com.jack.service;

import com.jack.pojo.PageBean;
import com.jack.pojo.ProbInfo;
import com.jack.pojo.Staff;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public interface StaffService {
    /**
     * 新增人才一枚
     * @return
     */
    public boolean insertStaff(Staff staff);

    /**
     * 显示所有正式员工
     * @return
     */
    PageBean<Staff> showSeletedStaffByPage(int pageSize, int currentPage, String searchString, int workType, int isEnter);

    /**
     * 显示某部门所有正式员工
     * @return
     */
    public PageBean<Staff> showSeletedStaffByDepartmentByPage(int pageSize, int currentPage, String searchString, int departmentId, int workType, int isEnter);

    /**
     * 显示某岗位所有正式员工
     * @return
     */
    public PageBean<Staff> showSeletedStaffByJobByPage(int pageSize, int currentPage, String searchString, int jobId, int workType, int isEnter);

    /**
     * 显示所有已入职员工
     * @return
     */
    public PageBean<Staff> showEnterStaffByPage(int pageSize, int currentPage, String searchString, int isEnter);

    /**
     * 显示所有未入职的人才
     * @return
     */
    public PageBean<Staff> showEmployeeByPage(int pageSize, int currentPage, String searchString, int isEnter);

    /**
     * 从人才库选择进入公司试用
     * @return
     */
    public boolean getEmployeeEnter(int staffId, int departmentId, int jobId, String probBeginTime, String probEndTime, String enterTime, int isEnter, int workType, int isQuit);

    /**
     * 显示所有试用期员工
     * @return
     */
    public PageBean<ProbInfo> showProbStaffByPage(int pageSize, int currentPage, String searchString, int workType, int isEnter);

    /**
     * 给试用期员工一个试用结果
     * @return
     */
    public boolean getProbPassResult(int staffId, String executeTime, int workType);
    public boolean getProbProlongResult(int staffId, String probEndTime, String executeTime);
    public boolean getProbOutResult(int staffId, String executeTime);

    /**
     * 员工离职
     * @return
     */
    public boolean quitJob(int id, int type, int isResume, String quitTime);
}
