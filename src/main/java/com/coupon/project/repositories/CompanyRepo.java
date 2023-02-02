package com.coupon.project.repositories;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Integer> {
    // automatically add curd methods
    @Query(value = "SELECT * FROM company WHERE email = :email AND password = :password", nativeQuery = true)
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
