package com.rubbersoft.android.newssample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rubbersoft.android.newssample.adapters.MyAdapter;
import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.BaseModel;
import com.rubbersoft.android.newssample.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    List<BaseModel> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDataset();

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void createDataset(){
        mDataset = new ArrayList<>();

        mDataset.add(new BaseModel(BaseModel.Type.TYPE1,new NewsModel("World powers 'agree Syria ceasfire'",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Japanese shares plunge over glocal woes",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("'Paternity leaves' MP quits over affair",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Clinton and Sanders clash over Obama",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Man missing 30 years remembers identity",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE1,new NewsModel("HK man's 'abduction breaches treaty'",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Oregon militia stand-off ends",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Mexico proson riot leaves 49 dead",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("NY officer convicted in stairwell death",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("South Sudan president reappoints rival",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Brasil aims for Zika vaccine in a year",null,null,null,null)));
        mDataset.add(new BaseModel(BaseModel.Type.TYPE2,new NewsModel("Opposition thrown out of Zuma speech",null,null,null,null)));
    }


}
