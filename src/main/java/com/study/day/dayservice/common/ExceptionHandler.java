package com.study.day.dayservice.common;

import com.study.day.dayservice.errormessage.ErrorCodeAndMsg;
import com.study.day.dayservice.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tiger on 2018/10/9.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CommonException.class)
    @ResponseBody
    public Response handleStudentException(HttpServletRequest request, CommonException ex) {
        Response response;
        log.error("StudentException code:{},msg:{}", ex.getResponse().getCode(), ex.getResponse().getMsg());
        response = new Response(ex.getResponse().getCode(), ex.getResponse().getMsg());
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Exception ex) {
        Response response;
        log.error("exception error:{}", ex);
        response = new Response(ErrorCodeAndMsg.Network_error.getCode(),
                ErrorCodeAndMsg.Network_error.getMsg());
        return response;
    }
}