#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.controller;

import cn.yzw.framework.core.auth.AuthUser;
import cn.yzw.framework.core.auth.Authority;
import ${package}.api.converter.SimpleDataConverter;
import ${package}.contract.SimpleDataServiceContract;
import ${package}.contract.dto.ModuleDetailDTO;
import ${package}.contract.dto.SimpleDataPageReqDTO;
import ${package}.contract.dto.SimpleDataReqDTO;
import ${package}.contract.dto.SimpleDataRespDTO;
import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataPageReqModel;
import ${package}.business.model.SimpleDataReqModel;
import ${package}.business.service.SimpleDataService;
import cn.yzw.mro.common.json.Json;
import cn.yzw.mro.common.model.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static ${package}.business.constant.AuthConstant.MRO_DEMO_SIMPLE_GET;
import static ${package}.business.constant.AuthConstant.MRO_DEMO_SIMPLE_PAGE;
import static ${package}.business.constant.AuthConstant.MRO_DEMO_SIMPLE_TEST;


/**
 * 测试controller
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 4:30 PM
 */
@Api(tags = "${parentArtifactId}", description = "测试${parentArtifactId}相关接口")
@RestController
@Slf4j
public class SimpleDataController implements SimpleDataServiceContract {

    @Autowired
    private SimpleDataService simpleDataService;
    @Autowired
    private SimpleDataConverter simpleDataConverter;

    @Override
    @ApiOperation(notes = "返回测试样品数据", value = "获取测试数据")
    @Authority({MRO_DEMO_SIMPLE_GET, MRO_DEMO_SIMPLE_TEST})
    public SimpleDataRespDTO getSimpleData(@RequestBody @Valid SimpleDataReqDTO simpleDataReqDTO) {
        AuthUser authUser = AuthUser.getCurrent();
        log.info(Json.toJson(authUser));
        log.info(Json.toJson(simpleDataReqDTO));
        SimpleDataReqModel simpleDataReqModel = simpleDataConverter.convertSimpleDataReqModel(simpleDataReqDTO);
        return simpleDataConverter.convertSimpleDataResp(simpleDataService.getSimpleData(simpleDataReqModel));
    }

    @Override
    @ApiOperation(notes = "返回分页样品数据", value = "分页测试数据")
    @Authority(MRO_DEMO_SIMPLE_PAGE)
    public Pagination<ModuleDetailDTO> queryPageData(@RequestBody @Valid SimpleDataPageReqDTO simpleDataPageReqDTO) {
        SimpleDataPageReqModel simpleDataPageReqModel = simpleDataConverter.convertSimpleDataPageReqModel(simpleDataPageReqDTO);
        List<ModuleDetailModel> moduleDetailModelList = simpleDataService.queryPageData(simpleDataPageReqModel);
        Pagination<ModuleDetailDTO> pagination = Pagination.create(simpleDataPageReqDTO);
        pagination.setDatas(simpleDataConverter.convertModuleDetailDTOlList(moduleDetailModelList));
        if (simpleDataPageReqDTO.isQueryTotal()) {
            pagination.setTotal(simpleDataService.queryPageTotal(simpleDataPageReqModel));
        }
        return pagination;
    }
}
