package top.todev.express.zto.api.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import top.todev.express.zto.api.bean.request.basic.BaseOrgQuery;
import top.todev.express.zto.api.bean.request.basic.HourPriceQuery;
import top.todev.express.zto.api.bean.response.ZopResult02Response;
import top.todev.express.zto.api.bean.response.basic.BaseAreaInfo;
import top.todev.express.zto.api.bean.response.basic.BaseOrganizePage;
import top.todev.express.zto.api.bean.response.basic.FullAreaInfo;
import top.todev.express.zto.api.bean.response.ZopResult01Response;
import top.todev.express.zto.api.bean.response.basic.HourPriceData;
import top.todev.express.zto.api.service.IZopApiService;
import top.todev.express.zto.api.service.IZopBasicInfoService;
import top.todev.express.zto.common.bean.CommonResultResponse;
import top.todev.express.zto.common.exception.ZopError;
import top.todev.express.zto.common.exception.ZopErrorException;

import java.util.List;

import static top.todev.express.zto.api.constant.BasicInfoUrlEnum.*;

/**
 * <p>
 * 中通开放平台基础信息接口实现
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 10:44
 * @since 0.0.1
 */
@Slf4j
public class ZopBasicInfoServiceImpl extends ZopApiServiceBaseImpl implements IZopBasicInfoService {

    /** 获取指定的省市区服务子类 */
    private final static String MSG_TYPE_GET_AREA = "GET_AREA";
    /** 获取全部省市区服务子类 */
    private final static String MSG_TYPE_GET_ALL = "GET_ALL";
    /** 获取时效价格服务子类 */
    private final static String MSG_TYPE_GET_HOUR_PRICE = "GET_HOUR_PRICE";

    private final static String DEFAULT_ALL_AREA = "0";

    public ZopBasicInfoServiceImpl(@NonNull IZopApiService apiService) {
        super(apiService);
    }

    @Override
    public List<BaseAreaInfo> baseAreaGetArea(String code) throws ZopErrorException {
        if (StrUtil.isBlank(code)) {
            throw new ZopErrorException(ZopError.getErrorNull());
        }
        String body = createParamsWithCompany(MSG_TYPE_GET_AREA, code);
        String result = postUrl(BASIC_INFO_BASE_AREA_GET_AREA, body);
        ZopResult01Response<List<BaseAreaInfo>> response = JSON.parseObject(result,
                new TypeReference<ZopResult01Response<List<BaseAreaInfo>>>(){});

        return checkResponseResult(response);
    }

    @Override
    public List<FullAreaInfo> baseAreaGetAll() throws ZopErrorException {
        String body = createParamsWithCompany(MSG_TYPE_GET_ALL, DEFAULT_ALL_AREA);
        String result = postUrl(BASIC_INFO_BASE_AREA_GET_ALL, body);
        ZopResult01Response<List<FullAreaInfo>> response = JSON.parseObject(result,
                new TypeReference<ZopResult01Response<List<FullAreaInfo>>>(){});

        return checkResponseResult(response);
    }

    @Override
    public HourPriceData queryHourPriceData(HourPriceQuery hourPriceQuery) throws ZopErrorException {
        String body = createParamsWithCompany(MSG_TYPE_GET_HOUR_PRICE, hourPriceQuery);
        String result = postUrl(BASIC_INFO_PRICE_AND_HOUR_INTERFACE_GET_HOUR_PRICE, body);
        ZopResult02Response<HourPriceData> response = JSON.parseObject(result,
                new TypeReference<ZopResult02Response<HourPriceData>>(){});

        return checkResponseResult(response);
    }

    @Override
    public BaseOrganizePage queryBaseOrganize(BaseOrgQuery baseOrgQuery) throws ZopErrorException {
        String body = createParams("baseOrgDto", baseOrgQuery);
        String result = postUrl(BASIC_INFO_DO_NET_GATEWAY_SERVICE, body);
        CommonResultResponse<BaseOrganizePage> response = JSON.parseObject(result,
                new TypeReference<CommonResultResponse<BaseOrganizePage>>(){});
        return checkResponseResult(response);
    }
}
