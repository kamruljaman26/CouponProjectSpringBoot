package com.coupon.project.errors.exceptions;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;

public class DuplicateCustomerEmailException extends Throwable {
    public DuplicateCustomerEmailException(Customer customer){
        super("Error: email="+customer.getEmail()+" conflict with other customer");
    }
}
