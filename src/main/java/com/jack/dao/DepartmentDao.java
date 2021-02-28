package com.jack.dao;

import com.jack.pojo.Department;
import com.jack.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {
    /**
     * 添加部门
     * @return
     */
    @Insert("INSERT INTO department (`name`,`phone`,`detail`,`beginTime`) VALUES(#{name},#{phone},#{detail},#{beginTime})")
    public int insertDepartment(Department department);

    /**
     * 删除部门
     * @return
     */
    @Delete("DELETE FROM department WHERE `id` = #{departmentId}")
    public int deleteDepartment(int departmentId);

    /**
     * 更新部门
     * @return
     */
    @Update("UPDATE department SET `name` = #{name}, `phone` = #{phone}, `detail` = #{detail}, `beginTime` = #{beginTime} WHERE `id` = #{id}")
    public int updateDepartment(Department department);

    /**
     * 分页查找所有部门
     * @return
     */
    public List<Department> selectAllDepartmentByPage(Map<String,Object> parameters);
    public int selectAllDepartmentByPageCount(Map<String,Object> parameters);

    /**
     * 查找所有部门t
     * @return
     */
    @Select("select * from department")
    public List<Department> selectAllDepartment();

    /**
     * 查找指定id的部门
     * @param departmentId
     * @return
     */
    @Select("select * from department where id = #{departmentId}")
    public Department findDepartment(int departmentId);
}
