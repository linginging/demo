#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract.dto;

import cn.yzw.mro.common.model.PageRequestBase;
import lombok.Data;

/**
 * 请求入参
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 3:52 PM
 */
@Data
public class SimpleDataPageReqDTO extends PageRequestBase {
    /**
     * 参数1
     */
    private String moduleName;
    /**
     * 参数2
     */
    private String param2;
    /**
     * 参数3
     */
    private String param3;
}
