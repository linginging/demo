#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract;

import ${package}.contract.dto.SimpleDataReqDTO;
import ${package}.contract.dto.SimpleDataRespDTO;
import ${package}.contract.dto.ModuleDetailDTO;
import ${package}.contract.dto.SimpleDataPageReqDTO;
import cn.yzw.mro.common.model.Pagination;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 计算API微服契约
 * User: ryan.w.li
 * Date: 2018-08-28
 * Time: 下午4:20
 */
@FeignClient("${parentArtifactId}-server")
public interface SimpleDataServiceContract {

    @PostMapping("/v1/${parentArtifactId}/test/get")
    SimpleDataRespDTO getSimpleData(SimpleDataReqDTO simpleDataReqDTO);

    @PostMapping("/v1/${parentArtifactId}/test/page")
    Pagination<ModuleDetailDTO> queryPageData(SimpleDataPageReqDTO simpleDataPageReqDTO);

}
