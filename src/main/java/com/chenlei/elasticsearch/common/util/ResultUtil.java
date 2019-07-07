package com.chenlei.elasticsearch.common.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chenlei.elasticsearch.common.enums.EnumResult;
import com.chenlei.elasticsearch.vo.ResultVO;

public class ResultUtil {

    /**
     * 成功
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultVO result = new ResultVO();
        result.setCode(EnumResult.SUCCESS.getCode());
        result.setMsg(EnumResult.SUCCESS.getMsg());
        // 处理json属性值存在null值
        result.setData(JSONObject.parse(JSONObject.toJSONString(object, SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse)));
        return result;
    }

    /**
     * 
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 
     * @param enumResult
     * @return
     */
    public static ResultVO error(EnumResult enumResult) {
        ResultVO result = new ResultVO();
        result.setCode(enumResult.getCode());
        result.setMsg(enumResult.getMsg());
        return result;
    }

}
