package top.todev.express.zto.api.bean.response.basic;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 网点信息实体
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 9:47
 * @since 0.0.1
 */
@Data
public class BaseOrganize implements Serializable {
    private static final long serialVersionUID = -7451102287113233772L;

    /** 网点ID */
    private Long siteId;
    /** 网点Code */
    private String code;
    /** 网点全称 */
    private String fullName;
    /** 网点所在省 */
    private String province;
    /** 网点所在市 */
    private String city;
    /** 网点所在区 */
    private String district;
    /** 网点详细地址，不存在返回空字符串 */
    private String address;
    /** 网点所在省id */
    private Long provinceId;
    /** 网点所在市id */
    private Long cityId;
    /** 网点所在区id */
    private Long districtid;

}
