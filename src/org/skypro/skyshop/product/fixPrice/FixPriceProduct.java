package org.skypro.skyshop.product.fixPrice;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 150;

    public FixPriceProduct(String name) {
        super(name);
    }

    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE;
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