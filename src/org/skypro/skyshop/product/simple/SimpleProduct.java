package org.skypro.skyshop.product.simple;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    public int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + (int)getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}