package com.retailboosters.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.HomeActivity;
import com.retailboosters.R;
import com.retailboosters.RegisterFormsActivity;
import com.retailboosters.response.DropDownResponse;
import com.retailboosters.response.Step3Response;
import com.retailboosters.response.Step4Response;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class LoanInfoFragment extends Fragment implements OnApiResponse {

    private EditText ifYesEditText,reasonForMisEditText,
            fromWhereEditText,empTermEditText,conEndEditText,contributionEditText,creditPayEditText,
            repaymentAccEditText,otherAccEditText,outstandingTextView
            ,accDetailsEditText,otherAccDetailsEditText,accNameEditText,otherAccNameEditText,howMuchTextView
    ;

    private TextView tenorTextView,anyOtherTextView,itemOfPurTextView,valueTextView,
            bankTextView,otherBankTextView,havUMissedEditText,ownOrgaEditText,whenWasEditText;

    private String mLoanID ="";
    private PopupMenu mOwnMenu,mHaveMissRePAyMenu,mTenorMenu,mOutStandingMenu,mAnyOtherMenu,mHowMuchMenu,mItemOfPurMenu,mValueMenu,mBankMenu,mOtherBankMenu;
    private Button mConfirmButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_loan_info, container, false);
        ((RegisterFormsActivity)getActivity()).onCurrentFragment(LoanInfoFragment.this);
        mLoanID = Pref.loadStringPref(getActivity(),Pref.LOAN_ID);
        ifYesEditText = (EditText)rootView.findViewById(R.id.ifYesEditText);
        whenWasEditText = (TextView)rootView.findViewById(R.id.whenWasEditText);
        reasonForMisEditText = (EditText)rootView.findViewById(R.id.reasonForMisEditText);
        fromWhereEditText = (EditText)rootView.findViewById(R.id.fromWhereEditText);
        empTermEditText = (EditText)rootView.findViewById(R.id.empTermEditText);
        tenorTextView = (TextView)rootView.findViewById(R.id.tenorTextView);
        conEndEditText = (EditText)rootView.findViewById(R.id.conEndEditText);
        contributionEditText = (EditText)rootView.findViewById(R.id.contributionEditText);
        creditPayEditText = (EditText)rootView.findViewById(R.id.creditPayEditText);
        repaymentAccEditText = (EditText)rootView.findViewById(R.id.repaymentAccEditText);
        otherAccEditText = (EditText)rootView.findViewById(R.id.otherAccNumberEditText);
        accDetailsEditText= (EditText)rootView.findViewById(R.id.accDetailEditText);


        havUMissedEditText = (TextView)rootView.findViewById(R.id.havUMissedEditText);

        ownOrgaEditText = (TextView) rootView.findViewById(R.id.ownOrgaEditText);
        tenorTextView= (TextView) rootView.findViewById(R.id.tenorTextView);
        outstandingTextView= (EditText) rootView.findViewById(R.id.outstandingTextView);
        anyOtherTextView= (TextView) rootView.findViewById(R.id.anyOtherTextView);
        howMuchTextView= (EditText) rootView.findViewById(R.id.howMuchTextView);
        itemOfPurTextView= (TextView) rootView.findViewById(R.id.itemOfPurTextView);
        valueTextView= (TextView) rootView.findViewById(R.id.valueTextView);
        bankTextView= (TextView) rootView.findViewById(R.id.bankTextView);
        otherBankTextView= (TextView) rootView.findViewById(R.id.otherBankTextView);
        accNameEditText= (EditText)rootView.findViewById(R.id.acNameTextView);
        otherAccNameEditText = (EditText)rootView.findViewById(R.id.otherAccNameTextView);

        mConfirmButton = (Button)rootView.findViewById(R.id.button1);

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Global.DROP_DOWN_RESPONSE = gson.fromJson(Pref.loadStringPref(getActivity(),Pref.DROP_DOWN_KEY),DropDownResponse.class);

        setValues();
        setOwnMenu(rootView);
        setTenorMenu();
        setOutstandingMenu();
        setAnyOtherMenu(rootView);
        setHowMuchMenu();
        setItemOfPurMenu();
        setValueMenu();
        setBankMenu();
        setOtherBankMenu();
        setMissRePaymentMenu(rootView);

        ownOrgaEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOwnMenu.show();
            }
        });

        havUMissedEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//						showExpDateDialog();
                mHaveMissRePAyMenu.show();
            }
        });
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
        tenorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTenorMenu.show();
            }
        });
        /*outstandingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOutStandingMenu.show();
            }
        });*/
        anyOtherTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnyOtherMenu.show();
            }
        });
