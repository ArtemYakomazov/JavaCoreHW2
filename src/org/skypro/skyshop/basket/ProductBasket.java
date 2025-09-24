package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;
    private int size;

    public ProductBasket() {
        this.products = new LinkedList<>();
        this.size = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        size++;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        int specialProducts = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            } else if (size == 0) {
                System.out.println("в корзине пусто");
                return;
            }
        }
        for (Product product : products) {
            if (product.isSpecial()) {
                specialProducts++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialProducts);
    }

    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    public void deleteProductByName(String name) {
        List<Product> deleteProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                deleteProducts.add(product);
                iterator.remove();
            }
        }
        if (deleteProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты: " + deleteProducts);
        }
    }
}
