package com.codegym.demo.service.customer;

import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.CustomerRepository;
import com.codegym.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }


    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

}
