#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract.dto;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 请求入参
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 3:52 PM
 */
@Data
public class SimpleDataReqDTO {
    /**
     * 参数1
     */
    private String param1;
    /**
     * 参数2
     */
    @Size(min = 2, message = "param2不能为空")
    private String param2;
    /**
     * 参数3
     */
    private String param3;
}
