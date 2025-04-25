package com.example.k8s_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demo-customers")
public class Customer {

    /**
     * Unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * Full name of the customer.
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Email address of the customer. Must be unique.
     */
    @Column(name = "email", unique = true, length = 255)
    private String email;

    /**
     * Phone number of the customer.
     */
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}