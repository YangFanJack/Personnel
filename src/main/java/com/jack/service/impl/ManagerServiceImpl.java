package com.jack.service.impl;

import com.jack.dao.ManagerDao;
import com.jack.pojo.Manager;
import com.jack.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;


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
