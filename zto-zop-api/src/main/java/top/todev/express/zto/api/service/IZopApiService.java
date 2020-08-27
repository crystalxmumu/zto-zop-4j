package top.todev.express.zto.api.service;

import top.todev.express.zto.api.config.IZopConfigStorage;

/**
 * <p>
 * 中通开放接口Api接口
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 10:47
 * @since 0.0.1
 */
public interface IZopApiService {

    String HEADER_X_COMPANY_ID = "x-companyId";
    String HEADER_X_DATA_DIGEST = "x-dataDigest";

    String PARAM_COMPANY_ID = "company_id";
    String PARAM_MSG_TYPE = "msg_type";
    String PARAM_DATA = "data";

    /**
     * 获取开放平台接口配置
     * @return 开放平台接口配置
     */
    IZopConfigStorage getConfigStorage();

    /**
     * 获取开放平台基础信息服务接口
     * @return 基础信息服务接口
     */
    IZopBasicInfoService getBasicInfoService();
}
