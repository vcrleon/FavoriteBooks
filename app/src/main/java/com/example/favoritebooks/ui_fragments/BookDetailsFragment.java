package com.example.favoritebooks.ui_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.favoritebooks.FragmentNavigator;
import com.example.favoritebooks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {
    public static final String TITLE_KEY = "book_title";
    public static final String AUTHOR_KEY = "book_author";
    public static final String GENRE_KEY = "book_genre";

    private FragmentNavigator fragmentNavigator;
    private String bookTitle;
    private String bookAuthor;
    private String bookGenre;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

   public static BookDetailsFragment newInstance(String bookTitle, String bookAuthor, String bookGenre) {
        Bundle bundle = new Bundle();
        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
        bundle.putString(TITLE_KEY, bookTitle);
        bundle.putString(AUTHOR_KEY, bookAuthor);
        bundle.putString(GENRE_KEY, bookGenre);
        bookDetailsFragment.setArguments(bundle);
        return bookDetailsFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentNavigator = (FragmentNavigator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookTitle = getArguments().getString(TITLE_KEY);
        bookAuthor= getArguments().getString(AUTHOR_KEY);
        bookGenre = getArguments().getString(GENRE_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView bookTitleView = view.findViewById(R.id.title_text_view);
        TextView bookAuthorView = view.findViewById(R.id.author_text_view);
        TextView bookGenreView = view.findViewById(R.id.genre_text_view);
        Button editButton = view.findViewById(R.id.edit_book);

        bookTitleView.setText(bookTitle);
        bookAuthorView.setText(bookAuthor);
        bookGenreView.setText(bookGenre);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
