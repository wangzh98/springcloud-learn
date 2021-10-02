package com.wzh.springcloud.service;

import com.wzh.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(long id);

    public List<Dept> queryAll();
}
