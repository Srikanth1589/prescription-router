package com.prescription.pharmacy;

import com.prescription.order.Item;

import java.util.List;

public class Inventory {
    private Item item;
    private int available;
    private int cost;
    private List<Price> otherPrices;

    public Inventory(Item item, int available, int cost, List<Price> otherPrices) {
        this.item = item;
        this.available = available;
        this.cost = cost;
        this.otherPrices = otherPrices;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Price> getOtherPrices() {
        return otherPrices;
    }

    public void setOtherPrices(List<Price> otherPrices) {
        this.otherPrices = otherPrices;
    }
}
