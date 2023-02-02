package com.coupon.project.repositories;

import java.util.Optional;

import com.coupon.project.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    // automatically add curd methods
    Optional<Customer> findCustomerByEmailEqualsAndPasswordEquals(String email, String password);

}
