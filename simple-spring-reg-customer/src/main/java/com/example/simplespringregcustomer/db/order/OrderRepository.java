package com.example.simplespringregcustomer.db.order;

import com.example.simplespringregcustomer.db.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
