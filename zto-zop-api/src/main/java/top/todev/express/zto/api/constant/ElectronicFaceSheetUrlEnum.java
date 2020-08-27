package top.todev.express.zto.api.constant;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import top.todev.express.zto.api.bean.ZopHostConfig;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;
import static top.todev.express.zto.api.bean.ZopHostConfig.buildUrl;

/**
 * 电子面单
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@AllArgsConstructor
public enum ElectronicFaceSheetUrlEnum implements IZopApiUrl {
    /**
     * 获取单号(有密钥)
     */
    ELECTRONIC_FACE_SHEET_SUBMIT_ORDER_CODE("/submitOrderCode"),
    /**
     * 获取可用余额接口(有密钥)
     */
    ELECTRONIC_FACE_SHEET_QUERY_AVAILABLE_BALANCE("/queryAvailableBalance"),
    /**
     * 获取单号（无密钥）
     */
    ELECTRONIC_FACE_SHEET_PARTNER_INSERT_SUBMIT_AGENT("/partnerInsertSubmitagent"),
    /**
     * 电子面单余额查询（无密钥）
     */
    ELECTRONIC_FACE_SHEET_PARTNER_INSERT_AVAILABLE_COUNTER("/partnerInsertAvailablecounter"),
    /**
     * 电子面单服务-获取运单号并打印
     */
    ELECTRONIC_FACE_SHEET_EXPOSE_SERVICE_PUSH_ORDER_SERVICE("/exposeServicePushOrderService"),
    /**
     * 云打印-打印接口
     */
    ELECTRONIC_FACE_SHEET_DO_PRINT("/doPrint"),
    /**
     * 集包地大头笔获取
     */
    ELECTRONIC_FACE_SHEET_BAG_ADDR_MARK_GET_MARK("/bagAddrMarkGetmark"),
    /**
     * 电子面单账号申请接口
     */
    ELECTRONIC_FACE_SHEET_PUBLIC_CUSTOMER_APPLY_SERVICE("/publicCustomerApplyService"),
    /**
     * 查询客户申请审核结果接口
     */
    ELECTRONIC_FACE_SHEET_GET_CHECK_STATUS("/getCheckStatus"),
    /**
     * 实名制-个人用户上传
     */
    ELECTRONIC_FACE_SHEET_REALNAME_PER_USER_UPLOAD("/realnamePerUserUpload"),
    /**
     * 实名制-机构用户上传
     */
    ELECTRONIC_FACE_SHEET_REALNAME_ORG_USER_UPLOAD("/realnameOrgUserUpload"),
    /**
     * 查询客户资料接口
     */
    ELECTRONIC_FACE_SHEET_QUERY_CUST_INFO_BY_USER_ID("/queryCustInfoByUserId"),
    /**
     * 绑定用户和客户关系
     */
    ELECTRONIC_FACE_SHEET_BINDING_CUSTOMER("/bindingCustomer")
    ;

    /**
     * 路径URI
     */
    @NonNull
    private final String path;

    @Override
    public String getUrl(ZopHostConfig config) {
        return buildUrl(config, API_DEFAULT_HOST_URL, this.path);
    }
}
