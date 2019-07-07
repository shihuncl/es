package com.chenlei.elasticsearch.common.util;

import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * PHP反序列化工具类
 */
public class PHPSerializeUtils {

    /**
     * 反序列化php序列化的数组
     */
    public static <T> List<T> unserialize(String str, T t) {
        if (str == null || "".equals(str)) {
            return null;
        }
        //需把正式商品重新编辑一次，否则此处可能会报错
//        String[] strSpilt=str.split("i:");
//        String strNew=strSpilt[0];
//        for(int i=1;i<strSpilt.length;i++){
//            strNew+="i:"+(i-1)+strSpilt[i].substring(1);
//        }
        List<T> list = null;
        try {
            PHPSerializer p = new PHPSerializer();
            AssocArray array = null;
            array = (AssocArray) p.unserialize(str.getBytes(), AssocArray.class);
            list = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                T e = (T) Cast.cast(array.get(i), (Class) t);
                list.add(e);
            }
        } catch (Exception ex) {

        }
        return list;
    }
    /**
     * 把list序列化成字符串
     * @param list
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static String serialize(List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	if (list == null || list.size()==0) {
            return null;
        }
		PHPSerializer p = new PHPSerializer();
		byte[] serialize = p.serialize(list);
    	return new String(serialize);
    }
    /**
     * 把list序列化成字符串
     * @param o
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static String serialize(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PHPSerializer p = new PHPSerializer();
		byte[] serialize = p.serialize(o);
    	return new String(serialize);
    }

    /**
     * 数组转化为特定格式分隔的字符串
     *
     * @param list
     * @param regex
     * @return
     */
    public static String getStringOfString(List<String> list, String regex) {
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s).append(regex);
        }
        if (sb.lastIndexOf(regex) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(regex));
        }
        return sb.toString();
    }
}
