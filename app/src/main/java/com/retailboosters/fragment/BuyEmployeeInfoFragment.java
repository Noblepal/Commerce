package com.retailboosters.fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.angads25.filepicker.controller.DialogSelectionListener;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.adapter.BankParserListAdapter;
import com.retailboosters.adapter.SalaryListAdapter;
import com.retailboosters.response.BankParserResponse;
import com.retailboosters.response.CreateOrderResponse;
import com.retailboosters.response.FileUploadResponse;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetSalaryResponse;
import com.retailboosters.response.GetStoreResponse;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;
import static com.android.volley.VolleyLog.TAG;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class BuyEmployeeInfoFragment extends Fragment implements OnApiResponse {

	FragmentManager fragmentManager;
	private Button mBuyButton;
	private ImageView mProofIdImageView,mBankStmtImageView,mProductImageView;
    private LinearLayout mCantFindLayout;
    private GetProductByStoreResponse.Datum mProduct;
    private TextView mNameTextView,mMemoryTextView,mUrlTextView,mColorTextView,priceTextView,empIdLabelTextView,
            bankTextView,salaryTitleTv,mAlmostTextView;
    private EditText mEmpIdEditText;
    private ListView mSalaryListView;
    private AutoCompleteTextView mWhereWorkEditText;
    ArrayList<String> nameList = new ArrayList<>();
    private SalaryListAdapter mListAdapter;
    RequestOptions ro = new RequestOptions();
    ArrayAdapter<String> adapter;
    private Bitmap mProffIdBitmap,mBankStmtBitmap;
    GetStoreResponse.Datum store;
    String mORderId;
    private static int BANK_STMT_CODE= 101;
    private static int PROFF_ID_CODE= 102;
    private String[] mBankStmtStrings;
    private String mIdcardPath,mBillPath,mLicensePath;


    CreateOrderResponse createOrderResponse;
    DialogProperties properties = new DialogProperties();
    FilePickerDialog dialog;

    PopupMenu mBankMenu;
    private boolean mCantFind = false;

    DialogProperties proffProperties = new DialogProperties();
    FilePickerDialog proffDialog;
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_buy_employee, container, false);
		fragmentManager = getActivity().getSupportFragmentManager();

        mProduct = (GetProductByStoreResponse.Datum)getArguments().getSerializable("product");
        store = (GetStoreResponse.Datum)getArguments().getSerializable("store");
        mORderId = getArguments().getString("orderId");
        createOrderResponse= (CreateOrderResponse)getArguments().getSerializable("orderResponse");

		mBuyButton = (Button) rootView.findViewById(R.id.button1);

		mCantFindLayout = (LinearLayout)rootView.findViewById(R.id.cantFindCpyLayout);

		mProofIdImageView = (ImageView)rootView.findViewById(R.id.proofIdImageView);
		mBankStmtImageView = (ImageView)rootView.findViewById(R.id.bankStmtImageView);
        mProductImageView = (ImageView)rootView.findViewById(R.id.productImageView);

		mWhereWorkEditText = (AutoCompleteTextView) rootView.findViewById(R.id.whereWorkEdittext);
		mWhereWorkEditText.setThreshold(2);

        mNameTextView = (TextView)rootView.findViewById(R.id.pNameEdittext);
        mMemoryTextView= (TextView)rootView.findViewById(R.id.memoryTextView);
        mUrlTextView = (TextView)rootView.findViewById(R.id.urlTextView);
        mColorTextView= (TextView)rootView.findViewById(R.id.colorTextView);
        priceTextView= (TextView)rootView.findViewById(R.id.priceTextView);
        empIdLabelTextView= (TextView)rootView.findViewById(R.id.empIdLabelTextView);
        salaryTitleTv= (TextView)rootView.findViewById(R.id.salaryTitleTv);
        bankTextView = (TextView) rootView.findViewById(R.id.bankTextView);
        mAlmostTextView= (TextView)rootView.findViewById(R.id.almostTextView);

        mEmpIdEditText = (EditText)rootView.findViewById(R.id.empIdEdittext);

        mSalaryListView = (ListView)rootView.findViewById(R.id.salaryListView);

        mNameTextView.setText(mProduct.getProductName());
        mMemoryTextView.setText(""+mProduct.getDescription());
        mUrlTextView.setText(""+store.getUrl());
        mColorTextView.setText("Quantity "+mProduct.getQuantity());
        priceTextView.setText("₦"+NumberFormat.getNumberInstance(Locale.US).format(mProduct.getUnitprice()));
        mAlmostTextView.setText("Almost there, "+Pref.loadStringPref(getActivity(),Pref.FIRST_NAME));


        ro.placeholder(R.drawable.image_icon);
        ro.error(R.drawable.image_icon);
        Glide.with(getActivity()).applyDefaultRequestOptions(ro)
                .load(mProduct.getProductImage())
                .into(mProductImageView);

        bankTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBankMenu.show();
            }
        });

        mCantFindLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    if(!mCantFind) {
			        mCantFind = true;
                    ((ImageView) mCantFindLayout.getChildAt(0)).setImageResource(R.drawable.red_gray_circle);
                    //empIdLabelTextView.setText("Where do you work?");
                    empIdLabelTextView.setVisibility(View.GONE);
                    mEmpIdEditText.setVisibility(View.GONE);
                    mProofIdImageView.setVisibility(View.VISIBLE);
                    mWhereWorkEditText.setEnabled(false);

                    new Utils().showErrorDialog(getActivity(), "Sorry, only employees from pre-approved companies can apply for credit on retail boosters. Contact enquiries@retailboosters.ng on how to add your company to be part of the program.");
                }else{
                    mCantFind = false;
                    ((ImageView) mCantFindLayout.getChildAt(0)).setImageResource(R.drawable.gray_circle);
//                    empIdLabelTextView.setText("Employee ID");
                    empIdLabelTextView.setVisibility(View.VISIBLE);
                    mEmpIdEditText.setVisibility(View.VISIBLE);
                    mProofIdImageView.setVisibility(View.VISIBLE);
                    mWhereWorkEditText.setEnabled(true);

                }
			}
		});

        if(Pref.loadStringPref(getActivity(),Pref.WHERE_WORK) != null){
            mWhereWorkEditText.setText(""+Pref.loadStringPref(getActivity(),Pref.WHERE_WORK));
        }

        mWhereWorkEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                new Utils().callGetApi(getActivity(),Utils.SERCH_COMPANY+mWhereWorkEditText.getText().toString().trim(),BuyEmployeeInfoFragment.this,
                        false);
            }
        });

        mWhereWorkEditText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mWhereWorkEditText.setText(adapter.getItem(position));
                mProofIdImageView.setVisibility(View.VISIBLE);


            }
        });



        mBankStmtImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                isReadStoragePermissionGranted(BANK_STMT_CODE);

                if(bankTextView.getText().toString().equalsIgnoreCase("Select Bank")){
                    new Utils().showErrorDialog(getActivity(),"Please select bank.");
                }else{
                    dialog.show();
                }

            }
        });

        mProofIdImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

