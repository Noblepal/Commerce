package com.retailboosters.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retailboosters.ChangePasswordActivity;
import com.retailboosters.DocumentActivity;
import com.retailboosters.HomeActivity;
import com.retailboosters.MainActivity;
import com.retailboosters.R;
import com.retailboosters.RegisterFormsActivity;
import com.retailboosters.utils.Pref;

public class AccountFragment extends Fragment {

    private TextView mChangePassTextView,mAppFormTextView,mSignoutTextView,mDocTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_account, container, false);

        mChangePassTextView = (TextView)rootView.findViewById(R.id.changePassTextView);
        mAppFormTextView = (TextView)rootView.findViewById(R.id.appFormTextView);
        mSignoutTextView = (TextView)rootView.findViewById(R.id.logoutTextView);

        mDocTextView = (TextView)rootView.findViewById(R.id.docTextView);


        mChangePassTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        mAppFormTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),RegisterFormsActivity.class);
                intent.putExtra("isEdit",true);
                startActivity(intent);
//                getActivity().finish();

            }
        });

        mDocTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),DocumentActivity.class);
                intent.putExtra("isEdit",true);
                startActivity(intent);
//                getActivity().finish();

            }
        });
        mSignoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pref.saveIntPref(getActivity(),Pref.REGISTRATION_STEP,-1);
                Pref.saveStringPref(getActivity(),Pref.STEP_1_RESPONSE,null);
                Pref.saveStringPref(getActivity(),Pref.STEP_2_RESPONSE,null);
                Pref.saveStringPref(getActivity(),Pref.STEP_3_RESPONSE,null);
                Pref.saveStringPref(getActivity(),Pref.STEP_4_RESPONSE,null);


                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return rootView;
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
