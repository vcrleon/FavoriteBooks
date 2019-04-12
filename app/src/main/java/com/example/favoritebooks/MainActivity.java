package com.example.favoritebooks;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.favoritebooks.ui_fragments.BookDetailsFragment;
import com.example.favoritebooks.ui_fragments.BookDisplayFragment;
import com.example.favoritebooks.ui_fragments.NewBookFragment;

public class MainActivity extends AppCompatActivity implements FragmentNavigator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayBooks();
    }

    @Override
    public void displayBooks() {
        final Fragment bookFragment = BookDisplayFragment.newInstance();
        inflateFragment(bookFragment);

    }

    @Override
    public void displayNewBookForm() {
        final Fragment newBookFragment = NewBookFragment.newInstance();
        inflateFragment(newBookFragment);

    }

    @Override
    public void displayBookDetails(String bookTitle, String bookAuthor, String bookGenre) {
        final Fragment bookDetailsFragment = BookDetailsFragment.newInstance(bookTitle, bookAuthor, bookGenre);
        inflateFragment(bookDetailsFragment);

    }

    private void inflateFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}