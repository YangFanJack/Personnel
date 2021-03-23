package com.jack.service.impl;

import com.jack.dao.JobDao;
import com.jack.pojo.Department;
import com.jack.pojo.Job;
import com.jack.pojo.PageBean;
import com.jack.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;


    /**
     * 添加岗位
     *
     * @return
     */
    @Override
    public boolean insertJob(Job job) {
        try{
            int i = jobDao.insertJob(job);
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
     * 删除岗位
     *
     * @return
     */
    @Override
    public boolean deleteJob(int jobId) {
        try{
            int i = jobDao.deleteJob(jobId);
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
     * 更新岗位
     *
     * @return
     */
    @Override
    public boolean updateJob(Job job) {
        try{
            int i = jobDao.updateJob(job);
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
     * 分页查找所有岗位
     *
     * @return
     */
    @Override
    public PageBean<Job> selectAllJobByPage(int currentPage, int pageSize, String searchString) {
        PageBean<Job> jobPageBean = new PageBean<>();
        jobPageBean.setCurrentPage(currentPage);
        jobPageBean.setPageSize(pageSize);

        Map<String,Object> map1 = new HashMap<>();
        if(searchString!=null){
            searchString = "%"+searchString+"%";
        }

        //调用dao查询总记录数
        map1.put("name",searchString);
        int totalCount = jobDao.selectAllJobByPageCount(map1);
        jobPageBean.setTotalCount(totalCount);

        int start = (currentPage-1)*pageSize;
        Map<String,Object> map2 = new HashMap<>();
        map2.put("start",start);
        map2.put("pageSize",pageSize);
        map2.put("name",searchString);
        List<Job> jobs = jobDao.selectAllJobByPage(map2);
        jobPageBean.setList(jobs);

        //设置总页码
        int totalPage = (totalCount % pageSize ) == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;
        jobPageBean.setTotalPage(totalPage);
        return jobPageBean;
    }

    /**
     * 查找指定部门的所有岗位
     *
     * @return
     */
    @Override
    public List<Job> findSelectJob(int departmentId) {
        List<Job> selectJob = jobDao.findSelectJob(departmentId);
        return selectJob;
    }
}
