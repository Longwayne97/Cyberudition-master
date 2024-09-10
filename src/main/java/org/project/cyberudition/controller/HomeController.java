package org.project.cyberudition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String Home(){
        return "web/index";
    }

    @RequestMapping("/about")
    public String About(){
        return "web/about";
    }

    @RequestMapping("/center")
    public String Center(){
        return "web/center";
    }

    @RequestMapping("/event")
    public String Event(){
        return "web/event";
    }

    @RequestMapping("/contract")
    public String Contract(){
        return "web/contract";
    }

    @RequestMapping("/solana")
    public String solana(){
        return "web/123";
    }

}
