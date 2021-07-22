package com.jerrypro.common.exception;

/**
 * @author jerrypro
 * @date 2021/7/22
 */
public class ParamsException extends ServiceException {

    private static final long serialVersionUID = 8336801071550068539L;

    /**
     * 无参构造方法.
     */
    public ParamsException() {
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
    public ParamsException(final String message, final Throwable cause, final boolean enableSuppression,
                           final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     * @param cause   Throwable
     */
    public ParamsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     */
    public ParamsException(final String message) {
        super(message);
    }

    /**
     * 构造方法.
     *
     * @param cause Throwable
     */
    public ParamsException(final Throwable cause) {
        super(cause);
    }
}
