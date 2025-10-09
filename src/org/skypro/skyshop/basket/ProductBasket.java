package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;


    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), new LinkedList<>());
        }
        products.get(product.getName()).add(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (List<Product> productList : products.values()) {

            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Total cost basket: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public void deleteProductByName(String name) {
        List<Product> deleteProducts = new ArrayList<>();
        for (List<Product> productList : products.values()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    deleteProducts.add(product);
                    iterator.remove();
                }
            }
        }
        if (deleteProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты: " + deleteProducts);
        }
    }
}
