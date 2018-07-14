package cn.standard.dao;

import cn.standard.pojo.Sendbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendbillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sendbill record);

    int insertSelective(Sendbill record);

    Sendbill selectByPrimaryKey(Integer id);
    //多条件查询
    List<Sendbill> selectByDuoTiaojian(@Param("start")String start,
                                       @Param("end")String end,
                                       @Param("senddate")String senddate,
                                       @Param("sendnum")String sendnum,
                                       @Param("goods")String goods,
                                       @Param("goodsstateid")Integer goodsstateid,
                                       @Param("form")Integer pageNo,
                                       @Param("pageSize")Integer pageSize
                                       );

    Sendbill selectBySendNum(String num);
    List<Sendbill> selectBySendnum();

    int updateByPrimaryKeySelective(Sendbill record);

    int updateByPrimaryKey(Sendbill record);
    int updateById(@Param("id") Integer id, @Param("carid") Integer carid);
    int updateByGoodsId(@Param("id") Integer id, @Param("gid") Integer gid);

    //查询总记录数
    int count();

    //根据条件查询总记录数
    int countByCondition(
            @Param("start")String start,
            @Param("end")String end,
            @Param("senddate")String senddate,
            @Param("sendnum")String sendnum,
            @Param("goods")String goods,
            @Param("goodsstateid")Integer goodsstateid
    );


    //根据起站和到站查询发货次数
    int seclectCount(@Param("start") String start,@Param("end")String end);


}