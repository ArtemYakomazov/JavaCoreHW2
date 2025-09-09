package org.skypro.skyshop.article;

public final class Article implements Searchable {
    String title;
    String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название статьи: " + title + "; Текст статьи: " + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }


}
