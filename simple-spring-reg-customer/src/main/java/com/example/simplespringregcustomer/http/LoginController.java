package com.example.simplespringregcustomer.http;

import com.example.simplespringregcustomer.db.customer.Customer;
import com.example.simplespringregcustomer.db.customer.CustomerRepository;
import com.example.simplespringregcustomer.db.order.Order;
import com.example.simplespringregcustomer.db.order.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    private final CustomerRepository customerRepository;

    LoginController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customer/new")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }
}
