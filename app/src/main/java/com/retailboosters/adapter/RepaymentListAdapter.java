package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.R;
import com.retailboosters.response.GetRepaymentHistory;
import com.retailboosters.response.GetSalaryResponse;
import com.retailboosters.response.GetUserOrdersResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class RepaymentListAdapter extends ArrayAdapter<GetRepaymentHistory.Datum.RepaymentHistory> {

    private Context mContext;
    private ArrayList<GetRepaymentHistory.Datum.RepaymentHistory> moviesList = new ArrayList<>();
    RequestOptions ro = new RequestOptions();

    public RepaymentListAdapter(Context context, ArrayList<GetRepaymentHistory.Datum.RepaymentHistory> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }
    private static class ViewHolder {
        TextView monthTextView,toPayTextView,balanceTextView;

    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        GetRepaymentHistory.Datum.RepaymentHistory currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.repayment_list_item, parent,
                    false);


            viewHolder.monthTextView = (TextView) convertView.findViewById(R.id.monthTv);
            viewHolder.toPayTextView = (TextView) convertView.findViewById(R.id.toPayTv);
            viewHolder.balanceTextView = (TextView) convertView.findViewById(R.id.balanceTv);

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        try {
            viewHolder.monthTextView.setText(getMonth(currentStore.getDueDate()));

        }catch (Exception e){
            e.printStackTrace();
        }
//        viewHolder.toPayTextView.setText(""+currentStore.getPaymentDue());
        viewHolder.toPayTextView.setText("₦"+currentStore.getPaymentDue());
        viewHolder.balanceTextView.setText("₦"+currentStore.getBalance());

        return convertView;
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
    public GetRepaymentHistory.Datum.RepaymentHistory getItem(int position) {
        return super.getItem(position);
    }
}
