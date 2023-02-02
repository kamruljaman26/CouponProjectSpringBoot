package com.coupon.project.repositories;

import com.coupon.project.entities.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Integer> {
    // automatically add curd methods
    Optional<Company> findCompanyByEmailEqualsAndPasswordEquals(String email,String password);

//    @Query(value = "select * from company where email=?1 && password=?2", nativeQuery = true)

}
