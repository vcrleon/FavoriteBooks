package com.example.favoritebooks.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.favoritebooks.R;
import com.example.favoritebooks.database.Book;

import java.util.List;

public class BookDisplayAdapter extends RecyclerView.Adapter<BookDisplayViewHolder> {
    private List<Book> bookList;

    public BookDisplayAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookDisplayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.book_item_view, viewGroup, false);
        return new BookDisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookDisplayViewHolder bookDisplayViewHolder, int i) {
        bookDisplayViewHolder.onBind(bookList.get(i));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
