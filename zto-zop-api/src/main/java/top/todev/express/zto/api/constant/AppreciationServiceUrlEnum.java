package top.todev.express.zto.api.constant;

import lombok.AllArgsConstructor;
import top.todev.express.zto.api.bean.ZopHostConfig;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;
import static top.todev.express.zto.api.bean.ZopHostConfig.buildUrl;

/**
 * 增值服务
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@AllArgsConstructor
public enum AppreciationServiceUrlEnum implements IZopApiUrl {
    /**
     * 安全手机号 - 客户余额查询
     */
    APPRECIATION_SERVICE_TIAN_ZHOU_SERVICE_BALANCE_RETURN_ENTITY("/tianZhouServiceBalancereturnentity"),
    /**
     * 安全手机号 - 绑定手机号码服务
     */
    APPRECIATION_SERVICE_TIAN_ZHOU_SERVICE_BIND_PHONE_SERVICE("/tianZhouServiceBindphoneservice"),
    /**
     * 安全手机号 - 取消接口
     */
    APPRECIATION_SERVICE_TIAN_ZHOU_SERVICE_CANCEL_PHONE_SERVICE("/tianZhouServiceCancelphoneservice"),
    /**
     * 代理点平台-代理点创建接口
     */
    APPRECIATION_SERVICE_AGENT_CREATE("/agentCreate"),
    /**
     * 代理点平台-代理点更新接口
     */
    APPRECIATION_SERVICE_AGENT_UPDATE("/agentUpdate"),
    /**
     * 代理点平台-代理点状态推送接口
     */
    APPRECIATION_SERVICE_ORDER_STATE_CHANGE("/OrderStateChange"),
    /**
     * 代理点平台-取件通知回传接口
     */
    APPRECIATION_SERVICE_CREATE_SMS_MSG("/createSmsMsg"),
    /**
     * 代理点平台-代理点文件上传接口（音频、图片）
     */
    APPRECIATION_SERVICE_AGENT_UPLOAD_FILE("/agentUploadFile"),
    /**
     * 代理点平台-禁投第三方校验接口
     */
    APPRECIATION_SERVICE_CHECK_BILL_IS_FORBID("/checkBillIsForbid"),
    /**
     * 代理点平台-代理点异常补推出入库接口
     */
    APPRECIATION_SERVICE_CREATE_SUPPLEMENT_STORAGE("/createSupplementStorage"),
    /**
     * 代理点平台-运单号是否可代发短信接口
     */
    APPRECIATION_SERVICE_GET_MOBILE_AND_NAME_BY_BILL_CODE("/getMobileAndNameByBillCode"),
    /**
     * 代理点平台-代理点代发短信接口
     */
    APPRECIATION_SERVICE_SEND_MSG("/sendMsg"),
    /**
     * 代理点平台-出库面单图片回传给物流轨迹接口
     */
    APPRECIATION_SERVICE_BACK_BILL_IMG("/backBillImg"),
    /**
     * 代理点平台-代理点下单接口
     */
    APPRECIATION_SERVICE_ORDER_CREATE("/OrderCreate"),
    /**
     * 中通分机号绑定接口
     */
    APPRECIATION_SERVICE_BINDING_PARTNER_SERVICE_FACADE("/BindingPartnerServiceFacade")
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
