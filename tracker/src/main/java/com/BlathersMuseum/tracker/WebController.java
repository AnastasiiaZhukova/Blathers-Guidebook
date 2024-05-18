package com.BlathersMuseum.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

}
