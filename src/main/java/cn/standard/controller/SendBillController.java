package cn.standard.controller;

import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendBillController {

    @Autowired
    private SendbillMapper sendbillMapper;

    @RequestMapping(value = "/addbill")
    public String add(Sendbill sendbill) {
        sendbillMapper.insertSelective(sendbill);
        return "index";
    }

    @RequestMapping(value = "/checkSendNum")
    @ResponseBody
    public String checkSendNum(@RequestParam String p) {
        Sendbill a = sendbillMapper.selectBySendNum(p);
        String message = "";
        if(a!=null){
            message = "fail";
        } else {
            message ="ok";
        }
        return JSON.toJSONString(message);
    }

}
