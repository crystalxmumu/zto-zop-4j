package top.todev.express.zto.common.service;

/**
 * 中通开放平台公共服务接口
 * @date 2020-08-25 15:58
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IZopBaseService {

    /**
     * 使用post方式请求接口
     * @param url 请求接口Url
     * @param body 请求参数
     * @return 响应结果
     */
    String postUrl(String url, String body);
}
