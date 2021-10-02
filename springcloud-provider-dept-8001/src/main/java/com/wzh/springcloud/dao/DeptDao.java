package com.wzh.springcloud.dao;


import com.wzh.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept queryById(@Param("deptno") long id);

    public List<Dept> queryAll();
}
