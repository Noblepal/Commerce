package com.retailboosters.fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.adapter.RepaymentListAdapter;
import com.retailboosters.response.GetRepaymentHistory;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class RepaymentFragment extends Fragment implements OnApiResponse {


    private ListView mListView;
    RepaymentListAdapter listAdapter;
    private TextView mAmountTextView,mIntrestTextView,mTenureTextView,mDaysTextView,mOrderTextView;
    private PopupMenu mOrderMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_repayment, container, false);


        mListView = (ListView)rootView.findViewById(R.id.schduleListView);

        mAmountTextView = (TextView)rootView.findViewById(R.id.amountTextView);
        mIntrestTextView = (TextView)rootView.findViewById(R.id.intrestTextView);
        mTenureTextView = (TextView)rootView.findViewById(R.id.tenureTextView);
        mDaysTextView = (TextView)rootView.findViewById(R.id.daysTextView);

        mOrderTextView = (TextView)rootView.findViewById(R.id.orderTextView);

        callApi();

        mOrderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOrderMenu.show();
            }
        });

        return rootView;
    }
    private void callApi() {

            String URL = Utils.GET_REPAYMENT_HISTORY;
            Log.e("Auth"," == "+Pref.loadStringPref(getActivity(),Pref.AUTH_TOKEN_KEY));

            new Utils().callGetApiWithHeader(getActivity(),URL,RepaymentFragment.this,true);


    }
    @Override
    public void onSuccess(String method,String response) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetRepaymentHistory repaymentHistory = gson.fromJson(response,
                GetRepaymentHistory.class);

        if(repaymentHistory.getStatus()){

            mAmountTextView.setText("₦"+repaymentHistory.getData().get(0).getLoanAmount());
            mIntrestTextView.setText("₦"+repaymentHistory.getData().get(0).getInterest());
            mTenureTextView.setText(""+repaymentHistory.getData().get(0).getTenorAgreed()+" months");
            mOrderTextView.setText(""+repaymentHistory.getData().get(0).getProductDetails().getProductName());

            if(repaymentHistory.getData().get(0).getRepaymentHistory().size() > 0) {
                mDaysTextView.setText("" + dayDiff(repaymentHistory.getData().get(0).getRepaymentHistory().get(0).getDueDate()) + " days");

                listAdapter = new RepaymentListAdapter(getActivity(), repaymentHistory.getData().get(0).getRepaymentHistory());
                mListView.setAdapter(listAdapter);
            }

            setOrderMenu(repaymentHistory);


        }

    }

    @Override
    public void onError(String response) {

    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("json.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public long dayDiff(String date)
    {
        long msDiff = getDate(date).getTime()-Calendar.getInstance().getTimeInMillis();
        long daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff);
        return daysDiff;
    }


    public static Date getDate(String date) {
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
            Log.e("Month"," "+d.getTime());
            return d;
        }catch (Exception e){
            return new Date();
        }

    }

    private void setOrderMenu(final GetRepaymentHistory getUserOrdersResponse){

        mOrderMenu = new PopupMenu(getActivity(),mOrderTextView);

        for(int i=0;i<getUserOrdersResponse.getData().size();i++){
            if(getUserOrdersResponse.getData().get(i).getRepaymentHistory().size() > 0)
            mOrderMenu.getMenu().add(i,i,i,""+getUserOrdersResponse.getData().get(i).getProductDetails().getProductName());
        }


        mOrderMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                mAmountTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(getUserOrdersResponse.getData().get(item.getItemId()).getLoanAmount()));
                mIntrestTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(getUserOrdersResponse.getData().get(item.getItemId()).getInterest()));
                mTenureTextView.setText(""+getUserOrdersResponse.getData().get(item.getItemId()).getTenorAgreed()+" months");

                mDaysTextView.setText("" + dayDiff(getUserOrdersResponse.getData().get(item.getItemId()).getRepaymentHistory().get(0).getDueDate()) + " days");


                mOrderTextView.setText(item.getTitle());
                listAdapter = new RepaymentListAdapter(getActivity(),getUserOrdersResponse.getData().get(item.getItemId()).getRepaymentHistory());
                mListView.setAdapter(listAdapter);
                return false;
            }
        });
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_search);
        menuItem.setVisible(false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}

