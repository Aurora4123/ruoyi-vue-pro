package cn.iocoder.yudao.module.cms.service.competition;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.cms.controller.admin.competition.vo.*;
import cn.iocoder.yudao.module.cms.dal.dataobject.competition.CompetitionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.cms.dal.mysql.competition.CompetitionMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.cms.enums.ErrorCodeConstants.*;

/**
 * 竞赛目录 Service 实现类
 *
 * @author aurora
 */
@Service
@Validated
public class CompetitionServiceImpl implements CompetitionService {

    @Resource
    private CompetitionMapper competitionMapper;

    @Override
    public Long createCompetition(CompetitionSaveReqVO createReqVO) {
        // 插入
        CompetitionDO competition = BeanUtils.toBean(createReqVO, CompetitionDO.class);
        competitionMapper.insert(competition);
        // 返回
        return competition.getId();
    }

    @Override
    public void updateCompetition(CompetitionSaveReqVO updateReqVO) {
        // 校验存在
        validateCompetitionExists(updateReqVO.getId());
        // 更新
        CompetitionDO updateObj = BeanUtils.toBean(updateReqVO, CompetitionDO.class);
        competitionMapper.updateById(updateObj);
    }

    @Override
    public void deleteCompetition(Long id) {
        // 校验存在
        validateCompetitionExists(id);
        // 删除
        competitionMapper.deleteById(id);
    }

    @Override
        public void deleteCompetitionListByIds(List<Long> ids) {
        // 校验存在
        validateCompetitionExists(ids);
        // 删除
        competitionMapper.deleteByIds(ids);
        }

    private void validateCompetitionExists(List<Long> ids) {
        List<CompetitionDO> list = competitionMapper.selectByIds(ids);
        if (CollUtil.isEmpty(list) || list.size() != ids.size()) {
            throw exception(COMPETITION_NOT_EXISTS);
        }
    }

    private void validateCompetitionExists(Long id) {
        if (competitionMapper.selectById(id) == null) {
            throw exception(COMPETITION_NOT_EXISTS);
        }
    }

    @Override
    public CompetitionDO getCompetition(Long id) {
        return competitionMapper.selectById(id);
    }

    @Override
    public PageResult<CompetitionDO> getCompetitionPage(CompetitionPageReqVO pageReqVO) {
        return competitionMapper.selectPage(pageReqVO);
    }

}