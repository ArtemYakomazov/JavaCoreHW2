package org.skypro.skyshop.article;

import java.util.Objects;

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
        return "";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
