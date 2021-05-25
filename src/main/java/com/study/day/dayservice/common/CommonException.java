package com.study.day.dayservice.common;

import com.study.day.dayservice.errormessage.ErrorCodeAndMsg;

/**
 * 统一异常捕获类
 * Created by Tiger on 2018/10/9.
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -6370612186038915645L;

    private final ErrorCodeAndMsg response;

    public CommonException(ErrorCodeAndMsg response) {
        this.response = response;
    }

    public ErrorCodeAndMsg getResponse() {
        return response;
    }
}