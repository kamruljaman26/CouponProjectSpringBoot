package com.coupon.project.errors.advice;

import com.coupon.project.errors.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompanyAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateCouponNameException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String duplicateCouponName(DuplicateCouponNameException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String notLogin(NotLoginException ex) {
        return ex.getMessage();
    }
}
