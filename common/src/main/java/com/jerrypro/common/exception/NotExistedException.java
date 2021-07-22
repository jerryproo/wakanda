package com.jerrypro.common.exception;

/**
 * @author jerrypro
 * @date 2021/7/22
 */
public class NotExistedException extends ServiceException {
    /**
     * 自动生成的serialVersionUID.
     */
    private static final long serialVersionUID = -5612925588190340248L;

    /**
     * 无参构造方法.
     */
    public NotExistedException() {
        super();
    }

    /**
     * 构造方法.
     *
     * @param message            异常信息
     * @param cause              Throwable
     * @param enableSuppression  boolean
     * @param writableStackTrace boolean
     */
    public NotExistedException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     * @param cause   Throwable
     */
    public NotExistedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     */
    public NotExistedException(final String message) {
        super(message);
    }

    /**
     * 构造方法.
     *
     * @param cause Throwable
     */
    public NotExistedException(final Throwable cause) {
        super(cause);
    }

}
