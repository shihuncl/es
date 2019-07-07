package com.chenlei.elasticsearch.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.chenlei.elasticsearch.common.enums.EnumResult;
import com.chenlei.elasticsearch.vo.SimpleResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 默认全局异常处理类
 * 
 * @author ZY
 * @date 2018/10/18
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);


    /**
     * 业务异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public void handBizException(BizException e, HttpServletResponse response) {
        SimpleResultVO result = new SimpleResultVO();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        writeJson(result, response);
    }

    /**
     * 其它异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public void handException(Exception e, HttpServletResponse response) {
        logger.error("系统异常：", e);
        SimpleResultVO result = new SimpleResultVO();
        result.setCode(EnumResult.SYSTEM_EXCEPTION.getCode());
        result.setMsg(EnumResult.SYSTEM_EXCEPTION.getMsg());
        writeJson(result, response);
    }

    /**
     * 以json形式输出异常信息
     * 
     * @param result
     * @param response
     */
    private void writeJson(SimpleResultVO result, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
