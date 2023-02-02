package com.coupon.project;

import com.coupon.project.entities.Category;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import com.coupon.project.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired private CategoryRepo categoryRepo;
    @Autowired private CompanyRepo companyRepo;
    @Autowired private CouponRepo couponRepo;
    @Autowired private CustomerRepo customerRepo;
    @Autowired private CustomerVsCouponRepo cVCRepo;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {

            // save category
/*            categoryRepo.save(new Category("Food"));
            categoryRepo.save(new Category("Appliances"));
            categoryRepo.save(new Category("Restaurants"));
            categoryRepo.save(new Category("Vacations"));*/



        };
    }
}
