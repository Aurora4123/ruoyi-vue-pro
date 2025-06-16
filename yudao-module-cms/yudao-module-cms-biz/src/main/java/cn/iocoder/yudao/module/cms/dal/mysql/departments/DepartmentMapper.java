package cn.iocoder.yudao.module.cms.dal.mysql.departments;

import cn.iocoder.yudao.module.cms.dal.dataobject.depts.DepartmentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<DepartmentDO> selectCollegeList();
    List<DepartmentDO> selectMajorList();
}
