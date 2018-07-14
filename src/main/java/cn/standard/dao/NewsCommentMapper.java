package cn.standard.dao;

import cn.standard.pojo.NewsComment;

import java.util.List;

public interface NewsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    List<NewsComment> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);
}