package com.coupon.project.controllers;

import com.coupon.project.Application;
import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import com.coupon.project.errors.exceptions.DuplicateCompanyNameOrEmailException;
import com.coupon.project.errors.exceptions.DuplicateCustomerEmailException;
import com.coupon.project.errors.exceptions.UpdateCompanyNameException;
import com.coupon.project.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/company")
    public Company addCompany(@RequestBody Company company)
            throws DuplicateCompanyNameOrEmailException {
        return adminService.addCompany(company);
    }

    @PutMapping(path = "/company")
    public Company updateCompany(@RequestBody Company company)
            throws UpdateCompanyNameException {
        return adminService.updateCompany(company);
    }

    @DeleteMapping(path = "/company/{id}")
    public boolean deleteCompany(@PathVariable int id) {
        return adminService.deleteCompany(id);
    }

    @GetMapping(path = "/company/{id}")
    public Company getCompany(@PathVariable int id) {
        return adminService.getOneCompany(id);
    }

    @GetMapping(path = "/company")
    public ArrayList<Company> getAllCompanies() {
        // This returns a JSON or XML with the users
        return adminService.getAllCompanies();
    }

    @PostMapping(path = "/customer")
    public Customer addCustomer(@RequestBody Customer customer) throws DuplicateCustomerEmailException{
        return adminService.addCustomer(customer);
    }

    @PutMapping(path = "/customer")
    public Customer updateCustomer(@RequestBody Customer customer) throws DuplicateCustomerEmailException {
        return adminService.updateCustomer(customer);
    }

    @DeleteMapping(path = "/customer/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return adminService.deleteCustomer(id);
    }

    @GetMapping(path = "/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        // This returns a JSON or XML with the users
        return adminService.getOneCustomer(id);
    }

    @GetMapping(path = "/customer")
    public ArrayList<Customer> getAllCustomers() {
        // This returns a JSON or XML with the users
        return adminService.getAllCustomers();
    }
}
