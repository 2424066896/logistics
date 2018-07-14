package cn.standard.service;

import cn.standard.pojo.NewsDetail;

import java.util.List;

public interface NewsMapperService {

    List<NewsDetail> findAllInfosByPageByName(String title, Integer pageNo, Integer pageSize);

}
