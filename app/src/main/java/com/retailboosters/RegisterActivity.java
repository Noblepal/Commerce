package com.retailboosters;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.response.BVNResponse;
import com.retailboosters.response.RegisterResponse;
import com.retailboosters.response.SendOtpResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends Activity implements OnApiResponse {

    private EditText mEmailEditText, mMobileEditText, mBVNEditText, mPasswordEditText;
    private TextView mFNameTextView, mLnameTextView, mEmailTextView, mMoTextView, mBVNVerifyView, mMobileVerifyView;
    private ImageView mEmailValidView, mPassImageView;
    private RelativeLayout relativeLayout;

    private LinearLayout mBVNInfoLayout;
    private boolean isBVNValid = false;
    private String mBvnDob = "", otpId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        relativeLayout = findViewById(R.id.rlRegister);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mEmailEditText = (EditText) findViewById(R.id.emailEdittext);
        mMobileEditText = (EditText) findViewById(R.id.mobileEditext);
        mBVNEditText = (EditText) findViewById(R.id.bvmEdittext);
        mPasswordEditText = (EditText) findViewById(R.id.passwordEditext);

        mFNameTextView = (TextView) findViewById(R.id.fNameTextView);
        mLnameTextView = (TextView) findViewById(R.id.lNameTextView);
        mEmailTextView = (TextView) findViewById(R.id.emailTextView);
        mMoTextView = (TextView) findViewById(R.id.mNumTextView);
        /*mMobileVerifyView = (TextView) findViewById(R.id.mobileVerifyTv);*/

        mBVNInfoLayout = (LinearLayout) findViewById(R.id.bvnInfoLayout);

        /*mBVNVerifyView = (TextView) findViewById(R.id.bvmValidView);*/
        mEmailValidView = (ImageView) findViewById(R.id.emailValidView);
        mPassImageView = (ImageView) findViewById(R.id.passValidView);


        mBVNVerifyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBVNEditText.getText().toString().trim().length() > 3) {
                    validateBVN(mBVNEditText.getText().toString());
                } else {
                    mBVNInfoLayout.setVisibility(View.GONE);
                }
            }
        });


        mMobileVerifyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmailEditText.getText().toString().length() <= 0 || !isValidEmail(mEmailEditText.getText().toString())) {
                    new Utils().showErrorDialog(RegisterActivity.this, "Please enter valid email");
                } else if (mMobileEditText.getText().toString().length() <= 0) {
                    new Utils().showErrorDialog(RegisterActivity.this, "Please enter mobile number");
                } else {
                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("mobileNo", mMobileEditText.getText().toString());
                        jsonBody.put("email", mEmailEditText.getText().toString());
                    } catch (Exception e) {

                    }
                    new Utils().callApis(RegisterActivity.this, Utils.SEND_OTP, jsonBody, RegisterActivity.this);

                    openOTPDialog();
                }


            }
        });

		/*mMobileEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {


				if(mMobileEditText.getText().toString().trim().length() > 8 &&
						mMobileEditText.getText().toString().trim().length() < 15){
					mMobileImageView.setImageResource(R.drawable.reg_ok);
				}else{
					mMobileImageView.setImageResource(R.drawable.reg_error);

				}

			}
		});*/
        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (mPasswordEditText.getText().toString().trim().length() > 5) {
                    mPassImageView.setImageResource(R.drawable.reg_ok);
                } else {
                    mPassImageView.setImageResource(R.drawable.reg_error);

                }

            }
        });
        mEmailEditText.addTextChangedListener(new TextWatcher() {

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
/*
                if(isValidEmail(mEmailEditText.getText().toString().trim())) {
                    mEmailValidView.setImageResource(R.drawable.reg_ok);
                }else {
                    mEmailValidView.setImageResource(R.drawable.reg_error);
                }*/
            }
        });
    }

    Dialog otpDialog;

    private void openOTPDialog() {
        otpDialog = new Dialog(RegisterActivity.this);
        otpDialog.setContentView(R.layout.dialog_otp);
        final EditText otpEditText = (EditText) otpDialog.findViewById(R.id.passwordEditext);
        Button submitButton = (Button) otpDialog.findViewById(R.id.confirmButton);
        TextView resendTextView = (TextView) otpDialog.findViewById(R.id.resendTv);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("id", otpId);
                    jsonBody.put("verificationOtp", otpEditText.getText().toString());
                } catch (Exception e) {

                }
                new Utils().callApis(RegisterActivity.this, Utils.VERIFY_OTP, jsonBody, RegisterActivity.this);
            }
        });

        resendTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("mobileNo", mMobileEditText.getText().toString());
                    jsonBody.put("email", mEmailEditText.getText().toString());
                } catch (Exception e) {

                }


                new Utils().callApis(RegisterActivity.this, Utils.SEND_OTP, jsonBody, RegisterActivity.this);
            }
        });

        otpDialog.show();
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void validateBVN(String bvn) {
        try {
            final ProgressDialog dialog = new ProgressDialog(RegisterActivity.this);
            dialog.setMessage("Please wait...");
            dialog.show();

            RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
            String URL = Utils.VERIFY_BVN;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("bvn", bvn);

            final String mRequestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("LOG_VOLLEY_RESPONEe", response);
                    dialog.dismiss();
                    parseBVNData(response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY_ERROR", error.toString());
                    dialog.dismiss();
                    NetworkResponse response = error.networkResponse;
                    if (error instanceof ServerError && response != null) {
                        try {
                            String res = new String(response.data,
                                    HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                            // Now you can use any deserializer to make sense of data
                            JSONObject obj = new JSONObject(res);
                            Log.e("BVN EROOR", obj.getString("message"));
                            mBVNInfoLayout.setVisibility(View.GONE);
                        } catch (UnsupportedEncodingException e1) {
                            // Couldn't properly decode data to string
                            e1.printStackTrace();
                        } catch (JSONException e2) {
                            // returned data is not JSONObject?
                            e2.printStackTrace();
                        }
                    }

                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody
                                .getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog
                                .wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                                        mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(
                        NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {

                        responseString = String.valueOf(response.statusCode);


                    }
                    return super.parseNetworkResponse(response);
                    // return Response.success(responseString,
                    // HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseBVNData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        BVNResponse bvnResponse = gson.fromJson(resString, BVNResponse.class);

        if (bvnResponse.getStatus() && bvnResponse.getData().getBvn() != null) {
            isBVNValid = true;
            mFNameTextView.setText(bvnResponse.getData().getFirstName());
            mLnameTextView.setText(bvnResponse.getData().getLastName());
            mEmailTextView.setText(bvnResponse.getData().getEmail());
            mMoTextView.setText(bvnResponse.getData().getPhoneNumber());
            mBVNInfoLayout.setVisibility(View.VISIBLE);
            mBvnDob = bvnResponse.getData().getDateOfBirth();
        } else {
            isBVNValid = false;
            mBVNInfoLayout.setVisibility(View.GONE);
            new Utils().showErrorDialog(RegisterActivity.this, bvnResponse.getMessage());
        }

    }

    public void onClickConfirm(View v) {

        if (mEmailEditText.getText().toString().trim().length() <= 0) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please enter email address");
        } else if (!isValidEmail(mEmailEditText.getText().toString().trim())) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please enter correct email address");
        } else if (mMobileEditText.getText().toString().trim().length() <= 0) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please enter mobile number");
        } else if (!mMobileVerifyView.getText().toString().equalsIgnoreCase("Verified")) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please verify mobile number");
        } else if (mPasswordEditText.getText().toString().trim().length() <= 0) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please enter password");
        } else if (mBVNEditText.getText().toString().trim().length() <= 0) {
            new Utils().showErrorDialog(RegisterActivity.this, "Please enter BVN");
        } else {
            doRegister();
        }

