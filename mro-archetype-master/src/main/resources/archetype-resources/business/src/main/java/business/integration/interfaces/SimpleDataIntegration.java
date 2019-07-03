#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.integration.interfaces;


import ${package}.business.model.SimpleDataModel;
import ${package}.business.model.SimpleDataReqModel;

/**
 * 集成外部接口
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 7:46 PM
 */
public interface SimpleDataIntegration {
    /**
     *  测试
     *  @param simpleDataReqModel 查询条件
     * @return SimpleDataModel 实体
     */
    SimpleDataModel getSimpleData(SimpleDataReqModel simpleDataReqModel);
}
