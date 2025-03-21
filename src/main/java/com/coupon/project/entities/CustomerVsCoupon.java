package com.coupon.project.entities;

import javax.persistence.*;

@Entity
public class CustomerVsCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    private Coupon coupon;

    public CustomerVsCoupon() {
    }

    public CustomerVsCoupon(Customer customer, Coupon coupon) {
        this.customer = customer;
        this.coupon = coupon;
    }

    public CustomerVsCoupon(int id, Customer customer, Coupon coupon) {
        this.id = id;
        this.customer = customer;
        this.coupon = coupon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "CustomerVsCoupon{" +
                "id=" + id +
                ", customer=" + customer +
                ", coupon=" + coupon +
                '}';
    }
}
