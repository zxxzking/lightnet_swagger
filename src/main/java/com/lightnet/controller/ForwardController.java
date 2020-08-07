package com.lightnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ForwardController {

    @RequestMapping("/")
    public String forwardDocsPage() {
        return "redirect:/docs.html";
    }
}
