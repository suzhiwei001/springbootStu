package com.szw.springbootdemosu.filter.sign;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: 签名算法
 */
public class SignOauthUtil {

    private static Logger logger = LoggerFactory.getLogger(SignOauthUtil.class);

    private static final String SIGN_METHOD_MD5 = "md5";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 根据参数生成签名
     *
     * @param params     参数
     * @return 签名
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static String signRequest(String params, String secretKey) throws IOException,
            NoSuchAlgorithmException {

        if (Objects.isNull(params) || StringUtils.isEmpty(secretKey)) {
            return null;
        }

        StringBuffer buffer = new StringBuffer(params);

        buffer.append("=");

        buffer.append(secretKey);

        logger.info("签名前的参数串：" + buffer.toString());

        byte[] bytes = encryptMD5(buffer.toString());

        String result = byte2hex(bytes);

        logger.info("签名后的参数串：" + result);

        return result;
    }

    /**
     * MD5加密
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static byte[] encryptMD5(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] btInput = data.getBytes("utf-8");
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance(SIGN_METHOD_MD5);
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        return md;
    }

    /**
     * 二进制转化为大写的十六进制
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
