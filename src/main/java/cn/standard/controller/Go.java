package cn.standard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Go {
    @RequestMapping(value = "/goindex")
    public  String test(){
        return "index";
    }
    @RequestMapping(value = "/gohwpz")
    public  String test1(){
        return "hwpz";
    }

    @RequestMapping(value = "/goquery")
    public  String test2(){
        return "query";
    }

    @RequestMapping(value = "/goconfirm")
    public  String test3(){
        return "confirm";
    }


    @RequestMapping(value = "/lo")
    public  String test4(){
        return "login";
    }


    @RequestMapping(value = "/gopeizai")
    public ModelAndView test5(@RequestParam Integer id,ModelAndView mv){
        mv.setViewName("gopeizai");
        mv.addObject("id",id);
        return mv;
    }



    @RequestMapping(value = "/gopaixu")
    public  String gopaixu(){
        return "paixue";
    }

}
