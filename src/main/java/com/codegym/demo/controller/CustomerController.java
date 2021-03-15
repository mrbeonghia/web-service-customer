package com.codegym.demo.controller;

import com.codegym.demo.Exception.NotFoundException;
import com.codegym.demo.model.Customer;

import com.codegym.demo.service.customer.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> getAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findOne(@PathVariable Long id){
        Customer customer;
        try {
            customer = customerService.findById(id);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
