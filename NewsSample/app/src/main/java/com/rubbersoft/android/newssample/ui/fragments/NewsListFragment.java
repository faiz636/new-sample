package com.rubbersoft.android.newssample.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.BaseModel;
import com.rubbersoft.android.newssample.model.NewsModel;
import com.rubbersoft.android.newssample.ui.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {


    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
        createDataset();
        return rootView;
        
    }

    private void createDataset(){
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE1,new NewsModel("World powers 'agree Syria ceasfire'",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Japanese shares plunge over glocal woes",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("'Paternity leaves' MP quits over affair",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Clinton and Sanders clash over Obama",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Man missing 30 years remembers identity",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE1,new NewsModel("HK man's 'abduction breaches treaty'",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Oregon militia stand-off ends",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Mexico proson riot leaves 49 dead",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("NY officer convicted in stairwell death",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2, new NewsModel("South Sudan president reappoints rival", null, null, null, null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Brasil aims for Zika vaccine in a year",null,null,null,null)));
        mAdapter.addItem(new BaseModel(BaseModel.Type.TYPE2, new NewsModel("Opposition thrown out of Zuma speech", null, null, null, null)));
    }



}
