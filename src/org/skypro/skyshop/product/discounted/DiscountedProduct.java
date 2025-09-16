package org.skypro.skyshop.product.discounted;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(String name, double basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
        try {
            checkBasePriceException(basePrice);
            checkDiscountException(discount);
        } catch (NullPointerException e) {
            System.err.println("Недействительная цена");
        } catch (IllegalArgumentException e) {
            System.err.println("Недействительный процент");
        }
    }

    public static void checkBasePriceException(double basePrice) {
        if (basePrice <= 0) {
            throw new NullPointerException("Недействительная цена");
        }
    }

    public static void checkDiscountException(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Недействительный процент");
        }
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