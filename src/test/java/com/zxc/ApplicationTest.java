package com.zxc;

import com.zxc.core.ExcelBuilder;
import com.zxc.core.entity.ExcelEntity;
import com.zxc.utils.FileUtils;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple Application.
 */
public class ApplicationTest {

    @Test
    public void buildExcel() {
        String filePath = "/Users/blkfhusky/Desktop/e1.xlsx";
        File file = FileUtils.getFile(filePath);
        ExcelBuilder builder = new ExcelBuilder();
        ExcelEntity entity = builder.buile(file, "1");
        System.out.println(entity);

    }

}