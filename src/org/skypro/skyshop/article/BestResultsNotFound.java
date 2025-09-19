package org.skypro.skyshop.article;

public class BestResultsNotFound extends Exception {

    public BestResultsNotFound(String query) {
        super("Подходящий результат не найден для " + query);
    }
}
