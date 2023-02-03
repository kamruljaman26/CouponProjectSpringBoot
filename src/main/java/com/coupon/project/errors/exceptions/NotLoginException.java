package com.coupon.project.errors.exceptions;

public class NotLoginException extends Throwable{
    public NotLoginException(){
        super("Please login to access any method!");
    }
}
