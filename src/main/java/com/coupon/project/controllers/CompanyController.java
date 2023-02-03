package com.coupon.project.controllers;

import com.coupon.project.Application;
import com.coupon.project.entities.Category;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import com.coupon.project.errors.exceptions.DuplicateCompanyNameOrEmailException;
import com.coupon.project.errors.exceptions.DuplicateCouponNameException;
import com.coupon.project.errors.exceptions.NotLoginException;
import com.coupon.project.errors.exceptions.UpdateCompanyNameException;
import com.coupon.project.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CompanyService companyService;

    @PostMapping(path = "/coupon")
    public Coupon addCoupon(@RequestBody Coupon coupon)
            throws DuplicateCouponNameException, NotLoginException {
        return companyService.addCoupon(coupon);
    }

    @PutMapping(path = "/coupon")
    public Coupon updateCoupon(@RequestBody Coupon coupon)
            throws DuplicateCouponNameException, NotLoginException {
        return companyService.updateCoupon(coupon);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteCoupon(@PathVariable int id)
            throws NotLoginException {
        return companyService.deleteCoupon(id);
    }

    @GetMapping(path = "")
    public Company getCompanyDetails() throws NotLoginException {
        return companyService.getCompanyDetails();
    }

    @GetMapping(path = "/coupon")
    public ArrayList<Coupon> getCompanyCoupons() throws NotLoginException {
        return companyService.getCompanyCoupons();
    }

    @GetMapping(path = "/coupon-by-category")
    public ArrayList<Coupon> getCompanyCouponsByCategory(@RequestBody Category category) throws NotLoginException {
        return companyService.getCompanyCoupons(category);
    }

    @GetMapping(path = "/coupon-by-max-price")
    public ArrayList<Coupon> getCompanyCouponsByMaxPrice(@RequestParam double maxPrice) throws NotLoginException {
        return companyService.getCompanyCoupons(maxPrice);
    }

    @GetMapping(path = "/logout")
    public String logout() {
        companyService.logout();
        return "Logout successful!";
    }


}
