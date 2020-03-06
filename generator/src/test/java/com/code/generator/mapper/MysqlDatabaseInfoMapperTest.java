package com.code.generator.mapper;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @program: analysis-generator
 * @description:
 * @author: zhengzz
 * @create: 2020-02-11 22:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MysqlDatabaseInfoMapperTest {
    @Autowired
    private  MysqlDatabaseInfoMapper mysqlDatabaseInfoMapper;
    @Test
    public void testgetTables(){
        System.out.println(mysqlDatabaseInfoMapper.toString());
       List<HashMap<String,String>> rs= mysqlDatabaseInfoMapper.getTables();
       log.info(rs.toString());
    }
}
