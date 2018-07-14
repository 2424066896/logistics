package cn.standard.dao;
import cn.standard.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    User selectByPwdWithName(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    int count();

}