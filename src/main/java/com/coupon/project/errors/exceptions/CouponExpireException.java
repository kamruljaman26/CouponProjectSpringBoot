package com.coupon.project.errors.exceptions;

public class CouponExpireException extends Throwable{
    public CouponExpireException(){
        super("Sorry you can't purchase a expired coupon");
    }
}
