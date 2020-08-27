package top.todev.express.zto.api.service.impl;

import lombok.Getter;
import top.todev.express.zto.api.config.IZopConfigStorage;
import top.todev.express.zto.api.service.IZopApiService;
import top.todev.express.zto.api.service.IZopBasicInfoService;

/**
 * <p>
 * 中通开放平台接口实现
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 15:37
 * @since 0.0.1
 */
@Getter
public class ZopApiServiceImpl implements IZopApiService {

    /** 开放平台配置 */
    private final IZopConfigStorage configStorage;
    /** 基础信息接口 */
    private final IZopBasicInfoService basicInfoService;

    public ZopApiServiceImpl(IZopConfigStorage configStorage) {
        this.configStorage = configStorage;
        basicInfoService = new ZopBasicInfoServiceImpl(this);
    }

}
