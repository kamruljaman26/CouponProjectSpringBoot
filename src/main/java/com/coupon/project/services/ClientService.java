package com.coupon.project.services;

import com.coupon.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerVsCouponRepo cVCRepo;

    public abstract boolean login(String email, String password);
}