//		else if(!isBVNValid){
//			new Utils().showErrorDialog(RegisterActivity.this,"Please enter correct BVN");
//		}


    }


    private void doRegister() {
        try {

            String URL = Utils.REGISTER;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", mEmailEditText.getText().toString().trim());
            jsonBody.put("mobileNo", "+234" + mMobileEditText.getText().toString().trim());
            jsonBody.put("password", mPasswordEditText.getText().toString().trim());
            jsonBody.put("firstName", mFNameTextView.getText().toString().trim());
            jsonBody.put("lastName", mLnameTextView.getText().toString().trim());
            jsonBody.put("bvn", mBVNEditText.getText().toString().trim());

            new Utils().callApis(RegisterActivity.this, URL, jsonBody, RegisterActivity.this);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(String method, String response) {
        if (method.equalsIgnoreCase(Utils.SEND_OTP)) {

            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            SendOtpResponse sendOtpResponse = gson.fromJson(response, SendOtpResponse.class);

            if (sendOtpResponse.getStatus()) {
                otpId = sendOtpResponse.getData().getId();
            }


        } else if (method.equalsIgnoreCase(Utils.VERIFY_OTP)) {

            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getBoolean("status")) {
                    mEmailEditText.setEnabled(false);
                    mMobileEditText.setEnabled(false);
                    mMobileVerifyView.setEnabled(false);
                    mMobileVerifyView.setTextColor(Color.GRAY);
                    mMobileVerifyView.setText("Verified");
                    otpDialog.dismiss();

                }
                Toast.makeText(RegisterActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {

            }


        } else {
            parseData(response);
        }

    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        RegisterResponse registerResponse = gson.fromJson(resString, RegisterResponse.class);
        if (registerResponse.getStatus()) {

            Pref.saveIntPref(RegisterActivity.this, Pref.REGISTRATION_STEP, -1);
            Pref.saveStringPref(RegisterActivity.this, Pref.STEP_1_RESPONSE, null);
            Pref.saveStringPref(RegisterActivity.this, Pref.STEP_2_RESPONSE, null);
            Pref.saveStringPref(RegisterActivity.this, Pref.STEP_3_RESPONSE, null);
            Pref.saveStringPref(RegisterActivity.this, Pref.STEP_4_RESPONSE, null);
            Pref.saveStringPref(RegisterActivity.this, Pref.AUTH_TOKEN_KEY, null);

            Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_LONG).show();
            Pref.saveStringPref(RegisterActivity.this, Pref.AUTH_TOKEN_KEY, registerResponse.getToken());
            Pref.saveStringPref(RegisterActivity.this, Pref.MOBILE_NO, "" + registerResponse.getData().getMobileNo());
            Pref.saveStringPref(RegisterActivity.this, Pref.USER_ID_KEY, registerResponse.getData().getId());

            Intent intent = new Intent(RegisterActivity.this, RegisterFormsActivity.class);

            if (mBVNInfoLayout.getVisibility() == View.VISIBLE) {
                if (mFNameTextView.getText().toString().length() > 0) {
                    intent.putExtra("fName", mFNameTextView.getText().toString());
                }
                if (mLnameTextView.getText().toString().length() > 0) {
                    intent.putExtra("lName", mLnameTextView.getText().toString());
                }

                if (mBvnDob != null && mBvnDob.length() > 0) {
                    String strCurrentDate = mBvnDob;
                    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                    try {
                        Date newDate = format.parse(strCurrentDate);

                        format = new SimpleDateFormat("MM/dd/yyyy");
                        String date = format.format(newDate);
                        intent.putExtra("dob", date);
                        Log.e("DOB", "" + date);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }


                }

            }
            startActivity(intent);
            finish();

        } else {
            new Utils().showErrorDialog(RegisterActivity.this, registerResponse.getMessage());
        }


    }

}
