package com.code.generator.domain.dto;

import lombok.Data;

/**
 * @program: analysis-generator
 * @description:
 * @author: zhengzz
 * @create: 2020-02-12 10:17
 **/
@Data
public class  ColumnInfo {
    private  String columnName;
    private String columnComment;
    private  String sqlType;
    private Class<?> javaType;
    private Boolean isPrimaryKey;
}
