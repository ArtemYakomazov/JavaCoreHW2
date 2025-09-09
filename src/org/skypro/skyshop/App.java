package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.discounted.DiscountedProduct;
import org.skypro.skyshop.product.fixPrice.FixPriceProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;
import org.skypro.skyshop.article.SearchEngine;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = getProductBasket();

        System.out.println("Корзина");
        productBasket.printProductBasket();

        System.out.println(("Есть ли хлеб в корзине? " + productBasket.hasProduct("хлеб")));

        Article article1 = new Article("Хлебный колос", "Производство хлеба");
        Article article2 = new Article("Молочная продукция", "Добыча молока");
        Article article3 = new Article("Виды колбас", "Колбасные нарезки");
        Article article4 = new Article("Сыры мира", "Благородные сыры");
        Article article5 = new Article("Майонез в домашних условиях", "Рецепт майонеза");

        System.out.println(article1);
        System.out.println(article2);
        System.out.println(article3);
        System.out.println(article4);
        System.out.println(article5);

        SearchEngine engine = new SearchEngine(5);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article5);
        System.out.println(Arrays.toString(engine.search("Хлеб")));
        System.out.println(Arrays.toString(engine.search("Сыр")));
        System.out.println(Arrays.toString(engine.search("Майонез")));
    }

    private static ProductBasket getProductBasket() {
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
        return productBasket;
    }
}