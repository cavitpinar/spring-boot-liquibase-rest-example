package com.magnesiatech.liquibasEexample.service;

import com.magnesiatech.liquibasEexample.repository.CustomerRepository;
import com.magnesiatech.liquibasEexample.repository.entity.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public Customer createCustomer(Customer customer){
    return customerRepository.save(customer);
  }

  public Customer updateCustomer(Customer customer){
    return customerRepository.save(customer);
  }

  public Optional<Customer> findCustomerById(Long id){
    return customerRepository.findById(id);
  }




}
