package top.todev.express.zto.api.bean.response;

import lombok.Data;
import top.todev.express.zto.common.bean.CommonResultResponse;
import top.todev.express.zto.common.bean.IZopResultResponse;

import java.io.Serializable;

/**
 * <p>
 * 响应结果02实体
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 10:26
 * @since 0.0.1
 */
@Data
public class ZopResult02Response<T> implements Serializable, IZopResultResponse<T> {
    private static final long serialVersionUID = -102399960397087274L;

    /** 状态消息 */
    private String msg;
    /** 响应结果 */
    private T data;
    /** 是否成功 */
    private Boolean status;

    @Override
    public Boolean getSuccess() {
        return this.status;
    }

    @Override
    public String getErrorCode() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return this.msg;
    }

    public CommonResultResponse<T> convert() {
        return new CommonResultResponse<T>(this.status, null, this.msg, this.data);
    }
}
