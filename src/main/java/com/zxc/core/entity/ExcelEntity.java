package com.zxc.core.entity;

import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * @author: BlkFHusky
 * @date: 2018/2018/1/27
 * @description: excel表格对象
 */
@Data
public class ExcelEntity {

    /**
     * workbook对象
     */
    private Workbook workbook;

    /**
     * 所有sheet
     */
    private List<SheetEntity> sheets;

}
