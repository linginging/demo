#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.impl;

import ${package}.business.constant.EsConstant;
import ${package}.business.dal.interfaces.EsRepo;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import cn.yzw.mro.common.model.Pagination;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * es 操作订单接口实现类
 *
 * @author : joy.x.wei
 * @Data : 2018/12/20
 * @Time : 5:45 PM
 */
@Service
public class OrderEsRepoImpl implements EsRepo {
    @Autowired
    private Client client;

    @Override
    public Pagination<OrderModel> searchOrder(OrderSearchModel orderSearchModel) {
        SearchRequestBuilder builder = client.prepareSearch(EsConstant.WARE_INDEX)
                .setTypes(EsConstant.WARE_TYPE_TEST).setSearchType(SearchType.DEFAULT)
                .setFrom(orderSearchModel.getPageStart())
                .setSize(orderSearchModel.getPageSize());
        if (!StringUtils.isEmpty(orderSearchModel.getSortField())) {
            String[] sortFields = orderSearchModel.getSortField().split(",");
            Arrays.stream(sortFields).forEach(v -> builder.addSort(v, SortOrder.fromString(orderSearchModel.getSortAsc())));
        }

        builder.setQuery(buildOrderRequest(orderSearchModel));

        SearchResponse response = builder.get();
        int totalRowSize = (int) response.getHits().totalHits;
        List<OrderModel> orderModelList = new ArrayList<>();
        Arrays.stream(response.getHits().getHits()).forEach(p -> {
            OrderModel orderModel = new OrderModel();
            orderModel.setOrderCode(p.getSource().get("orderCode").toString());
            orderModel.setOrderCode(p.getSource().get("supplierName").toString());
            orderModel.setOrderName(p.getSource().get("orderName").toString());
            orderModelList.add(orderModel);
        });

        return Pagination.create(orderModelList, totalRowSize, orderSearchModel);
    }

    @Override
    public boolean updateOrder(OrderModel orderModel) {
        ObjectMapper mapper = new ObjectMapper();
        UpdateRequestBuilder updateBuilder = client.prepareUpdate(EsConstant.WARE_INDEX, EsConstant.WARE_TYPE_TEST, orderModel.getOrderCode());
        updateBuilder.setDoc(mapper.convertValue(orderModel, Map.class));
        updateBuilder.setDocAsUpsert(true);
        UpdateResponse response = updateBuilder.execute().actionGet();
        return orderModel.getOrderCode().equals(response.getId());
    }

    @Override
    public boolean deleteOrder(String orderCode) {
        DeleteRequestBuilder deleteRequestBuilder = client.prepareDelete(EsConstant.WARE_INDEX, EsConstant.WARE_TYPE_TEST, orderCode);
        DeleteResponse response = deleteRequestBuilder.execute().actionGet();
        return response.status() == RestStatus.OK;
    }

    private QueryBuilder buildOrderRequest(OrderSearchModel orderSearchModel) {
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        if (!StringUtils.isEmpty(orderSearchModel.getOrderCode())) {
            query.must(QueryBuilders.termQuery("orderCode", orderSearchModel.getOrderCode()));
        }

        if (!StringUtils.isEmpty(orderSearchModel.getSupplierName())) {
            query.must(QueryBuilders.matchQuery("supplierName", orderSearchModel.getSupplierName()));
        }

        return query;
    }
}
