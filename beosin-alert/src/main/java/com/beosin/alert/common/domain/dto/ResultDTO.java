package com.beosin.alert.common.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用结果
 * @author wulin
 * */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -831678996819330527L;

    /** 状态码 */
    private Integer code;

    /** 消息 */
    private String message;

    /** 数据 */
    private T data;

    /** 时间戳 */
    private Long timestamp;

    /** 成功标示 */
    private Boolean success;

    private ResultDTO(T data) {
        this(200, "success");
        this.data = data;
    }

    private ResultDTO(int code, String message) {
        this.success = code == 200;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    private ResultDTO(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    private ResultDTO(int code, String message, T data, Boolean success) {
        this(code, message);
        this.data = data;
        this.success = success;
    }

    private static <T> ResultDTO<T> result(int code, String message) {
        return new ResultDTO<>(code, message);
    }

    private static <T> ResultDTO<T> result(int code, String message, T data) {
        return new ResultDTO<>(code, message, data);
    }

    public static <T> ResultDTO<T> success(T data) {
        return new ResultDTO<>(data);
    }

    public static <T> ResultDTO<T> fail(int code, String message) {
        return new ResultDTO<>(code, message);
    }
}