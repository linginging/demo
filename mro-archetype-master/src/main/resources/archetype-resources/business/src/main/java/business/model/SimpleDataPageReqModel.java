#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.model;

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
public class SimpleDataPageReqModel extends PageRequestBase {
    /**
     *  参数1
     */
    private String module;
}
