package com.jack.controller;

import com.jack.dao.DepartmentDao;
import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import com.jack.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService departmentService;

    /**
     * 添加部门
     * @param model
     * @return
     */
    @RequestMapping("insertDepartment")
    public String insertDepartment(String name, String phone, String detail, String beginTime, Model model){
        Department department = new Department();
        department.setName(name);
        department.setPhone(phone);
        department.setDetail(detail);
        department.setBeginTime(beginTime);
        boolean b = departmentService.insertDepartment(department);
        if(b){
            return "redirect:/selectAllDepartmentByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 删除部门
     * @param model
     * @return
     */
    @RequestMapping("deleteDepartment")
    public String deleteDepartment(String departmentId, Model model){
        int departmentId0 = Integer.parseInt(departmentId);
        boolean b = departmentService.deleteDepartment(departmentId0);
        if(b){
            return "redirect:/selectAllDepartmentByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 编辑部门
     * @param model
     * @return
     */
    @RequestMapping("updateDepartment")
    public String updateDepartment(String id, String name, String phone, String detail, String beginTime, Model model){
        Department department = new Department();
        int id0 = Integer.parseInt(id);
        department.setId(id0);
        department.setName(name);
        department.setPhone(phone);
        department.setDetail(detail);
        department.setBeginTime(beginTime);
        boolean b = departmentService.updateDepartment(department);
        if(b){
            return "redirect:/selectAllDepartmentByPage";
        }
        else {
            return "pages/admin-500";
        }
    }

    /**
     * 分页查找所有部门
     * @param model
     * @return
     */
    @RequestMapping("selectAllDepartmentByPage")
    public String selectAllDepartmentByPage(String totalPage, String currentPage, String searchString, Model model){
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
        PageBean<Department> departmentPageBean = departmentService.selectAllDepartmentByPage(currentPage0, pageSize, searchString);
        model.addAttribute("departmentPageBean",departmentPageBean);
        model.addAttribute("searchString",searchString);
        return "pages/admin-manageDepartment";
    }
}
