package com.example.favoritebooks;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentNavigator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayBooks();
    }

    @Override
    public void displayBooks() {

    }

    @Override
    public void displayNewBookForm() {

    }

    @Override
    public void displayBookDetails() {

    }

    private void inflateFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
