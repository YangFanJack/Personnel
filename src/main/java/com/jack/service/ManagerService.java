package com.jack.service;

import com.jack.pojo.Manager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ManagerService {
    /**
     * 人事管理员登录
     * @return
     */
    public boolean login(Manager manager);
}
