#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import cn.yzw.framework.core.validate.BizException;
import ${package}.business.dal.interfaces.SimpleDataRepo;
import ${package}.business.integration.interfaces.SimpleDataIntegration;
import ${package}.business.model.SimpleDataPageReqModel;
import ${package}.business.model.SimpleDataReqModel;
import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 测试${parentArtifactId}
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 5:57 PM
 */
@Service
public class SimpleDataService {
    @Autowired
    private SimpleDataRepo simpleDataRepo;
    @Autowired
    private SimpleDataIntegration simpleDataIntegration;

    /**
     * 测试
     * @param simpleDataReqModel 实体
     * @return 实体
     */
    public SimpleDataModel getSimpleData(SimpleDataReqModel simpleDataReqModel) {
        if (simpleDataReqModel == null || StringUtils.isEmpty(simpleDataReqModel.getParam1())) {
            throw new BizException(BizException.INVALID_PARAMETER, "参数非法");
        }
        return simpleDataIntegration.getSimpleData(simpleDataReqModel);
    }

    /**
     *  测试分页
     * @param simpleDataPageReqModel 查询条件
     * @return 结果集合
     */
    public List<ModuleDetailModel> queryPageData(SimpleDataPageReqModel simpleDataPageReqModel) {
        return simpleDataRepo.queryPageSimpleData(simpleDataPageReqModel);
    }

    /**
     * 查询分页总数
     * @param simpleDataPageReqModel 查询条件
     * @return 总条数
     */
    public int queryPageTotal(SimpleDataPageReqModel simpleDataPageReqModel) {
        return simpleDataRepo.queryPageTotal(simpleDataPageReqModel);
    }
}
