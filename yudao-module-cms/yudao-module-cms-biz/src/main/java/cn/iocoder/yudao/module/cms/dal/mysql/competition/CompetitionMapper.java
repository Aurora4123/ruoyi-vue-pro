package cn.iocoder.yudao.module.cms.dal.mysql.competition;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.cms.dal.dataobject.competition.CompetitionDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.cms.controller.admin.competition.vo.*;

/**
 * 竞赛目录 Mapper
 *
 * @author aurora
 */
@Mapper
public interface CompetitionMapper extends BaseMapperX<CompetitionDO> {

    default PageResult<CompetitionDO> selectPage(CompetitionPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CompetitionDO>()
                .likeIfPresent(CompetitionDO::getName, reqVO.getName())
                .eqIfPresent(CompetitionDO::getDescription, reqVO.getDescription())
                .betweenIfPresent(CompetitionDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(CompetitionDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(CompetitionDO::getHasSchoolLevelCompetition, reqVO.getHasSchoolLevelCompetition())
                .eqIfPresent(CompetitionDO::getOfficialWebsite, reqVO.getOfficialWebsite())
                .eqIfPresent(CompetitionDO::getOrganizer, reqVO.getOrganizer())
                .eqIfPresent(CompetitionDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CompetitionDO::getRulesAttachmentUrl, reqVO.getRulesAttachmentUrl())
                .eqIfPresent(CompetitionDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CompetitionDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CompetitionDO::getId));
    }

}