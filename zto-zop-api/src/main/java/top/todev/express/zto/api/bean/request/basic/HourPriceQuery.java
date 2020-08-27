package top.todev.express.zto.api.bean.request.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 时效价格请求参数
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 9:38
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HourPriceQuery implements Serializable {
    private static final long serialVersionUID = 5616203669629443391L;

    /** 发件省 */
    private String sendProv;
    /** 发件市 */
    private String sendCity;
    /** 收件省 */
    private String dispProv;
    /** 收件市 */
    private String dispCity;
}
