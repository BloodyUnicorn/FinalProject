package com.example.hp.finalproject.MainActivity.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.finalproject.R;


public class FragmentNotes extends Fragment {

    private Context contInst;
    private View view;
    private LinearLayoutManager mLayoutManager;


    private FragmentActivity myContext;


    public static FragmentNotes newInstance() {

        Bundle args = new Bundle();
        FragmentNotes fragment = new FragmentNotes();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notes, container, false);
        contInst = getActivity();
        //java code



        ///java code
        return view;
    }




}

