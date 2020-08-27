package top.todev.express.zto.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 中通开放平台错误信息
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 10:39
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
public class ZopError implements Serializable {
    private static final long serialVersionUID = 1178815536051758591L;
    /** 必填信息为空 */
    private static ZopError ERROR_NULL = new ZopError("1001", "信息为空");

    /**
     * 错误代码.
     */
    private final String errorCode;

    /**
     * 错误信息.
     * （如果可以翻译为中文，就为中文）
     */
    private final String errorMsg;


    public static ZopError getErrorNull() {
        return ERROR_NULL;
    }
}
