package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.util.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 * @Describe
 */
@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public ResultVO pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
            return new ResultVO(message);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultVO(message);
        }
    }
}
