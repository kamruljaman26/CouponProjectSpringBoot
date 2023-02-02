package com.coupon.project.services;

import com.coupon.project.entities.Category;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService extends ClientService{

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public Coupon addCoupon(Coupon coupon){
        return null;
    }

    public Coupon updateCoupon(Coupon coupon){
        return null;
    }

    public boolean addCoupon(int couponId){
        return false;
    }

    public ArrayList<Coupon> getCompanyCoupons(){
        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category){
        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice){
        return null;
    }

    public Company getCompanyDetails(){
        return null;
    }
}
