package cn.iocoder.yudao.module.cms.dal.dataobject.competition;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 竞赛目录 DO
 *
 * @author aurora
 */
@TableName("cms_competition")
@KeySequence("cms_competition_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 竞赛名称
     */
    private String name;
    /**
     * 竞赛详情/简介 (可支持富文本)
     */
    private String description;
    /**
     * 报名开始时间或竞赛活动开始时间
     */
    private LocalDateTime startTime;
    /**
     * 报名截止时间或竞赛活动结束时间
     */
    private LocalDateTime endTime;
    /**
     * 是否具有校赛 (0: 否, 1: 是)
     */
    private Boolean hasSchoolLevelCompetition;
    /**
     * 官方网址
     */
    private String officialWebsite;
    /**
     * 主办单位
     */
    private String organizer;
    /**
     * 竞赛级别 (1:校级, 2:省级, 3:国家级, 4:国际级)
     */
    private Integer level;
    /**
     * 规则附件URL
     */
    private String rulesAttachmentUrl;
    /**
     * 竞赛状态 (0:未开始, 1:报名中, 2:进行中, 3:等待结果, 4:已结束)
     */
    private Integer status;


}