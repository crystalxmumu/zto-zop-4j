package top.todev.express.zto.api.constant;

import lombok.AllArgsConstructor;
import top.todev.express.zto.api.bean.ZopHostConfig;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;
import static top.todev.express.zto.api.bean.ZopHostConfig.buildUrl;

/**
 * 订单服务
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@AllArgsConstructor
public enum OrderServiceUrlEnum implements IZopApiUrl {
    /**
     * 总对总-创建订单
     */
    ORDER_SERVICE_PLATE_ORDER("/plateOrder"),
    /**
     * 总对总-取消订单
     */
    ORDER_SERVICE_CANCEL_ORDER("/cancelOrder"),
    /**
     * 总对总-创建门店
     */
    ORDER_SERVICE_CREATE_STORE("/createStore"),
    /**
     * 总对总-创建订单（返回寄件码）
     */
    ORDER_SERVICE_PLATE_ORDER2("/plateOrder"),
    /**
     * 总对总-费用查询接口
     */
    ORDER_SERVICE_GET_PRICE_FOR_CUSTOMER("/getPriceForCustomer"),
    /**
     * 预约寄件-订单创建
     */
    ORDER_SERVICE_OPEN_ORDER_CREATE("/OpenOrderCreate"),
    /**
     * 预约寄件-订单取消
     */
    ORDER_SERVICE_COMMON_ORDER_UPDATE("/commonOrderUpdate"),
    /**
     * 预约寄件-订单查询
     */
    ORDER_SERVICE_COMMON_ORDER_SEARCH("/commonOrderSearch"),
    /**
     * 预约寄件-订单明细查询
     */
    ORDER_SERVICE_COMMON_ORDER_SEARCH_BY_CODE("/commonOrderSearchbycode")
    ;

    /**
     * 路径URI
     */
    private final String path;

    @Override
    public String getUrl(ZopHostConfig config) {
        return buildUrl(config, API_DEFAULT_HOST_URL, this.path);
    }
}
