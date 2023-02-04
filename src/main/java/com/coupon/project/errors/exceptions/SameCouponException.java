package com.coupon.project.errors.exceptions;

import com.coupon.project.entities.Coupon;

public class SameCouponException extends Throwable{
    public SameCouponException(){
        super("Sorry you can't purchase a coupon twice");
    }
}