//                isReadStoragePermissionGranted(PROFF_ID_CODE);

                openIdDialog();

            }
        });

        mBuyButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				onClickConfirm(false);

			}
		});

        String[] ext = new String[]{".pdf"};

        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(DialogConfigs.DEFAULT_DIR);
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions =ext;


        dialog = new FilePickerDialog(getActivity(),properties);
        dialog.setTitle("Select a File");
        dialog.setDialogSelectionListener(new DialogSelectionListener() {
            @Override
            public void onSelectedFilePaths(String[] files) {
                //files is the array of the paths of files selected by the Application User.
                mBankStmtStrings = files;
                Log.e("Fil PAth",files[0]);
                onClickConfirm(true);


            }
        });


        proffProperties.selection_mode = DialogConfigs.SINGLE_MODE;
        proffProperties.selection_type = DialogConfigs.FILE_SELECT;
        proffProperties.root = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.offset = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.extensions =null;


        if(createOrderResponse.getData().getGovermentId().getDocument() != null &&
                createOrderResponse.getData().getGovermentId().getDocument().length() > 0){
            mIdcardPath = createOrderResponse.getData().getGovermentId().getDocument();

        }
        if(createOrderResponse.getData().getInternationalPassport().getDocument() != null &&
                createOrderResponse.getData().getInternationalPassport().getDocument().length() > 0){
            mLicensePath = createOrderResponse.getData().getInternationalPassport().getDocument();

        }
        if(createOrderResponse.getData().getUtilityBill().getDocument() != null &&
                createOrderResponse.getData().getUtilityBill().getDocument().length() > 0){
            mBillPath = createOrderResponse.getData().getUtilityBill().getDocument();

        }

        setBankMenu();

        getSalaryInfo();
		return rootView;
	}


    private void setBankMenu(){

        mBankMenu = new PopupMenu(getActivity(),bankTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getRepaymentBankbank().size(); i++){
            mBankMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getRepaymentBankbank().get(i));
        }
        mBankMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                bankTextView.setText(item.getTitle());
                return false;
            }
        });
    }
    private void getSalaryInfo() {
        try {

            String URL = Utils.GET_SALARY_HISTORY;
            JSONObject jsonBody = new JSONObject();
//            jsonBody.put("phoneNumber", "08126227772");
            jsonBody.put("phoneNumber", Pref.loadStringPref(getActivity(),Pref.MOBILE_NO));
            jsonBody.put("orderId",mORderId);
            new Utils().callApis(getActivity(),URL,jsonBody,BuyEmployeeInfoFragment.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onSuccess(String method,String response) {
	    Log.e("MEthid",method);
	    if(method.startsWith(Utils.SERCH_COMPANY)){
	        parseCompanyData(response);
        }else if(method.equals(Utils.GET_SALARY_HISTORY)){
            parseData(response);
        }else if(method.equals(Utils.BANK_PARSER)){
            parserBankParser(response);
        }else if(method.equals(Utils.UPLOAD_DOC_BUY_PRODUCT)){

            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            FileUploadResponse getSalaryResponse = gson.fromJson(response,
                    FileUploadResponse.class);

            if(getSalaryResponse.getStatus()){
                String bankStmtUrl = getSalaryResponse.getData().getBankStatement().getDocument();
                if(mBankStmtImageView.getVisibility() == View.VISIBLE && bankStmtUrl != null && bankStmtUrl.length() > 0){

                    String URL = Utils.BANK_PARSER;
                    JSONObject jsonBody = new JSONObject();
                    try {
                        Log.e("OrderId",""+mORderId);
                        jsonBody.put("orderId",mORderId);
//                        jsonBody.put("selectedBank",bankTextView.getText().toString());
                        jsonBody.put("selectedBank","wema");

                        jsonBody.put("bankStatement", getSalaryResponse.getData().getBankStatement().getDocument());
                        new Utils().callApis(getActivity(),URL,jsonBody,BuyEmployeeInfoFragment.this);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }



        }

    }

    @Override
    public void onError(String response) {



    }

    private void parseCompanyData(String resString){
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        nameList.clear();
        mWhereWorkEditText.setAdapter(null);
        try {
            JSONArray jsonArray = new JSONArray(resString);
            JSONObject jsonObject;



            for(int i=0;i<jsonArray.length();i++) {
                jsonObject = jsonArray.getJSONObject(i);
                nameList.add(jsonObject.getString("companyName"));

               }

            adapter = new ArrayAdapter<String>
                    (getActivity(),android.R.layout.simple_dropdown_item_1line
                            ,nameList);
            mWhereWorkEditText.setAdapter(adapter);
            mWhereWorkEditText.showDropDown();


        }catch (Exception e){

        }

    }

    private void parserBankParser(String response){

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        BankParserResponse bankParserResponse = gson.fromJson(response,
                BankParserResponse.class);

        if(bankParserResponse.getStatus()){
            Log.e("size",""+bankParserResponse.getData().getBankParserData().size());
            BankParserListAdapter listAdapter = new BankParserListAdapter(getActivity(),bankParserResponse.getData().getBankParserData());
            mSalaryListView.setAdapter(listAdapter);
            LayoutInflater inflater = getActivity().getLayoutInflater();
            ViewGroup header = (ViewGroup)inflater.inflate(R.layout.salary_list_header,mSalaryListView,false);
            mSalaryListView.addHeaderView(header);

            TextView headerTextView = (TextView)header.findViewById(R.id.tv);
            try {
                headerTextView.setText(""+bankParserResponse.getData().getBankParserData().get(0).getYear());
            }catch (Exception e){
                e.printStackTrace();
            }
            setListHeight();
        }

    }
    private void parseData(String resString) {

        if(getActivity() != null){


        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetSalaryResponse getSalaryResponse = gson.fromJson(resString,
                GetSalaryResponse.class);

        if(getSalaryResponse.getStatus()){
            salaryTitleTv.setVisibility(View.VISIBLE);
            mBankStmtImageView.setVisibility(View.GONE);
            bankTextView.setVisibility(View.GONE);
            LayoutInflater inflater = getActivity().getLayoutInflater();
            ViewGroup header = (ViewGroup)inflater.inflate(R.layout.salary_list_header,mSalaryListView,false);
            mSalaryListView.addHeaderView(header);

            TextView headerTextView = (TextView)header.findViewById(R.id.tv);
            try {
                headerTextView.setText(SalaryListAdapter.getYear(getSalaryResponse.getData().getData().getSalaryPaymentDetails().get(0).getPaymentDate()));
            }catch (Exception e){
                e.printStackTrace();
            }
            mListAdapter = new SalaryListAdapter(getActivity(),getSalaryResponse.getData().getData().getSalaryPaymentDetails());
            mSalaryListView.setAdapter(mListAdapter);
            setListHeight();

        }else{
            salaryTitleTv.setVisibility(View.GONE);
            mBankStmtImageView.setVisibility(View.VISIBLE);
            bankTextView.setVisibility(View.VISIBLE);
//            new Utils().showErrorDialog(getActivity(),getSalaryResponse.getMessage());
            new Utils().showErrorDialog(getActivity(),"No salary history found, upload your 6-months bank statement to access credit.");


        }
        }
    }

    private void openIdDialog(){

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.id_dialog);
        //dialog.setTitle("Title...");

        // set the custom dialog components - text, image and button

        final Button idButton = (Button) dialog.findViewById(R.id.idButton);
        final Button billButton = (Button) dialog.findViewById(R.id.billButton);
        final Button photoButton = (Button) dialog.findViewById(R.id.photoButton);
        final Button okButton = (Button) dialog.findViewById(R.id.okButton);
        // if button is clicked, close the custom dialog

        final RelativeLayout mIdLayout = (RelativeLayout)dialog.findViewById(R.id.idLayout);
        final RelativeLayout mLicenceLayout = (RelativeLayout)dialog.findViewById(R.id.licenceLayout);
        final RelativeLayout mBillLayout = (RelativeLayout)dialog.findViewById(R.id.billLayout);



        if(mIdcardPath != null){
            String name = mIdcardPath.substring(mIdcardPath.lastIndexOf("/")+1);
//            idButton.setText(name);
        }
        if(mLicensePath != null){
            String name = mLicensePath.substring(mLicensePath.lastIndexOf("/")+1);
//            photoButton.setText(name);
        }
        if(mBillPath != null){
            String name = mBillPath.substring(mBillPath.lastIndexOf("/")+1);
//            billButton.setText(name);
        }
        if(!createOrderResponse.getData().getGovermentId().isEditable()){
            idButton.setEnabled(false);
            idButton.setAlpha(0.5f);
        }
        if(!createOrderResponse.getData().getInternationalPassport().isEditable()){
            photoButton.setEnabled(false);
            photoButton.setAlpha(0.5f);
        }
        if(!createOrderResponse.getData().getUtilityBill().isEditable()){
            billButton.setEnabled(false);
            billButton.setAlpha(0.5f);
        }
        okButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        photoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proffDialog = new FilePickerDialog(getActivity(),proffProperties);
                proffDialog.setTitle("Select a File");
                proffDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mLicensePath = files[0];
                        String name = mLicensePath.substring(mLicensePath.lastIndexOf("/")+1);
                        photoButton.setText(name);
                        Log.e("Fil PAth",files[0]);
                    }
                });
                proffDialog.show();
            }
        });
        idButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proffDialog = new FilePickerDialog(getActivity(),proffProperties);
                proffDialog.setTitle("Select a File");
                proffDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mIdcardPath = files[0];
                        String name = mIdcardPath.substring(mIdcardPath.lastIndexOf("/")+1);
                        idButton.setText(name);
                        Log.e("Fil PAth",files[0]);
                    }
                });
                proffDialog.show();
                //dialog.dismiss();
            }
        });
        /*passButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proffDialog = new FilePickerDialog(getActivity(),proffProperties);
                proffDialog.setTitle("Select a File");
                proffDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mPassportPath = files[0];
                        String name = mPassportPath.substring(mPassportPath.lastIndexOf("/")+1);
                        passButton.setText(name);
                        Log.e("Fil PAth",files[0]);
                    }
                });
                proffDialog.show();
            }
        });
        licenseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proffDialog = new FilePickerDialog(getActivity(),proffProperties);
                proffDialog.setTitle("Select a File");
                proffDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mLicensePath = files[0];
                        String name = mLicensePath.substring(mLicensePath.lastIndexOf("/")+1);
                        licenseButton.setText(name);
                        Log.e("Fil PAth",files[0]);
                    }
                });
                proffDialog.show();
            }
        });*/
        billButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proffDialog = new FilePickerDialog(getActivity(),proffProperties);
                proffDialog.setTitle("Select a File");
                proffDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mBillPath = files[0];
                        String name = mBillPath.substring(mBillPath.lastIndexOf("/")+1);
                        billButton.setText(name);
                        Log.e("Fil PAth",files[0]);
                    }
                });
                proffDialog.show();
            }
        });

        mIdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(createOrderResponse.getData().getGovermentId().getDocument() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(createOrderResponse.getData().getGovermentId().getDocument()));
                    startActivity(browserIntent);
                }
            }
        });

        mLicenceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(createOrderResponse.getData().getInternationalPassport().getDocument() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(createOrderResponse.getData().getInternationalPassport().getDocument()));
                    startActivity(browserIntent);
                }
            }
        });
        mBillLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(createOrderResponse.getData().getUtilityBill().getDocument() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(createOrderResponse.getData().getUtilityBill().getDocument()));
                    startActivity(browserIntent);
                }
            }
        });
        dialog.show();
    }


    private void setListHeight(){
        ListAdapter listadp = mSalaryListView.getAdapter();
        if (listadp != null) {
            int totalHeight = 0;
            for (int i = 0; i < listadp.getCount(); i++) {
                View listItem = listadp.getView(i, null, mSalaryListView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mSalaryListView.getLayoutParams();
            params.height = totalHeight
                    + (mSalaryListView.getDividerHeight() * (listadp.getCount() - 1));
            mSalaryListView.setLayoutParams(params);
            mSalaryListView.requestLayout();
        }
    }

    public void onClickConfirm(boolean isBankStmt) {


            String URL = Utils.UPLOAD_DOC_BUY_PRODUCT ;
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("loanId", Pref.loadStringPref(getActivity(),Pref.LOAN_ID));
            hashMap.put("productId",mProduct.getId());
            hashMap.put("storeId", store.getId());
            if(mWhereWorkEditText.isEnabled()) {
                hashMap.put("whereWork", mWhereWorkEditText.getText().toString());
                hashMap.put("employeeId", mEmpIdEditText.getText().toString());

            }else{
               // hashMap.put("whereWork", mEmpIdEditText.getText().toString());
            }
            hashMap.put("orderId", mORderId);

            HashMap<String,String> imagesHashMap = new HashMap<>();
            if(!createOrderResponse.getData().getGovermentId().getStatus().equals("received") && mIdcardPath!=null){
                imagesHashMap.put("govermentId", mIdcardPath);

            }
            if(!createOrderResponse.getData().getInternationalPassport().getStatus().equals("received") && mLicensePath!=null){
                imagesHashMap.put("passportOrDrivingLicense", mLicensePath);

            }
            if(!createOrderResponse.getData().getUtilityBill().getStatus().equals("received") && mBillPath!=null){
                imagesHashMap.put("utilityBill", mBillPath);

            }

            if(mBankStmtStrings != null){
                imagesHashMap.put("bankStatement", mBankStmtStrings[0]);

            }



            if(isBankStmt){
                if(mBankStmtImageView.getVisibility() == View.VISIBLE && mBankStmtStrings==null){
                    new Utils().showErrorDialog(getActivity(),"Upload your 6-months bank statement to access credit.");
                }else{
                    new Utils().uploadFile(getActivity(),URL,hashMap,imagesHashMap,BuyEmployeeInfoFragment.this);
                }
            }else{

                if(mBankStmtImageView.getVisibility() == View.VISIBLE && mBankStmtStrings==null){
                    new Utils().showErrorDialog(getActivity(),"Upload your 6-months bank statement to access credit.");
                }else if(mIdcardPath==null || mLicensePath==null || mBillPath==null ){
                    new Utils().showErrorDialog(getActivity(),"Upload your Proof of ID.");
                } else{
                    new Utils().uploadFile(getActivity(),URL,hashMap,imagesHashMap,BuyEmployeeInfoFragment.this);
                    startFragment();
                }
            }






	}

	private void startFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("orderId",mORderId);
        bundle.putSerializable("product",mProduct);
        bundle.putSerializable("store",store);

        BuyLoanInfoFragment fragment = new BuyLoanInfoFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public  boolean isReadStoragePermissionGranted(int code) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                if(code == BANK_STMT_CODE) {
                    chooseFile.setType("*/*");
                }else{
                    chooseFile.setType("*/*");

                }
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, code);
                return true;
            } else {

                Log.v(TAG,"Permission is revoked1");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
            chooseFile.setType("*/*");
            chooseFile = Intent.createChooser(chooseFile, "Choose a file");
            startActivityForResult(chooseFile, code);
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
//            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(i, requestCode);
//            dialog.show();
        }else{

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            Log.e("URI"," == "+imageUri.getPath());
            try {
                //getting bitmap object from uri
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);

                //displaying selected image to imageview
                mProductImageView.setImageBitmap(bitmap);

                //calling the method uploadBitmap to upload image
                if(requestCode == PROFF_ID_CODE){
                    mProffIdBitmap = bitmap;
                }else{
                    mBankStmtBitmap = bitmap;
                }

            } catch (IOException e) {
                e.printStackTrace();
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
