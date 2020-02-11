package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
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
import com.retailboosters.response.GetProductByStoreResponse;

import java.util.ArrayList;

public class ProductListRecyclerViewAdapter extends RecyclerView.Adapter<ProductListRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<GetProductByStoreResponse.Datum> featureArrayList;
    private StoreListFragment mStoreListFragment;
    private RequestOptions ro = new RequestOptions();

    public ProductListRecyclerViewAdapter(Context mContext, ArrayList<GetProductByStoreResponse.Datum> featureArrayList, StoreListFragment mStoreListFragment) {
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
        final GetProductByStoreResponse.Datum currentProduct = featureArrayList.get(position);
        myViewHolder.name.setText(currentProduct.getProductName());
        myViewHolder.price.setText(String.valueOf(currentProduct.getUnitprice()));

        myViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoreListFragment.onClickProduct(currentProduct);
            }
        });

        Glide.with(mContext).applyDefaultRequestOptions(ro)
                .load(currentProduct.getProductImage())
                .into(myViewHolder.thumb);
    }

    @Override
    public int getItemCount() {
        return featureArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView thumb;
        MaterialCardView layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.headerNameTextView);
            price = itemView.findViewById(R.id.headerPriceTextView);
            thumb = itemView.findViewById(R.id.headerThumbImageView);
            layout = itemView.findViewById(R.id.rootLayout1);

        }
    }
}
