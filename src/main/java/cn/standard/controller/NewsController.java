package cn.standard.controller;

import cn.standard.dao.NewsCommentMapper;
import cn.standard.dao.NewsDetailMapper;
import cn.standard.pojo.NewsComment;
import cn.standard.pojo.NewsDetail;
import cn.standard.service.NewsMapperService;
import cn.standard.tools.Page;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsMapperService newsMapperService;
    @Autowired
    private NewsDetailMapper newsDetailMapper;
    @Autowired
    private NewsCommentMapper newsCommentMapper;
    @RequestMapping(value = "gocomment")
    public ModelAndView first(@RequestParam Integer id){
        List<NewsComment> list = newsCommentMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("comment");
        return mv;
    }


    @RequestMapping(value = "/list")
    public ModelAndView index(@RequestParam(value = "name",required = false)String name, @RequestParam(value = "pageNo",required = false) Integer pageNo, @RequestParam(value = "pageSize",required = false) Integer pageSize){
        Page<NewsDetail> page = new Page();
        ModelAndView mv = new  ModelAndView();
        int totalCount = 0;
        if(pageNo==null){
            pageNo=1;
        }
        if(name==null){
            totalCount = newsDetailMapper.selectCount();
        }else {
            totalCount = newsDetailMapper.selectCountName(name);
        }

        List<NewsDetail> newslist = newsMapperService.findAllInfosByPageByName(name, pageNo, 2);
        page.setPageSize(2);
        page.setTotalCount(totalCount);
        page.setPageNo(pageNo);

        page.setList(newslist);
        mv.addObject("name",name);
        mv.addObject("news",page);
        mv.setViewName("newslist");
        return mv;
    }

    @RequestMapping(value = "goaddcomment")
    public ModelAndView goaddcomment(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addcomment");
        mv.addObject("id",id);
        return mv;
    }
    @RequestMapping(value = "insertcomment")
    public String insert(@RequestParam Integer id,
                               @RequestParam String author,
                               @RequestParam String content

    ){
        NewsComment newsComment = new NewsComment();
        newsComment.setNewsid(id);
        newsComment.setAuthor(author);
        newsComment.setContent(content);
        newsComment.setCreatedate(new Date());
        newsCommentMapper.insertSelective(newsComment);
        return "forward:gocomment";
    }


    @RequestMapping(value = "dele")
    @ResponseBody
    public String dele(@RequestParam Integer id){
        int del = newsDetailMapper.deleteByPrimaryKey(id);
        return  JSON.toJSONString(del);
    }

}
