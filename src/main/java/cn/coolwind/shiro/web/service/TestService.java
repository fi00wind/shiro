package cn.coolwind.shiro.web.service;

import cn.coolwind.shiro.web.dao.TestDao;
import cn.coolwind.shiro.web.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public Test getById(int id) {
        return testDao.getById(id);
    }
}
