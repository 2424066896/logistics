package cn.standard.controller;

import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Query {
    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/query")
    public ModelAndView query(ModelAndView mv, @RequestParam Integer id) {
        Sendbill send = sendbillMapper.selectByPrimaryKey(id);
        mv.addObject("send",send);
        mv.addObject("id",id);
        //返回的是ModelAndView对象
        mv.setViewName("modify");
        return mv;
    }
}
