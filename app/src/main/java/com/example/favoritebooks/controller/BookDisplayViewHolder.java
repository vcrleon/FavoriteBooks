package com.example.favoritebooks.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.favoritebooks.FragmentNavigator;
import com.example.favoritebooks.R;
import com.example.favoritebooks.database.Book;

public class BookDisplayViewHolder extends RecyclerView.ViewHolder {
    private FragmentNavigator fragmentNavigator;
    private CardView bookCardView;
    private TextView bookTitle;


    public BookDisplayViewHolder(@NonNull View itemView) {
        super(itemView);
        fragmentNavigator = (FragmentNavigator) itemView.getContext();
        bookCardView = itemView.findViewById(R.id.book_card_view);
        bookTitle = itemView.findViewById(R.id.book_title_view);
    }

    public void onBind(final Book book) {
        bookTitle.setText(book.getTitle());

        bookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentNavigator.displayBookDetails(book.getTitle(), book.getAuthor(), book.getGenre());
            }
        });
    }
}
