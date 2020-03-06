package com.code.generator.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: analysis-generator
 * @description: 基于MySQL数据表信息
 * @author: zhengzz
 * @create: 2020-02-11 22:42
 **/
@Data
@ApiModel
public class MySqlTableInfo {
    @ApiModelProperty(name = "表名")
    private String tableName;
    private  String comment;
    private String charset;
    ArrayList<ColumnInfo> columnInfos;
}
