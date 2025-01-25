package com.smga.smga.pedidos;

import jakarta.persistence.*;

@Entity
@Table(name = "orders") // Cambia el nombre de la tabla a "orders"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private int quantity;
    private double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Constructor vacío
    public Order() {
    }

    // Constructor con todos los campos
    public Order(Long id, String product, int quantity, double price, OrderStatus status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}




