package cn.iocoder.yudao.module.cms.service.competition;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.cms.controller.admin.competition.vo.*;
import cn.iocoder.yudao.module.cms.dal.dataobject.competition.CompetitionDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 竞赛目录 Service 接口
 *
 * @author aurora
 */
public interface CompetitionService {

    /**
     * 创建竞赛目录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCompetition(@Valid CompetitionSaveReqVO createReqVO);

    /**
     * 更新竞赛目录
     *
     * @param updateReqVO 更新信息
     */
    void updateCompetition(@Valid CompetitionSaveReqVO updateReqVO);

    /**
     * 删除竞赛目录
     *
     * @param id 编号
     */
    void deleteCompetition(Long id);

    /**
    * 批量删除竞赛目录
    *
    * @param ids 编号
    */
    void deleteCompetitionListByIds(List<Long> ids);

    /**
     * 获得竞赛目录
     *
     * @param id 编号
     * @return 竞赛目录
     */
    CompetitionDO getCompetition(Long id);

    /**
     * 获得竞赛目录分页
     *
     * @param pageReqVO 分页查询
     * @return 竞赛目录分页
     */
    PageResult<CompetitionDO> getCompetitionPage(CompetitionPageReqVO pageReqVO);

}