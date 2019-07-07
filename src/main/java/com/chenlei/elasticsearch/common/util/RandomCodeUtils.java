package com.chenlei.elasticsearch.common.util;

import java.util.Random;

/**
 * 生产随机验证码工具类
 */
public class RandomCodeUtils {

    public static String getRandNum(int charCount) {
        String charValue ="";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        //临时测试用，上线后需要注释
//        return "000000";
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

}
