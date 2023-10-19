package com.beosin.alert.common.exception;

/**
 * 服务异常
 *
 * @author shangye
 * @date 2021/11/25
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
