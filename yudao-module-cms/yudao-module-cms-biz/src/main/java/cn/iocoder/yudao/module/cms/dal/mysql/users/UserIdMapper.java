package cn.iocoder.yudao.module.cms.dal.mysql.users;

import cn.iocoder.yudao.module.cms.dal.dataobject.users.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserIdMapper {
    @Select("select ss.id,ss.username from system_users ss")
    List<User> selectList();
}
