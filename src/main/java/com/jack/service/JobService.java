package com.jack.service;

import com.jack.pojo.Department;
import com.jack.pojo.Job;
import com.jack.pojo.PageBean;

import java.util.List;

public interface JobService {
    /**
     * 添加岗位
     * @return
     */
    public boolean insertJob(Job job);

    /**
     * 删除岗位
     * @return
     */
    public boolean deleteJob(int jobId);

    /**
     * 更新岗位
     * @return
     */
    public boolean updateJob(Job job);

    /**
     * 分页查找所有岗位
     * @return
     */
    public PageBean<Job> selectAllJobByPage(int currentPage, int pageSize, String searchString);

    /**
     * 查找指定部门的所有岗位
     * @return
     */
    public List<Job> findSelectJob(int departmentId);
}
