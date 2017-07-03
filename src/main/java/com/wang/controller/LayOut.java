package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangxiangyun on 2017/7/3.
 */
@Controller
public class LayOut {
    @RequestMapping("/index")
    public String index() {
        return "layout/index";
    }
}
