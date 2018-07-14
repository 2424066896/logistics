package cn.standard.service;

import cn.standard.dao.NewsDetailMapper;
import cn.standard.dao.StandardMapper;
import cn.standard.pojo.NewsDetail;
import cn.standard.pojo.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StandardMapperServiceImpl implements StandardMapperService {
    @Autowired
    private NewsDetailMapper newsDetailMapper;

    @Override
    public List<Standard> findAllInfosByPageByName(String name, Integer pageNo, Integer pageSize) {
        return null;
    }
}
