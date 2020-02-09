package com.retailboosters;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnApiResponse {

    private EditText mEmailEdittext, mPasswordEditText;
    private Button mLoginButton;
    private RelativeLayout rlRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmailEdittext = (EditText) findViewById(R.id.emailEdittext);
        mPasswordEditText = (EditText) findViewById(R.id.EdittextPassword);


        mLoginButton = (Button) findViewById(R.id.ButtonLogin);
        rlRegister = (RelativeLayout) findViewById(R.id.rlRegister);

        mLoginButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                doLogin(mEmailEdittext.getText().toString(), mPasswordEditText.getText().toString());
            }
        });
        rlRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        mEmailEdittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub


            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                /*if (isValidEmail(mEmailEdittext.getText().toString().trim())) {
                    Drawable drawable = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        drawable = getDrawable(R.drawable.reg_ok);
                        Drawable drawable1 = getDrawable(R.drawable.ic_email_black_24dp);
                        mEmailEdittext.setCompoundDrawables(drawable1, null, drawable, null);
                    }
                    *//*mEmailValidView.setImageResource(R.drawable.reg_ok);*//*
                } else {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        Drawable error = getDrawable(R.drawable.reg_error);
                        mEmailEdittext.setCompoundDrawables(null, null, error, null);
                    }
                }*/
            }
        });
    }


    public void onClickConfirm(View v) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickForgotPassword(View v) {
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void doLogin(String email, String password) {
        try {

            String URL = Utils.LOGIN;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", email);
            jsonBody.put("password", password);
            new Utils().callApis(LoginActivity.this, URL, jsonBody, LoginActivity.this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String method, String response) {
        parseData(response);
    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        LoginResponse loginResponse = gson.fromJson(resString,
                LoginResponse.class);

        if (loginResponse.getStatus()) {
            Pref.saveStringPref(LoginActivity.this, Pref.AUTH_TOKEN_KEY, loginResponse.getToken());
            Pref.saveStringPref(LoginActivity.this, Pref.MOBILE_NO, "" + loginResponse.getData().getMobileNo());
            Pref.saveStringPref(LoginActivity.this, Pref.LOAN_ID, loginResponse.getData().getLoanId());
            Pref.saveStringPref(LoginActivity.this, Pref.USER_ID_KEY, loginResponse.getData().getId());
            Pref.saveStringPref(LoginActivity.this, Pref.FIRST_NAME, loginResponse.getData().getFirstName());
            Pref.saveStringPref(LoginActivity.this, Pref.WHERE_WORK, loginResponse.getCompanyName());


            Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();

            if (loginResponse.getData().getLoanStep() != null &&
                    loginResponse.getData().getLoanStep().equalsIgnoreCase("step-4")) {
                Pref.saveIntPref(LoginActivity.this, Pref.REGISTRATION_STEP, 4);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                String step = loginResponse.getData().getLoanStep();
                if (step != null && step.equalsIgnoreCase("step-3")) {
                    Pref.saveIntPref(LoginActivity.this, Pref.REGISTRATION_STEP, 3);
                } else if (step != null && step.equalsIgnoreCase("step-2")) {
                    Pref.saveIntPref(LoginActivity.this, Pref.REGISTRATION_STEP, 2);
                } else if (step != null && step.equalsIgnoreCase("step-1")) {
                    Pref.saveIntPref(LoginActivity.this, Pref.REGISTRATION_STEP, 1);
                } else {
                    Pref.saveIntPref(LoginActivity.this, Pref.REGISTRATION_STEP, -1);
                }

                Intent intent = new Intent(LoginActivity.this, RegisterFormsActivity.class);
                intent.putExtra("fName", loginResponse.getData().getFirstName());
                intent.putExtra("lName", loginResponse.getData().getLastName());

                startActivity(intent);
                finish();
            }


        } else {
            new Utils().showErrorDialog(LoginActivity.this, loginResponse.getMessage());
        }

    }


}


