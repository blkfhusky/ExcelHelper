package com.zxc.core.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: BlkFHusky
 * @date: 2018/1/27
 * @description: 每个sheet对象
 */
@Data
public class SheetEntity {

    /**
     * 表头开始行（从0开始）
     */
    private Integer headIndex;

    /**
     * 表头 key:列索引（从0开始），value：列名
     */
    private Map<Integer, List<String>> header;

    /**
     * excel内数据 key：行索引（从0开始），value：行数据
     */
    private Map<Integer, List<String>> datas;
}
