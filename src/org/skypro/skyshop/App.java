package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.BestResultsNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.discounted.DiscountedProduct;
import org.skypro.skyshop.product.fixPrice.FixPriceProduct;
import org.skypro.skyshop.product.simple.SimpleProduct;
import org.skypro.skyshop.article.SearchEngine;

public class App {
    public static void main(String[] args) throws BestResultsNotFound {
        ProductBasket productBasket = getProductBasket();


        SearchEngine engine = getSearchEngine();
        System.out.println(engine.search("Хлеб"));
        System.out.println(engine.search("Сыр"));
        System.out.println(engine.search("Шампиньоны"));

        engine.findBestMatch("Хлеб");
        engine.findBestMatch("сыр");

        productBasket.deleteProductByName("Хлеб");
        productBasket.printProductBasket();
        productBasket.deleteProductByName("Мыло");
        productBasket.printProductBasket();
        System.out.println();
        System.out.println(engine);
    }

    private static SearchEngine getSearchEngine() {
        Article article1 = new Article("Сыр", "Благородные сыры");
        Article article2 = new Article("Хлеб", "Производство хлеба");
        Article article3 = new Article("Колбаски", "Колбасные нарезки");
        Article article4 = new Article("Шампиньоны", "Выращивание шампиньонов");


        SearchEngine engine = new SearchEngine();
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article1);
        engine.add(article2);
        return engine;
    }

    private static ProductBasket getProductBasket() {
        ProductBasket productBasket = new ProductBasket();
        try {
            Product product1 = new SimpleProduct("Хлеб", 30);
            productBasket.addProduct(product1);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Product product2 = new DiscountedProduct("Молоко", 60, 12);
            productBasket.addProduct(product2);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Product product3 = new DiscountedProduct("Колбаса", 12, 15);
            productBasket.addProduct(product3);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        Product product4 = new FixPriceProduct("Сыр");
        productBasket.addProduct(product4);
        Product product5 = new FixPriceProduct("Шампиньоны");
        productBasket.addProduct(product5);
        return productBasket;
    }
}