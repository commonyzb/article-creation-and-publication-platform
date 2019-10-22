package com.yzb.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println(dataSource.getClass());
        DruidDataSource druidDataSource=(DruidDataSource) dataSource;
        System.out.println(druidDataSource.getProperties());
        System.out.println(druidDataSource.getMinIdle());
        System.out.println(druidDataSource.getValidationQuery());
    }


}
