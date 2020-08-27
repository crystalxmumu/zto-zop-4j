package top.todev.express.zto.api.constant;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import top.todev.express.zto.api.bean.ZopHostConfig;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;
import static top.todev.express.zto.api.bean.ZopHostConfig.buildUrl;

/**
 * 快件轨迹
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@AllArgsConstructor
public enum ExpressTrackUrlEnum implements IZopApiUrl {
    /**
     * 获取快件轨迹信息
     */
    EXPRESS_TRACK_TRACE_INTERFACE_NEW_TRACES("/traceInterfaceNewTraces"),
    /**
     * 获取快件最新一条
     */
    EXPRESS_TRACK_TRACE_INTERFACE_LATEST("/traceInterfaceLatest")
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
