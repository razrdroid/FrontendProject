package com.example.sharm.frontendproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sharm.frontendproject.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by sharm on 14-06-2017.
 */

public class FragmentHistory extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_history, container, false);
        return rootView;
    }
}
