package com.example.favoritebooks.ui_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.favoritebooks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewBookFragment extends Fragment {


    public NewBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_book, container, false);
    }

}
