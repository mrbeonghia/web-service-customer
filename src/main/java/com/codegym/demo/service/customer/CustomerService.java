package com.codegym.demo.service.customer;

import com.codegym.demo.model.Customer;


public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void remove(Long id);

    void save(Customer customer);

}
