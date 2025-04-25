package com.example.k8s_demo.service.impl;

import com.example.k8s_demo.model.Customer;
import com.example.k8s_demo.repo.CustomerRepo;
import com.example.k8s_demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerDetails(Long customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    @Override
    public Customer saveCustomerDetails(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomerDetails(Long customerId, Customer updatedCustomer) {
        return customerRepo.findById(customerId).map(existing -> {
            existing.setName(updatedCustomer.getName());
            existing.setEmail(updatedCustomer.getEmail());
            existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepo.save(existing);
        }).orElse(null);
    }

    @Override
    public Customer patchCustomerDetails(Long customerId, Customer partialUpdate) {
        return customerRepo.findById(customerId).map(existing -> {
            if (partialUpdate.getName() != null)
                existing.setName(partialUpdate.getName());
            if (partialUpdate.getEmail() != null)
                existing.setEmail(partialUpdate.getEmail());
            if (partialUpdate.getPhoneNumber() != null)
                existing.setPhoneNumber(partialUpdate.getPhoneNumber());
            return customerRepo.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepo.deleteById(customerId);
    }

}
