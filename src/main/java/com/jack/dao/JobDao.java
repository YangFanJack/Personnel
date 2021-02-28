package com.jack.dao;

import com.jack.pojo.Department;
import com.jack.pojo.Job;
import com.jack.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface JobDao {
    /**
     * 添加岗位
     * @return
     */
    @Insert("INSERT INTO job (`name`,`departmentId`) VALUES(#{name},#{departmentId.id})")
    public int insertJob(Job job);

    /**
     * 删除岗位
     * @return
     */
    @Delete("DELETE FROM job WHERE `id` = #{jobId}")
    public int deleteJob(int jobId);

    /**
     * 更新岗位
     * @return
     */
    @Update("UPDATE job SET `name` = #{name}, `departmentId` = #{departmentId.id} WHERE `id` = #{id}")
    public int updateJob(Job job);

    /**
     * 分页查找所有岗位
     * @return
     */
    public List<Job> selectAllJobByPage(Map<String,Object> parameters);
    public int selectAllJobByPageCount(Map<String,Object> parameters);

    /**
     * 根据所选的部门查找对应岗位
     * @return
     */
    @Select("select * from job where departmentId = ${departmentId}")
    public List<Job> findSelectJob(int departmentId);
}
