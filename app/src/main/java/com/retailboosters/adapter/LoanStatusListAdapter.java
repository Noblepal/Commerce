package com.retailboosters.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.OfferLatterWebviewActivity;
import com.retailboosters.R;
import com.retailboosters.response.GetOrderHistoryResponse;
import com.retailboosters.response.GetUserOrdersResponse;
import com.retailboosters.utils.Utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class LoanStatusListAdapter extends ArrayAdapter<GetOrderHistoryResponse.Datum> {

    private Context mContext;
    private ArrayList<GetOrderHistoryResponse.Datum> moviesList = new ArrayList<>();
    RequestOptions ro = new RequestOptions();

    public LoanStatusListAdapter(Context context, ArrayList<GetOrderHistoryResponse.Datum> list) {
        super(context, 0, list);
        mContext = context;
        moviesList = list;
        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }

    private static class ViewHolder {
        TextView item, date, amount, paidAm, view;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        final GetOrderHistoryResponse.Datum currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.loan_status_list_item, parent,
                    false);
            viewHolder.paidAm = convertView.findViewById(R.id.paidAmount);
            viewHolder.item = convertView.findViewById(R.id.itemTextView);
            viewHolder.date = convertView.findViewById(R.id.dateTextView);
            viewHolder.amount = convertView.findViewById(R.id.amountTextView);
            /*viewHolder.view = (TextView) convertView.findViewById(R.id.viewTextView);*/

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        try {
            //  viewHolder.monthTextView.setText(getMonth(currentStore.getDueDate()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.paidAm.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(currentStore.getPaid()));
        viewHolder.amount.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(currentStore.getAmount()));
        viewHolder.item.setText("" + currentStore.getProductDetails().getProductName());
        try {
            /*viewHolder.date.setText("" + getMonth(currentStore.getOrderDate()) + "\n" + getMonth(currentStore.getExpectedDeliveryDate()));*/
            viewHolder.date.setText("" + getMonth(currentStore.getOrderDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*viewHolder.amount.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(currentStore.getPaid()) + "\n" + "₦" + NumberFormat.getNumberInstance(Locale.US).format(currentStore.getAmount()));
        if (currentStore.getOfferLetter() != null && currentStore.getOfferLetter().length() > 0) {
            viewHolder.view.setAlpha(1f);

        } else {
            viewHolder.view.setAlpha(0.5f);
        }*/
        Log.e("Offer", "" + currentStore.getOfferLetter());
        /*viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentStore.getOfferLetter() != null && currentStore.getOfferLetter().length() > 0) {
                    viewHolder.view.setAlpha(1f);
//                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentStore.getOfferLetter()));
//                    mContext.startActivity(browserIntent);

                    Intent intent = new Intent(mContext, OfferLatterWebviewActivity.class);
                    intent.putExtra("url", currentStore.getOfferLetter());
                    mContext.startActivity(intent);

                } else {
                    viewHolder.view.setAlpha(0.5f);
                }
            }
        });
*/
        return convertView;
    }

    public static String getMonth(String date) throws ParseException {
        Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
        String monthName = new SimpleDateFormat("MMM dd,yyyy").format(d);
        Log.e("Month", " " + monthName);
        return monthName;
    }

    public static String getYear(String date) throws ParseException {
        Date d = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(date);
        String monthName = new SimpleDateFormat("yyyy").format(d);
        Log.e("Month", " " + monthName);
        return monthName;
    }

    @Override
    public GetOrderHistoryResponse.Datum getItem(int position) {
        return super.getItem(position);
    }
}
