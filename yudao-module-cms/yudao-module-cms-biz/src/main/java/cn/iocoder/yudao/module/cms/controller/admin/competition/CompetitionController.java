package cn.iocoder.yudao.module.cms.controller.admin.competition;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.cms.controller.admin.competition.vo.*;
import cn.iocoder.yudao.module.cms.dal.dataobject.competition.CompetitionDO;
import cn.iocoder.yudao.module.cms.service.competition.CompetitionService;

@Tag(name = "管理后台 - 竞赛目录")
@RestController
@RequestMapping("/cms/competition")
@Validated
public class CompetitionController {

    @Resource
    private CompetitionService competitionService;

    @PostMapping("/create")
    @Operation(summary = "创建竞赛目录")
    @PreAuthorize("@ss.hasPermission('cms:competition:create')")
    public CommonResult<Long> createCompetition(@Valid @RequestBody CompetitionSaveReqVO createReqVO) {
        return success(competitionService.createCompetition(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新竞赛目录")
    @PreAuthorize("@ss.hasPermission('cms:competition:update')")
    public CommonResult<Boolean> updateCompetition(@Valid @RequestBody CompetitionSaveReqVO updateReqVO) {
        competitionService.updateCompetition(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除竞赛目录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('cms:competition:delete')")
    public CommonResult<Boolean> deleteCompetition(@RequestParam("id") Long id) {
        competitionService.deleteCompetition(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除竞赛目录")
                @PreAuthorize("@ss.hasPermission('cms:competition:delete')")
    public CommonResult<Boolean> deleteCompetitionList(@RequestParam("ids") List<Long> ids) {
        competitionService.deleteCompetitionListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得竞赛目录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('cms:competition:query')")
    public CommonResult<CompetitionRespVO> getCompetition(@RequestParam("id") Long id) {
        CompetitionDO competition = competitionService.getCompetition(id);
        return success(BeanUtils.toBean(competition, CompetitionRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得竞赛目录分页")
    @PreAuthorize("@ss.hasPermission('cms:competition:query')")
    public CommonResult<PageResult<CompetitionRespVO>> getCompetitionPage(@Valid CompetitionPageReqVO pageReqVO) {
        PageResult<CompetitionDO> pageResult = competitionService.getCompetitionPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CompetitionRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出竞赛目录 Excel")
    @PreAuthorize("@ss.hasPermission('cms:competition:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCompetitionExcel(@Valid CompetitionPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CompetitionDO> list = competitionService.getCompetitionPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "竞赛目录.xls", "数据", CompetitionRespVO.class,
                        BeanUtils.toBean(list, CompetitionRespVO.class));
    }

}