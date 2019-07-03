#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.model;

import cn.yzw.mro.common.model.BaseModel;
import lombok.Data;

/**
 * 模拟数据持久层
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 5:48 PM
 */
@Data
public class SimpleDataModel extends BaseModel {
    /**
     *  参数6
     */
    private String param6;
    /**
     *  参数4
     */
    private String param4;
    /**
     *  参数5
     */
    private String param5;
}
