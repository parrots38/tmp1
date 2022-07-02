package com.example.simplespringregcustomer.db.order;

import com.example.simplespringregcustomer.db.customer.Customer;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Order {

    private @Id @GeneratedValue Long id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private String orderValue;
    private String comment;
    private Instant createdAt;

    public Order() {}

    public Order(Customer customer, String orderValue, String comment) {
        this.customer = customer;
        this.orderValue = orderValue;
        this.comment = comment;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public String getOrderValue() { return orderValue; }
    public String getComment() { return comment; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setOrderValue(String orderValue) { this.orderValue = orderValue; }
    public void setComment(String comment ) { this.comment = comment; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order))
            return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(customer, order.customer) &&
                Objects.equals(orderValue, order.orderValue) && Objects.equals(comment, order.comment) &&
                Objects.equals(createdAt, order.createdAt);
    }

    @Override
    public int hashCode() { return Objects.hash(id, customer, orderValue, comment, createdAt); }

    @Override
    public String toString() {
        return String.format("Order{id=%d, customer=%s, value='%s', comment='%s', createdAt='%s'}",
            id, customer, orderValue, comment, createdAt);
    }
}
