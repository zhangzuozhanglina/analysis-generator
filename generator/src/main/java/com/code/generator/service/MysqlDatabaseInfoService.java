package com.code.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.code.generator.domain.dto.MySqlTableInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface MysqlDatabaseInfoService extends IService<MySqlTableInfo> {
    public HashMap<String,MySqlTableInfo> getTablesInfo();
}
