package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.R;
import com.retailboosters.fragment.StoreListFragment;
import com.retailboosters.response.GetStoreResponse;

import java.util.ArrayList;

public class StoreListRecyclerViewAdapter extends RecyclerView.Adapter<StoreListRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<GetStoreResponse.Datum> featureArrayList;
    private StoreListFragment mStoreListFragment;
    private RequestOptions ro = new RequestOptions();

    public StoreListRecyclerViewAdapter(Context mContext, ArrayList<GetStoreResponse.Datum> featureArrayList, StoreListFragment mStoreListFragment) {
        this.mContext = mContext;
        this.featureArrayList = featureArrayList;
        this.mStoreListFragment = mStoreListFragment;

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.product_list_header_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        GetStoreResponse.Datum currentStore = featureArrayList.get(position);
        myViewHolder.name.setText(currentStore.getStoreName());
        /*viewHolder.phone.setText(currentStore.getPhoneNo());
        viewHolder.web.setText(currentStore.getUrl());*/

        Glide.with(mContext).applyDefaultRequestOptions(ro)
                .load(currentStore.getStoreImage())
                .into(myViewHolder.thumb);
    }

    @Override
    public int getItemCount() {
        return featureArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView priceTextView;
        ImageView thumb;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            thumb = itemView.findViewById(R.id.thumbImageView);
            layout = itemView.findViewById(R.id.rootLayout);

        }
    }
}
