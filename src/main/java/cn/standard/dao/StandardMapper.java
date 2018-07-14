package cn.standard.dao;

import cn.standard.pojo.Standard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);

    int selectCount();
    int selectCountName(@Param("name")String name);


    List<Standard> findAllInfosByPage(@Param("name") String name,@Param("from")Integer pageNo,@Param("pageSize")Integer pageSize);

    Standard findStandardBystdnum(@Param("stdnum") String stdnum);

}