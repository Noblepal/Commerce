package com.retailboosters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.fragment.ContactFragment;
import com.retailboosters.fragment.EmploymentFragment;
import com.retailboosters.fragment.LoanInfoFragment;
import com.retailboosters.fragment.PersonalDetailsFragment;
import com.retailboosters.response.GetLoanDetailsResponse;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.response.Step1Response;
import com.retailboosters.response.Step2Response;
import com.retailboosters.response.Step3Response;
import com.retailboosters.response.Step4Response;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterFormsActivity   extends AppCompatActivity implements OnApiResponse {
    TextView oneTextView,twoTextView,threeTextView,fourTextView;
    View includeView;
    Fragment mCurrentFragment;
    public boolean isUserCanEdit= false;
    public boolean isFromEdit= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_forms);

        includeView = (View)findViewById(R.id.includeLayout);

        String fName = getIntent().getStringExtra("fName");
        String lName = getIntent().getStringExtra("lName");

        String dob = getIntent().getStringExtra("dob");

        oneTextView = (TextView)includeView.findViewById(R.id.oneTV);
        twoTextView = (TextView)includeView.findViewById(R.id.twoTv);
        threeTextView = (TextView)includeView.findViewById(R.id.threeTv);
        fourTextView = (TextView)includeView.findViewById(R.id.fourTv);

        isFromEdit = getIntent().getBooleanExtra("isEdit",false);

        if(isFromEdit){
            getLoanDetails();
        }else{
            callFragment(fName,lName,dob,false);
        }



    }

    private void callFragment(String fName,String lName,String dob,boolean isEditForm){
        if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) == -1 ||isEditForm){
            PersonalDetailsFragment personalDetailsFragment = new PersonalDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("fName",fName);
            bundle.putString("lName",lName);
            bundle.putString("dob",dob);
            personalDetailsFragment.setArguments(bundle);
            loadFragment(personalDetailsFragment);
            oneTextView.setSelected(true);
            oneTextView.setTextColor(getResources().getColor(R.color.white));
        }else if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) == 1){
            loadFragment(new ContactFragment());
            twoTextView.setSelected(true);
            twoTextView.setTextColor(getResources().getColor(R.color.white));
        }if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) == 2){
            loadFragment(new EmploymentFragment());
            threeTextView.setSelected(true);
            threeTextView.setTextColor(getResources().getColor(R.color.white));
        }if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) == 3){
            loadFragment(new LoanInfoFragment());
            fourTextView.setSelected(true);
            fourTextView.setTextColor(getResources().getColor(R.color.white));
        }
    }

    private void getLoanDetails(){


        try {

            String URL = Utils.GET_LOAN_DETAILS;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("loanId", Pref.loadStringPref(RegisterFormsActivity.this,Pref.LOAN_ID));
            new Utils().callApis(RegisterFormsActivity.this,URL,jsonBody,RegisterFormsActivity.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(String method, String response) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetLoanDetailsResponse getLoanDetailsResponse = gson.fromJson(response,
                GetLoanDetailsResponse.class);
        if(getLoanDetailsResponse.getStatus()){

            isUserCanEdit = getLoanDetailsResponse.getData().getEditApplicationForm();

            Step1Response step1Response = new Step1Response();
            Step1Response.Data data= step1Response.new Data();
            data.setFirstName(getLoanDetailsResponse.getData().getFirstName());
            data.setLastName(getLoanDetailsResponse.getData().getLastName());
            data.setTitle(getLoanDetailsResponse.getData().getTitle());
            data.setGender(getLoanDetailsResponse.getData().getGender());
            data.setMeansOfIdentification(getLoanDetailsResponse.getData().getMeansOfIdentification());
            data.setMaritalStatus(getLoanDetailsResponse.getData().getMaritalStatus());
            data.setIdentificationNumber(getLoanDetailsResponse.getData().getIdentificationNumber());
            data.setExpiryDateOfId(getLoanDetailsResponse.getData().getExpiryDateOfId());
            data.setDateOfBirth(getLoanDetailsResponse.getData().getDateOfBirth());
            data.setNumberOfDependents(getLoanDetailsResponse.getData().getNumberOfDependents());
            data.setEducationalBackGround(getLoanDetailsResponse.getData().getEducationalBackGround());
            data.setAge(getLoanDetailsResponse.getData().getAge());
            step1Response.setData(data);
            String json = gson.toJson(step1Response);
            Pref.saveStringPref(RegisterFormsActivity.this,Pref.STEP_1_RESPONSE,json);


            Step2Response step2Response = new Step2Response();
            Step2Response.Data data2 = step2Response.new Data();
            data2.setMobileNo1(getLoanDetailsResponse.getData().getMobileNo1());
            data2.setLengthOfStay(getLoanDetailsResponse.getData().getLengthOfStay());
            data2.setMobileNo2(getLoanDetailsResponse.getData().getMobileNo2());
            data2.setHomeAddress(getLoanDetailsResponse.getData().getHomeAddress());
            data2.setNearestBusStop(getLoanDetailsResponse.getData().getNearestBusStop());
            data2.setBuildingDiscription(getLoanDetailsResponse.getData().getBuildingDiscription());
            data2.setState(getLoanDetailsResponse.getData().getState1());
            data2.setContactLga(getLoanDetailsResponse.getData().getContactLga());
            data2.setTypeOfApartment(getLoanDetailsResponse.getData().getTypeOfApartment());
            data2.setAccomodationType(getLoanDetailsResponse.getData().getAccomodationType());
            data2.setHowtogetToYourHome(getLoanDetailsResponse.getData().getHowtogetToYourHome());
            data2.setCommonNameCalledAtHome(getLoanDetailsResponse.getData().getCommonNameCalledAtHome());
            data2.setRefereeName(getLoanDetailsResponse.getData().getRefereeName());
            data2.setRefereeMobileNo(getLoanDetailsResponse.getData().getRefereeMobileNo());
            data2.setSpouseName(getLoanDetailsResponse.getData().getSpouseName());
            data2.setSpouseMobileNo(getLoanDetailsResponse.getData().getSpouseMobileNo());
            data2.setSpouseEmail(getLoanDetailsResponse.getData().getSpouseEmail());
            step2Response.setData(data2);
            String json2= gson.toJson(step2Response);
            Pref.saveStringPref(RegisterFormsActivity.this,Pref.STEP_2_RESPONSE,json2);



            Step3Response step3Response = new Step3Response();
            Step3Response.Data data3 = step3Response.new Data();
            data3.setEmploymentStatus(getLoanDetailsResponse.getData().getEmploymentStatus());
            data3.setCompanyName(getLoanDetailsResponse.getData().getCompanyName());
            data3.setCompanyAddress(getLoanDetailsResponse.getData().getCompanyAddress());
            data3.setCompanyHrContactNumber(getLoanDetailsResponse.getData().getCompanyHrContactNumber());
            data3.setCompanyHrEmail(getLoanDetailsResponse.getData().getCompanyHrEmail());
            data3.setTimeAtOrganisation(getLoanDetailsResponse.getData().getTimeAtOrganisation());
            data3.setNetMonthlySalary(getLoanDetailsResponse.getData().getNetMonthlySalary());
            data3.setEmploymentTerm(getLoanDetailsResponse.getData().getEmploymentTerm());
            step3Response.setData(data3);
            String json3= gson.toJson(step3Response);
            Pref.saveStringPref(RegisterFormsActivity.this,Pref.STEP_3_RESPONSE,json3);



            Step4Response step4Response = new Step4Response();
            Step4Response.Data data4 = step4Response.new Data();

            data4.setCurrentlyOwingAnyOrganisation(getLoanDetailsResponse.getData().getCurrentlyOwingAnyOrganisation());
            data4.setStateValueOfLoan(getLoanDetailsResponse.getData().getStateValueOfLoan());
            data4.setDisbursed(getLoanDetailsResponse.getData().getDisbursed());
            data4.setTenor(""+getLoanDetailsResponse.getData().getTenor());
            data4.setOutstanding(getLoanDetailsResponse.getData().getOutstanding());
            data4.setMissedRepaymentDate(getLoanDetailsResponse.getData().getMissedRepaymentDate());
            data4.setOtherSourceOfIncome(getLoanDetailsResponse.getData().getOtherSourceOfIncome());
            data4.setMonth(getLoanDetailsResponse.getData().getMonth());
            data4.setRepaymentAccount(getLoanDetailsResponse.getData().getRepaymentAccount());
            data4.setRepaymentBank(getLoanDetailsResponse.getData().getRepaymentBank());
            data4.setOtherAccount(getLoanDetailsResponse.getData().getOtherAccount());
            data4.setOtherBank(getLoanDetailsResponse.getData().getOtherBank());
            data4.setRepaymentAccountName(getLoanDetailsResponse.getData().getRepaymentAccountName());
            data4.setAccountDetailForRepayment(getLoanDetailsResponse.getData().getAccountDetailForRepayment());
            data4.setOtherAccountName(getLoanDetailsResponse.getData().getOtherAccountName());
            step4Response.setData(data4);
            String json4= gson.toJson(step4Response);
            Pref.saveStringPref(RegisterFormsActivity.this,Pref.STEP_4_RESPONSE,json4);



            callFragment(getLoanDetailsResponse.getData().getFirstName(),getLoanDetailsResponse.getData().getLastName()
                    ,getLoanDetailsResponse.getData().getDateOfBirth(),true);


        }

    }

    public boolean isUserCanEdit() {
        return isUserCanEdit;
    }

    public boolean isFromEdit() {
        return isFromEdit;
    }

    @Override
    public void onError(String response) {

    }

    public void onClickNumber(View v) {

        switch (v.getId()){
            case R.id.oneTV :


                if(mCurrentFragment instanceof PersonalDetailsFragment){
                    v.setSelected(true);
                    ((TextView)v).setTextColor(getResources().getColor(R.color.white));
                    twoTextView.setSelected(false);
                    twoTextView.setTextColor(getResources().getColor(R.color.red));
                    threeTextView.setSelected(false);
                    threeTextView.setTextColor(getResources().getColor(R.color.red));
                    fourTextView.setSelected(false);
                    fourTextView.setTextColor(getResources().getColor(R.color.red));
                }else{
                    if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) >= 0){

                        loadFragment(new PersonalDetailsFragment());

                    }
                }

                break;

            case R.id.twoTv :



                if(mCurrentFragment instanceof ContactFragment){
                    v.setSelected(true);
                    ((TextView)v).setTextColor(getResources().getColor(R.color.white));
                    oneTextView.setSelected(false);
                    oneTextView.setTextColor(getResources().getColor(R.color.red));
                    threeTextView.setSelected(false);
                    threeTextView.setTextColor(getResources().getColor(R.color.red));
                    fourTextView.setSelected(false);
                    fourTextView.setTextColor(getResources().getColor(R.color.red));
                }else{
                    if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) >= 1){

                        loadFragment(new ContactFragment());

                    }
                }
                break;
            case R.id.threeTv :


                if(mCurrentFragment instanceof EmploymentFragment){
                    v.setSelected(true);
                    ((TextView)v).setTextColor(getResources().getColor(R.color.white));
                    oneTextView.setSelected(false);
                    oneTextView.setTextColor(getResources().getColor(R.color.red));
                    twoTextView.setSelected(false);
                    twoTextView.setTextColor(getResources().getColor(R.color.red));
                    fourTextView.setSelected(false);
                    fourTextView.setTextColor(getResources().getColor(R.color.red));
                }else{
                    if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) >= 2){


                        loadFragment(new EmploymentFragment());


                    }
                }
                break;
            case R.id.fourTv :
                if(mCurrentFragment instanceof LoanInfoFragment){
                    v.setSelected(true);
                    ((TextView)v).setTextColor(getResources().getColor(R.color.white));

                    oneTextView.setSelected(false);
                    oneTextView.setTextColor(getResources().getColor(R.color.red));
                    twoTextView.setSelected(false);
                    twoTextView.setTextColor(getResources().getColor(R.color.red));
                    threeTextView.setSelected(false);
                    threeTextView.setTextColor(getResources().getColor(R.color.red));
                }else{
                    if(Pref.loadIntPref(RegisterFormsActivity.this,Pref.REGISTRATION_STEP) >= 3){

                        loadFragment(new LoanInfoFragment());


                    }
                }

                break;
        }

    }
    public void onCurrentFragment(Fragment currentFragment){
        mCurrentFragment = currentFragment;
        if(currentFragment instanceof PersonalDetailsFragment){
            onClickNumber(oneTextView);
        }else if(currentFragment instanceof ContactFragment){
            onClickNumber(twoTextView);
        }else if(currentFragment instanceof EmploymentFragment){
            onClickNumber(threeTextView);
        }else if(currentFragment instanceof LoanInfoFragment){
            onClickNumber(fourTextView);
        }

    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
