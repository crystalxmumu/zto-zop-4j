package top.todev.express.zto.common.exception;

import cn.hutool.core.util.StrUtil;

/**
 * 不期望发生的异常类。
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 9:50
 * @since 0.0.1
 */
public class NotExceptException extends RuntimeException {

	private static final long serialVersionUID = 1600998598473760730L;

	public NotExceptException() {
		this("不期望发生的异常!");
	}

	public NotExceptException(String msg) {
		super(msg);
	}

	public NotExceptException(String msg, Exception e) {
		super(msg, e);
	}

	/**
	 * <p>
	 * 模板方式创建异常
	 * </p
	 * @param msg 字符串模板
	 * @param args 参数
	 */
	public NotExceptException(String msg, Object... args) {
		super(StrUtil.format(msg, args));
	}
}
