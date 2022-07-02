package com.example.simplespringregcustomer.db.customer;

import com.example.simplespringregcustomer.db.order.Order;
import com.example.simplespringregcustomer.exception.OrderNotFoundException;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
    private String name;
    @OneToMany(mappedBy="customer")
    private List<Order> orders;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Order> getOrders() { return orders; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name); }

    @Override
    public String toString() { return String.format("Customer{id=%d, name='%s', orders=%s}", id, name, orders); }
}
