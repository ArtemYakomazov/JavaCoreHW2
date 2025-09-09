package org.skypro.skyshop.article;

public interface Searchable {
    String searchTerm();
    String getTypeContent();
    String getName();


    default String getStringRepresentation() {
        return getName() + getTypeContent();
    }

}
