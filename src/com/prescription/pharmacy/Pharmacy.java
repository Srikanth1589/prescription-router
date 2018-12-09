package com.prescription.pharmacy;

import com.prescription.order.Order;
import com.prescription.order.OrderItem;

import java.util.List;

public class Pharmacy {
    private List<Inventory> stock;
    private String pharmacyName;

    public Pharmacy(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Inventory getSpecificItem(String item) {
        return stock.stream().filter(inventory -> inventory.getItem().equals(item)).findAny().get();
    }

    public boolean containsEnoughItems(OrderItem orderItem) {
        return stock.stream().anyMatch(inventory -> inventory.getItem().equals(orderItem.getItem()) &&
                inventory.getAvailable() >= orderItem.getCount());
    }

    public int estimateShipping(Order o) {
        return o.getItems().stream().mapToInt(this::estimateShippingForOrderItem).sum();
    }

    public int estimateShippingForOrderItem(OrderItem orderItem) {
        return orderItem.getCount()*getSpecificItem(orderItem.getItem()).getCost();
    }

    public List<Inventory> getStock() {
        return stock;
    }

    public void setStock(List<Inventory> stock) {
        this.stock = stock;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
