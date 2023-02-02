package com.coupon.project.repositories;

import com.coupon.project.entities.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends CrudRepository<Coupon, Integer> {
    // automatically add curd methods
}
