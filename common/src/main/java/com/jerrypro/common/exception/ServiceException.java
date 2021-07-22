package com.jerrypro.common.exception;

/**
 * @author jerrypro
 * @date 2021/7/22
 */
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = 6461493341838706388L;

    /**
     * 无参构造方法.
     */
    public ServiceException() {
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
    public ServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     * @param cause   Throwable
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法.
     *
     * @param message 异常信息
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * 构造方法.
     *
     * @param cause Throwable
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }

}
