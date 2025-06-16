package cn.iocoder.yudao.module.cms.service.users;

import cn.iocoder.yudao.module.cms.dal.dataobject.depts.DepartmentDO;
import cn.iocoder.yudao.module.cms.dal.dataobject.users.UserDO;

import java.util.List;

public interface UserService {
    List<UserDO> getUserList();
    List<DepartmentDO> getCollegeList();
    List<DepartmentDO> getMajorList();
}
