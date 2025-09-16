package org.skypro.skyshop.product.simple;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    public int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        try {
            checkPriceException(price);
        } catch (IllegalArgumentException e) {
            System.err.println("Недействительная цена");
        }
    }
    public static void checkPriceException(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + (int) getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String searchTerm() {
        return super.searchTerm();
    }

    @Override
    public String getTypeContent() {
        return super.getTypeContent();
    }
}