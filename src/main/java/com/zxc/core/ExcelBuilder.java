package com.zxc.core;

import com.zxc.core.entity.ExcelEntity;
import com.zxc.core.entity.SheetEntity;
import com.zxc.utils.CommonUtils;
import com.zxc.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: BlkFHusky
 * @date: 2018/1/27
 * @description: 读取excel
 */
@Slf4j
public class ExcelBuilder {

    /**
     * 构建excel实体
     *
     * @param file
     * @param headIndexs 逗号拼接的头索引(0-based)。如果只有一个则表示所有的sheet索引为同一个
     * @return
     */
    public ExcelEntity buile(File file, String headIndexs) {
        ExcelEntity entity = new ExcelEntity();
        try {
            Workbook workbook = readExcel(file);
            entity.setWorkbook(workbook);
            List<Sheet> sheets = getSheets(workbook);
            int[] indexs = CommonUtils.split(headIndexs);
            if (null != indexs && (1 == indexs.length || indexs.length == sheets.size())) {
                List<SheetEntity> list = new ArrayList<>();
                for (int i = 0; i < indexs.length; i++) {
                    SheetEntity sheetEntity = getSheetEntity(sheets.get(i), indexs[i]);
                    list.add(sheetEntity);
                }
                entity.setSheets(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * 读取excel的workbook
     *
     * @param file
     * @return
     * @throws Exception
     */
    public Workbook readExcel(File file) throws Exception {
        return WorkbookFactory.create(file);
    }

    /**
     * 获取workbook中所有sheet
     *
     * @param workbook
     * @return
     */
    public List<Sheet> getSheets(Workbook workbook) {
        int size = workbook.getNumberOfSheets();
        if (size > 0) {
            ArrayList<Sheet> sheets = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                sheets.add(workbook.getSheetAt(i));
            }
            return sheets;
        }
        return null;
    }

    /**
     * 获取excel sheet实体
     *
     * @param sheet
     * @param headIndex 0-based
     * @return
     */
    public SheetEntity getSheetEntity(Sheet sheet, int headIndex) {
        SheetEntity entity = new SheetEntity();
        entity.setHeadIndex(headIndex);
        Row headRow = sheet.getRow(headIndex - 1);
        entity.setHeader(ExcelUtils.readRow(headRow));
        int lastRowNum = sheet.getLastRowNum();
        if (lastRowNum > headIndex) {
            Map<Integer, List<String>> datas = new HashMap<>();
            for (int i = headIndex; i <= lastRowNum; i++) {
                datas.putAll(ExcelUtils.readRow(sheet.getRow(i)));
            }
            entity.setDatas(datas);
        }
        return entity;
    }

}
