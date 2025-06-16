package cn.iocoder.yudao.module.cms.dal.mysql.students;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.cms.dal.dataobject.students.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.cms.controller.admin.students.vo.*;

/**
 * 学生 Mapper
 *
 * @author aurora
 */
@Mapper
public interface StudentMapper extends BaseMapperX<StudentDO> {

    default PageResult<StudentDO> selectPage(StudentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StudentDO>()
                .eqIfPresent(StudentDO::getUserId, reqVO.getUserId())
                .eqIfPresent(StudentDO::getStudentNo, reqVO.getStudentNo())
                .likeIfPresent(StudentDO::getRealName, reqVO.getRealName())
                .eqIfPresent(StudentDO::getCollege, reqVO.getCollege())
                .eqIfPresent(StudentDO::getMajor, reqVO.getMajor())
                .likeIfPresent(StudentDO::getClassName, reqVO.getClassName())
                .eqIfPresent(StudentDO::getGrade, reqVO.getGrade())
                .eqIfPresent(StudentDO::getPhone, reqVO.getPhone())
                .eqIfPresent(StudentDO::getEmail, reqVO.getEmail())
                .eqIfPresent(StudentDO::getEmergencyContact, reqVO.getEmergencyContact())
                .eqIfPresent(StudentDO::getEmergencyPhone, reqVO.getEmergencyPhone())
                .eqIfPresent(StudentDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(StudentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(StudentDO::getId));
    }

}