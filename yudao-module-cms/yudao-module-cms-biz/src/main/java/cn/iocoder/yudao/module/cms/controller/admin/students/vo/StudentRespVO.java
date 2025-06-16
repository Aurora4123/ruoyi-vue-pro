package cn.iocoder.yudao.module.cms.controller.admin.students.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 学生 Response VO")
@Data
@ExcelIgnoreUnannotated
public class StudentRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "11887")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "11356")
    @ExcelProperty("用户ID")
    private Long userId;

    @Schema(description = "学号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("学号")
    private String studentNo;

    @Schema(description = "真实姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("真实姓名")
    private String realName;

    @Schema(description = "学院")
    @ExcelProperty("学院")
    private String college;

    @Schema(description = "专业")
    @ExcelProperty("专业")
    private String major;

    @Schema(description = "班级", example = "01")
    @ExcelProperty("班级")
    private String className;

    @Schema(description = "年级")
    @ExcelProperty("年级")
    private String grade;

    @Schema(description = "手机号")
    @ExcelProperty("手机号")
    private String phone;

    @Schema(description = "邮箱")
    @ExcelProperty("邮箱")
    private String email;

    @Schema(description = "紧急联系人")
    @ExcelProperty("紧急联系人")
    private String emergencyContact;

    @Schema(description = "紧急联系人电话")
    @ExcelProperty("紧急联系人电话")
    private String emergencyPhone;

    @Schema(description = "状态", example = "1")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("student_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}