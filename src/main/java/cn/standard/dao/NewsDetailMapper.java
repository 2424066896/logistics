package cn.standard.dao;

import cn.standard.pojo.NewsDetail;
import cn.standard.pojo.Standard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsDetail record);

    int insertSelective(NewsDetail record);

    NewsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsDetail record);

    int updateByPrimaryKey(NewsDetail record);

    List<NewsDetail> findAllNewsByNameWithPage(@Param("title") String title, @Param("from")Integer pageNo, @Param("pageSize")Integer pageSize);

    int selectCount();
    int selectCountName(@Param("title")String title);

}