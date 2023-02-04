package com.coupon.project.errors.advice;

import com.coupon.project.errors.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerAdvice {

    @ResponseBody
    @ExceptionHandler(CouponExpireException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String couponExpire(CouponExpireException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CouponOutOfStockException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String couponOutOfStock(CouponOutOfStockException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SameCouponException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String sameCouponException(SameCouponException ex) {
        return ex.getMessage();
    }

}
