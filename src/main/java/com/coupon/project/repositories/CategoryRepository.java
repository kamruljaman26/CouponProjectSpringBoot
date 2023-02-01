package com.coupon.project.repositories;

import com.coupon.project.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    // automatically add curd methods
}
