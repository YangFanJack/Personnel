package com.jack.controller;

import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import com.jack.pojo.ProbInfo;
import com.jack.pojo.Staff;
import com.jack.service.DepartmentService;
import com.jack.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    @Qualifier("StaffServiceImpl")
    private StaffService staffService;

    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService departmentService;

    /**
     * 新增人才一枚
     * @param model
     * @return
     */
    @RequestMapping("insertStaff")
    public String insertStaff(String name, String gender, String identityId, String from, String org, String home,
          String phone, String qualif1, String qualif2, String university, String major, Model model){
        int gender0 = Integer.parseInt(gender);
        int from0 = Integer.parseInt(from);
        int org0 = Integer.parseInt(org);
        int qualif10 = Integer.parseInt(qualif1);
        int qualif20 = Integer.parseInt(qualif2);

        Staff staff = new Staff();
        staff.setName(name);
        staff.setGender(gender0);
        staff.setIdentityId(identityId);
        staff.setFrom(from0);
        staff.setOrg(org0);
        staff.setHome(home);
        staff.setPhone(phone);
        staff.setQualif1(qualif10);
        staff.setQualif2(qualif20);
        staff.setUniversity(university);
        staff.setMajor(major);
        staff.setIsEnter(1);

        boolean b = staffService.insertStaff(staff);
        if(b){
            model.addAttribute("msg","个人信息投入人才库成功！");
            return "pages/input-employee";
        }
        else{
            model.addAttribute("msg","个人信息投入人才库失败！");
            return "pages/input-employee";
        }
    }

    /**
     * 显示所有正式员工
     * @param model
     * @return
     */
    @RequestMapping("showSeletedStaffByPage")
    public String showSeletedStaffByPage(String totalPage, String currentPage, String searchString, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int workType = 2;
        int isEnter = 2;
        PageBean<Staff> staffPageBean = staffService.showSeletedStaffByPage(pageSize, currentPage0, searchString, workType, isEnter);
        model.addAttribute("staffPageBean",staffPageBean);
        model.addAttribute("searchString",searchString);
        return "pages/admin-manageQuit";
    }

    /**
     * 显示某部门所有正式员工
     * @param model
     * @return
     */
    @RequestMapping("showSeletedStaffByDepartmentByPage")
    public String showSeletedStaffByDepartmentByPage(String totalPage, String currentPage, String searchString, String departmentId, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int workType = 2;
        int isEnter = 2;
        int departmentId0 = Integer.parseInt(departmentId);
        PageBean<Staff> staffPageBean = staffService.showSeletedStaffByDepartmentByPage(pageSize, currentPage0, searchString, departmentId0, workType, isEnter);
        model.addAttribute("staffPageBean",staffPageBean);
        model.addAttribute("departmentId",departmentId);
        model.addAttribute("searchString",searchString);
        return "pages/departmentStaffInfo";
    }

    /**
     * 显示某岗位所有正式员工
     * @param model
     * @return
     */
    @RequestMapping("showSeletedStaffByJobByPage")
    public String showSeletedStaffByJobByPage(String totalPage, String currentPage, String searchString, String jobId, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int workType = 2;
        int isEnter = 2;
        int jobId0 = Integer.parseInt(jobId);
        PageBean<Staff> staffPageBean = staffService.showSeletedStaffByJobByPage(pageSize, currentPage0, searchString, jobId0, workType, isEnter);
        model.addAttribute("staffPageBean",staffPageBean);
        model.addAttribute("jobId",jobId);
        model.addAttribute("searchString",searchString);
        return "pages/jobStaffInfo";
    }

    /**
     * 显示已入职所有员工(正式&试用)
     * @param model
     * @return
     */
    @RequestMapping("showEnterStaffByPage")
    public String showEnterStaffByPage(String totalPage, String currentPage, String searchString, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int isEnter = 2;
        PageBean<Staff> staffPageBean = staffService.showEnterStaffByPage(pageSize, currentPage0, searchString, isEnter);
        model.addAttribute("staffPageBean",staffPageBean);
        model.addAttribute("searchString",searchString);
        return "pages/admin-manageEntry";
    }

    /**
     * 显示未入职所有人才
     * @param model
     * @return
     */
    @RequestMapping("showEmployeeByPage")
    public String showEmployeeByPage(String totalPage, String currentPage, String searchString, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int isEnter = 1;
        PageBean<Staff> staffPageBean = staffService.showEmployeeByPage(pageSize, currentPage0, searchString, isEnter);
        model.addAttribute("staffPageBean",staffPageBean);
        model.addAttribute("searchString",searchString);

        //新增人员时候选择所属部门，需要先查找所有部门
        List<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "pages/admin-manageEntry2";
    }

    /**
     * 从人才库选择进入公司试用
     * @param model
     * @return
     */
    @RequestMapping("getEmployeeEnter")
    public String getEmployeeEnter(String staffId, String departmentId, String jobId, String probBeginTime, String probEndTime, Model model){
        int staffId0 = Integer.parseInt(staffId);
        int departmentId0 = Integer.parseInt(departmentId);
        int jobId0 = Integer.parseInt(jobId);

        //获取当前系统时间并转化为字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String enterTime = sdf.format(date);
        int isEnter = 2;
        int workType = 1;
        int isQuit = 1;
        boolean b = staffService.getEmployeeEnter(staffId0, departmentId0, jobId0, probBeginTime, probEndTime, enterTime, isEnter, workType, isQuit);
        if(b){
            model.addAttribute("msg","从人才库添加求职者成功！");
            return "redirect:/showEmployeeByPage";
        }
        else{
            model.addAttribute("msg","从人才库添加求职者失败！");
            return "pages/admin-500";
        }
    }

    /**
     * 显示所有试用期员工
     * @param model
     * @return
     */
    @RequestMapping("showProbStaffByPage")
    public String showProbStaffByPage(String totalPage, String currentPage, String searchString, Model model){
        int currentPage0 = 0;
        if(currentPage!=null&&!currentPage.equals("")){
            currentPage0 = Integer.parseInt(currentPage);
            if(currentPage0 <= 1){
                currentPage0 = 1;
            }
        }
        if(totalPage!=null&&!totalPage.equals("")){
            if(Integer.parseInt(currentPage) >= Integer.parseInt(totalPage)){
                currentPage0 = Integer.parseInt(totalPage);
            }
        }
        if (currentPage0 == 0){
            currentPage0=1;
        }

        int pageSize = 8;
        int workType = 1;
        int isEnter = 2;
        PageBean<ProbInfo> probPageBean = staffService.showProbStaffByPage(pageSize, currentPage0, searchString, workType, isEnter);
        model.addAttribute("probPageBean",probPageBean);
        model.addAttribute("searchString",searchString);
        return "pages/admin-manageProbation";
    }

    /**
     * 给试用期员工一个试用结果
     * @param model
     * @return
     */
    @RequestMapping("getProbPassResult")
    public String getProbPassResult(String staffId, Model model){
        //获取当前系统时间并转化为字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String executeTime = sdf.format(date);

        int staffId0 = Integer.parseInt(staffId);
        int workType = 2;
        boolean b = staffService.getProbPassResult(staffId0,executeTime,workType);
        if(b){
            model.addAttribute("msg","该员工通过试用期成功！");
            return "redirect:/showProbStaffByPage";
        }
        else{
            model.addAttribute("msg","该员工通过试用期失败！");
            return "pages/admin-500";
        }
    }
    @RequestMapping("getProbProlongResult")
    public String getProbProlongResult(String staffId, String probEndTime, Model model){
        //获取当前系统时间并转化为字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String executeTime = sdf.format(date);

        int staffId0 = Integer.parseInt(staffId);
        boolean b = staffService.getProbProlongResult(staffId0, probEndTime, executeTime);
        if(b){
            model.addAttribute("msg","该员工通过试用期成功！");
            return "redirect:/showProbStaffByPage";
        }
        else{
            model.addAttribute("msg","该员工通过试用期失败！");
            return "pages/admin-500";
        }
    }
    @RequestMapping("getProbOutResult")
    public String getProbOutResult(String staffId, Model model){
        //获取当前系统时间并转化为字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String executeTime = sdf.format(date);

        int staffId0 = Integer.parseInt(staffId);
        boolean b = staffService.getProbOutResult(staffId0,executeTime);
        if(b){
            model.addAttribute("msg","该员工通过试用期成功！");
            return "redirect:/showProbStaffByPage";
        }
        else{
            model.addAttribute("msg","该员工通过试用期失败！");
            return "pages/admin-500";
        }
    }

    /**
     * 员工离职
     * @param model
     * @return
     */
    @RequestMapping("quitJob")
    public String quitJob(String id, String type, String isResume, Model model){
        //获取当前系统时间并转化为字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String quitTime = sdf.format(date);

        int id0 = Integer.parseInt(id);
        int type0 = Integer.parseInt(type);
        int isResume0 = Integer.parseInt(isResume);
        boolean b = staffService.quitJob(id0, type0, isResume0, quitTime);
        if(b){
            model.addAttribute("msg","员工离职成功！");
            return "redirect:/showSeletedStaffByPage";
        }
        else{
            model.addAttribute("msg","员工离职失败！");
            return "pages/admin-500";
        }
    }
}
