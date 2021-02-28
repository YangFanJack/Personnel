package com.jack.service.impl;

import com.jack.dao.ManagerDao;
import com.jack.pojo.Manager;
import com.jack.service.ManagerService;

import java.util.HashMap;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    /**
     * 人事管理员登录
     *
     * @return
     */
    @Override
    public boolean login(Manager manager) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username",manager.getUsername());
        map.put("password",manager.getPassword());
        Manager man = managerDao.selectManager(map);
        try{
            if(man != null){
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
