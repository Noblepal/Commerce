package com.retailboosters.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.retailboosters.response.GetLgaFromStateResponse;
import com.retailboosters.response.Step2Response;
import com.retailboosters.utils.Global;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContactFragment  extends Fragment implements OnApiResponse {

    private EditText mobEditText,mob2EditText,mob3EditText,emailEditText,homeAddEditText,busStopEditText,buildDescEditText,
            descNameEditText,commonNameEditText,prevResiAddEditText,prevBusstopEditText,buildDescPrevEditText,prevLGAEditText,prevLengthStayEditText,refreeNameEditText,
            refreeMobEditText,souseNameEditText,souseMobileEditText,spouseEmailEditText;

    private TextView stateTextView,tohTextView,toaTextView,accTypeTextView,lenghStayEditText;
    private PopupMenu mTOHMenu,mTOAMenu,mAccoTypeMenu,mStateMenu,mLGAMenu,mLOSMenu;
    private AutoCompleteTextView lgaTextView;

    private String mLoanID ="";
    FragmentTransaction transaction;
    private Button mConfirmButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_contact, container, false);
        transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        mobEditText = (EditText)rootView.findViewById(R.id.mobNum1Edittext);
        mob2EditText = (EditText)rootView.findViewById(R.id.mobNum2Edittext);
        mob3EditText = (EditText)rootView.findViewById(R.id.mobNum3Edittext);
        emailEditText = (EditText)rootView.findViewById(R.id.emailEdittext);
        homeAddEditText = (EditText)rootView.findViewById(R.id.homeAddEdittext);
        busStopEditText = (EditText)rootView.findViewById(R.id.busStopEdittext);
        buildDescEditText = (EditText)rootView.findViewById(R.id.buildDiscEdittext);
        descNameEditText = (EditText)rootView.findViewById(R.id.getHomeEdittext);
        commonNameEditText = (EditText)rootView.findViewById(R.id.commonNameEdittext);

        prevResiAddEditText = (EditText)rootView.findViewById(R.id.prevResiAddET);
        prevBusstopEditText = (EditText)rootView.findViewById(R.id.prevBusStpoET);
        buildDescPrevEditText = (EditText)rootView.findViewById(R.id.prevBuildDescET);
        prevLGAEditText = (EditText)rootView.findViewById(R.id.lgaOfPrevET);
        prevLengthStayEditText = (EditText)rootView.findViewById(R.id.losPrevET);
        refreeNameEditText = (EditText)rootView.findViewById(R.id.refNameEdittext);
        refreeMobEditText = (EditText)rootView.findViewById(R.id.refMobEdittext);
        souseNameEditText = (EditText)rootView.findViewById(R.id.sopuseEdittext);
        spouseEmailEditText = (EditText)rootView.findViewById(R.id.spouseEmailEdittext);
        souseMobileEditText = (EditText)rootView.findViewById(R.id.sopuseMobEdittext);

        lgaTextView= (AutoCompleteTextView) rootView.findViewById(R.id.lgaTextView);
        tohTextView= (TextView) rootView.findViewById(R.id.tohTextView);
        toaTextView= (TextView) rootView.findViewById(R.id.toaTextView);
        accTypeTextView= (TextView) rootView.findViewById(R.id.acomoTextView);
        stateTextView = (TextView) rootView.findViewById(R.id.stateTv);
        lenghStayEditText = (TextView)rootView.findViewById(R.id.losEdtitext);

        mConfirmButton = (Button)rootView.findViewById(R.id.confirmButton);



        mLoanID = Pref.loadStringPref(getActivity(),Pref.LOAN_ID);

        ((RegisterFormsActivity)getActivity()).onCurrentFragment(ContactFragment.this);

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Global.DROP_DOWN_RESPONSE = gson.fromJson(Pref.loadStringPref(getActivity(),Pref.DROP_DOWN_KEY),DropDownResponse.class);

        setValues();

        //setLGAMenu();
        setTOHMenu();
        setTOAMenu();
        setAccoTypeMenu();
        setStateMenu();
        setLOSMenu();

        stateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStateMenu.show();
            }
        });

