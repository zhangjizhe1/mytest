package com.easymall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping("/forward/{path}.action")
    public String forward(@PathVariable("path") String path){
        return "forward:/WEB-INF/jsp/"+path+".jsp";
    }
}
