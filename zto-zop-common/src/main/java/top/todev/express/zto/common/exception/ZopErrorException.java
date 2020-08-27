package top.todev.express.zto.common.exception;

import lombok.Getter;

/**
 * <p>
 * 中通开放平台接口异常
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 10:41
 * @since 0.0.1
 */
@Getter
public class ZopErrorException extends Exception {

    private static final long serialVersionUID = -2238949970975233428L;
    private final ZopError error;

    public ZopErrorException(ZopError error) {
        super(error.toString());
        this.error = error;
    }

    public ZopErrorException(ZopError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }
}
