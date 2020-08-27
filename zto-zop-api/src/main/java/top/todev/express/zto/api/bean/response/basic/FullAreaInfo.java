package top.todev.express.zto.api.bean.response.basic;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 完整区域信息
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/25 16:14
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FullAreaInfo extends BaseAreaInfo implements Serializable {
    private static final long serialVersionUID = 4252837851524458534L;

    /** 下级省市区数据 */
    private Set<FullAreaInfo> sub;
}
