package com.szw.springbootdemosu.filter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author suzhiwei
 * @Date 2019/11/14
 * @Describe
 */
public class RequestWrapper extends HttpServletRequestWrapper {
    private static final Logger logger = LoggerFactory.getLogger(RequestWrapper.class);
    /**
     * 用于保存流配置
     */
    private byte[] requestBody = null;

    public void setRequestBody(byte[] body){
        this.requestBody = body;
    }

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            //得到request输入流
            ServletInputStream inputStream = request.getInputStream();
            //把得到的输入流放入数组中
            requestBody = StreamUtils.copyToByteArray(inputStream);
        } catch (IOException e) {
            logger.error("缓存requestBody异常",e);
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (requestBody == null) {
            requestBody = new byte[0];
        }
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public String getBody(){
        return new String(this.requestBody);
    }
}
