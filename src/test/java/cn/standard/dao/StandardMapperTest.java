package cn.standard.dao;

import cn.standard.pojo.Sendbill;
import cn.standard.pojo.Standard;
import cn.standard.pojo.User;
import cn.standard.service.StandardMapperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mybatis.xml")

public class StandardMapperTest {
@Autowired
private StandardMapper standardMapper;

    @Autowired
    private StandardMapperService standardMapperService;
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private SendbillMapper sendbillMapper;

    @Test
    public void test4(){
        List<Sendbill> a = sendbillMapper.selectBySendnum();
        System.out.println(a.size());
        for(Sendbill s:a){
            System.out.println(s.getSendnum());
        }
    }
    @Test
    public void test(){
        User user =new User();
        user.setUserName("admin");
        user.setUserPassword("123");
        User a = userMapper.selectByPwdWithName(user);
        System.out.println(a.getUserPassword());
        System.out.println(a.getUserName());
    }


    @Test
    public void test3(){
        Sendbill a = sendbillMapper.selectBySendNum("11");
        System.out.println(a.getSendnum());
    }

    @Test
    public void findAllInfosByPageS(){
        List<Standard> a = standardMapperService.findAllInfosByPageByName("",1,5);
        System.out.println(a.size());
        for(Standard s:a){
            System.out.println(s.getZhname());
        }
    }

    @Test
    public void selectCount(){
        System.out.println(standardMapper.selectCount());
    }

    @Test
    public void selectCountName(){
        System.out.println(standardMapper.selectCountName("4"));
    }

    @Test
    public void findStandardBystdnum(){
        Standard a = standardMapper.findStandardBystdnum("GB 6657.4-2014");
        System.out.println(a.getZhname());
    }
    @Test
    public void insert(){
        Standard s = new Standard();
       s.setZhname("ddd");
       s.setImpldate(new Date());

        String date="2013-06-09";
        SimpleDateFormat dat = new SimpleDateFormat("yyyy-MM-dd");
        Date a = null;
        try {
            a = dat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       s.setReleasedate(a);
        s.setStdnum("GB 6657.13-2014");
        s.setKe("ddd");
        s.setVersion("d");
       s.setPackagepath("d4");
        standardMapper.insertSelective(s);
    }
    @Test
    public void findAllInfosByPage(){
        List<Standard> a = standardMapper.findAllInfosByPage("", 0, 4);
        System.out.println(a.size());
        for(Standard s:a){
            System.out.println(s.getZhname());
        }
    }

}