package cn.iocoder.yudao.module.cms.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode COMPETITION_NOT_EXISTS = new ErrorCode(1145, "竞赛目录不存在");
    ErrorCode STUDENT_NOT_EXISTS = new ErrorCode(1146, "学生不存在");
}
