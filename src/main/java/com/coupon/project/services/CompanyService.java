package com.coupon.project.services;

import com.coupon.project.Application;
import com.coupon.project.entities.*;
import com.coupon.project.errors.exceptions.DuplicateCouponNameException;
import com.coupon.project.errors.exceptions.NotLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.StreamSupport;

@Service
public class CompanyService extends ClientService {

    private Company company = null;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public boolean login(String email, String password) {
        company = companyRepo.findByEmailAndPassword(email, password);
        return company != null;
    }

    public Coupon addCoupon(Coupon coupon)
            throws DuplicateCouponNameException, NotLoginException {
        // if not login
        if (company == null) throw new NotLoginException();

        // check for coupon name duplicate
        AtomicBoolean isDuplicateCoupon = new AtomicBoolean(false);
        couponRepo.findAll().forEach(c -> {
            if (c.getTitle().equals(coupon.getTitle())
                    && c.getCompany().equals(coupon.getCompany())) isDuplicateCoupon.set(true);
        });

        if (isDuplicateCoupon.get()) throw new DuplicateCouponNameException(coupon);

        return couponRepo.save(coupon);
    }

    public Coupon updateCoupon(Coupon coupon)
            throws DuplicateCouponNameException, NotLoginException {

        // if not login
        if (company == null) throw new NotLoginException();

        // check coupon name not matched with other coupon name
        AtomicBoolean isDuplicateCoupon = new AtomicBoolean(false);
        couponRepo.findAll().forEach(c -> {
            if (c.getId() != coupon.getId() && c.getTitle().equals(coupon.getTitle())
                    && c.getCompany().equals(coupon.getCompany())) isDuplicateCoupon.set(true);
        });

        if (isDuplicateCoupon.get()) throw new DuplicateCouponNameException(coupon);

        return couponRepo.save(coupon);
    }

    public boolean deleteCoupon(int couponId) throws NotLoginException {
        if (company == null) throw new NotLoginException();

        try {
            // delete all customer vs coupon
            ArrayList<CustomerVsCoupon> listCVC = new ArrayList<>();
            customerVsCouponRepo.findAll().forEach(cvc -> {
                if (cvc.getCoupon().getId() == couponId) listCVC.add(cvc);
            });
//            System.out.println(listCVC.toString());
            listCVC.forEach(cvc -> {
                customerVsCouponRepo.delete(cvc);
            });

            couponRepo.deleteById(couponId);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // debug
            return false;
        }
    }

    public ArrayList<Coupon> getCompanyCoupons() throws NotLoginException {
        if (company == null) throw new NotLoginException();

        // filter and return company coupons
        List<Coupon> actualList = StreamSupport
                .stream(couponRepo.findAll().spliterator(), false)
                .filter(coupon -> coupon.getCompany().getId() == company.getId())
                .toList();

        return new ArrayList<>(actualList);
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category) throws NotLoginException {
        if (company == null) throw new NotLoginException();

        // filter and return company coupons
        List<Coupon> actualList = getCompanyCoupons()
                .stream()
                .filter(coupon -> coupon.getCategory().equals(category))
                .toList();

        return new ArrayList<>(actualList);
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws NotLoginException {
        if (company == null) throw new NotLoginException();
        // filter and return company coupons
        List<Coupon> actualList = getCompanyCoupons()
                .stream()
                .filter(coupon -> coupon.getPrice() <= maxPrice)
                .toList();

        return new ArrayList<>(actualList);
    }

    public Company getCompanyDetails() throws NotLoginException {
        if (company == null) throw new NotLoginException();
        return company;
    }

    // custom logout
    public void logout() {
        company = null;
    }
}
