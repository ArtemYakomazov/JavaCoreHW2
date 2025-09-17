package org.skypro.skyshop.product.discounted;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(String name, double basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Недействительная цена");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Недействительный процент");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discount / 100d);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + getDiscount() + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
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