#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.integration.impl;

import ${package}.business.integration.interfaces.SimpleDataIntegration;
import ${package}.business.model.SimpleDataModel;
import ${package}.business.model.SimpleDataReqModel;
import org.springframework.stereotype.Service;

/**
 * 外部集成实现类
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 8:01 PM
 */
@Service
public class SimpleDataIntegrationImpl implements SimpleDataIntegration {
    @Override
    public SimpleDataModel getSimpleData(SimpleDataReqModel simpleDataReqModel) {
        SimpleDataModel simpleDataModel = new SimpleDataModel();
        simpleDataModel.setParam4("test4");
        simpleDataModel.setParam5("test5");
        simpleDataModel.setParam6("test6");
        return simpleDataModel;
    }
}
