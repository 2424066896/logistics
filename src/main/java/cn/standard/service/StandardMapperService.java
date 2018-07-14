package cn.standard.service;

import cn.standard.pojo.Standard;

import java.util.List;

public interface StandardMapperService {
    List<Standard> findAllInfosByPageByName(String name, Integer pageNo, Integer pageSize);

}
