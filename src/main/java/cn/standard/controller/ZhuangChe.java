package cn.standard.controller;
import cn.standard.dao.SendbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZhuangChe {

    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/zhuangche")
    public String zhuangche(@RequestParam Integer id,@RequestParam Integer carid){
        sendbillMapper.updateById(id,carid);
        return "hwpz";
    }

}