//        lgaTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mLGAMenu.show();
//
//            }
//        });
        tohTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTOHMenu.show();

            }
        });

        toaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTOAMenu.show();

            }
        });

        accTypeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAccoTypeMenu.show();

            }
        });
        lenghStayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLOSMenu.show();

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

        String response = Pref.loadStringPref(getActivity(),Pref.STEP_2_RESPONSE);
        if(response != null){
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            Step2Response step2Response = gson.fromJson(response,
                    Step2Response.class);
            mobEditText.setText(step2Response.getData().getMobileNo1());
            mob2EditText.setText(step2Response.getData().getMobileNo2());
            mob3EditText.setText(step2Response.getData().getMobileNo3());
//            emailEditText.setText(step2Response.getData().getEmail());
            homeAddEditText.setText(step2Response.getData().getHomeAddress());
            busStopEditText.setText(step2Response.getData().getNearestBusStop());
            buildDescEditText.setText(step2Response.getData().getBuildingDiscription());
            lgaTextView.setText(step2Response.getData().getContactLga());
            stateTextView.setText(step2Response.getData().getState());
            tohTextView.setText(step2Response.getData().getTypeOfHouse());
            toaTextView.setText(step2Response.getData().getTypeOfApartment());
            accTypeTextView.setText(step2Response.getData().getAccomodationType());
            descNameEditText.setText(step2Response.getData().getHowtogetToYourHome());
            commonNameEditText.setText(step2Response.getData().getCommonNameCalledAtHome());
            lenghStayEditText.setText(step2Response.getData().getLengthOfStay());
            prevResiAddEditText.setText(step2Response.getData().getPreviousResidentialAddress());
            prevBusstopEditText.setText(step2Response.getData().getNearestBusStopOfPrevious());
            buildDescPrevEditText.setText(step2Response.getData().getBuildingDiscriptionOfPrevious());
            //prevLGAEditText.setText(step2Response.getData().getc);
//            prevLengthStayEditText.setText(step2Response.getData().getl);
            refreeNameEditText.setText(step2Response.getData().getRefereeName());
            refreeMobEditText.setText(step2Response.getData().getRefereeMobileNo());
            souseNameEditText.setText(step2Response.getData().getSpouseName());
            souseMobileEditText.setText(step2Response.getData().getSpouseMobileNo());
            spouseEmailEditText.setText(step2Response.getData().getSpouseEmail());


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
            jsonBody.put("step","step-2");
            jsonBody.put("loanId",mLoanID);
            jsonBody.put("mobileNo1","+234"+ mobEditText.getText().toString());
            jsonBody.put("mobileNo2", "+234"+mob2EditText.getText().toString());
//            jsonBody.put("mobileNo3", mob3EditText.getText().toString());
//            jsonBody.put("email", emailEditText.getText().toString());
            jsonBody.put("homeAddress", homeAddEditText.getText().toString());
            jsonBody.put("nearestBusStop", busStopEditText.getText().toString());
            jsonBody.put("buildingDiscription", buildDescEditText.getText().toString());
            jsonBody.put("contactLga", lgaTextView.getText().toString());
            jsonBody.put("state1", stateTextView.getText().toString());
//            jsonBody.put("typeOfHouse", tohTextView.getText().toString());
            jsonBody.put("typeOfApartment", toaTextView.getText().toString());
            jsonBody.put("accomodationType", accTypeTextView.getText().toString());
            jsonBody.put("HowtogetToYourHome", descNameEditText.getText().toString());
            jsonBody.put("commonNameCalledAtHome", commonNameEditText.getText().toString());
            jsonBody.put("lengthOfStay", lenghStayEditText.getText().toString());
//            jsonBody.put("previousResidentialAddress", prevResiAddEditText.getText().toString());
//            jsonBody.put("nearestBusStopOfPrevious", prevBusstopEditText.getText().toString());
//            jsonBody.put("buildingDiscriptionOfPrevious", buildDescPrevEditText.getText().toString());
//            jsonBody.put("contactLgaOfPrevious ", prevLGAEditText.getText().toString());
//            jsonBody.put("lengthOfStayOfPrevious  ", prevLengthStayEditText.getText().toString());
            jsonBody.put("refereeName", refreeNameEditText.getText().toString());
            jsonBody.put("refereeMobileNo", "+234"+refreeMobEditText.getText().toString());
            jsonBody.put("spouseName", souseNameEditText.getText().toString());
            jsonBody.put("spouseMobileNo", "+234"+souseMobileEditText.getText().toString());
            jsonBody.put("spouseEmail", spouseEmailEditText.getText().toString());


            if(((RegisterFormsActivity)getActivity()).isFromEdit ){
                if(((RegisterFormsActivity)getActivity()).isUserCanEdit){
                    new Utils().callApis(getActivity(),URL,jsonBody,ContactFragment.this);
                }else{
                    Toast.makeText(getActivity(),"Sorry you can not edit data",Toast.LENGTH_SHORT).show();
                }
            }else{
                new Utils().callApis(getActivity(),URL,jsonBody,ContactFragment.this);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String url,String response) {
        if(url.equals(Utils.GET_LGA_FROM_STATE)){
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            GetLgaFromStateResponse getLgaFromStateResponse = gson.fromJson(response,
                    GetLgaFromStateResponse.class);
            if(getLgaFromStateResponse.getStatus()){
                setLGAMenu(getLgaFromStateResponse.getData().getLgas());
            }

        }else{
            parseData(response);
        }

    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        Step2Response step2Response = gson.fromJson(resString,
                Step2Response.class);

        if(step2Response.getStatus()){
            if(!((RegisterFormsActivity)getActivity()).isFromEdit()) {
                Pref.saveIntPref(getActivity(),Pref.REGISTRATION_STEP,2);
            }

            Pref.saveStringPref(getActivity(),Pref.STEP_2_RESPONSE,resString);

            Toast.makeText(getActivity(),step2Response.getMessage(),Toast.LENGTH_LONG).show();
            loadFragment(new EmploymentFragment());

            /*Intent intent = new Intent(getActivity(),EmploymentActivity.class);
            intent.putExtra("loanID",step2Response.getData().getId());
            startActivity(intent);*/
        }else{
            new Utils().showErrorDialog(getActivity(),step2Response.getMessage());
        }

    }




    private void setLGAMenu(ArrayList<String> lgaList){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.select_dialog_item, lgaList);
        //Getting the instance of AutoCompleteTextView
        lgaTextView.setThreshold(1);//will start working from first character
        lgaTextView.setAdapter(adapter);

//        mLGAMenu = new PopupMenu(getActivity(),lgaTextView);
//        for(int i = 0; i<lgaList.size(); i++){
//            mLGAMenu.getMenu().add(i,i,i,lgaList.get(i));
//        }
//
//        mLGAMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                lgaTextView.setText(item.getTitle());
//                return false;
//            }
//        });
    }
    private void setStateMenu(){

        mStateMenu = new PopupMenu(getActivity(),stateTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getState().size(); i++){
            mStateMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getState().get(i));
        }
        mStateMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                stateTextView.setText(item.getTitle());

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("state",item.getTitle());

                }catch (Exception e){

                }

                new Utils().callApis(getActivity(),Utils.GET_LGA_FROM_STATE,jsonBody,ContactFragment.this);
                return false;
            }
        });
    }


    private void setLOSMenu(){

        mLOSMenu = new PopupMenu(getActivity(),lenghStayEditText);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getLengthOfStay().size(); i++){
            mLOSMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getLengthOfStay().get(i));
        }
        mLOSMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                lenghStayEditText.setText(item.getTitle());
                return false;
            }
        });
    }
    private void setTOHMenu(){

        mTOHMenu = new PopupMenu(getActivity(),tohTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfHouse().size(); i++){
            mTOHMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfHouse().get(i));
        }
        mTOHMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                tohTextView.setText(item.getTitle());
                return false;
            }
        });
    }

    private void setTOAMenu(){

        mTOAMenu = new PopupMenu(getActivity(),toaTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfAppartment().size(); i++){
            mTOAMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getTypeOfAppartment().get(i));
        }
        mTOAMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                toaTextView.setText(item.getTitle());
                return false;
            }
        });
    }

    private void setAccoTypeMenu(){

        mAccoTypeMenu = new PopupMenu(getActivity(),accTypeTextView);
        for(int i = 0; i<Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAccommodationType().size(); i++){
            mAccoTypeMenu.getMenu().add(i,i,i,Global.DROP_DOWN_RESPONSE.getData().getDropDown().getAccommodationType().get(i));
        }
        mAccoTypeMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                accTypeTextView.setText(item.getTitle());
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