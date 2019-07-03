#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.impl;

import ${package}.business.dal.interfaces.SimpleDataRepo;
import ${package}.business.dal.mappers.SimpleDataMapper;
import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataPageReqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库持久层业务实现
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 8:03 PM
 */
@Service
public class SimpleDataRepoImpl implements SimpleDataRepo {

    @Autowired
    private SimpleDataMapper simpleDataMapper;

    @Override
    public String test() {
        return "SimpleDataRepo";
    }

    @Override
    public List<ModuleDetailModel> queryPageSimpleData(SimpleDataPageReqModel simpleDataPageReqModel) {
        return simpleDataMapper.queryPageSimpleData(simpleDataPageReqModel);
    }

    @Override
    public int queryPageTotal(SimpleDataPageReqModel simpleDataPageReqModel) {
        return simpleDataMapper.queryPageTotal(simpleDataPageReqModel);
    }
}
