package com.example.favoritebooks.ui_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.favoritebooks.FragmentNavigator;
import com.example.favoritebooks.R;
import com.example.favoritebooks.database.Book;
import com.example.favoritebooks.database.BookDatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewBookFragment extends Fragment {
    private FragmentNavigator fragmentNavigator;
    private EditText titleInput;
    private EditText authorInput;
    private EditText genreInput;
    private BookDatabaseHelper bookDatabaseHelper;

    public NewBookFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        final NewBookFragment newBookFragment = new NewBookFragment();
        return newBookFragment;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleInput = view.findViewById(R.id.title_edit_text);
        authorInput = view.findViewById(R.id.author_edit_text);
        genreInput = view.findViewById(R.id.genre_edit_text);
        final Button addBookButton = view.findViewById(R.id.add_new_book_button);

        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewBookDetails();
                fragmentNavigator.displayBooks();
            }
        });

    }

    public void addNewBookDetails() {
        String bookTitle = titleInput.getText().toString();
        String bookAuthor = authorInput.getText().toString();
        String bookGenre = genreInput.getText().toString();

        bookDatabaseHelper.addFellow(new Book(bookTitle, bookAuthor, bookGenre));

    }
}
