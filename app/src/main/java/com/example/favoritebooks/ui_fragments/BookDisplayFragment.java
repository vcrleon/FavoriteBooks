package com.example.favoritebooks.ui_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.favoritebooks.FragmentNavigator;
import com.example.favoritebooks.R;
import com.example.favoritebooks.database.BookDatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDisplayFragment extends Fragment {
    private FragmentNavigator fragmentNavigator;
    private BookDatabaseHelper bookDatabaseHelper;


    public BookDisplayFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new BookDisplayFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentNavigator = (FragmentNavigator) context;
        bookDatabaseHelper = new BookDatabaseHelper(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button addBookButton = view.findViewById(R.id.add_book_button);
        final RecyclerView bookRecyclerView = view.findViewById(R.id.book_recycler_view);

        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentNavigator.displayNewBookForm();
            }
        });


    }


}
