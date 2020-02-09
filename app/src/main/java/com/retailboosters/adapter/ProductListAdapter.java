package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.retailboosters.R;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetStoreResponse;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<GetProductByStoreResponse.Datum> {

    private Context mContext;
    private ArrayList<GetProductByStoreResponse.Datum> moviesList = new ArrayList<>();

    public ProductListAdapter(Context context, ArrayList<GetProductByStoreResponse.Datum> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }
    private static class ViewHolder {
        TextView name,desc,price;
        ImageView image;

    }

    @Override
    public GetProductByStoreResponse.Datum getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        GetProductByStoreResponse.Datum currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_list_item, parent,
                    false);

            viewHolder.image = (ImageView)convertView.findViewById(R.id.thumbImageView);

            viewHolder.name = (TextView) convertView.findViewById(R.id.nameTextView);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.descTextView);
            viewHolder.price = (TextView) convertView.findViewById(R.id.priceTextView);

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(currentStore.getProductName());
        viewHolder.desc.setText(currentStore.getDescription());
        viewHolder.price.setText("₦"+currentStore.getUnitprice());

        Glide.with(mContext).load(currentStore.getProductImage()).into(viewHolder.image);

        return convertView;
    }


}
