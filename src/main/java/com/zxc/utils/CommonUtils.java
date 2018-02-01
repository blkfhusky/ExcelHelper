package com.zxc.utils;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: BlkFHusky
 * @date: 2018/1/27
 * @description: 数据工具类
 */
public class CommonUtils {

    private static final String SPLIT = ",";

    /**
     * 检查集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean collectionIsNull(Collection collection) {
        return null == collection || collection.size() <= 0;
    }

    /**
     * 检查map是否为0
     *
     * @param map
     * @return
     */
    public static boolean mapIsNull(Map map) {
        return null == map || map.size() <= 0;
    }

    /**
     * 将逗号拼接的字符串按逗号分隔成int数组
     *
     * @param arrStr
     * @return
     */
    public static int[] split(String arrStr) {
        if (strIsEmpty(arrStr)) {
            return null;
        }
        String[] arrs = arrStr.split(SPLIT);
        return Stream.of(arrs).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 校验string是否为空
     *
     * @param str
     * @return
     */
    public static boolean strIsEmpty(String str) {
        return null == str || "".equals(str);
    }
}
