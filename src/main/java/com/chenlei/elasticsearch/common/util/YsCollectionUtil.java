package com.chenlei.elasticsearch.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 集合工具类
 * @date 2018/10/09
 */
public class YsCollectionUtil {

    /**
     * 复制List对象
     *
     * @param poList
     * @param voClass
     * @return
     */
    public static List copyList(List<? extends Object> poList, Class voClass) {

        List<Object> voList = new ArrayList<>();

        Object voObj = null;
        for (Object poObj : poList) {
            try {
                voObj = voClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(poObj, voObj);
            voList.add(voObj);
        }
        return voList;
    }

    /**
     * 创建hashMap
     *
     * @return
     */
    public static Map<String, Object> createHashMap() {
        return new HashMap<String, Object>(5);
    }

    /**
     * 创建hashMap
     *
     * @return
     */
    public static Map<String, Integer> createHashMapInteger() {
        return new HashMap<String, Integer>(5);
    }

    /**
     * 创建hashMap
     *
     * @return
     */
    public static Map<String, Double> createHashMapDouble() {
        return new HashMap<String, Double>(5);
    }

    /**
     * 数组转化为特定格式分隔的字符串
     *
     * @param list
     * @param regex
     * @return
     */
    public static String getStringOfInteger(List<Integer> list, String regex) {
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i).append(regex);
        }
        if (sb.lastIndexOf(regex) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(regex));
        }
        return sb.toString();
    }

    /**
     * 数组转化为特定格式分隔的字符串
     *
     * @param list
     * @param regex
     * @return
     */
    public static String getStringOfString(List<String> list, String regex) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s).append(regex);
        }
        if (sb.lastIndexOf(regex) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(regex));
        }
        return sb.toString();
    }


    /**
     * List实体类转listMap
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<Map<String,Object>> entityConvertMap(List<T> list){
        List<Map<String,Object>> l = new LinkedList<>();
        try {
            for(T t : list){
                Map<String,Object> map = new HashMap<>();
                Method[] methods = t.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getName().startsWith("get") && !"getClass".equals(method.getName())) {
                        String name = method.getName().substring(3);
                        name = name.substring(0, 1).toLowerCase() + name.substring(1);
                        Object value = method.invoke(t);
                        map.put(name,value);
                    }
                }
                l.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * 实体类转换成Map
     * @param obj
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



}
