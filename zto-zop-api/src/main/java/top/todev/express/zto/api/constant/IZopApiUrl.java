package top.todev.express.zto.api.constant;

import top.todev.express.zto.api.bean.ZopHostConfig;

/**
 * <p>中通开放平台 API 路径配置类</p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IZopApiUrl {

    /**
     * 获取API接口路径
     * @param config 路径配置类
     * @return API接口路径
     */
    String getUrl(ZopHostConfig config);

}
