package com.coupon.project.repositories;

import com.coupon.project.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer WHERE email = :email AND password = :password", nativeQuery = true)
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
