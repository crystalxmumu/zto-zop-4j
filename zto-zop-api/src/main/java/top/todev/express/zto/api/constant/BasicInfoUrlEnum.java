package top.todev.express.zto.api.constant;

import lombok.AllArgsConstructor;
import top.todev.express.zto.api.bean.ZopHostConfig;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;
import static top.todev.express.zto.api.bean.ZopHostConfig.buildUrl;

/**
 * 基础信息
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@AllArgsConstructor
public enum BasicInfoUrlEnum implements IZopApiUrl {

    /**
     * 获取指定的省市区
     */
    BASIC_INFO_BASE_AREA_GET_AREA("/baseAreaGetArea"),

    /**
     * 获取全部省市区
     */
    BASIC_INFO_BASE_AREA_GET_ALL("/baseAreaGetAll"),

    /**
     * 获取时效价格
     */
    BASIC_INFO_PRICE_AND_HOUR_INTERFACE_GET_HOUR_PRICE("/priceAndHourInterfaceGetHourPrice"),

    /**
     * 网点基础信息获取
     */
    BASIC_INFO_DO_NET_GATEWAY_SERVICE("/DoNetGatewayService")
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
