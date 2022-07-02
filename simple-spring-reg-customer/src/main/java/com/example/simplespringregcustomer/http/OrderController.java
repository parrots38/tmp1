package com.example.simplespringregcustomer.http;

import com.example.simplespringregcustomer.db.customer.Customer;
import com.example.simplespringregcustomer.db.customer.CustomerRepository;
import com.example.simplespringregcustomer.db.order.Order;
import com.example.simplespringregcustomer.db.order.OrderRepository;
import com.example.simplespringregcustomer.exception.CustomerNotFoundException;
import com.example.simplespringregcustomer.exception.OrderNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    OrderController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/customer/{id}/orders")
    List<Order> allOrders(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customer.getOrders();
    }

    @PostMapping("/customer/{id}/new-order")
    Order setNewOrder(@PathVariable Long id, @RequestBody Order order) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    @DeleteMapping("/customer/{id}/delete-order")
    Order deleteOrder(@PathVariable(name="id") Long customerId, @RequestBody Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        if (!order.getId().equals(customerId))
            throw new OrderNotFoundException(id);
        orderRepository.deleteById(id);
        return order;
    }
}
