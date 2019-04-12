package com.example.favoritebooks;

public interface FragmentNavigator {
    void displayBooks();
    void displayNewBookForm();
    void displayBookDetails(String bookTitle, String bookAuthor, String bookGenre);
}
