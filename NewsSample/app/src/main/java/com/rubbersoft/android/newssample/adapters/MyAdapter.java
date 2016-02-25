package com.rubbersoft.android.newssample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rubbersoft.android.newssample.R;
import com.rubbersoft.android.newssample.model.BaseModel;
import com.rubbersoft.android.newssample.model.NewsModel;

import java.util.List;

/**
 * Created by Faiz on 11/02/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final List<BaseModel> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<BaseModel> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        int type;
        switch (viewType){
            case BaseModel.Type.TYPE1:
                type = R.layout.news_item_big;
                break;
            case BaseModel.Type.TYPE2:
            default:
                type = R.layout.news_item_small;
        }
        View v = LayoutInflater.from(parent.getContext())
                .inflate(type, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        BaseModel baseModel = getItem(position);
        switch (baseModel.getType()) {
            case BaseModel.Type.TYPE1:
            case BaseModel.Type.TYPE2:
                NewsModel newsModel = (NewsModel) baseModel.getNewsModel();
                holder.mTitle.setText(newsModel.getTitle());
                break;
        }

    }

    private BaseModel getItem(int position){
        return mDataset.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle;

        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.title);
        }
    }
}