package com.coupon.project.repositories;

import com.coupon.project.entities.Customer;
import com.coupon.project.entities.CustomerVsCoupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVsCouponRepo
        extends CrudRepository<CustomerVsCoupon, Integer> {
    // provide filtered list based on customer
    Iterable<CustomerVsCoupon> findAllByCustomerEquals(Customer customer);
}
