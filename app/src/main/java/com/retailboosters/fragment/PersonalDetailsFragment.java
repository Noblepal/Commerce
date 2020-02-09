package com.retailboosters.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.retailboosters.R;
import com.retailboosters.RegisterFormsActivity;
import com.retailboosters.response.DropDownResponse;
import com.retailboosters.response.Step1Response;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class PersonalDetailsFragment  extends Fragment implements OnApiResponse {

    private EditText mFnameEditText,mLnameEditText,mIdNumEditText,mResiAddEditText;
    private TextView mTitleTextView,mGenderTextView,mMeanIdTextView,mNumOfDeptTextView,mEduBgTextView
            ,mExpDateEditText,mDobEditText,mMerrStatusTextView,mAgeEditText;

    private PopupMenu mMarrStatusPopupMenu,mTitleMenu,mGenderMenu,mIdMenu,mNumDepMenu,mEduMenu,mAgeMenu;

    private Button mConfirmButton;
    FragmentTransaction transaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.personal_details, container, false);
        ((RegisterFormsActivity)getActivity()).onCurrentFragment(PersonalDetailsFragment.this);
        transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();

        mFnameEditText = (EditText)rootView.findViewById(R.id.fNameEditext);
        mLnameEditText = (EditText)rootView.findViewById(R.id.lNameEdittext);
        mIdNumEditText = (EditText)rootView.findViewById(R.id.idNumTextView);
        mDobEditText = (TextView)rootView.findViewById(R.id.dobEdittext);

        if(getArguments() != null ) {
            mFnameEditText.setText(getArguments().getString("fName"));
            mLnameEditText.setText(getArguments().getString("lName"));
            mDobEditText.setText(getArguments().getString("dob"));
        }

        mAgeEditText = (TextView)rootView.findViewById(R.id.ageEdittext);
        mResiAddEditText = (EditText)rootView.findViewById(R.id.resAddTextView);

        mTitleTextView = (TextView) rootView.findViewById(R.id.titleTextView);
        mGenderTextView = (TextView) rootView.findViewById(R.id.genderTextView);
        mMeanIdTextView = (TextView) rootView.findViewById(R.id.meansOfIdTv);
        mNumOfDeptTextView = (TextView) rootView.findViewById(R.id.numDeptTv);
        mEduBgTextView = (TextView) rootView.findViewById(R.id.eduBgTextView);
        mExpDateEditText = (TextView)rootView.findViewById(R.id.expDateEdittext);
        mMerrStatusTextView= (TextView)rootView.findViewById(R.id.marriedStatusTv);

        mConfirmButton = (Button)rootView.findViewById(R.id.confirmButton);

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Global.DROP_DOWN_RESPONSE = gson.fromJson(Pref.loadStringPref(getActivity(),Pref.DROP_DOWN_KEY),DropDownResponse.class);

        setValues();
        setAgeMenu();
        setTitleMenu();
        setGenderMenu();
        setIdMenu();
        setNumDeptMenu();
        setEduMenu();
        setMarriedStatusMenu();

        mAgeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAgeMenu.show();
            }
        });
        mTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTitleMenu.show();
            }
        });
        mGenderTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mGenderMenu.show();
            }
        });

        mMeanIdTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mIdMenu.show();
            }
        });

        mNumOfDeptTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mNumDepMenu.show();
            }
        });

        mEduBgTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEduMenu.show();
            }
        });

        mDobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDobDialog();
            }
        });
        mMerrStatusTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMarrStatusPopupMenu.show();
            }
        });
        mExpDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExpDateDialog();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

        if(getArguments() != null && getArguments().getString("fName") != null){
            mFnameEditText.setText(getArguments().getString("fName"));
            //mFnameEditText.setEnabled(false);
        }
        if(getArguments() != null && getArguments().getString("lName") != null){
            mLnameEditText.setText(getArguments().getString("lName") );
            //mLnameEditText.setEnabled(false);
        }
        return rootView;
    }

    private void setValues(){

        String response = Pref.loadStringPref(getActivity(),Pref.STEP_1_RESPONSE);
        if(response != null){
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            Step1Response step1Response = gson.fromJson(response,
                    Step1Response.class);

            mFnameEditText.setText(step1Response.getData().getFirstName());
            mLnameEditText.setText(step1Response.getData().getLastName());
            mTitleTextView.setText(step1Response.getData().getTitle());
            mGenderTextView.setText(step1Response.getData().getGender());
            mMerrStatusTextView.setText(step1Response.getData().getMaritalStatus());
            mMeanIdTextView.setText(step1Response.getData().getMeansOfIdentification());
            mIdNumEditText.setText(step1Response.getData().getIdentificationNumber());
            mExpDateEditText.setText(step1Response.getData().getExpiryDateOfId());
            mDobEditText.setText(step1Response.getData().getDateOfBirth());
            mNumOfDeptTextView.setText(""+step1Response.getData().getNumberOfDependents());
            mEduBgTextView.setText(step1Response.getData().getEducationalBackGround());
            mResiAddEditText.setText(step1Response.getData().getResidentialAddress());
            mAgeEditText.setText(""+step1Response.getData().getAge());

        }


    }

    private void callApi() {
        try {

            String URL = Utils.NEW_LOAN;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("step","step-1");
            jsonBody.put("firstName",mFnameEditText.getText().toString() );
            jsonBody.put("lastName", mLnameEditText.getText().toString());
            jsonBody.put("title", mTitleTextView.getText().toString());
            jsonBody.put("gender", mGenderTextView.getText().toString());
            jsonBody.put("maritalStatus", mMerrStatusTextView.getText().toString());
            jsonBody.put("meansOfIdentification", mMeanIdTextView.getText().toString());
            jsonBody.put("identificationNumber", mIdNumEditText.getText().toString());
            jsonBody.put("expiryDateOfId", mExpDateEditText.getText().toString());
            jsonBody.put("dateOfBirth", mDobEditText.getText().toString());
            jsonBody.put("numberOfDependents", mNumOfDeptTextView.getText().toString());
            jsonBody.put("age", mAgeEditText.getText().toString());
            jsonBody.put("educationalBackGround", mEduBgTextView.getText().toString());
//            jsonBody.put("residentialAddress", mResiAddEditText.getText().toString());


            if(((RegisterFormsActivity)getActivity()).isFromEdit ){
                if(((RegisterFormsActivity)getActivity()).isUserCanEdit){
                    jsonBody.put("loanId",Pref.loadStringPref(getActivity(),Pref.LOAN_ID));
                    new Utils().callApis(getActivity(),URL,jsonBody,PersonalDetailsFragment.this);
                }else{
                    Toast.makeText(getActivity(),"Sorry you can not edit data",Toast.LENGTH_SHORT).show();
                }
            }else{
                new Utils().callApis(getActivity(),URL,jsonBody,PersonalDetailsFragment.this);
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

        Step1Response step1Response = gson.fromJson(resString,
                Step1Response.class);

        if(step1Response.getStatus()){
            Pref.saveStringPref(getActivity(),Pref.FIRST_NAME,step1Response.getData().getFirstName());
            Pref.saveStringPref(getActivity(),Pref.LOAN_ID,step1Response.getData().getId());
            if(!((RegisterFormsActivity)getActivity()).isFromEdit()) {
                Pref.saveIntPref(getActivity(),Pref.REGISTRATION_STEP,1);
            }

            Pref.saveStringPref(getActivity(),Pref.STEP_1_RESPONSE,resString);

            Toast.makeText(getActivity(),step1Response.getMessage(),Toast.LENGTH_LONG).show();

            loadFragment(new ContactFragment());
            /*Intent intent = new Intent(getActivity(),ContactActivity.class);
            intent.putExtra("loanID",step1Response.getData().getId());
            startActivity(intent);*/

        }else{
            new Utils().showErrorDialog(getActivity(),step1Response.getMessage());
        }

    }
    /*private void loadFragment(Fragment fragment){
//        fragmentHome.setArguments(bundle);
        // put the fragment in place
        transaction.replace(R.id.content_frame, fragment);

        // this is the part that will cause a fragment to be added to backstack,
        // this way we can return to it at any time using this tag
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(fragment.getClass().getName());

        transaction.commit();
    }*/

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getActivity().getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit(); // save the changes
    }



    private void setAgeMenu(){

        mAgeMenu = new PopupMenu(getActivity(),mAgeEditText);
//        mAgeMenu.getMenu().add(0,0,0,"18-25");
//        mAgeMenu.getMenu().add(0,0,0,"26-30");
//        mAgeMenu.getMenu().add(0,0,0,"31-40");
//        mAgeMenu.getMenu().add(0,0,0,"41-50");
//        mAgeMenu.getMenu().add(0,0,0,"51-60");
//        mAgeMenu.getMenu().add(0,0,0,"61-69");
//        mAgeMenu.getMenu().add(0,0,0,"above 70");

        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAgeBand().size();i++){
            mAgeMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAgeBand().get(i));
        }
        mAgeMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mAgeEditText.setText(item.getTitle());
                return false;
            }
        });
    }
    private void setTitleMenu(){

        mTitleMenu = new PopupMenu(getActivity(),mTitleTextView);

        Log.e("Drop Respo"," == "+Global.DROP_DOWN_RESPONSE);
        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTitle().size();i++){
            mTitleMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTitle().get(i));
        }


        mTitleMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mTitleTextView.setText(item.getTitle());
                return false;
            }
        });
    }
    private void setMarriedStatusMenu(){

        mMarrStatusPopupMenu = new PopupMenu(getActivity(),mMerrStatusTextView);

        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getMaritalStatus().size();i++){
            mMarrStatusPopupMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getMaritalStatus().get(i));
        }

        mMarrStatusPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mMerrStatusTextView.setText(item.getTitle());
                return false;
            }
        });
    }
    private void setGenderMenu(){

        mGenderMenu = new PopupMenu(getActivity(),mGenderTextView);
        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getGender().size();i++){
            mGenderMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getGender().get(i));
        }
        mGenderMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mGenderTextView.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setIdMenu(){

        mIdMenu = new PopupMenu(getActivity(),mMeanIdTextView);
        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getMeansOfIdentification().size();i++){
            mIdMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getMeansOfIdentification().get(i));
        }

        mIdMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mMeanIdTextView.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setNumDeptMenu(){

        mNumDepMenu = new PopupMenu(getActivity(),mNumOfDeptTextView);
        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getNumberOfDependents().size();i++){
            mNumDepMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getNumberOfDependents().get(i));
        }
        mNumDepMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mNumOfDeptTextView.setText(item.getTitle());
                return false;
            }
        });
    }

    private void setEduMenu(){

        mEduMenu = new PopupMenu(getActivity(),mEduBgTextView);
        for(int i=0;i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getEducationalBackground().size();i++){
            mEduMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getEducationalBackground().get(i));
        }
        mEduMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                mEduBgTextView.setText(item.getTitle());
                return false;
            }
        });
    }



    private void showExpDateDialog(){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mExpDateEditText.setText((monthOfYear + 1) + "/" +dayOfMonth + "/"  + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showDobDialog(){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mDobEditText.setText((monthOfYear + 1) + "/" +dayOfMonth + "/"  + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}