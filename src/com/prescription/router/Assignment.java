package com.prescription.router;

import com.prescription.order.OrderItem;
import com.prescription.pharmacy.Pharmacy;

public class Assignment {
    private OrderItem item;
    private Pharmacy site;

    public Assignment(OrderItem item, Pharmacy site) {
        this.item = item;
        this.site = site;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }

    public Pharmacy getSite() {
        return site;
    }

    public void setSite(Pharmacy site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return this.item + "; Pharmacy : "+ this.site.getPharmacyName();
    }
}
