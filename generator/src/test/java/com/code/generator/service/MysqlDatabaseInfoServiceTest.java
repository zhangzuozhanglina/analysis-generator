package com.code.generator.service;

import com.code.generator.BaseTest;
import com.code.generator.domain.dto.MySqlTableInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @program: analysis-generator
 * @description:
 * @author: zhengzz
 * @create: 2020-02-12 10:36
 **/
@Slf4j
public class MysqlDatabaseInfoServiceTest extends BaseTest {
    @Autowired
    private MysqlDatabaseInfoService service;
    @Test
    public void testGetTableInfo() {
        log.info(service.toString());
        HashMap<String, MySqlTableInfo> infos= service.getTablesInfo();
        log.info(infos.toString());
    }
}
