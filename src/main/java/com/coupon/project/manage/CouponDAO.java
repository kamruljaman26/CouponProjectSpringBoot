package com.coupon.project.manage;

import com.coupon.project.entities.Category;

import java.util.ArrayList;
//This is CouponDAO Class
public interface CouponDAO {
    void addCoupon(Coupon coupon) throws Exception;
    void updateCoupon(Coupon coupon) throws Exception;
    void deleteCoupon(Coupon coupon) throws Exception;
    ArrayList<Coupon> getAllCoupon() throws Exception;
    Coupon getOneCoupon(int couponId) throws Exception;
    void addCouponPurchase(int custId,int coupId) throws Exception;
    void deleteCouponPurchase(int custID,int CoupId) throws Exception;
    ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception;
}
