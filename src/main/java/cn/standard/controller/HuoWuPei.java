package cn.standard.controller;
import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HuoWuPei {
    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/pei")
    @ResponseBody
    public String pei(){
        List<Sendbill> list = sendbillMapper.selectBySendnum();
        return JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
    }




}
