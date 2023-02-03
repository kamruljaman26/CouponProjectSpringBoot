package com.coupon.project.errors.exceptions;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import com.coupon.project.entities.Customer;

public class DuplicateCouponNameException extends Throwable{
    public DuplicateCouponNameException(Coupon coupon){
        super("Error: title=" + coupon.getTitle() + " conflict with other coupon");
    }
}
