package com.coupon.project.repositories;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    // automatically add curd methods
    Optional<Company> findCompanyByEmailEqualsAndPasswordEquals(String email,String password);
}
