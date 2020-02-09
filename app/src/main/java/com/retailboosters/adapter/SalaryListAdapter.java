package com.retailboosters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.retailboosters.R;
import com.retailboosters.fragment.StoreListFragment;
import com.retailboosters.response.GetSalaryResponse;
import com.retailboosters.response.GetStoreResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SalaryListAdapter extends ArrayAdapter<GetSalaryResponse.Data.Data_.SalaryPaymentDetail> {

    private Context mContext;
    private ArrayList<GetSalaryResponse.Data.Data_.SalaryPaymentDetail> moviesList = new ArrayList<>();
    RequestOptions ro = new RequestOptions();

    public SalaryListAdapter(Context context, ArrayList<GetSalaryResponse.Data.Data_.SalaryPaymentDetail> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
    }
    private static class ViewHolder {
        TextView monthTextView,salaryTextView;

    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder; // view lookup cache stored in tag
        GetSalaryResponse.Data.Data_.SalaryPaymentDetail currentStore = moviesList.get(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.salary_list_item, parent,
                    false);


            viewHolder.monthTextView = (TextView) convertView.findViewById(R.id.monthNameTv);
            viewHolder.salaryTextView = (TextView) convertView.findViewById(R.id.salaryTv);

            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.salaryTextView.setText("₦"+currentStore.getAmount());
        try {
            viewHolder.monthTextView.setText(getMonth(currentStore.getPaymentDate()));

        }catch (Exception e){

            e.printStackTrace();
        }





        return convertView;
    }
    public static String getMonth(String date) throws ParseException {
        Date d = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(date);
        String monthName = new SimpleDateFormat("MMMM").format(d);
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
    public GetSalaryResponse.Data.Data_.SalaryPaymentDetail getItem(int position) {
        return super.getItem(position);
    }
}
