package com.chenlei.elasticsearch.common.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 * 
 * @author ZY
 * @date 2018/12/04
 */
public class YsStringUtil {

    /**
     * 拆分字符串为List<Integer>
     * 
     * @param str
     * @param regex
     * @return
     */
    public static List<Integer> splitToInteger(String str, String regex) {
        List<Integer> list = new ArrayList<Integer>();
        if (!StringUtils.isEmpty(str)) {
            for (String s : str.split(regex)) {
                list.add(Integer.valueOf(s));
            }
        }
        return list;
    }

    /**
     * 拆分字符串为List<Long>
     * 
     * @param str
     * @param regex
     * @return
     */
    public static List<Long> splitToLong(String str, String regex) {
        List<Long> list = new ArrayList<Long>();
        if (!StringUtils.isEmpty(str)) {
            for (String s : str.split(regex)) {
                list.add(Long.valueOf(s));
            }
        }
        return list;
    }

    /**
     * 拆分字符串为List<String>
     * 
     * @param str
     * @param regex
     * @return
     */
    public static List<String> splitToString(String str, String regex) {
        List<String> list = new ArrayList<String>();
        if (!StringUtils.isEmpty(str)) {
            for (String s : str.split(regex)) {
                list.add(s);
            }
        }
        return list;
    }
}
