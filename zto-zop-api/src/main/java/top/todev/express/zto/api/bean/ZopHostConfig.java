package top.todev.express.zto.api.bean;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *     中通开放平台API路径配置类
 * </p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZopHostConfig {

    public static final String API_DEFAULT_HOST_URL = "http://japi.zto.cn";

    /**
     * API 路径
     */
    private String apiHost;

    /**
     * 创建Api路径
     * @param hostConfig API路径配置类
     * @param prefix API前缀
     * @param path API路径
     * @return 返回API全路径
     */
    public static String buildUrl(ZopHostConfig hostConfig, String prefix, String path) {
        if (hostConfig == null) {
            return prefix + path;
        }

        if (StrUtil.isNotBlank(hostConfig.getApiHost()) &&
                StrUtil.equals(prefix, API_DEFAULT_HOST_URL)) {
            return hostConfig.getApiHost() + path;
        }

        return prefix + path;
    }
}
