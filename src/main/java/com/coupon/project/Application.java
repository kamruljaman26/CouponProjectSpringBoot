package com.coupon.project;

import com.coupon.project.entities.Category;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Coupon;
import com.coupon.project.entities.Customer;
import com.coupon.project.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


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
            log.info("Preloading: "+categoryRepo.save(new Category("Food")));
            log.info("Preloading: "+categoryRepo.save(new Category("Appliances")));
            log.info("Preloading: "+categoryRepo.save(new Category("Restaurants")));
            log.info("Preloading: "+categoryRepo.save(new Category("Vacations")));

            log.info("Preloading: "+ customerRepo.save(
                    new Customer("Jhon","Due", "jhon@gmail.com","123456")));
            log.info("Preloading: "+ customerRepo.save(
                    new Customer("Loies","Due", "loies@gmail.com","123456")));

            log.info("Preloading: " + companyRepo.save(
                    new Company("SpaceX", "jhon@gmail.com", "123456")));
            log.info("Preloading: " + companyRepo.save(
                    new Company("Microsoft", "kamrul@gmail.com", "123456")));

            // preloading coupon
            Coupon coupon = new Coupon();
            coupon.setAmount(100);
            coupon.setCategory(categoryRepo.findAll().iterator().next());
            coupon.setCompany(companyRepo.findAll().iterator().next());
            coupon.setDescription("Coupon Description");
            coupon.setStartDate(LocalDateTime.now());
            coupon.setEndDate(LocalDateTime.now().plusDays(10L));
            coupon.setImage("https://image.com");
            coupon.setPrice(200);
            coupon.setTitle("Buy 1 Get 2");
            couponRepo.save(coupon);
            log.info("Preloading: " + coupon);

        };
    }
}
