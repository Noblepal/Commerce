package com.retailboosters.fragment;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.LoginActivity;
import com.retailboosters.R;
import com.retailboosters.adapter.LoanStatusListAdapter;
import com.retailboosters.response.GetUserOrdersResponse;
import com.retailboosters.response.LoanStatusResponse;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class LoanStatusFragment extends Fragment implements OnApiResponse {

    String _id;
    private ImageView mProductImageView;
    private TextView mPriceTextView, mNameTextView, mOfferTextView, mPaidTextView, mRepaymentTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_loan_status, container, false);

        _id = getArguments().getString("id");


        /*mBvnImageView = (ImageView)rootView.findViewById(R.id.bvnImageView);
        mAppSubImageView = (ImageView)rootView.findViewById(R.id.appSubImageView);
        mBankImageView = (ImageView)rootView.findViewById(R.id.bankStmtImageView);
        mRepayImageView = (ImageView)rootView.findViewById(R.id.repaymentImageView);
        mApproveImageView = (ImageView)rootView.findViewById(R.id.approveImageView);
        mDeliveryImageView = (ImageView)rootView.findViewById(R.id.deliveryImageView);*/
        mProductImageView = (ImageView) rootView.findViewById(R.id.productImageView);


        mPriceTextView = (TextView) rootView.findViewById(R.id.priceTextView);
        mNameTextView = (TextView) rootView.findViewById(R.id.pNameTextView);
        mOfferTextView = (TextView) rootView.findViewById(R.id.offerTextView);
        mPaidTextView = (TextView) rootView.findViewById(R.id.paidTextView);
        mRepaymentTextView = (TextView) rootView.findViewById(R.id.repaymentTextView);


        callApi();

        return rootView;
    }

    private void callApi() {

        try {

            String URL = Utils.LOAN_STATUS;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderId", _id);
            new Utils().callApis(getActivity(), URL, jsonBody, LoanStatusFragment.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onSuccess(String method, String response) {

        if (getActivity() != null) {
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            LoanStatusResponse statusResponse = gson.fromJson(response,
                    LoanStatusResponse.class);

            if (statusResponse.getStatus()) {


                mPriceTextView.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(statusResponse.getProductDetails().getUnitprice()));
                mNameTextView.setText("" + statusResponse.getProductDetails().getProductName());
                mOfferTextView.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(statusResponse.getOfferAmount()));
                mPaidTextView.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(statusResponse.getBalancePaid()));
                mRepaymentTextView.setText("₦" + NumberFormat.getNumberInstance(Locale.US).format(statusResponse.getRepaymentAmount()));
                Glide.with(getActivity()).load(statusResponse.getProductDetails().getProductImage())
                        .into(mProductImageView);


                if (statusResponse.getBvn()) {
                    /*mBvnImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }
                if (statusResponse.getApplicationStatus()) {
                    /*mAppSubImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }
                if (statusResponse.getSalaryAndBankStatementStatus()) {
                    /*mBankImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }
                if (statusResponse.getRepaymentScheduleStatus()) {
                    /*mRepayImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }
                if (statusResponse.getDelieveryStatus()) {
                    /*mDeliveryImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }
                if (statusResponse.getApprovalStatus()) {
                    /*mApproveImageView.setImageResource(R.drawable.red_circle_drawable);*/
                }

            }

        }

    }

    @Override
    public void onError(String response) {

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
