package cn.iocoder.yudao.module.cms.service.users;

import cn.iocoder.yudao.module.cms.dal.dataobject.depts.DepartmentDO;
import cn.iocoder.yudao.module.cms.dal.dataobject.users.UserDO;
import cn.iocoder.yudao.module.cms.dal.mysql.departments.DepartmentMapper;
import cn.iocoder.yudao.module.cms.dal.mysql.users.UserIdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Collections;
import java.util.List;
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserIdMapper userMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public List<UserDO> getUserList() {
        return userMapper.selectList();
    }

    @Override
    public List<DepartmentDO> getCollegeList() {
        return departmentMapper.selectCollegeList();
    }

    @Override
    public List<DepartmentDO> getMajorList() {
        return departmentMapper.selectMajorList();
    }


}
