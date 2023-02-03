package com.coupon.project.services;

import com.coupon.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CategoryRepo categoryRepo;
    @Autowired
    protected CompanyRepo companyRepo;
    @Autowired
    protected CouponRepo couponRepo;
    @Autowired
    protected CustomerRepo customerRepo;
    @Autowired
    protected CustomerVsCouponRepo cVCRepo;

    public abstract boolean login(String email, String password);

}
