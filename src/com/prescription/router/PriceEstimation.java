package com.prescription.router;

public class PriceEstimation {
    private Assignment assignment;
    private int cost;

    public PriceEstimation(Assignment assignment, int cost) {
        this.assignment = assignment;
        this.cost = cost;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.assignment + "; Cost : $"+ this.cost;
    }
}