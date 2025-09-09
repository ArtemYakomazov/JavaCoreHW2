package org.skypro.skyshop.product.discounted;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(String name, double basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getDiscount() {
        if (discount > 0 && discount < 100) {
            return discount;
        } else {
            throw new RuntimeException("Неверный процент");
        }
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
}