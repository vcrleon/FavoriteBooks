package com.example.favoritebooks.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.favoritebooks.R;
import com.example.favoritebooks.database.Book;

public class BookDisplayViewHolder extends RecyclerView.ViewHolder {
    private CardView bookCardView;
    private TextView bookTitle;

    public BookDisplayViewHolder(@NonNull View itemView) {
        super(itemView);
        bookCardView = itemView.findViewById(R.id.book_card_view);
        bookTitle = itemView.findViewById(R.id.book_title_view);
    }

    public void onBind(final Book book) {
        bookTitle.setText(book.getTitle());

        bookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("bookTitle: ", book.getTitle());
                Log.e("bookAuthor: ", book.getAuthor());
                Log.e("bookGenre: ", book.getGenre());
            }
        });
    }
}