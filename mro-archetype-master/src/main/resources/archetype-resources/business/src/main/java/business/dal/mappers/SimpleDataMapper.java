#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.mappers;


import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataPageReqModel;

import java.util.List;

/**
 * 测试数据持久层接口
 *
 * @author : joy.x.wei
 * @Data : 2018/12/14
 * @Time : 2:14 PM
 */
public interface SimpleDataMapper {
    /**
     *  分页查询测试数据
     * @param simpleDataPageReqModel 分页信息
     * @return 测试数据集合
     */
    List<ModuleDetailModel> queryPageSimpleData(SimpleDataPageReqModel simpleDataPageReqModel);
    /**
     *  查询总条数
     * @param simpleDataPageReqModel 查询总条数
     * @return 查询总条数
     */
    int queryPageTotal(SimpleDataPageReqModel simpleDataPageReqModel);
}
