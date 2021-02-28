package com.jack.service;

import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface DepartmentService {
    /**
     * 添加部门
     * @return
     */
    public boolean insertDepartment(Department department);

    /**
     * 删除部门
     * @return
     */
    public boolean deleteDepartment(int departmentId);

    /**
     * 更新部门
     * @return
     */
    public boolean updateDepartment(Department department);

    /**
     * 分页查找所有部门
     * @return
     */
    public PageBean<Department> selectAllDepartmentByPage(int currentPage, int pageSize, String searchString);

    /**
     * 查找所有部门
     * @return
     */
    public List<Department> selectAllDepartment();

    /**
     * 查找指定id的部门
     * @return
     */
    public Department findDepartment(int departmentId);
}
