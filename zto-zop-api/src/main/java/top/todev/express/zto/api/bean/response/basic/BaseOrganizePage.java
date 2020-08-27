package top.todev.express.zto.api.bean.response.basic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.todev.express.zto.api.bean.ZopPage;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 网点响应分页数据
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 10:21
 * @since 0.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseOrganizePage extends ZopPage implements Serializable {

    private static final long serialVersionUID = -5790087459397574534L;

    /** 网点信息列表 */
    private List<BaseOrganize> baseOrganize;
}
