package cn.standard.dao;

import cn.standard.pojo.Car;
import org.springframework.stereotype.Component;
public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);
    Car selectByCarNumber(String num);
    /* <include refid="Base_Column_List" />*/
    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}