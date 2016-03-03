package com.rubbersoft.android.newssample.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.NewsModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailFragment extends Fragment {

    public static final String DATA = "data";

    public NewsDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView titleTV = (TextView) view.findViewById(R.id.title);
        TextView sDescTV = (TextView) view.findViewById(R.id.s_desc);
        TextView  lDescTV = (TextView) view.findViewById(R.id.l_desc);

        Bundle bundle = getArguments();

        NewsModel newsModel = bundle.getParcelable(DATA);

        if (newsModel != null) {
            // Inflate the layout for this fragment
            titleTV.setText(newsModel.getTitle());
            sDescTV.setText(newsModel.getS_desc());
            lDescTV.setText(newsModel.getL_desc());
        }
        return view;
    }


}
