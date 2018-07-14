package cn.standard.dao;
import cn.standard.pojo.NewsComment;
import cn.standard.pojo.NewsDetail;
import cn.standard.service.NewsMapperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mybatis.xml")
public class NewsDetailMapperTest {
   @Autowired
    private  NewsDetailMapper newsDetailMapper;
    @Autowired
    private NewsMapperService newsMapperService;
    @Autowired
    private NewsCommentMapper newsCommentMapper;
    @Test
    public void testselectCount(){
        System.out.println(newsDetailMapper.selectCount());
        System.out.println(newsDetailMapper.selectCountName("3"));
    }
    @Test
    public void testselecPage(){
        List<NewsDetail> a = newsDetailMapper.findAllNewsByNameWithPage(null, 1, 3);
        for(NewsDetail n:a){
            System.out.println(n.getTitle());
        }
    }
    @Test
    public void testselecPages(){
        List<NewsDetail> a = newsMapperService.findAllInfosByPageByName("",1,3);
        for(NewsDetail n:a){
            System.out.println(n.getTitle());
        }
    }

    @Test
    public void testselecComment(){
        List<NewsComment> a = newsCommentMapper.selectByPrimaryKey(3);
        for(NewsComment n:a){
            System.out.println(n.getContent());
        }
    }

}