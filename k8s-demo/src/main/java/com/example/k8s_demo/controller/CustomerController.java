package com.example.k8s_demo.controller;

import com.example.k8s_demo.model.Customer;
import com.example.k8s_demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerDetails(@PathVariable Long customerId) {
        return customerService.getCustomerDetails(customerId);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomerDetails(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        return customerService.updateCustomerDetails(customerId, customer);
    }

    @PatchMapping("/{customerId}")
    public Customer patchCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        return customerService.patchCustomerDetails(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}

