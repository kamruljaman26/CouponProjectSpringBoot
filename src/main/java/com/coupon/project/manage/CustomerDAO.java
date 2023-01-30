package com.coupon.project.manage;

import java.util.ArrayList;

public interface CustomerDAO {
    boolean isCustomerExists(String email,String password) throws Exception;
    void addCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer) throws Exception;
    void deleteCustomer(int customerId) throws Exception;
    ArrayList<Customer> getAllCustomer() throws Exception;
    Customer getOneCustomer(int customerId) throws Exception;
}
