package com.code.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Resource
public interface MysqlDatabaseInfoMapper extends BaseMapper<Object> {
    public List<HashMap<String,String>> getTables();
}
