package top.todev.express.zto.api.bean.response.basic;

import java.io.Serializable;

/**
 * <p>
 * 时效价格响应实体
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 9:43
 * @since 0.0.1
 */
public class HourPriceData implements Serializable {
    private static final long serialVersionUID = -6083074278129333305L;

    /** 首重费用 */
    private String firstMoney;
    /** 续重费用 */
    private String addMoney;
    /** 时效 */
    private String hour;
}
