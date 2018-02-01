package com.zxc.utils;

import java.io.File;

/**
 * @author: BlkFHusky
 * @date: 2018/2/1
 * @description: 文件工具类
 */
public class FileUtils {

    /**
     * 根据文件路径获取文件
     *
     * @param filePath
     * @return
     */
    public static File getFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        return file;
    }

}
