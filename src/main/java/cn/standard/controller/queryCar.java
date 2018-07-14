package cn.standard.controller;
import cn.standard.dao.CarMapper;
import cn.standard.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class queryCar {
    @Autowired
    private CarMapper carMapper;
    @RequestMapping(value = "/queryCar")
    public ModelAndView queryCar(@RequestParam String carnum,ModelAndView mv){
        Car car = carMapper.selectByCarNumber(carnum);
        mv.addObject("carlist",car);
        mv.setViewName("confirm");
        return mv;
    }
}
