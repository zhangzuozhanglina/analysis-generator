package com.code.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.code.generator.domain.Enum.TableInfoType;
import com.code.generator.domain.dto.ColumnInfo;
import com.code.generator.domain.dto.MySqlTableInfo;
import com.code.generator.mapper.MysqlDatabaseInfoMapper;
import com.code.generator.service.MysqlDatabaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: analysis-generator
 * @description:
 * @author: zhengzz
 * @create: 2020-02-11 22:59
 **/
@Service
public class MysqlDatabaseInfoServiceImpl  implements MysqlDatabaseInfoService {
    @Autowired
    private MysqlDatabaseInfoMapper mapper;
    @Override
    public HashMap<String,MySqlTableInfo> getTablesInfo() {
       List<HashMap<String,String>> rs= mapper.getTables();
       HashMap<String,MySqlTableInfo> tables= new HashMap<String,MySqlTableInfo>();
 rs.stream().map(table->{
     addTable(table,tables);
     return null;
     }).collect(Collectors.toList());
        return tables;
    }

    @Override
    public boolean saveBatch(Collection<MySqlTableInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MySqlTableInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<MySqlTableInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(MySqlTableInfo entity) {
        return false;
    }

    @Override
    public MySqlTableInfo getOne(Wrapper<MySqlTableInfo> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<MySqlTableInfo> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<MySqlTableInfo> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<MySqlTableInfo> getBaseMapper() {
        return null;
    }

    public  final static  void addTable(HashMap<String,String> rs,HashMap<String,MySqlTableInfo> tables) {
        System.out.println(rs.toString());
        String tableName=rs.get(TableInfoType.TABLENAME.name());
       if(tables.containsKey(tableName)) {
          MySqlTableInfo info= tables.get(tableName);
           ArrayList<ColumnInfo> cols =info.getColumnInfos()==null?new ArrayList<>():info.getColumnInfos();
           cols.add(setColumn(rs));
           info.setColumnInfos(cols);
           tables.put(tableName,info);
           return ;
       }else {
           MySqlTableInfo info = new MySqlTableInfo();
           info.setComment(rs.get(TableInfoType.TABLECOM.getValue()));
           info.setTableName(tableName);
           tables.put(tableName,info);
           addTable(rs,tables);
       }
    }
    public static ColumnInfo setColumn(HashMap<String,String> rs) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(rs.get(TableInfoType.COLNAME.getValue()));
        columnInfo.setColumnComment(rs.get(TableInfoType.COLCOM.getValue()));
        boolean isPrimary=rs.get(TableInfoType.PRIMARY.getValue())==null?false:true;
        columnInfo.setIsPrimaryKey(isPrimary);
        //columnInfo.setSqlType();
       // columnInfo.setJavaType();
        return  columnInfo;
    }

}
