package com.prescription.pharmacy;

public class Price {
    private String payer;
    private int cost;

    public Price(String payer, int cost) {
        this.payer = payer;
        this.cost = cost;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
