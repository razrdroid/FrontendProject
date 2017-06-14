package com.example.sharm.frontendproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sharm.frontendproject.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by sharm on 13-06-2017.
 */

public class LastFragment extends Fragment {
    StickyListHeadersListView recyclerView;
    LastAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_last, container, false);
        recyclerView = (StickyListHeadersListView) rootView.findViewById(R.id.rv);

//
        adapter = new LastAdapter(getContext());
        recyclerView.setAdapter(adapter);
        return rootView;

    }
    public class LastAdapter extends BaseAdapter implements StickyListHeadersAdapter {

        private String[] countries;
        private String[] names;
        private LayoutInflater inflater;

        public LastAdapter(Context context) {
            inflater = LayoutInflater.from(context);
            countries = context.getResources().getStringArray(R.array.countries);
            names=context.getResources().getStringArray(R.array.names);
        }

        @Override
        public int getCount() {
            return countries.length;
        }

        @Override
        public Object getItem(int position) {
            return countries[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LastHolder holder = new LastHolder();
            convertView = inflater.inflate(R.layout.card_last, parent, false);
            holder.tv_heading = (TextView) convertView.findViewById(R.id.tv_heading1);
            holder.tv_description = (TextView) convertView.findViewById(R.id.tv_description1);
            convertView.setTag(holder);
            holder.tv_description.setText("lore porem a  sdi asdasd sad asdasd f");
            String headerText = "" + countries[position];

            holder.tv_heading.setText(headerText);

            return convertView;
        }

        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            HeaderLastHolder holder = new HeaderLastHolder();
            convertView = inflater.inflate(R.layout.card_last_header, parent, false);
            holder.text1 = (TextView) convertView.findViewById(R.id.tv_head1);
            convertView.setTag(holder);

            String headerText = "" + names[position];
            holder.text1.setText(headerText);
            return convertView;
        }

        @Override
        public long getHeaderId(int position) {
            return names[position].subSequence(0, 1).charAt(0);
        }

        class HeaderLastHolder {
            TextView text1;
        }

        class LastHolder {
            TextView tv_heading;
            TextView tv_description;
        }

    }



}

