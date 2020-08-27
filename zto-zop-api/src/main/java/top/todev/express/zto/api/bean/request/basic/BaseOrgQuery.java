package top.todev.express.zto.api.bean.request.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.todev.express.zto.api.bean.ZopPage;

import java.io.Serializable;

/**
 * <p>
 * 网点查询请求参数实体
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 10:18
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseOrgQuery extends ZopPage implements Serializable {

    private static final long serialVersionUID = 5600131034953242344L;

    private String name;

    public BaseOrgQuery initPage() {
        return initPage(100);
    }

    public BaseOrgQuery initPage(Integer pageSize) {
        this.pageIndex = 1;
        this.pageSize = pageSize;
        return this;
    }
}
