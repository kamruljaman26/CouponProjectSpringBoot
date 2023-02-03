package com.coupon.project.controllers;

import com.coupon.project.Application;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import com.coupon.project.errors.exceptions.DuplicateCompanyNameOrEmailException;
import com.coupon.project.errors.exceptions.DuplicateCustomerEmailException;
import com.coupon.project.errors.exceptions.UpdateCompanyNameException;
import com.coupon.project.services.AdminService;
import com.coupon.project.services.CompanyService;
import com.coupon.project.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    /**
     * LoginManager/Controller
     *
     * @param type type of client
     * @param email      client email
     * @param password   client password
     * @return login status
     */
    @PostMapping(path = "/login")
    public boolean login(@RequestParam String type,
                         @RequestParam String email,
                         @RequestParam String password) {
        log.info("Login: email="+email+" password="+password);
        if (type.equalsIgnoreCase("admin")) return adminService.login(email, password);
        if (type.equalsIgnoreCase("company")) return companyService.login(email, password);
        if (type.equalsIgnoreCase("customer")) return customerService.login(email, password);
        return false;
    }


}
