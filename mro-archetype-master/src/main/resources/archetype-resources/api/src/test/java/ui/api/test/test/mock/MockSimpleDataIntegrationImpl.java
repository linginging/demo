#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ui.api.test.test.mock;

import ${package}.contract.dto.SimpleDataReqDTO;
import ${package}.contract.dto.SimpleDataRespDTO;
import ${package}.contract.SimpleDataServiceContract;
import ${package}.contract.dto.ModuleDetailDTO;
import ${package}.contract.dto.SimpleDataPageReqDTO;
import cn.yzw.mro.common.model.Pagination;
import org.springframework.stereotype.Service;

/**
 * 描述
 * User: ryan.w.li
 * Date: 2018-09-09
 * Time: 下午2:38
 */
@Service
public class MockSimpleDataIntegrationImpl implements SimpleDataServiceContract {

    @Override
    public SimpleDataRespDTO getSimpleData(SimpleDataReqDTO simpleDataReqDTO) {
        return null;
    }

    @Override
    public Pagination<ModuleDetailDTO> queryPageData(SimpleDataPageReqDTO simpleDataPageReqDTO) {
        return null;
    }
}
