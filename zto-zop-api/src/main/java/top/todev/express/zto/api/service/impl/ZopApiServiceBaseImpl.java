package top.todev.express.zto.api.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import top.todev.express.zto.api.bean.ZopHostConfig;
import top.todev.express.zto.api.config.IZopConfigStorage;
import top.todev.express.zto.api.constant.IZopApiUrl;
import top.todev.express.zto.api.service.IZopApiService;
import top.todev.express.zto.common.bean.IZopResultResponse;
import top.todev.express.zto.common.exception.ZopError;
import top.todev.express.zto.common.exception.ZopErrorException;
import top.todev.express.zto.common.service.IZopBaseService;

import java.util.LinkedHashMap;
import java.util.Map;

import static top.todev.express.zto.api.service.IZopApiService.*;

/**
 * <p>
 * 中通开放平台基础实现类
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 11:17
 * @since 0.0.1
 */
@Slf4j
public abstract class ZopApiServiceBaseImpl implements IZopBaseService {

    /** 开放平台接口 */
    @NonNull
    protected final IZopApiService apiService;
    /** 开放平台配置接口 */
    protected final IZopConfigStorage configStorage;
    /** 开放平台API路径配置类 */
    protected final ZopHostConfig hostConfig;

    public ZopApiServiceBaseImpl(@NonNull IZopApiService apiService) {
        this.apiService = apiService;
        this.configStorage = apiService.getConfigStorage();
        this.hostConfig = apiService.getConfigStorage().getZopHostConfig();
    }

    /**
     * 使用post方式请求接口
     * @param apiUrl 请求接口Url
     * @param body 请求参数
     * @return 响应结果
     */
    public String postUrl(IZopApiUrl apiUrl, String body) {
        String url = apiUrl.getUrl(this.hostConfig);
        return postUrl(url, body);
    }

    @Override
    public String postUrl(String url, String body) {
        String signature = signature(body);
        String result = HttpRequest.post(url)
                .contentType(ContentType.FORM_URLENCODED.toString(CharsetUtil.CHARSET_UTF_8))
                .header(HEADER_X_COMPANY_ID, this.configStorage.getCompanyId())
                .header(HEADER_X_DATA_DIGEST, signature)
                .body(body)
                .execute()
                .body();
        log.info("请求路径: {}, 请求参数: {}, 签名: {}, 响应结果: {}", url, body, signature, result);
        return result;
    }

    /**
     * 检查响应结果并返回响应数据
     * @param response 响应结果
     * @param <T> 响应数据类型
     * @return 响应数据
     * @throws ZopErrorException 调用错误异常
     */
    protected <T> T checkResponseResult(IZopResultResponse<T> response) throws ZopErrorException {
        if (response == null) {
            throw new ZopErrorException(ZopError.getErrorNull());
        } else if( response.getSuccess() == null || !response.getSuccess()) {
            throw new ZopErrorException(new ZopError(response.getErrorCode(), response.getErrorMessage()));
        }
        return response.getData();
    }

    /**
     * 创建业务请求参数
     * @param msgType 接口服务子类
     * @param data 业务数据
     * @return 请求参数
     */
    protected String createParamsWithCompany(String msgType, Object data) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(PARAM_COMPANY_ID, this.configStorage.getCompanyId());
        map.put(PARAM_MSG_TYPE, msgType);
        map.put(PARAM_DATA,
                data instanceof String ? (String) data : JSON.toJSONString(data));
        return HttpUtil.toParams(map, null);
    }

    /**
     * 创建业务请求参数
     * @param key 请求参数key
     * @param data 业务数据
     * @return 请求参数
     */
    protected String createParams(String key, Object data) {
        Map<String, String> map = new LinkedHashMap<>();
        if (data != null ) {
            map.put(key,
                    data instanceof String ? (String) data : JSON.toJSONString(data));
        }
        return HttpUtil.toParams(map);
    }

    /**
     * 对业务参数签名
     * @param params 待签名业务参数串
     * @return 签名数据
     */
    protected String signature(String params) {
        String string = params + this.apiService.getConfigStorage().getCompanyKey();
        String md5 = SecureUtil.md5(string);
        return Base64.encode(md5);
    }
}
