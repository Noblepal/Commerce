package com.retailboosters.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.R;
import com.retailboosters.response.GetOrderHistoryResponse;
import com.retailboosters.response.GetRepaymentHistory;
import com.retailboosters.response.GetUserOrdersResponse;
import com.retailboosters.utils.Utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TransactionHistoryAdapter extends ArrayAdapter<GetRepaymentHistory.Datum> {

    private Context mContext;
    private ArrayList<GetRepaymentHistory.Datum> moviesList = new ArrayList<>();
    RequestOptions ro = new RequestOptions();

    public TransactionHistoryAdapter(Context context, ArrayList<GetRepaymentHistory.Datum> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }
    private static class ViewHolder {
        TextView pNameTextView,qtyTextView,statusTextView,cBalanceTextView,tBalanceTextView;
        LinearLayout addLayout;

    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        GetRepaymentHistory.Datum currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tran_history_list_item, parent,
                    false);


            viewHolder.pNameTextView = (TextView) convertView.findViewById(R.id.pNameTextView);
           viewHolder.qtyTextView = (TextView) convertView.findViewById(R.id.qtyTextView);
            viewHolder.statusTextView = (TextView) convertView.findViewById(R.id.statusTextView);
            viewHolder.cBalanceTextView = (TextView) convertView.findViewById(R.id.cBalanceTextView);
            viewHolder.tBalanceTextView = (TextView) convertView.findViewById(R.id.tBalanceTextView);

            viewHolder.addLayout = (LinearLayout)convertView.findViewById(R.id.addLayout);
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        try {
          //  viewHolder.monthTextView.setText(getMonth(currentStore.getDueDate()));

        }catch (Exception e){
            e.printStackTrace();
        }
        viewHolder.pNameTextView.setText(currentStore.getProductDetails().getProductName());
        viewHolder.qtyTextView.setText(""+currentStore.getQuantity());
        viewHolder.statusTextView.setText(""+currentStore.getApplicationStatus());
        viewHolder.cBalanceTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(currentStore.getCreditedBalance()));
        viewHolder.tBalanceTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(currentStore.getTotalAmount()));



        viewHolder.addLayout.removeAllViews();
        for (int i=0;i<currentStore.getTransactionHistory().size();i++){
            addViews(viewHolder.addLayout,currentStore.getTransactionHistory().get(i));
        }

        return convertView;
    }


    private void addViews(LinearLayout addLayout,GetRepaymentHistory.Datum.TransactionHistory datum){


        View child = ((Activity)mContext).getLayoutInflater().inflate(R.layout.transac_list_item, null);
        final TextView dateTextView = (TextView)child.findViewById(R.id.tDateTextView);
        final TextView amtTextView = (TextView)child.findViewById(R.id.amtTextView);
        final TextView statusTextView = (TextView)child.findViewById(R.id.statusTextView);
        final TextView rrrTextView = (TextView)child.findViewById(R.id.rrrTextView);
        final TextView referTextView = (TextView)child.findViewById(R.id.referTextView);


        try {
            dateTextView.setText(getMonth(datum.getLastStatusUpdateTime()));

        }catch (Exception e){
            e.printStackTrace();
        }

        amtTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(Float.parseFloat(datum.getAmount())));
        statusTextView.setText(""+datum.getStatus());
        rrrTextView.setText(""+datum.getRRR());
        referTextView.setText(""+datum.getTransactionRef());
        addLayout.addView(child);


    }

    public static String getMonth(String date) throws ParseException {
        Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
        String monthName = new SimpleDateFormat("MMMM dd,yyyy").format(d);
        Log.e("Month"," "+monthName);
        return monthName;
    }

    public static String getYear(String date) throws ParseException {
        Date d = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(date);
        String monthName = new SimpleDateFormat("yyyy").format(d);
        Log.e("Month"," "+monthName);
        return monthName;
    }



    @Override
    public GetRepaymentHistory.Datum getItem(int position) {
        return super.getItem(position);
    }
}
