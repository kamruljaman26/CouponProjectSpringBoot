package com.coupon.project.errors.exceptions;

import com.coupon.project.entities.Company;

public class UpdateCompanyNameException extends Throwable {
    public UpdateCompanyNameException(Company company){
        super("Error: sorry company name can't be update!");
    }
}
