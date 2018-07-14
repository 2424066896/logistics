package cn.standard.controller;

import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Modify {
    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/modify")
    public ModelAndView modify(ModelAndView mv, Sendbill sendbill, @RequestParam Integer id) {
        sendbill.setId(id);
        int send = sendbillMapper.updateByPrimaryKeySelective(sendbill);
        String message = "";
        if(send>0){
            message = "修改成功";
        }
        //返回的是ModelAndView对象
        mv.addObject("message",message);
        mv.setViewName("hwpz");
        return mv;
    }
}
