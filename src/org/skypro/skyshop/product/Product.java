package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    public String name;

    public Product(String name) {
        this.name = name;
        try {
            checkNameException(name);
        } catch (IllegalArgumentException exception) {
            System.err.println("Пустая строка названия");
        }
    }
    public static void checkNameException(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
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
