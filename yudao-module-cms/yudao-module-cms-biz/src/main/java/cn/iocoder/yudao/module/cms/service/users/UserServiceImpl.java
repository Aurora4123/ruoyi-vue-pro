package cn.iocoder.yudao.module.cms.service.users;

import cn.iocoder.yudao.module.cms.dal.dataobject.users.User;
import cn.iocoder.yudao.module.cms.dal.mysql.users.UserIdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserIdMapper userMapper;
    @Override
    public List<User> getUserList() {
        return userMapper.selectList();
    }
}
