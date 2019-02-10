package com.prescription.pharmacy;

import com.prescription.order.Item;
import com.prescription.order.Order;
import com.prescription.order.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pharmacy {
    private List<Inventory> stock;
    private List<String> allowedJurisdictions;
    private String pharmacyName;

    public Pharmacy(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    private List<Inventory> getSpecificItem(Item item) {
        return stock.stream().filter(inventory -> inventory.getItem().equals(item) ||
                (inventory.getItem().getDrug().equals(item.getDrug()) && item.isGeneric())).collect(Collectors.toList());
    }

    public boolean containsEnoughItems(OrderItem orderItem) {
        return stock.stream().anyMatch(inventory -> (inventory.getItem().equals(orderItem.getItem()) ||
                (inventory.getItem().getDrug().equals(orderItem.getItem().getDrug()) && inventory.getItem().isGeneric())) &&
                inventory.getAvailable() >= orderItem.getCount());
    }

    public boolean isInAllowedJurisdiction(String jurisdiction) {
        return allowedJurisdictions.contains(jurisdiction);
    }

    /*
        Assumption: The cost of the item will be cheaper if the inventory of that item has the payer's insurance
     */
    public int estimateShippingForOrderItem(OrderItem orderItem, Order order) {
        List<Inventory> requiredItems = getSpecificItem(orderItem.getItem());
        int lowCostItem = Integer.MAX_VALUE;
        for (Inventory inventory : requiredItems) {
            Optional<Price> insurancePrice = inventory.getOtherPrices().stream()
                    .filter(price -> order.getPayer() != null && price.getPayer().equals(order.getPayer())).findFirst();
            int temp = orderItem.getCount() * (insurancePrice.map(Price::getCost).orElseGet(inventory::getCost));
            lowCostItem = temp < lowCostItem ? temp : lowCostItem;
        }
        return lowCostItem;
    }

    public List<Inventory> getStock() {
        return stock;
    }

    public void setStock(List<Inventory> stock) {
        this.stock = stock;
    }

    public List<String> getAllowedJurisdictions() {
        return allowedJurisdictions;
    }

    public void setAllowedJurisdictions(List<String> allowedJurisdictions) {
        this.allowedJurisdictions = allowedJurisdictions;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
