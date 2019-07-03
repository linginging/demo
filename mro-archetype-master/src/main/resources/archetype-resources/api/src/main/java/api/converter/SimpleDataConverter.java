#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.converter;

import ${package}.contract.dto.ModuleDetailDTO;
import ${package}.contract.dto.SimpleDataPageReqDTO;
import ${package}.contract.dto.SimpleDataReqDTO;
import ${package}.contract.dto.SimpleDataRespDTO;
import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataModel;
import ${package}.business.model.SimpleDataPageReqModel;
import ${package}.business.model.SimpleDataReqModel;
import cn.yzw.mro.common.util.WrappedBeanCopier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 转换工具
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 5:46 PM
 */
@Component
public class SimpleDataConverter {
    /**
     * 转换SimpleDataRespDTO
     * @param simpleDataModel ${parentArtifactId}实体
     * @return SimpleDataRespDTO集合
     */
    public SimpleDataRespDTO convertSimpleDataResp(SimpleDataModel simpleDataModel) {
        return WrappedBeanCopier.copyProperties(simpleDataModel, SimpleDataRespDTO.class);
    }

    /**
     * 转换SimpleDataReqModel
     * @param simpleDataReqDTO 前台传入查询实体
     * @return SimpleDataReqModel集合
     */
    public SimpleDataReqModel convertSimpleDataReqModel(SimpleDataReqDTO simpleDataReqDTO) {
        return SimpleDataReqModel.builder().param1(simpleDataReqDTO.getParam1())
                .param2(simpleDataReqDTO.getParam2()).param3(simpleDataReqDTO.getParam3()).build();
    }

    /**
     * SimpleDataPageReqModel 分页条件转换
     * @param simpleDataPageReqDTO 前台传入实体
     * @return SimpleDataPageReqModel内部实体对象
     */
    public SimpleDataPageReqModel convertSimpleDataPageReqModel(SimpleDataPageReqDTO simpleDataPageReqDTO) {
        return WrappedBeanCopier.copyProperties(simpleDataPageReqDTO, SimpleDataPageReqModel.class);
    }

    /**
     * 转换查询结果ModuleDetailDTO
     * @param moduleDetailModelList 查询数据集合
     * @return ModuleDetailDTO集合
     */
    public List<ModuleDetailDTO> convertModuleDetailDTOlList(List<ModuleDetailModel> moduleDetailModelList) {
        return WrappedBeanCopier.copyPropertiesOfList(moduleDetailModelList, ModuleDetailDTO.class);
    }
}
