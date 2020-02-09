package com.retailboosters.fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.HomeActivity;
import com.retailboosters.LoginActivity;
import com.retailboosters.R;
import com.retailboosters.response.CreateOrderResponse;
import com.retailboosters.response.GetProductByIdResponse;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetStoreResponse;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class BuyOnCreditFragment extends Fragment implements OnApiResponse {

	FragmentManager fragmentManager;
	private Button mBuyButton;
    private GetProductByStoreResponse.Datum mProduct;

    private TextView mAlmostTextView;
    private EditText mPNameEditText,mStoreEditText,mConNumEditText,mAddEditText,mTotalAmtEditText,mQtyEditText,
			mUnitEditText,mUrlEditText;
    private ImageView mProductImageView;
	GetStoreResponse.Datum store;
	RequestOptions ro = new RequestOptions();
	int total;
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_buyoncredit, container, false);

        mProduct = (GetProductByStoreResponse.Datum)getArguments().getSerializable("product");

		store = (GetStoreResponse.Datum)getArguments().getSerializable("store");

//		((HomeActivity)getActivity()).closeSearch();

        mPNameEditText = (EditText)rootView.findViewById(R.id.pNameEdittext);
        mStoreEditText = (EditText)rootView.findViewById(R.id.storeNameEdittext);
        mConNumEditText = (EditText)rootView.findViewById(R.id.conNumEdittext);
        mAddEditText = (EditText)rootView.findViewById(R.id.storeAddEdittext);
        mTotalAmtEditText = (EditText)rootView.findViewById(R.id.totalAmtEdittext);
        mUnitEditText = (EditText)rootView.findViewById(R.id.unitPriceEditext);
        mUrlEditText = (EditText)rootView.findViewById(R.id.storeUrlEdittext);
		mQtyEditText = (EditText)rootView.findViewById(R.id.qtyEdittext);
		mAlmostTextView= (TextView)rootView.findViewById(R.id.almostTextView);

        mProductImageView = (ImageView)rootView.findViewById(R.id.productImageView);

        fragmentManager = getActivity().getSupportFragmentManager();
		
		mBuyButton = (Button)rootView.findViewById(R.id.button1);

		Log.e("auth",""+Pref.loadStringPref(getActivity(),Pref.AUTH_TOKEN_KEY));

		mPNameEditText.setText(mProduct.getProductName());
		mUnitEditText.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(mProduct.getUnitprice())+"");
		mAlmostTextView.setText(Pref.loadStringPref(getActivity(),Pref.FIRST_NAME)+", Welcome to Retail Booster");


		if(store != null){
			mUrlEditText.setText(store.getUrl());
			mStoreEditText.setText(store.getStoreName());
			mAddEditText.setText(store.getAddress());
		}else{
			getProductInfo(mProduct.getId());
		}



		int qty = Integer.parseInt(mQtyEditText.getText().toString());
		total = mProduct.getUnitprice() * qty;
		mTotalAmtEditText.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(total)+"");

		ro.placeholder(R.drawable.image_icon);
		ro.error(R.drawable.image_icon);
		Glide.with(getActivity()).applyDefaultRequestOptions(ro)
				.load(mProduct.getProductImage())
				.into(mProductImageView);



		mQtyEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

				if(mQtyEditText.getText().toString().length() > 0) {
					int qty = Integer.parseInt(mQtyEditText.getText().toString());
					total = mProduct.getUnitprice() * qty;
					mTotalAmtEditText.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(total)+"");

				}else{
					mTotalAmtEditText.setText("");
				}
			}
		});

		mBuyButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onClickConfirm();
			}
		});
		
		return rootView;
	}


	private void createOrder(){
		try {

			String URL = Utils.ADD_ORDER;
			JSONObject jsonBody = new JSONObject();
			jsonBody.put("loanId", Pref.loadStringPref(getActivity(),Pref.LOAN_ID));
			jsonBody.put("storeId", store.getId());
			jsonBody.put("productId", mProduct.getId());
			jsonBody.put("unitPrice", mProduct.getUnitprice());
			jsonBody.put("quantity", mQtyEditText.getText().toString());
			jsonBody.put("totalAmount", total);
			new Utils().callApis(getActivity(),URL,jsonBody,BuyOnCreditFragment.this);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void onClickConfirm() {

		createOrder();

		
	}


	private void getProductInfo(String productId) {
		try {

			String URL = Utils.GET_PRODUCT_BY_ID;
			JSONObject jsonBody = new JSONObject();
			jsonBody.put("productId",productId);
			new Utils().callApis(getActivity(),URL,jsonBody,BuyOnCreditFragment.this);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onSuccess(String url,String response) {
    	if(getActivity() != null) {
			if (url.equalsIgnoreCase(Utils.GET_PRODUCT_BY_ID)) {
				parseProductId(response);
			} else {
				parseData(response);
			}
		}
	}

	@Override
	public void onError(String response) {

	}

	private void parseProductId(String resString){

		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();

		GetProductByIdResponse getProductByIdResponse = gson.fromJson(resString,GetProductByIdResponse.class);
		if(getProductByIdResponse.getStatus()){

			GetStoreResponse storeResponse = new GetStoreResponse();
			store = storeResponse.new Datum();

			Log.e("store Id",""+getProductByIdResponse.getStore().getId());
			store.setId(getProductByIdResponse.getStore().getId());
			store.setAddress(getProductByIdResponse.getStore().getAddress());
			store.setStoreName(getProductByIdResponse.getStore().getStoreName());
			store.setPhoneNo(getProductByIdResponse.getStore().getPhoneNo());
			store.setStoreImage(getProductByIdResponse.getStore().getStoreImage());
			store.setUrl(getProductByIdResponse.getStore().getUrl());
			mUrlEditText.setText(store.getUrl());
			mStoreEditText.setText(store.getStoreName());
			mAddEditText.setText(store.getAddress());

		}
	}


	private void parseData(String resString) {

		GsonBuilder gsonb = new GsonBuilder();
		Gson gson = gsonb.create();

		CreateOrderResponse loginResponse = gson.fromJson(resString,
                CreateOrderResponse.class);

		if(loginResponse.getStatus()){

			mProduct.setQuantity(Integer.parseInt(mQtyEditText.getText().toString()));
			Bundle bundle = new Bundle();
			bundle.putSerializable("product",mProduct);
            bundle.putSerializable("store",store);
            bundle.putString("orderId",loginResponse.getData().getId());
			bundle.putSerializable("orderResponse",loginResponse);

            BuyEmployeeInfoFragment fragment = new BuyEmployeeInfoFragment();
			fragment.setArguments(bundle);
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, fragment,"EmployeeFragment");
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();

		}else{
			new Utils().showErrorDialog(getActivity(),"Error");
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
