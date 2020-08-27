package top.todev.express.zto.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 分页实体
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 10:13
 * @since 0.0.1
 */
@Data
public class ZopPage implements Serializable {
    private static final long serialVersionUID = 3649228562756382385L;

    /** 页数 */
    protected Integer pageIndex;
    /** 本页条数，默认10，最大100 */
    protected Integer pageSize;
    /** 查询总条数 */
    protected Integer recordCount;
}
