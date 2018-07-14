package cn.standard.dao;

import cn.standard.pojo.Sendbill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mybatis.xml")
public class SendbillMapperTest {
    @Autowired
    private SendbillMapper sendbillMapper;
    @Test
    public void  test(){
        sendbillMapper.updateByGoodsId(1,2);
    }


    //注意select语句中不可以有空格
    @Test
    public void  test1(){
        List<Sendbill> a = sendbillMapper.selectByDuoTiaojian("淮安","","","","",1,0,2);
        System.out.println(a.size());
        for(Sendbill f:a){
            System.out.println(f.getSendnum());
        }

    }

    @Test
    public void  test4(){
        int a=sendbillMapper.count();
        System.out.println(a);

    }


    @Test
    public void  countByCondition(){
        int a=sendbillMapper.countByCondition("淮安","","","","",2);
        System.out.println(a);

    }



    @Test
    public void  seclectCount(){
        int count = sendbillMapper.seclectCount("淮安", "盐城");
        System.out.println(count);

    }



    @Test
    public void  seclectCounte(){
        List<Sendbill> count = sendbillMapper.selectBySendnum();
        System.out.println(count.size());

    }


    @Test
    public void  updateByPrimaryKey(){
        Sendbill sendbill = new Sendbill();
        sendbill.setSendnum("00");
        sendbill.setSender("hhe");
        sendbill.setGoodsstateid(1);
        sendbill.setId(15);
        int a = sendbillMapper.updateByPrimaryKeySelective(sendbill);
        System.out.println(a);

    }






    @Test
    public void  selectByPrimaryKey(){
        Sendbill send = sendbillMapper.selectByPrimaryKey(14);
        System.out.println(send);
        System.out.println(send.getGoodsstateid());
    }
}