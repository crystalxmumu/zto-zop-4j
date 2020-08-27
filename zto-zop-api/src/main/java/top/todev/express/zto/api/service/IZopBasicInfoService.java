package top.todev.express.zto.api.service;
import top.todev.express.zto.api.bean.request.basic.BaseOrgQuery;
import top.todev.express.zto.api.bean.request.basic.HourPriceQuery;
import top.todev.express.zto.api.bean.response.basic.BaseAreaInfo;
import top.todev.express.zto.api.bean.response.basic.BaseOrganizePage;
import top.todev.express.zto.api.bean.response.basic.FullAreaInfo;
import top.todev.express.zto.api.bean.response.basic.HourPriceData;
import top.todev.express.zto.common.exception.ZopErrorException;
import top.todev.express.zto.common.service.IZopBaseService;

import java.util.List;

/**
 * 中通开放平台基础信息接口
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 */
public interface IZopBasicInfoService extends IZopBaseService {

    /**
     * 通过省市区编码获取对应的下级地址信息.
     * @param code 省市区编码
     * @return 指定的省市区信息
     * @throws ZopErrorException 接口访问异常
     */
    List<BaseAreaInfo> baseAreaGetArea(String code) throws ZopErrorException;

    /**
     * 通过该获取中通全部的省市区地址集信息。
     * @return 全部省市区
     * @throws ZopErrorException 接口访问异常
     */
    List<FullAreaInfo> baseAreaGetAll() throws ZopErrorException;

    /**
     * 通过该接口获取中通报价和运输时效
     * @param hourPriceQuery 请求参数
     * @return 报价和运输时效
     * @throws ZopErrorException 接口访问异常
     */
    HourPriceData queryHourPriceData(HourPriceQuery hourPriceQuery) throws ZopErrorException;

    /**
     * 网点基础信息获取
     * @param baseOrgQuery 查询参数
     * @return 网点基础信息
     * @throws ZopErrorException 接口访问异常
     */
    BaseOrganizePage queryBaseOrganize(BaseOrgQuery baseOrgQuery) throws ZopErrorException;
}
