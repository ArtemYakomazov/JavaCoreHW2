package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.discounted.DiscountedProduct;
import org.skypro.skyshop.product.fixPrice.FixPriceProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product product1 = new SimpleProduct("Хлеб", 50);
        Product product2 = new DiscountedProduct("Молоко", 60, 10);
        Product product3 = new DiscountedProduct("Колбаса", 300, 15);
        Product product4 = new FixPriceProduct("Сыр");
        Product product5 = new FixPriceProduct("Майонез");

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);

        System.out.println("Корзина");
        productBasket.printProductBasket();

        System.out.println(("Есть ли хлеб в корзине? " + productBasket.hasProduct("хлеб")));
    }
}