package cn.standard.controller;

import cn.standard.dao.FahuodanMapper;
import cn.standard.pojo.Fahuodan;
import cn.standard.tools.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaveProducts {

    @Autowired
    private FahuodanMapper fahuodanMapper;
    @Autowired
    private Test test;

    @RequestMapping(value = "/fahuo")
    public  String test(Fahuodan fahuodan, ModelAndView modelAndView){
        fahuodan.setDanhao(test.nextCode());
        fahuodanMapper.insertSelective(fahuodan);
        System.out.println(test.nextCode());
        System.out.println("======================");

        return "index";
    }


}
