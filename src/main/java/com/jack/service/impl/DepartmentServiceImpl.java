package com.jack.service.impl;

import com.jack.dao.DepartmentDao;
import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import com.jack.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 添加部门
     *
     * @return
     */
    @Override
    public boolean insertDepartment(Department department) {
        try{
            int i = departmentDao.insertDepartment(department);
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
     * 删除部门
     *
     * @return
     */
    @Override
    public boolean deleteDepartment(int departmentId) {
        try{
            int i = departmentDao.deleteDepartment(departmentId);
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
     * 更新部门
     *
     * @return
     */
    @Override
    public boolean updateDepartment(Department department) {
        try{
            int i = departmentDao.updateDepartment(department);
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
     * 分页查找所有部门
     *
     * @return
     */
    @Override
    public PageBean<Department> selectAllDepartmentByPage(int currentPage, int pageSize, String searchString) {
        PageBean<Department> departmentPageBean = new PageBean<>();
        departmentPageBean.setCurrentPage(currentPage);
        departmentPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        int totalCount = departmentDao.selectAllDepartmentByPageCount(map1);
        departmentPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        List<Department> departments = departmentDao.selectAllDepartmentByPage(map2);
        departmentPageBean.setList(departments);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        departmentPageBean.setTotalPage(totalPage);
        return departmentPageBean;
    }

    /**
     * 查找所有部门
     *
     * @return
     */
    @Override
    public List<Department> selectAllDepartment() {
        List<Department> departments = departmentDao.selectAllDepartment();
        return departments;
    }

    /**
     * 查找指定id的部门
     *
     * @param departmentId
     * @return
     */
    @Override
    public Department findDepartment(int departmentId) {
        Department department = departmentDao.findDepartment(departmentId);
        return department;
    }
}
