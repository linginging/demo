#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract.dto;

import lombok.Data;

/**
 * 请求出参
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 3:52 PM
 */
@Data
public class SimpleDataRespDTO {
    /**
     * 参数6
     */
    private String param6;
    /**
     * 参数4
     */
    private String param4;
    /**
     * 参数5
     */
    private String param5;
}
