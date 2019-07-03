#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.interfaces;


import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataPageReqModel;

import java.util.List;

/**
 * 数据库集成
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 7:47 PM
 */
public interface SimpleDataRepo {
    /**
     * 测试
     *
     * @return 测试
     */
    String test();

    /**
     * 分页查询测试数据
     *
     * @param simpleDataPageReqModel 分页信息
     * @return 测试
     */
    List<ModuleDetailModel> queryPageSimpleData(SimpleDataPageReqModel simpleDataPageReqModel);

    /**
     * 查询总条数
     *
     * @param simpleDataPageReqModel 查询总条数
     * @return 测试
     */
    int queryPageTotal(SimpleDataPageReqModel simpleDataPageReqModel);
}
