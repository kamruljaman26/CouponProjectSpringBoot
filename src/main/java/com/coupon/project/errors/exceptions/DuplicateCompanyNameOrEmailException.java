package com.coupon.project.errors.exceptions;

import com.coupon.project.entities.Company;

public class DuplicateCompanyNameOrEmailException extends Throwable {
    public DuplicateCompanyNameOrEmailException(Company company) {
        super(String.format("Error:name=%s or email=%s conflict with other company",
                company.getName(), company.getEmail()));
    }
}
