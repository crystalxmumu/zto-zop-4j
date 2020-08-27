package top.todev.express.zto.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.todev.express.zto.api.bean.ZopHostConfig;
import top.todev.express.zto.api.bean.request.basic.BaseOrgQuery;
import top.todev.express.zto.api.bean.request.basic.HourPriceQuery;
import top.todev.express.zto.api.bean.response.basic.BaseAreaInfo;
import top.todev.express.zto.api.bean.response.basic.BaseOrganizePage;
import top.todev.express.zto.api.bean.response.basic.FullAreaInfo;
import top.todev.express.zto.api.bean.response.basic.HourPriceData;
import top.todev.express.zto.api.config.IZopConfigStorage;
import top.todev.express.zto.api.config.impl.ZopConfigStorageMemoryImpl;
import top.todev.express.zto.api.service.IZopApiService;
import top.todev.express.zto.api.service.impl.ZopApiServiceImpl;
import top.todev.express.zto.common.exception.ZopErrorException;

import java.util.List;

import static top.todev.express.zto.api.bean.ZopHostConfig.API_DEFAULT_HOST_URL;

/**
 * <p>
 * 基础信息测试类
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 15:32
 * @since 0.0.1
 */
@Slf4j
public class TestBasicInfoService {

    private IZopApiService service;

    /**
     * 测试环境配置
     */
    @BeforeEach
    public void setUpDevTest() {
        ZopHostConfig hostConfig = new ZopHostConfig("https://japi-dev.zto.com");
        IZopConfigStorage configStorage = new ZopConfigStorageMemoryImpl("kfpttestCode", "kfpttestkey==", hostConfig);
        service = new ZopApiServiceImpl(configStorage);
    }

    /**
     * 生产环境配置
     */
//    @BeforeEach
    public void setUpProdTest() {
        ZopHostConfig hostConfig = new ZopHostConfig(API_DEFAULT_HOST_URL);
        IZopConfigStorage configStorage = new ZopConfigStorageMemoryImpl("合作商编码", "合作商签名", hostConfig);
        service = new ZopApiServiceImpl(configStorage);
    }

    @Test
    public void testGetArea() throws ZopErrorException {
        List<BaseAreaInfo> baseAreaInfos = service.getBasicInfoService().baseAreaGetArea("150000");
        log.info("区域数量:{}", baseAreaInfos.size());
    }

    @Test
    public void testGetAllArea() throws ZopErrorException {
        List<FullAreaInfo> baseAreaInfos = service.getBasicInfoService().baseAreaGetAll();
        log.info("全部区域数量:{}", baseAreaInfos.size());
    }

    @Test
    public void testQueryHourPrice() throws ZopErrorException {
        HourPriceQuery query = new HourPriceQuery("浙江", "杭州市",
                "江苏", "无锡市");
        HourPriceData data = service.getBasicInfoService().queryHourPriceData(query);
        log.info("时效数据：{}", data);
    }

    @Test
    public void testQueryNetInfo() throws ZopErrorException {
        BaseOrgQuery query = new BaseOrgQuery("包头").initPage();
        BaseOrganizePage page = service.getBasicInfoService().queryBaseOrganize(query);
        log.info("网点数据：{}", page);
    }
}
