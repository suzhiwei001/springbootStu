package com.szw.springbootdemosu.filter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szw.springbootdemosu.filter.base.RequestParams;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: 解析body请求参数.
 */
public class GetRequestJsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将http中的inputSteam转换为RequestParams对象
     * @param request
     * @return
     * @throws IOException
     */
    public static RequestParams getRequestJsonObject(HttpServletRequest request) throws IOException {
        String json = getRequestJsonString(request);
        //return objectMapper.readValue(json, RequestParams.class);
        return JSONUtils.json2Obj(json, RequestParams.class);
    }


    /***
     * 获取 request 中 json 字符串的内容
     *
     * @param request
     * @return :
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:将request中的inputSteam转换为字节数组
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        return StreamUtils.copyToByteArray(request.getInputStream());
    }

    /**
     * 描述:将字节数组转换为字符串
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte[] buffer = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

}
