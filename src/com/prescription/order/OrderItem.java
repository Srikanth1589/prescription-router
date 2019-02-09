package com.prescription.order;

public class OrderItem {
    private Item item;
    private int count;

    public OrderItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item: "+ this.item + "; Count : "+ this.count;
    }
}
