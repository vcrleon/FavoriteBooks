package com.example.favoritebooks.ui_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.favoritebooks.FragmentNavigator;
import com.example.favoritebooks.R;
import com.example.favoritebooks.database.BookDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditBookFragment extends Fragment {
    public static final String TITLE_KEY = "book_title";
    public static final String AUTHOR_KEY = "book_author";
    public static final String GENRE_KEY = "book_genre";

    private FragmentNavigator fragmentNavigator;
    private BookDatabaseHelper bookDatabaseHelper;

    private String bookTitle;
    private String bookAuthor;
    private String bookGenre;


    public EditBookFragment() {
        // Required empty public constructor
    }

    public static EditBookFragment newInstance(String bookTitle, String bookAuthor, String bookGenre) {
        Bundle bundle = new Bundle();
        EditBookFragment editBookFragment = new EditBookFragment();
        bundle.putString(TITLE_KEY, bookTitle);
        bundle.putString(AUTHOR_KEY, bookAuthor);
        bundle.putString(GENRE_KEY, bookGenre);
        editBookFragment.setArguments(bundle);
        return editBookFragment;
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
        return inflater.inflate(R.layout.fragment_edit_book, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookTitle = getArguments().getString(TITLE_KEY);
        bookAuthor= getArguments().getString(AUTHOR_KEY);
        bookGenre = getArguments().getString(GENRE_KEY);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText bookTitleEdit = view.findViewById(R.id.title_update_view);
        EditText bookAuthorEdit = view.findViewById(R.id.author_update_view);
        EditText bookGenreEdit = view.findViewById(R.id.genre_update_view);
        Button saveButton = view.findViewById(R.id.save_button);

        bookTitleEdit.setText(bookTitle);
        bookAuthorEdit.setText(bookAuthor);
        bookGenreEdit.setText(bookGenre);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You've Updated " + bookTitle, Toast.LENGTH_SHORT).show();
                fragmentNavigator.displayBooks();
            }
        });

    }

}
