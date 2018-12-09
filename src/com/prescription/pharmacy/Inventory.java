package com.prescription.pharmacy;

public class Inventory {
    private String item;
    private int available;
    private int cost;

    public Inventory(String item, int available, int cost) {
        this.item = item;
        this.available = available;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
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
}
