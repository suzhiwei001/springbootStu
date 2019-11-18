package com.szw.springbootdemosu.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.szw.springbootdemosu.entity.ResultVO;
import com.szw.springbootdemosu.filter.base.RequestParams;
import com.szw.springbootdemosu.filter.constants.ResultCodeMessage;
import com.szw.springbootdemosu.filter.sign.ClientEnum;
import com.szw.springbootdemosu.filter.sign.SignOauthUtil;
import com.szw.springbootdemosu.filter.util.GetRequestJsonUtils;
import com.szw.springbootdemosu.filter.util.RequestWrapper;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author: uzdz
 * @date: 2018/8/30 14:23
 * @description:
 */
public class BaseFilterTwo implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ResultVO resultVo = new ResultVO();
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        List<String> split = Splitter.on("/").trimResults().omitEmptyStrings().limit(2).splitToList(requestURI);

        System.out.println(split.toString());

        RequestParams params = GetRequestJsonUtils.getRequestJsonObject(request);
        System.out.println(params);

        // 对请求参数进行加密
        String sign = null;
        try {
            sign = SignOauthUtil.signRequest(params.getData() == null ? "" : params.getData(),
                    ClientEnum.getClientSecretKey(params.getClient()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
        if(!sign.equals(params.getSign())){
            resultVo.setCode(ResultCodeMessage.SIGN_FAIL_ERROR_CODE);
            resultVo.setMsg(ResultCodeMessage.SIGN_FAIL_ERROR_MESSAGE);
            response.getWriter().write(objectMapper.writeValueAsString(resultVo));
            return;
        }


        /**
         * 对data参数进行解析，适配controller入参格式
         */
        String data = params.getData();
        if(!StringUtils.isEmpty(data)){
            RequestWrapper requestWrapper = (RequestWrapper)request;
            requestWrapper.setRequestBody(data.getBytes());
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
