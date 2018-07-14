package cn.standard.controller;
import cn.standard.dao.SendbillMapper;
import cn.standard.tools.PieChart;
import com.alibaba.fastjson.JSON;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class Picture {
    @Autowired
    private SendbillMapper sendbillMapper;
    @RequestMapping(value = "/paixue")
    @ResponseBody
    public String paixue(HttpSession session){
        int count1 = sendbillMapper.seclectCount("淮安","盐城");
        int count2 = sendbillMapper.seclectCount("淮安","广州");
        int count3 = sendbillMapper.seclectCount("淮安","上海");
        PieChart p = new PieChart();
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(count2, "淮安-广州", "广州");
        defaultCategoryDataset.addValue(count3, "淮安-上海", "上海");
        defaultCategoryDataset.addValue(count1, "淮安-盐城", "盐城");
        p.setDefaultCategoryDataset(defaultCategoryDataset);
        String fileName = "";
        try {
             fileName = p.genBarChart(session);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("fileName",fileName);
        return JSON.toJSONString(hashMap);


    }
}
