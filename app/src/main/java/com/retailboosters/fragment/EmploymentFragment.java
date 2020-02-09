package com.retailboosters.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.RegisterFormsActivity;
import com.retailboosters.response.DropDownResponse;
import com.retailboosters.response.Step3Response;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EmploymentFragment  extends Fragment implements OnApiResponse {
    private EditText offAddEditText,offEmailEditText,offPhoneEditText,
            netSalaryEditText,companyNameEditText;
    private AutoCompleteTextView whereWorkEdittext;

    private TextView empStatusEditText,timeAtOrgTextView,empTermTextView;

    private PopupMenu mEmpStatusMenu,mTimeAtOrgMenu,mEmpTermMenu;
    private String mLoanID ="";
    FragmentTransaction transaction;
    private Button mConfirmButton;
    ArrayAdapter<String> adapter;
    ArrayList<String> nameList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_employment, container, false);
        transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        ((RegisterFormsActivity)getActivity()).onCurrentFragment(EmploymentFragment.this);

        empStatusEditText = (TextView)rootView.findViewById(R.id.empStatusET);
        offAddEditText = (EditText)rootView.findViewById(R.id.offAddET);
        offEmailEditText = (EditText)rootView.findViewById(R.id.offEmailET);
        offPhoneEditText = (EditText)rootView.findViewById(R.id.offNumberET);
        netSalaryEditText = (EditText)rootView.findViewById(R.id.netSalaryET);
        whereWorkEdittext = (AutoCompleteTextView)rootView.findViewById(R.id.deptET);
        whereWorkEdittext.setThreshold(2);

        companyNameEditText= (EditText)rootView.findViewById(R.id.companyNameET);
        timeAtOrgTextView = (TextView) rootView.findViewById(R.id.timeOrgaTv);
        empTermTextView = (TextView) rootView.findViewById(R.id.empTermTv);

        mConfirmButton = (Button)rootView.findViewById(R.id.button1);


        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Global.DROP_DOWN_RESPONSE = gson.fromJson(Pref.loadStringPref(getActivity(),Pref.DROP_DOWN_KEY),DropDownResponse.class);


        setEmpStatusMenu();
        setTimeAtOrgMenu();
        setEmpTermMenu();
