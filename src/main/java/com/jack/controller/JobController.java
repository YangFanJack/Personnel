package com.jack.controller;

import com.jack.pojo.Department;
import com.jack.pojo.Job;
import com.jack.pojo.PageBean;
import com.jack.service.DepartmentService;
import com.jack.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class JobController {
    @Autowired
    @Qualifier("JobServiceImpl")
    private JobService jobService;

    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService departmentService;

    /**
     * 添加岗位
     * @param model
     * @return
     */
    @RequestMapping("insertJob")
    public String insertJob(String name, String departmentId, Model model){
        int departmentId0 = Integer.parseInt(departmentId);

        Job job = new Job();
        job.setName(name);
        //查询部门名字
        Department department = new Department();
        department.setId(departmentId0);
        job.setDepartmentId(department);

        boolean b = jobService.insertJob(job);
        if(b){
            return "redirect:/selectAllJobByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 删除岗位
     * @param model
     * @return
     */
    @RequestMapping("deleteJob")
    public String deleteJob(String jobId, Model model){
        int jobId0 = Integer.parseInt(jobId);
        boolean b = jobService.deleteJob(jobId0);
        if(b){
            return "redirect:/selectAllJobByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 编辑岗位
     * @param model
     * @return
     */
    @RequestMapping("updateJob")
    public String updateJob(String id, String name, String departmentId, Model model){
        int departmentId0 = Integer.parseInt(departmentId);
        int id0 = Integer.parseInt(id);

        Job job = new Job();
        job.setId(id0);
        job.setName(name);
        Department department = new Department();
        department.setId(departmentId0);
        job.setDepartmentId(department);

        boolean b = jobService.updateJob(job);
        if(b){
            return "redirect:/selectAllJobByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 分页查找所有岗位
     * @param model
     * @return
     */
    @RequestMapping("selectAllJobByPage")
    public String selectAllJobByPage(String totalPage, String currentPage, String searchString, Model model){
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
        PageBean<Job> jobPageBean = jobService.selectAllJobByPage(currentPage0, pageSize, searchString);
        model.addAttribute("jobPageBean",jobPageBean);
        model.addAttribute("searchString",searchString);

        //新增岗位时候选择所属部门时选择部门，需要先查找所有部门
        List<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "pages/admin-manageJob";
    }

    /**
     * 根据部门id查找相应岗位
     * @param
     * @return
     */
    @RequestMapping("findSelectJob")
    @ResponseBody
    public List<Job> findSelectJob(@RequestBody Map<String,String> map){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String departmentId = map.get("departmentId");
        int depId = Integer.parseInt(departmentId);
        List<Job> selectJob = jobService.findSelectJob(depId);
        System.out.println(selectJob);
        return selectJob;
    }
}
