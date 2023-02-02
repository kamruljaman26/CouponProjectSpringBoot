package com.coupon.project.repositories;

import com.coupon.project.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    // automatically add curd methods
}
