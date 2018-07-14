package cn.standard.controller;

import cn.standard.dao.UserMapper;
import cn.standard.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/login")
    public ModelAndView test(User user,ModelAndView mv){
        User u = userMapper.selectByPwdWithName(user);
        String message="";
        if(u==null){
            message = "用户名或者密码错误！";
            mv.setViewName("login");
            mv.addObject("message",message);
        }else {
            mv.setViewName("index");
        }
        return mv;
    }

}
