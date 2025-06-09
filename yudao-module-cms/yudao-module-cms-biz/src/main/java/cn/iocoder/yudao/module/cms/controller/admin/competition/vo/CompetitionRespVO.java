package cn.iocoder.yudao.module.cms.controller.admin.competition.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 竞赛目录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CompetitionRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "5957")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "竞赛名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("竞赛名称")
    private String name;

    @Schema(description = "竞赛详情/简介 (可支持富文本)", example = "你说的对")
    @ExcelProperty("竞赛详情/简介 (可支持富文本)")
    private String description;

    @Schema(description = "报名开始时间或竞赛活动开始时间")
    @ExcelProperty("报名开始时间或竞赛活动开始时间")
    private LocalDateTime startTime;

    @Schema(description = "报名截止时间或竞赛活动结束时间")
    @ExcelProperty("报名截止时间或竞赛活动结束时间")
    private LocalDateTime endTime;

    @Schema(description = "是否具有校赛 (0: 否, 1: 是)", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("是否具有校赛 (0: 否, 1: 是)")
    private Boolean hasSchoolLevelCompetition;

    @Schema(description = "官方网址")
    @ExcelProperty("官方网址")
    private String officialWebsite;

    @Schema(description = "主办单位")
    @ExcelProperty("主办单位")
    private String organizer;

    @Schema(description = "竞赛级别 (1:校级, 2:省级, 3:国家级, 4:国际级)")
    @ExcelProperty("竞赛级别 (1:校级, 2:省级, 3:国家级, 4:国际级)")
    private Integer level;

    @Schema(description = "规则附件URL", example = "https://www.iocoder.cn")
    @ExcelProperty("规则附件URL")
    private String rulesAttachmentUrl;

    @Schema(description = "竞赛状态 (0:未开始, 1:报名中, 2:进行中, 3:等待结果, 4:已结束)", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("竞赛状态 (0:未开始, 1:报名中, 2:进行中, 3:等待结果, 4:已结束)")
    private Integer status;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}