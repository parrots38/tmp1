package com.example.simplespringregcustomer.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find order by id " + id);
    }
}
