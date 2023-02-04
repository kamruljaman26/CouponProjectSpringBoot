package com.coupon.project.services;

import com.coupon.project.Application;
import com.coupon.project.entities.*;
import com.coupon.project.errors.exceptions.CouponExpireException;
import com.coupon.project.errors.exceptions.CouponOutOfStockException;
import com.coupon.project.errors.exceptions.NotLoginException;
import com.coupon.project.errors.exceptions.SameCouponException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CustomerService extends ClientService {

    private Customer customer = null;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public boolean login(String email, String password) {
        customer = customerRepo.findByEmailAndPassword(email, password);
        return customer != null;
    }

    public Coupon purchaseCoupon(Coupon coupon) throws CouponExpireException, CouponOutOfStockException,
            NotLoginException, SameCouponException {
        if (customer == null) throw new NotLoginException();

        // The coupon cannot be purchased if its expiration date has already arrived
        if (coupon.getEndDate().isBefore(LocalDateTime.now())) throw new CouponExpireException();

        // coupon out of stock
        if (couponRepo.findById(coupon.getId()).get().getAmount() <= 0)
            throw new CouponOutOfStockException();

        // You cannot purchase the same coupon more than once.
        if (getCustomerCoupons().contains(coupon)) throw new SameCouponException();

        // save and return response
        customerVsCouponRepo.save(new CustomerVsCoupon(customer, coupon));
        coupon.setAmount(couponRepo.findById(coupon.getId()).get().getAmount() - 1);
        couponRepo.save(coupon);
        return coupon;
    }

    public ArrayList<Coupon> getCustomerCoupons() throws NotLoginException {
        if (customer == null) throw new NotLoginException();

        // filter and return customer coupons
        List<Coupon> actualList = StreamSupport
                .stream(customerVsCouponRepo.findAllByCustomerEquals(customer).spliterator(), false)
                .map(CustomerVsCoupon::getCoupon)
                .toList();

        return new ArrayList<>(actualList);
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category) throws NotLoginException {
        List<Coupon> actualList = getCustomerCoupons()
                .stream()
                .filter(c -> c.getCategory().getId() == category.getId())
                .toList();
        return new ArrayList<>(actualList);
    }

    public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws NotLoginException {
        List<Coupon> actualList = getCustomerCoupons()
                .stream()
                .filter(c -> c.getPrice() <= maxPrice)
                .toList();
        return new ArrayList<>(actualList);
    }

    public Customer getCustomerDetails() throws NotLoginException {
        if (customer == null) throw new NotLoginException();
        return customer;
    }

    public void logout() {
        customer = null;
    }
}
