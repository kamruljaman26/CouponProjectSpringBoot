package com.coupon.project.repositories;

import com.coupon.project.entities.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepository extends CrudRepository<Coupon, Integer> {
    // automatically add curd methods
}
