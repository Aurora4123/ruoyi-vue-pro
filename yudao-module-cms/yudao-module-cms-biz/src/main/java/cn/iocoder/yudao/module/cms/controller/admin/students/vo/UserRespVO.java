package cn.iocoder.yudao.module.cms.controller.admin.students.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 用户信息 Response VO")
@Data
public class UserRespVO {
    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;
    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "yunai")
    private String username;
}
