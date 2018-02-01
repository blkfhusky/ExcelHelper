package com.zxc.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.*;

/**
 * @author: BlkFHusky
 * @date: 2018/1/30
 * @description:
 */
public class ExcelUtils {

    /**
     * 读取excel行
     *
     * @param row
     * @return key:index(0-based), value:row datas
     */
    public static Map<Integer, List<String>>  readRow(Row row) {
        if (null != row && row.getLastCellNum() > 0) {
            List<String> list = new ArrayList<>();
            Iterator<Cell> it = row.cellIterator();
            while (it.hasNext()) {
                Cell cell = it.next();
                list.add(null != cell ? cell.toString() : "");
            }
            Map<Integer, List<String>> map = new HashMap<>();
            map.put(row.getRowNum(), list);
            return map;
        }
        return null;
    }

}
