package top.todev.express.zto.api.config;

import top.todev.express.zto.api.bean.ZopHostConfig;

/**
 * <p>
 *     中通开放平台配置接口
 * </p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IZopConfigStorage {

    /**
     * 获取合作商编号
     * @return 合作商编号
     */
    String getCompanyId();

    /**
     * 获取合作商密钥
     * @return 合作商密钥
     */
    String getCompanyKey();

    /**
     * 获取通开放平台API路径配置
     * @return 通开放平台API路径配置
     */
    ZopHostConfig getZopHostConfig();
}
