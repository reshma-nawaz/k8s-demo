package com.example.k8s_demo.service;

import com.example.k8s_demo.model.Customer;
import com.example.k8s_demo.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer saveCustomerDetails(Customer customer);
    Customer getCustomerDetails(Long customerId);
    Customer updateCustomerDetails(Long customerId, Customer customer);
    Customer patchCustomerDetails(Long customerId, Customer customer);
    void deleteCustomer(Long customerId);
    List<Customer> getAllCustomers();
}

