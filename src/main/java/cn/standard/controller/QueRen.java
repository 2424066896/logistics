package cn.standard.controller;

import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class QueRen {
    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/queren")
    @ResponseBody
    public String queren(@RequestParam Integer id) {
        int a= sendbillMapper.updateByGoodsId(id,2);
        String hinit="";
        if(a>0){
            hinit="ok";
        }
        return JSON.toJSONString(hinit);
    }
}
