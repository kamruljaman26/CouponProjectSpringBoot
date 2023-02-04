package com.coupon.project.controllers;

import com.coupon.project.Application;
import com.coupon.project.entities.Category;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import com.coupon.project.entities.Customer;
import com.coupon.project.errors.exceptions.*;
import com.coupon.project.services.CompanyService;
import com.coupon.project.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/purchase")
    public Coupon addCoupon(@RequestBody Coupon coupon)
            throws NotLoginException, SameCouponException, CouponExpireException, CouponOutOfStockException {
        return customerService.purchaseCoupon(coupon);
    }

    @GetMapping(path = "/coupon")
    public ArrayList<Coupon> getCustomerCoupons() throws NotLoginException {
        return customerService.getCustomerCoupons();
    }

    @GetMapping(path = "/coupon-by-category")
    public ArrayList<Coupon> getCustomerCouponsByCategory(@RequestBody Category category) throws NotLoginException {
        return customerService.getCustomerCoupons(category);
    }

    @GetMapping(path = "/coupon-by-max-price")
    public ArrayList<Coupon> getCustomerCouponsByMaxPrice(@RequestParam double maxPrice) throws NotLoginException {
        return customerService.getCustomerCoupons(maxPrice);
    }

    @GetMapping(path = "")
    public Customer getCustomerDetails() throws NotLoginException {
        return customerService.getCustomerDetails();
    }

    @GetMapping(path = "/logout")
    public String logout() {
        customerService.logout();
        return "Logout successful!";
    }


}
