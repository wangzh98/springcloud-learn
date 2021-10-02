package com.wzh.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;

    //一个服务对应一个数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}


