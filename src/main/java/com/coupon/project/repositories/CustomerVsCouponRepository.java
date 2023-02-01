package com.coupon.project.repositories;

import com.coupon.project.entities.Coupon;
import com.coupon.project.entities.Customer;
import com.coupon.project.entities.CustomerVsCoupon;
import org.springframework.data.repository.CrudRepository;

public interface CustomerVsCouponRepository
        extends CrudRepository<CustomerVsCoupon, Integer> {
    // provide filtered list based on customer
    Iterable<CustomerVsCouponRepository> findAllByCustomerEquals(Customer customer);
}
