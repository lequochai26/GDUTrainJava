package vn.edu.giadinh.models;

import vn.edu.giadinh.enums.OrderStatus;

import java.time.LocalDateTime;

public class Order {
    // Fields:
    private String id;
    private LocalDateTime date;
    private OrderStatus status;

    // Constructors:
    public Order() {
    }

    public Order(String id, LocalDateTime date, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    // Getters / setters:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
