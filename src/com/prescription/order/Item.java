package com.prescription.order;

public class Item {
    private String item;
    private String drug;
    private boolean isGeneric;

    public Item(String item, String drug, boolean isGeneric) {
        this.item = item;
        this.drug = drug;
        this.isGeneric = isGeneric;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public void setGeneric(boolean generic) {
        isGeneric = generic;
    }

    @Override
    public String toString() {
        return "Item Name: "+ this.item + "; Drug : "+ this.drug + "; isGeneric : "+ this.isGeneric;
    }
}
