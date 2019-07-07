package com.chenlei.elasticsearch.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ValidationUtils
 * Function:  参数校验工具
 * Date:      2018-11-19 14:40
 * version    V1.0
 */
public class ValidationUtils {

	public static final String MOBILE_PATTERN = "^(1[3-9])\\d{9}$";
    /**
     * @Function 判断是否是手机号
     * @author   likaixuan
     * @Date     2018-11-19 14:41
     * @param    [phone]
     * @return   boolean
     */
    public static boolean isPhone(String phone) {

        Pattern pattern = Pattern.compile(MOBILE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
