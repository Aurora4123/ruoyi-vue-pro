package cn.iocoder.yudao.module.cms.controller.admin.competition.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 竞赛目录分页 Request VO")
@Data
public class CompetitionPageReqVO extends PageParam {

    @Schema(description = "竞赛名称", example = "王五")
    private String name;

    @Schema(description = "竞赛详情/简介 (可支持富文本)", example = "你说的对")
    private String description;

    @Schema(description = "报名开始时间或竞赛活动开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "报名截止时间或竞赛活动结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @Schema(description = "是否具有校赛 (0: 否, 1: 是)")
    private Boolean hasSchoolLevelCompetition;

    @Schema(description = "官方网址")
    private String officialWebsite;

    @Schema(description = "主办单位")
    private String organizer;

    @Schema(description = "竞赛级别 (1:校级, 2:省级, 3:国家级, 4:国际级)")
    private Integer level;

    @Schema(description = "规则附件URL", example = "https://www.iocoder.cn")
    private String rulesAttachmentUrl;

    @Schema(description = "竞赛状态 (0:未开始, 1:报名中, 2:进行中, 3:等待结果, 4:已结束)", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}