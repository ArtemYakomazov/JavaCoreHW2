package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    public String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Строка названия пустая или состоит из пробелов");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }
}
