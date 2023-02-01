package com.coupon.project.repositories;

import java.util.List;
import java.util.Optional;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    // automatically add curd methods
    Optional<Customer> findCustomerByEmailEqualsAndPasswordEquals(String email, String password);

}
