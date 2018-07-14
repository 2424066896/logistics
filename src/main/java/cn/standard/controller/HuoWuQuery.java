package cn.standard.controller;
import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import cn.standard.tools.Page;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HuoWuQuery {

    @Autowired
    private SendbillMapper sendbillMapper;

    @RequestMapping(value = "/huoWuQuery")
   /* @ResponseBody*/
    public ModelAndView huoWuQuery(@RequestParam(value = "start",required = false) String start,
                                   @RequestParam(value = "end",required = false) String end,
                                   @RequestParam(value = "senddate",required = false) String senddate,
                                   @RequestParam(value = "sendnum",required = false) String sendnum,
                                   @RequestParam(value = "goods",required = false) String goods,
                                   @RequestParam(value = "goodsstateid",required = false) Integer goodsstateid,
                                   @RequestParam(value = "pageNo",required = false)Integer pageNo,
                                   @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                   ModelAndView mv
                             ) {

        int totalCount=0;
        System.out.println(pageNo+"==========================");
        if(start==null&&end==null&&senddate==null&&sendnum==null&&goods==null&&goodsstateid==null){
           totalCount = sendbillMapper.count();
       }
       if(start!=null||end!=null||senddate!=null||sendnum!=null||goods!=null||goodsstateid!=null){
           totalCount = sendbillMapper.countByCondition(start,end,senddate,sendnum,goods,goodsstateid);
       }
        pageSize=1;
       if(pageNo==null||pageSize==null){
            pageNo=1;
       }
        List<Sendbill> queryList = sendbillMapper.selectByDuoTiaojian(start,end,senddate,sendnum,goods,goodsstateid,(pageNo-1)*pageSize,pageSize);

        Page<Sendbill> page = new Page();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setList(queryList);
        page.setPageNo(pageNo);
        mv.addObject("page",page);
        mv.setViewName("query");
        return mv;
    }
}
