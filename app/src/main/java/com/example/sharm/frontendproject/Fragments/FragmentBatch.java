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
 * Created by sharm on 12-06-2017.
 */

public class FragmentBatch extends Fragment {
    @Nullable
    StickyListHeadersListView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MyAdapter adapter;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_batches, container, false);
        recyclerView = (StickyListHeadersListView) rootView.findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(getContext());
        recyclerView.setAdapter(adapter);
        return rootView;

    }
    public class MyAdapter extends BaseAdapter implements StickyListHeadersAdapter {

        private String[] countries;
        private String[] names;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
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
            ViewHolder holder;

//            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.card_layout_batch, parent, false);
                holder.tv_heading = (TextView) convertView.findViewById(R.id.tv_heading);
                holder.tv_description = (TextView) convertView.findViewById(R.id.tv_description);
                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
            holder.tv_description.setText("lore porem a  sdi asdasd sad asdasd f");
            String headerText = "" + countries[position];

            holder.tv_heading.setText(headerText);

            return convertView;
        }

        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            HeaderViewHolder holder;
//            if (convertView == null) {
                holder = new HeaderViewHolder();
                convertView = inflater.inflate(R.layout.card_header, parent, false);
                holder.text = (TextView) convertView.findViewById(R.id.tv_head);
                convertView.setTag(holder);
//            } else {
//                holder = (HeaderViewHolder) convertView.getTag();
//            }
            //set header text as first char in name
            String headerText = "" + names[position];
            holder.text.setText(headerText);
            return convertView;
        }

        @Override
        public long getHeaderId(int position) {
            //return the first character of the country as ID because this is what headers are based upon
            return names[position].subSequence(0, 1).charAt(0);
        }

        class HeaderViewHolder {
            TextView text;
        }

        class ViewHolder {
            TextView tv_heading;
            TextView tv_description;
        }

    }
//public class MyHolder extends RecyclerView.ViewHolder{
//    TextView tv_description;
//    CircleImageView civ;
//    public MyHolder(View itemView) {
//        super(itemView);
//        tv_description= (TextView) itemView.findViewById(R.id.tv_description);
//        civ= (CircleImageView) itemView.findViewById(R.id.iv_circular);
//    }
//}
//public class MyAdapter extends RecyclerView.Adapter<MyHolder>{
//
//    @Override
//    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        MyHolder holder = new MyHolder(getLayoutInflater(null).inflate(R.layout.card_layout_batch, parent, false));
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyHolder holder, int position) {
//        holder.tv_description.setText("Hello world");
//    }
//
//    @Override
//    public int getItemCount() {
//        return 5;
//    }
//}

}
