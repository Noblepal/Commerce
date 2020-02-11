package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.retailboosters.R;
import com.retailboosters.fragment.StoreListFragment;
import com.retailboosters.response.GetProductByStoreResponse;

import java.util.ArrayList;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    ArrayList<GetProductByStoreResponse.Datum> featureArrayList;
    private StoreListFragment mStoreListFragment;

    public CustomPagerAdapter(Context context, ArrayList<GetProductByStoreResponse.Datum> featureArrayList, StoreListFragment storeListFragment) {
        mContext = context;
        this.featureArrayList = featureArrayList;
        mStoreListFragment = storeListFragment;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, final int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.product_list_header_item, collection, false);

        TextView name = (TextView) layout.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) layout.findViewById(R.id.priceTextView);
        ImageView thumb = (ImageView) layout.findViewById(R.id.thumbImageView);


        collection.addView(layout);
        name.setText(featureArrayList.get(position).getProductName());

        priceTextView.setText("₦" + featureArrayList.get(position).getUnitprice());

        Log.e("Name", "" + featureArrayList.get(position).getProductName());

        Glide.with(mContext).load(featureArrayList.get(position).getProductImage()).into(thumb);


        /*layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoreListFragment.onClickProduct(featureArrayList.get(position).getId(), featureArrayList.get(position));
            }
        });*/

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return this.featureArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return this.featureArrayList.get(position).getProductName();
    }

}
