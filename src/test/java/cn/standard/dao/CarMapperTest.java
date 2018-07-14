package cn.standard.dao;
import cn.standard.pojo.Car;
import cn.standard.pojo.Sendbill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mybatis.xml")
public class CarMapperTest {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private SendbillMapper sendbillMapper;

    @Test
    public void selectByCarNumber(){
        Car a = carMapper.selectByCarNumber("h123");
        System.out.println(a.getCartype());
        List<Sendbill> b = a.getSendbillList();
        for(Sendbill c:b){
            System.out.println(c.getSendnum());
        }

    }



    @Test
    public void selectByCarNumber1(){
        int a = sendbillMapper.updateById(1,3);
    }

}