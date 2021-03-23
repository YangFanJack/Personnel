package com.jack.service.impl;

import com.jack.dao.StaffDao;
import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import com.jack.pojo.ProbInfo;
import com.jack.pojo.Staff;
import com.jack.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;


    /**
     * 新增人才一枚
     *
     * @return
     */
    @Override
    public boolean insertStaff(Staff staff) {
        try{
            int i = staffDao.insertStaff(staff);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * 显示所有正式员工
     *
     * @return
     */
    @Override
    public PageBean<Staff> showSeletedStaffByPage(int pageSize, int currentPage, String searchString, int workType, int isEnter) {
        PageBean<Staff> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("workType",workType);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showSelectStaffByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("workType",workType);
        map2.put("isEnter",isEnter);
        List<Staff> staffs = staffDao.showSeletedStaffByPage(map2);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 显示某部门所有正式员工
     *
     * @return
     */
    @Override
    public PageBean<Staff> showSeletedStaffByDepartmentByPage(int pageSize, int currentPage, String searchString, int departmentId, int workType, int isEnter) {
        PageBean<Staff> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("departmentId",departmentId);
        map1.put("workType",workType);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showSeletedStaffByDepartmentByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("departmentId",departmentId);
        map2.put("workType",workType);
        map2.put("isEnter",isEnter);
        List<Staff> staffs = staffDao.showSeletedStaffByDepartmentByPage(map2);
        System.out.println(staffs);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 显示某岗位所有正式员工
     *
     * @return
     */
    @Override
    public PageBean<Staff> showSeletedStaffByJobByPage(int pageSize, int currentPage, String searchString, int jobId, int workType, int isEnter) {
        PageBean<Staff> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("jobId",jobId);
        map1.put("workType",workType);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showSeletedStaffByJobByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("jobId",jobId);
        map2.put("workType",workType);
        map2.put("isEnter",isEnter);
        List<Staff> staffs = staffDao.showSeletedStaffByJobByPage(map2);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 显示所有已入职员工
     *
     * @return
     */
    @Override
    public PageBean<Staff> showEnterStaffByPage(int pageSize, int currentPage, String searchString, int isEnter) {
        PageBean<Staff> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showEnterStaffByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("isEnter",isEnter);
        List<Staff> staffs = staffDao.showEnterStaffByPage(map2);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 显示所有未入职的人才
     *
     * @param pageSize
     * @param currentPage
     * @param searchString
     * @param isEnter
     * @return
     */
    @Override
    public PageBean<Staff> showEmployeeByPage(int pageSize, int currentPage, String searchString, int isEnter) {
        PageBean<Staff> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showEmployeeByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("isEnter",isEnter);
        List<Staff> staffs = staffDao.showEmployeeByPage(map2);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 从人才库选择进入公司试用
     *
     * @return
     */
    @Override
    public boolean getEmployeeEnter(int staffId, int departmentId, int jobId, String probBeginTime, String probEndTime, String enterTime, int isEnter, int workType, int isQuit) {
        Map<String,Object> map = new HashMap<>();
        map.put("staffId",staffId);
        map.put("departmentId",departmentId);
        map.put("jobId",jobId);
        map.put("probBeginTime",probBeginTime);
        map.put("probEndTime",probEndTime);
        map.put("enterTime",enterTime);
        map.put("isEnter",isEnter);
        map.put("workType",workType);
        map.put("isQuit",isQuit);

        try{
            //新增试用期表
            int j = staffDao.insertProb(map);
            //更新成员表
            int i = staffDao.getEmployeeEnter(map);
            if(i==1 && j==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * 显示所有试用期员工
     *
     * @return
     */
    @Override
    public PageBean<ProbInfo> showProbStaffByPage(int pageSize, int currentPage, String searchString, int workType, int isEnter) {
        PageBean<ProbInfo> staffPageBean = new PageBean<>();
        staffPageBean.setCurrentPage(currentPage);
        staffPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        map1.put("workType",workType);
        map1.put("isEnter",isEnter);
        int totalCount = staffDao.showProbStaffByPageCount(map1);
        staffPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        map2.put("workType",workType);
        map2.put("isEnter",isEnter);
        List<ProbInfo> staffs = staffDao.showProbStaffByPage(map2);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(staffs);
        staffPageBean.setList(staffs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        staffPageBean.setTotalPage(totalPage);
        return staffPageBean;
    }

    /**
     * 给试用期员工一个试用结果
     *
     * @return
     */
    @Override
    public boolean getProbPassResult(int staffId, String executeTime, int workType) {
        Map<String,Object> map = new HashMap<>();
        map.put("staffId",staffId);
        map.put("executeTime",executeTime);
        map.put("workType",workType);
        try{
            int i = staffDao.getProbPassResult1(map);
            int j = staffDao.getProbPassResult2(map);
            if(i==1&&j==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean getProbProlongResult(int staffId, String probEndTime, String executeTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("staffId",staffId);
        map.put("probEndTime",probEndTime);
        map.put("executeTime",executeTime);
        try{
            int i = staffDao.getProbProlongResult(map);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean getProbOutResult(int staffId, String executeTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("staffId",staffId);
        map.put("executeTime",executeTime);
        try{
            int i = staffDao.getProbOutResult1(map);
            int j = staffDao.getProbOutResult2(map);
            if(i==1&&j==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * 员工离职
     *
     * @return
     */
    @Override
    public boolean quitJob(int id, int type, int isResume,String quitTime) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("type",type);
        map.put("isResume",isResume);
        map.put("quitTime",quitTime);
        //直接删除
        if(isResume == 1){
            try{
                int i = staffDao.quitJob1(map);
                if(i==1){
                    return true;
                }
                else{
                    return false;
                }
            }
            catch (Exception e){
                return false;
            }
        }
        //回退到人才库
        else{
            try{
                int i = staffDao.quitJob2a(map);
                int j = staffDao.quitJob2b(map);
                int k = staffDao.quitJob2c(map);
                if(i==1&&j==1&&k==1){
                    return true;
                }
                else{
                    return false;
                }
            }
            catch (Exception e){
                return false;
            }
        }
    }
}
