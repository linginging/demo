#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 领域入参
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 3:52 PM
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDataReqModel {
    /**
     *  参数1
     */
    private String param1;
    /**
     *  参数2
     */
    private String param2;
    /**
     *  参数3
     */
    private String param3;
}
