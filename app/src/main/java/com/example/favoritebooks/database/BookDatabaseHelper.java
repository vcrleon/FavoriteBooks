package com.example.favoritebooks.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BookDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "books.db";
    private static final String TABLE_NAME = "books";
    private static final int SCHEMA_VERSION = 1;

    public BookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "book_title TEXT, book_author TEXT, book_genre TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addBook(Book book) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE book_title = '" + book.getTitle() +
                        "' AND book_author = '" + book.getAuthor() + "' AND book_genre = '" + book.getGenre() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(book_title, book_author, book_genre) VALUES('" +
                    book.getTitle() + "', '" +
                    book.getAuthor() + "', '" +
                    book.getGenre() + "');");
        }
        cursor.close();
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Book book = new Book(
                            cursor.getString(cursor.getColumnIndex("book_title")),
                            cursor.getString(cursor.getColumnIndex("book_author")),
                            cursor.getString(cursor.getColumnIndex("book_genre")));

                    bookList.add(book);
                } while (cursor.moveToNext());
            }
        }
        return bookList;
    }

}
