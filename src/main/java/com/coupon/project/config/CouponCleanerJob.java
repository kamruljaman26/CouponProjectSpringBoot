package com.coupon.project.config;

import com.coupon.project.repositories.CouponRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class CouponCleanerJob {
    private static final Logger log = LoggerFactory.getLogger(CouponCleanerJob.class);

    @Autowired
    CouponRepo couponRepo;

    /**
     * Clean all expired coupons from current time
     * The scheduler will run with each 5 min
     * and instability load after 30 sec
     */
    @Scheduled(fixedDelayString = "PT5M", initialDelay = 3000)
    public void cleanExpiredCoupon() {
        log.info("Automating couping cleaning started. ");
        couponRepo.findAll().forEach(coupon -> {
            if (coupon.getEndDate().isBefore(LocalDateTime.now())) {
                log.info("Coupon Cleaned: " + coupon);
                couponRepo.delete(coupon);
            }
        });
    }
}
