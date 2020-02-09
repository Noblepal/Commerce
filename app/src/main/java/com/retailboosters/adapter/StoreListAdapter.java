package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.R;
import com.retailboosters.fragment.StoreListFragment;
import com.retailboosters.response.GetStoreResponse;

import java.util.ArrayList;
import java.util.List;

public class StoreListAdapter extends ArrayAdapter<GetStoreResponse.Datum> {

    private Context mContext;
    private ArrayList<GetStoreResponse.Datum> moviesList = new ArrayList<>();
    private StoreListFragment mStoreListFragment;
    RequestOptions ro = new RequestOptions();

    public StoreListAdapter(Context context, ArrayList<GetStoreResponse.Datum> list, StoreListFragment storeListFragment) {
        super(context, 0, list);
        mContext = context;
        moviesList = list;
        mStoreListFragment = storeListFragment;

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }

    private static class ViewHolder {
        TextView name, web, phone;
        ImageView image;
        LinearLayout rootLayout;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        GetStoreResponse.Datum currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.store_list_item, parent,
                    false);

            viewHolder.image = (ImageView) convertView.findViewById(R.id.thumbImageView);

            viewHolder.name = (TextView) convertView.findViewById(R.id.nameTextView);
            /*viewHolder.phone = (TextView) convertView.findViewById(R.id.phoneTextView);
            viewHolder.web = (TextView) convertView.findViewById(R.id.webTextView);*/

            viewHolder.rootLayout = (LinearLayout) convertView.findViewById(R.id.storeLayout);

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(currentStore.getStoreName());
        /*viewHolder.phone.setText(currentStore.getPhoneNo());
        viewHolder.web.setText(currentStore.getUrl());*/

        Glide.with(mContext).applyDefaultRequestOptions(ro)
                .load(currentStore.getStoreImage())
                .into(viewHolder.image);


        viewHolder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoreListFragment.onListClick(position);
            }
        });
        return convertView;
    }


    @Override
    public GetStoreResponse.Datum getItem(int position) {
        return super.getItem(position);
    }
}
