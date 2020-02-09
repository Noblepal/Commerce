package com.retailboosters.fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.retailboosters.AppSubmitedActivity;
import com.retailboosters.MandateOtpActivity;
import com.retailboosters.PaymentActivity;
import com.retailboosters.R;
import com.retailboosters.adapter.RepaymentDialogListAdapter;
import com.retailboosters.adapter.RepaymentListAdapter;
import com.retailboosters.response.CreateOrderResponse;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetRepaymentHistory;
import com.retailboosters.response.GetStoreResponse;
import com.retailboosters.response.LoanCalculatorResponse;
import com.retailboosters.response.OrderCreatedResponse;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class BuyLoanInfoFragment extends Fragment implements OnApiResponse {

	FragmentManager fragmentManager;
	private Button mBuyButton;
    String mORderId;
    private TextView mTenureTextView;
    private PopupMenu mTenurePopupMenu;
    int tenure = 1;
    private GetProductByStoreResponse.Datum mProduct;
    private float mLoanEligibility = 0;
    private TextView mPriceTextView,mOfferTextView,mShipFeeTextView,mSubTotalTextView,mNameTextView,
    mVatTextView,mAdminFeeTextView,mTotalCostTextView,mRepaymentSchTextView,mBalancePaidTextView,
            mLessAmtTextView,mAlmostTextView,mDescTextView,mQtyTextView,mUrlTextView;//mEMITextView
    private EditText mAddressEditText;
    private LinearLayout mLessAmtLinearLayout;
    private ImageView mProductImageView;
    RequestOptions ro = new RequestOptions();
    private float subTotal,interest,emi,totalCost,adminFee,vat;
    private boolean lessLoanAmount = false;
    private GetStoreResponse.Datum store;
    LoanCalculatorResponse loanCalculatorResponse;

    public static int REQUEST_CODE = 121;
    public static int MANDATE_REQUEST_CODE = 1241;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_buy_loan, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        mORderId = getArguments().getString("orderId");
        mProduct = (GetProductByStoreResponse.Datum)getArguments().getSerializable("product");
        store = (GetStoreResponse.Datum)getArguments().getSerializable("store");


        mBuyButton = (Button) rootView.findViewById(R.id.button1);
		mTenureTextView = (TextView)rootView.findViewById(R.id.tenureTextView);

        mPriceTextView = (TextView)rootView.findViewById(R.id.pPriceTextView);
        mOfferTextView = (TextView)rootView.findViewById(R.id.offerTextView);
//        mEMITextView = (TextView)rootView.findViewById(R.id.emiTextView);
        mShipFeeTextView = (TextView)rootView.findViewById(R.id.shipFeeTextView);
        mSubTotalTextView = (TextView)rootView.findViewById(R.id.subTotalTextView);
        mNameTextView = (TextView)rootView.findViewById(R.id.pNameTextView);
        mLessAmtTextView = (TextView)rootView.findViewById(R.id.lessAmtTextView);
        mAlmostTextView= (TextView)rootView.findViewById(R.id.almostTextView);
        mVatTextView= (TextView)rootView.findViewById(R.id.vatTextView);
        mAdminFeeTextView= (TextView)rootView.findViewById(R.id.adminFeeTextView);
        mTotalCostTextView= (TextView)rootView.findViewById(R.id.totalCostTextView);
        mRepaymentSchTextView= (TextView)rootView.findViewById(R.id.repaymentTextView);
        mBalancePaidTextView= (TextView)rootView.findViewById(R.id.balancePaidTextView);
        mDescTextView= (TextView)rootView.findViewById(R.id.descTextView);
        mQtyTextView = (TextView)rootView.findViewById(R.id.qtyTextView);
        mUrlTextView = (TextView)rootView.findViewById(R.id.pUrlTextView);

        mProductImageView = (ImageView)rootView.findViewById(R.id.productImageView);

        mAddressEditText = (EditText)rootView.findViewById(R.id.addressEt);

        mLessAmtLinearLayout = (LinearLayout)rootView.findViewById(R.id.lessAmtLayout);

        int totalPrice = (mProduct.getUnitprice()*mProduct.getQuantity());
        int shippingFee = (int)(totalPrice*Global.DROP_DOWN_RESPONSE.getData().getProductSetting().getShippinFee())/100;
        subTotal = (totalPrice +shippingFee);
        vat = (int)(subTotal*Global.DROP_DOWN_RESPONSE.getData().getProductSetting().getVAT())/100;
        adminFee = (int)(subTotal*Global.DROP_DOWN_RESPONSE.getData().getProductSetting().getAdminFee())/100;

        totalCost = subTotal+vat+adminFee;


        mDescTextView.setText(""+mProduct.getDescription());
        mQtyTextView.setText("Quantity "+mProduct.getQuantity());
        mUrlTextView.setText(""+store.getUrl());

        mPriceTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(mProduct.getUnitprice()));
        mShipFeeTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format((int)shippingFee));
        mSubTotalTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(subTotal));
        mNameTextView.setText(mProduct.getProductName());
        mAlmostTextView.setText("Almost there, "+Pref.loadStringPref(getActivity(),Pref.FIRST_NAME));
        mVatTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(vat));
        mAdminFeeTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(adminFee));
        mTotalCostTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format((int)(totalCost)));

        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
        Glide.with(getActivity()).applyDefaultRequestOptions(ro)
                .load(mProduct.getProductImage())
                .into(mProductImageView);


        mBuyButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                if(mLoanEligibility == 0){

                }else if(mAddressEditText.getText().toString().length() > 0) {
                    onClickConfirm();
                }else{
                    new Utils().showErrorDialog(getActivity(),"Please add delivery address.");
                }
			}
		});


        mTenurePopupMenu = new PopupMenu(getActivity(),mTenureTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getRepaymentPeriod().size(); i++){
            mTenurePopupMenu.getMenu().add(i,Integer.parseInt(Global.DROP_DOWN_RESPONSE.getData().getDropDown().getRepaymentPeriod()
                    .get(i)),i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getRepaymentPeriod()
                    .get(i)+" months");
        }
        mTenureTextView.setText(""+mTenurePopupMenu.getMenu().getItem(0).getTitle()+" months");

        mTenureTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTenurePopupMenu.show();
            }
        });
        mTenurePopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                tenure = item.getItemId();
                mTenureTextView.setText(item.getTitle());
                getLoanEligibility();
                return false;
            }
        });

        mLessAmtLinearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lessLoanAmount = true;
                ((ImageView)rootView.findViewById(R.id.checkImageView)).setImageResource(R.drawable.red_gray_circle);

            }
        });

        mRepaymentSchTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mLoanEligibility != 0) {
                    openRepaymentDialog();
                }
            }
        });

        tenure = mTenurePopupMenu.getMenu().getItem(0).getItemId();
        getLoanEligibility();

        return rootView;
    }

    private void openRepaymentDialog(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_repayment);

        ListView listView = (ListView)dialog.findViewById(R.id.listview);
        RepaymentDialogListAdapter listAdapter;
        listAdapter = new RepaymentDialogListAdapter(getActivity(), loanCalculatorResponse.getData());
        listView.setAdapter(listAdapter);
        dialog.show();

    }

    private void getLoanEligibility(){

        try {
            String URL = Utils.LOAN_ELIGIBILITY;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderId", mORderId);
          //  jsonBody.put("salaryAmount", "10000");
            jsonBody.put("tenorAgreed", (tenure));
            Log.e("Tenure1"," "+jsonBody.toString());
            new Utils().callApis(getActivity(),URL,jsonBody,BuyLoanInfoFragment.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    String paymentResponse;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("RequestCode",""+requestCode);
        if(requestCode ==REQUEST_CODE  && resultCode == RESULT_OK){
            boolean isPaymentDone = data.getBooleanExtra("isPaymentDone",false);
            if(isPaymentDone){
                paymentResponse = data.getStringExtra("response");
                JSONObject jsonBody2 = new JSONObject();
                try{
                    jsonBody2.put("orderId", mORderId);
                    new Utils().callApis(getActivity(),Utils.APPROVE_LOAN,jsonBody2,BuyLoanInfoFragment.this);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }else if(requestCode == MANDATE_REQUEST_CODE && resultCode == RESULT_OK) {
            boolean isMandate = data.getBooleanExtra("isMandate", false);
            if (isMandate) {

                addOrder();
            }
        }
    }

    private void getLoanEMI(String eligibleAmt){

        try {
            int amount = mProduct.getQuantity() * mProduct.getUnitprice();
            int loanAmount ;
            if(Integer.parseInt(eligibleAmt) > amount){
                loanAmount = amount;
            }else {
                loanAmount = Integer.parseInt(eligibleAmt) ;
            }

            Log.e("Tenure"," "+mLoanEligibility);
            String URL = Utils.LOAN_CALCULATOR;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderId", mORderId);
            jsonBody.put("amount",mLoanEligibility);
            jsonBody.put("tenorAgreed", tenure);
            jsonBody.put("loanId",Pref.loadStringPref(getActivity(),Pref.LOAN_ID));
            new Utils().callApis(getActivity(),URL,jsonBody,BuyLoanInfoFragment.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void onClickConfirm() {


        int balancePaid = (int)(totalCost - mLoanEligibility);
        if(balancePaid > 0) {
//            Bundle bundle = new Bundle();
//            bundle.putInt("amount", balancePaid);
//            BuyProductPaymentFragment fragment = new BuyProductPaymentFragment();
//            fragment.setArguments(bundle);
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();

            Intent intent = new Intent(getActivity(),PaymentActivity.class);
            intent.putExtra("amount",balancePaid);
            getActivity().startActivityForResult(intent,REQUEST_CODE);

        }else{
            JSONObject jsonBody2 = new JSONObject();
            try{
                jsonBody2.put("orderId", mORderId);
                new Utils().callApis(getActivity(),Utils.APPROVE_LOAN,jsonBody2,BuyLoanInfoFragment.this);

            }catch (Exception e){
                e.printStackTrace();
            }

        }





	}

	private void addOrder(){
        try {

            String URL = Utils.ADD_ORDER;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderId", mORderId);
            jsonBody.put("shippingFee", mProduct.getShippingFee());
            jsonBody.put("subTotal", subTotal);
            jsonBody.put("loanAmount", mLoanEligibility);
            jsonBody.put("balancePaid", (totalCost-mLoanEligibility));
            jsonBody.put("applicationStatus", "received");
            jsonBody.put("delieveryAddress", mAddressEditText.getText().toString());
            jsonBody.put("interest", interest);
            jsonBody.put("emi",emi);
            jsonBody.put("adminFee",adminFee);
            jsonBody.put("vatFee",vat);
            jsonBody.put("totalCost",totalCost);

            if(paymentResponse!=null){
                JSONObject paymentObject = new JSONObject(paymentResponse);

                jsonBody.put("remitaCreditPayment",paymentObject.getJSONArray("responseData").getJSONObject(0));
            }

            Log.e("OBJECt",""+jsonBody.toString());
            if(mAddressEditText.getText().toString().length() <= 0){

                new Utils().showErrorDialog(getActivity(),"Please add delivery address.");
            }else{
                new Utils().callApis(getActivity(),URL,jsonBody,BuyLoanInfoFragment.this);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String method, String response) {
        if(getActivity() != null){


        if(method.equals(Utils.LOAN_ELIGIBILITY)){


            try {
                JSONObject jsonObject = new JSONObject(response);
                if(jsonObject.getBoolean("status")){
                    mLoanEligibility = Float.parseFloat(jsonObject.getString("eligibilieAmount"));
                    if(mLoanEligibility >totalCost){
                        mLoanEligibility = totalCost;
                    }
                    mOfferTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(mLoanEligibility));

                    float balancePaid = totalCost - mLoanEligibility;
                    mBalancePaidTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(balancePaid));

                    if(balancePaid > 0){
                        mBuyButton.setBackgroundResource(R.drawable.pnow);
                    }else{
                        mBuyButton.setBackgroundResource(R.drawable.submit_bg);
                    }
                }
            }catch (Exception e){
                Log.e("error",e.getMessage());
            }

            getLoanEMI("5000");
        }else if(method.equals(Utils.APPROVE_LOAN)){

            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();
            OrderCreatedResponse createOrderResponse = gson.fromJson(response,
                    OrderCreatedResponse.class);

            if(createOrderResponse.getIsOtp()){

                Intent intent = new Intent(getActivity(),MandateOtpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("orderId",mORderId);
                bundle.putSerializable("order",createOrderResponse);
                intent.putExtras(bundle);
                startActivityForResult(intent,MANDATE_REQUEST_CODE);

            }else{
               addOrder();
            }

        }else if(method.equals(Utils.ADD_ORDER)){

            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();
            CreateOrderResponse createOrderResponse = gson.fromJson(response,
                    CreateOrderResponse.class);

            if(createOrderResponse.getStatus()){
                Intent intent = new Intent(getActivity(),AppSubmitedActivity.class);
                startActivity(intent);
                getActivity().finish();

            }


        }else if(method.equals(Utils.LOAN_CALCULATOR)){

            parseLoanData(response);
        }
        }
    }

    @Override
    public void onError(String response) {

    }

    private void parseLoanData(String resString){
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        loanCalculatorResponse = gson.fromJson(resString,
                LoanCalculatorResponse.class);

        if(loanCalculatorResponse.getStatus()){

            interest = Float.parseFloat(loanCalculatorResponse.getTotalInterset());
            emi = Float.parseFloat(loanCalculatorResponse.getData().get(0).getPaymentDue());
//            mEMITextView.setText("₦"+loanCalculatorResponse.getData().get(0).getPaymentDue());
//            mEMITextView.setText("₦"+loanCalculatorResponse.getRepayment());

            if(mLoanEligibility < subTotal){
                mLessAmtLinearLayout.setVisibility(View.VISIBLE);
                mLessAmtTextView.setText("Your eligible loan amount is lesser than the product amount, so you will need to pay the balance amount that is "
                +mBalancePaidTextView.getText().toString());
            }else{
                mLessAmtLinearLayout.setVisibility(View.GONE);
            }

        }




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
