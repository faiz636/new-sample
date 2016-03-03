package com.rubbersoft.android.newssample.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.NewsModel;
import com.rubbersoft.android.newssample.services.listeners.ServiceError;
import com.rubbersoft.android.newssample.services.listeners.ServiceListener;
import com.rubbersoft.android.newssample.services.volley.HttpRequest;
import com.rubbersoft.android.newssample.ui.activities.MainActivity;
import com.rubbersoft.android.newssample.ui.adapters.MyAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {


    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private MainActivity mainActivity;

    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
        ServiceListener serviceListener2 = new ServiceListener<ArrayList<NewsModel>>() {
            @Override
            public void success(ArrayList<NewsModel> obj) {
                Toast.makeText(getContext(), "response", Toast.LENGTH_SHORT);
                if (obj != null)
                    mAdapter.addAll(obj);
            }

            @Override
            public void error(ServiceError serviceError) {

            }
        };
        HttpRequest.getNews(serviceListener2);
//        createDataset();

        mAdapter.setOnItemClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void onClick(NewsModel newsModel) {
                mainActivity.showDetailFragment(newsModel);
            }
        });

        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    private void createDataset() {
/*
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
*/
    }

    public static interface FragmentInteractionListener{
        public void showDetailFragment(NewsModel newsModel);
    }
}
