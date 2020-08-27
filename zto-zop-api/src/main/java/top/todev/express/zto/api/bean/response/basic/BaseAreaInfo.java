package top.todev.express.zto.api.bean.response.basic;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 基础区域信息
 * </p>
 * @author 小飞猪
 * @since 0.0.1
 * @version 0.0.1
 * @date 2020-08-25 16:05
 */
@Data
public class BaseAreaInfo implements Serializable {
    private static final long serialVersionUID = 4130864048242085066L;

    /** 省市区编码 */
    private String code;
    /** 名称 */
    private String fullName;
    /** 大头笔(目前已经废弃) */
    private String mark;
    /** 是否超区 */
    private String outofrange;
    /** 机打大头笔(目前已经废弃) */
    private String printMark;

}