//        howMuchTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mHowMuchMenu.show();
//            }
//        });
        itemOfPurTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemOfPurMenu.show();
            }
        });
        valueTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueMenu.show();
            }
        });
        bankTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBankMenu.show();
            }
        });
        otherBankTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOtherBankMenu.show();
            }
        });
        whenWasEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDisburedDialog();
            }
        });

        return rootView;
    }

    private void setValues(){
        String response = Pref.loadStringPref(getActivity(),Pref.STEP_4_RESPONSE);
        if(response != null) {
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            Step4Response step4Response = gson.fromJson(response,
                    Step4Response.class);

            Log.e("Tenor",""+step4Response.getData().getTenor());
            ownOrgaEditText.setText(""+step4Response.getData().getCurrentlyOwingAnyOrganisation());
            whenWasEditText.setText(""+step4Response.getData().getDisbursed());
            tenorTextView.setText(""+step4Response.getData().getTenor());
            outstandingTextView.setText(""+step4Response.getData().getOutstanding());
            havUMissedEditText.setText(""+step4Response.getData().getMissedRepaymentDate());
            anyOtherTextView.setText(""+step4Response.getData().getOtherSourceOfIncome());
            accDetailsEditText.setText(""+step4Response.getData().getAccountDetailForRepayment());
            bankTextView.setText(""+step4Response.getData().getRepaymentBank());
            accNameEditText.setText(""+step4Response.getData().getRepaymentAccountName());
            repaymentAccEditText.setText(""+step4Response.getData().getRepaymentAccount());
            otherBankTextView.setText(""+step4Response.getData().getOtherBank());
            otherAccNameEditText.setText(""+step4Response.getData().getOtherAccountName());
            otherAccEditText.setText(""+step4Response.getData().getOtherAccount());




        }

    }


    private void callApi() {
        try {

            String URL = Utils.NEW_LOAN;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("step","step-4");
            jsonBody.put("loanId",mLoanID);
            jsonBody.put("CurrentlyOwingAnyOrganisation", ownOrgaEditText.getText().toString());
            if(ownOrgaEditText.getText().toString().equalsIgnoreCase("Yes")) {
                jsonBody.put("stateValueOfLoan", ifYesEditText.getText().toString());
                jsonBody.put("disbursed", whenWasEditText.getText().toString());
            }

            jsonBody.put("tenor", tenorTextView.getText().toString());
            jsonBody.put("outstanding", outstandingTextView.getText().toString());
            jsonBody.put("missedRepaymentDate", havUMissedEditText.getText().toString());
//            jsonBody.put("reasonForMissingRepayment", reasonForMisEditText.getText().toString());
            jsonBody.put("otherSourceOfIncome", anyOtherTextView.getText().toString());
//            jsonBody.put("fromWhere", fromWhereEditText.getText().toString());
            jsonBody.put("month", howMuchTextView.getText().toString());
//            jsonBody.put("employmentTerm", empTermEditText.getText().toString());
//            jsonBody.put("tenorOfContract", tenorEditText.getText().toString());
//            jsonBody.put("contractEnding", conEndEditText.getText().toString());
//            jsonBody.put("itemOfPurchase", itemOfPurTextView.getText().toString());
//            jsonBody.put("value", valueTextView.getText().toString());
//            jsonBody.put("contribution", contributionEditText.getText().toString());
//            jsonBody.put("tenorOfCreditPayment", tenorEditText.getText().toString());
            jsonBody.put("accountDetailForRepayment", accDetailsEditText.getText().toString());
            jsonBody.put("repaymentAccount", repaymentAccEditText.getText().toString());
            jsonBody.put("repaymentAccountName", accNameEditText.getText().toString());
            jsonBody.put("repaymentBank", bankTextView.getText().toString());
            jsonBody.put("otherAccount", otherAccEditText.getText().toString());
            jsonBody.put("otherBank", otherBankTextView.getText().toString());
            jsonBody.put("otherAccountName", otherAccNameEditText.getText().toString());


            if(((RegisterFormsActivity)getActivity()).isFromEdit ){
                if(((RegisterFormsActivity)getActivity()).isUserCanEdit){
                    new Utils().callApis(getActivity(),URL,jsonBody,LoanInfoFragment.this);
                }else{
                    Toast.makeText(getActivity(),"Sorry you can not edit data",Toast.LENGTH_SHORT).show();
                }
            }else{
                new Utils().callApis(getActivity(),URL,jsonBody,LoanInfoFragment.this);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String method,String response) {
        parseData(response);
    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Step4Response step4Response = gson.fromJson(resString,
                Step4Response.class);

        if(step4Response.getStatus()){
//            Pref.saveStringPref(getActivity(),Pref.LOAN_ID,step4Response.getData().getId());
            Pref.saveStringPref(getActivity(),Pref.STEP_4_RESPONSE,resString);

            if(!((RegisterFormsActivity)getActivity()).isFromEdit()) {
                Pref.saveIntPref(getActivity(),Pref.REGISTRATION_STEP,4);
                Intent intent = new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }


            Toast.makeText(getActivity(),step4Response.getMessage(),Toast.LENGTH_LONG).show();


        }else{
            new Utils().showErrorDialog(getActivity(),step4Response.getMessage());
        }

    }




    private void showDisburedDialog(){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        whenWasEditText.setText((monthOfYear + 1) + "/" +dayOfMonth + "/"  + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    private void setOwnMenu(final View rootView){
        Log.e("Drop Respo"," == "+Global.DROP_DOWN_RESPONSE);
        mOwnMenu = new PopupMenu(getActivity(),ownOrgaEditText);
        mOwnMenu.getMenu().add(0,0,0,"Yes");
        mOwnMenu.getMenu().add(1,1,1,"No");
        mOwnMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                ownOrgaEditText.setText(item.getTitle());
                if(item.getItemId() == 0){
                    rootView.findViewById(R.id.ifYesLayout).setVisibility(View.VISIBLE);
                    whenWasEditText.setVisibility(View.VISIBLE);
                }else{
                    rootView.findViewById(R.id.ifYesLayout).setVisibility(View.GONE);
                    whenWasEditText.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }

    private void setMissRePaymentMenu(final View rootView){

        mHaveMissRePAyMenu = new PopupMenu(getActivity(),havUMissedEditText);
        mHaveMissRePAyMenu.getMenu().add(0,0,0,"Yes");
        mHaveMissRePAyMenu.getMenu().add(1,1,1,"No");
        mHaveMissRePAyMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                havUMissedEditText.setText(item.getTitle());
//                if(item.getItemId() == 0){
//                    rootView.findViewById(R.id.missingReLayout).setVisibility(View.VISIBLE);
//                }else{
//                    rootView.findViewById(R.id.missingReLayout).setVisibility(View.GONE);
//                }
                return false;
            }
        });
    }
    private void setTenorMenu(){

        mTenorMenu = new PopupMenu(getActivity(),tenorTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTenor().size(); i++){
            mTenorMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTenor().get(i));
        }
        mTenorMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tenorTextView.setText(item.getTitle());
                return false;
            }
        });
    }

    private void setOutstandingMenu(){

        mOutStandingMenu = new PopupMenu(getActivity(),outstandingTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAnnualRevenue().size(); i++){
            mOutStandingMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAnnualRevenue().get(i));
        }
        mOutStandingMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                outstandingTextView.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setAnyOtherMenu(final View rootView){

        mAnyOtherMenu = new PopupMenu(getActivity(),anyOtherTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getOtherSourseOfIncome().size(); i++){
            mAnyOtherMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getOtherSourseOfIncome().get(i));
        }
        mAnyOtherMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                anyOtherTextView.setText(item.getTitle());
                if(item.getTitle().toString().equalsIgnoreCase("Yes")){
                    rootView.findViewById(R.id.howmuchLayout).setVisibility(View.VISIBLE);

                }else{
                    rootView.findViewById(R.id.howmuchLayout).setVisibility(View.GONE);

                }

                return false;
            }
        });
    }

    private void setHowMuchMenu(){

        mHowMuchMenu = new PopupMenu(getActivity(),howMuchTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getHowmuchMonth().size(); i++){
            mHowMuchMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getHowmuchMonth().get(i));
        }
        mHowMuchMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                howMuchTextView.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setItemOfPurMenu(){

        mItemOfPurMenu = new PopupMenu(getActivity(),itemOfPurTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfHouse().size(); i++){
            mItemOfPurMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfHouse().get(i));
        }
        mItemOfPurMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                itemOfPurTextView.setText(item.getTitle());
                return false;
            }
        });
    }

    private void setValueMenu(){

        mValueMenu = new PopupMenu(getActivity(),valueTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTenor().size(); i++){
            mValueMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTenor().get(i));
        }
        mValueMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                valueTextView.setText(item.getTitle());
                return false;
            }
        });
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

    private void setOtherBankMenu(){

        mOtherBankMenu = new PopupMenu(getActivity(),otherBankTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getOtherBank().size(); i++){
            mOtherBankMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getOtherBank().get(i));
        }
        mOtherBankMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                otherBankTextView.setText(item.getTitle());
                return false;
            }
        });
    }
}