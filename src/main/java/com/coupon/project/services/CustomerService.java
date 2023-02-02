package com.coupon.project.services;

import com.coupon.project.entities.Category;
import com.coupon.project.entities.Coupon;
import com.coupon.project.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService extends ClientService{

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public Coupon purchaseCoupon(Coupon coupon){
        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(){
        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category){
        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(double maxPrice){
        return null;
    }

    public Customer getCustomerDetails(){
        return null;
    }
}
