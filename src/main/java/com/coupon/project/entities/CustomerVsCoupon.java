package com.coupon.project.entities;

import jakarta.persistence.*;

@Entity
public class CustomerVsCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Coupon coupon;
}
