package com.coupon.project.errors.advice;

import com.coupon.project.errors.exceptions.DuplicateCompanyNameOrEmailException;
import com.coupon.project.errors.exceptions.DuplicateCustomerEmailException;
import com.coupon.project.errors.exceptions.UpdateCompanyNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdminAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateCompanyNameOrEmailException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String duplicateCompanyNameOrEmail(DuplicateCompanyNameOrEmailException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UpdateCompanyNameException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String updateCompanyName(UpdateCompanyNameException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DuplicateCustomerEmailException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String duplicateCustomerEmail(DuplicateCustomerEmailException ex) {
        return ex.getMessage();
    }

}
