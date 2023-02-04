package com.coupon.project.errors.exceptions;

public class CouponOutOfStockException extends Throwable{
    public CouponOutOfStockException(){
        super("Sorry you can't purchase a the coupon, the coupon is out of stock");
    }
}
