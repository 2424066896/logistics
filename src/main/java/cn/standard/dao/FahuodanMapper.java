package cn.standard.dao;

import cn.standard.pojo.Fahuodan;

import java.util.List;

public interface FahuodanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fahuodan record);

    int insertSelective(Fahuodan record);

    Fahuodan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fahuodan record);

    int updateByPrimaryKey(Fahuodan record);


}