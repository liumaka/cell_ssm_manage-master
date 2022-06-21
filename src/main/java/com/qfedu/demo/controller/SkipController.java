package com.qfedu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("skip")
public class SkipController {

    @RequestMapping("imageupload")
    private String index(){
        return "imageupload";
    }
}