//        mLoanID = getArguments().getString("loanID");
        mLoanID = Pref.loadStringPref(getActivity(),Pref.LOAN_ID);

        setValues();


        whereWorkEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                new Utils().callGetApi(getActivity(),Utils.SERCH_COMPANY+whereWorkEdittext.getText().toString().trim(),
                        EmploymentFragment.this,
                        false);
            }
        });

        whereWorkEdittext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                whereWorkEdittext.setText(adapter.getItem(position));



            }
        });


        timeAtOrgTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimeAtOrgMenu.show();
            }
        });




        empStatusEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmpStatusMenu.show();
            }
        });
        empTermTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmpTermMenu.show();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });




        return rootView;
    }

    private void setValues(){

        String response = Pref.loadStringPref(getActivity(),Pref.STEP_3_RESPONSE);
        if(response != null){
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            Step3Response step3Response = gson.fromJson(response,
                    Step3Response.class);

            empStatusEditText.setText(step3Response.getData().getEmploymentStatus());
            companyNameEditText.setText(step3Response.getData().getCompanyName());
            offAddEditText.setText(step3Response.getData().getCompanyAddress());
            offEmailEditText.setText(step3Response.getData().getCompanyHrEmail());
            timeAtOrgTextView.setText(step3Response.getData().getTimeAtOrganisation());
            offPhoneEditText.setText(step3Response.getData().getCompanyHrContactNumber());
            netSalaryEditText.setText(step3Response.getData().getNetMonthlySalary());
            empTermTextView.setText(step3Response.getData().getEmploymentTerm());


        }


    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getActivity().getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    private void callApi() {
        try {

            String URL = Utils.NEW_LOAN;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("step","step-3");
            jsonBody.put("loanId",mLoanID);
            jsonBody.put("employmentStatus", empStatusEditText.getText().toString());
            jsonBody.put("companyName", companyNameEditText.getText().toString());
            jsonBody.put("companyAddress", offAddEditText.getText().toString());

            jsonBody.put("companyHrContactNumber", "+234"+offPhoneEditText.getText().toString());
            jsonBody.put("companyHrEmail", offEmailEditText.getText().toString());
            jsonBody.put("timeAtOrganisation", timeAtOrgTextView.getText().toString());
            jsonBody.put("netMonthlySalary", netSalaryEditText.getText().toString());
            jsonBody.put("employmentTerm", empTermTextView.getText().toString());

            if(((RegisterFormsActivity)getActivity()).isFromEdit ){
                if(((RegisterFormsActivity)getActivity()).isUserCanEdit){
                    new Utils().callApis(getActivity(),URL,jsonBody,EmploymentFragment.this);
                }else{
                    Toast.makeText(getActivity(),"Sorry you can not edit data",Toast.LENGTH_SHORT).show();
                }
            }else{
                new Utils().callApis(getActivity(),URL,jsonBody,EmploymentFragment.this);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String method,String response) {
        if(method.startsWith(Utils.SERCH_COMPANY)){
            parseCompanyData(response);
        }else {
            parseData(response);
        }
    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Step3Response step3Response = gson.fromJson(resString,
                Step3Response.class);

        if(step3Response.getStatus()){
            if(!((RegisterFormsActivity)getActivity()).isFromEdit()) {
                Pref.saveIntPref(getActivity(), Pref.REGISTRATION_STEP, 3);
            }
            Pref.saveStringPref(getActivity(),Pref.STEP_3_RESPONSE,resString);
            Pref.saveStringPref(getActivity(),Pref.WHERE_WORK,whereWorkEdittext.getText().toString());

            Toast.makeText(getActivity(),step3Response.getMessage(),Toast.LENGTH_LONG).show();
            loadFragment(new LoanInfoFragment());
            /*Intent intent = new Intent(getActivity(),LoanInfoActivity.class);
            intent.putExtra("loanID",step3Response.getData().getId());
            startActivity(intent);*/

        }else{
            new Utils().showErrorDialog(getActivity(),step3Response.getMessage());
        }

    }

    private void parseCompanyData(String resString){
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        nameList.clear();
        whereWorkEdittext.setAdapter(null);
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
            whereWorkEdittext.setAdapter(adapter);
            whereWorkEdittext.showDropDown();



        }catch (Exception e){

        }

    }


    private void setEmpStatusMenu(){

        mEmpStatusMenu = new PopupMenu(getActivity(),empStatusEditText);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getEmployementStatus().size(); i++){
            mEmpStatusMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getEmployementStatus().get(i));
        }

        mEmpStatusMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                empStatusEditText.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setTimeAtOrgMenu(){

        mTimeAtOrgMenu = new PopupMenu(getActivity(),timeAtOrgTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTimeAtOrganisation().size(); i++){
            mTimeAtOrgMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTimeAtOrganisation().get(i));
        }
        mTimeAtOrgMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                timeAtOrgTextView.setText(item.getTitle());
                return false;
            }
        });
    }


    private void setEmpTermMenu(){

        mEmpTermMenu = new PopupMenu(getActivity(),empTermTextView);
        mEmpTermMenu.getMenu().add(0,0,0,"Permanent");
        mEmpTermMenu.getMenu().add(0,1,0,"Contract ");
        mEmpTermMenu.getMenu().add(0,2,0,"Contract tenor less than 1 year");
        mEmpTermMenu.getMenu().add(0,3,0,"Contract tenor more than 1 year");



        mEmpTermMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                empTermTextView.setText(item.getTitle());
                return false;
            }
        });
    }


}
