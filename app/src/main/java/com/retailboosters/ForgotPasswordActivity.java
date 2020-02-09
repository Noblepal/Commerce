package com.retailboosters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgotPasswordActivity extends Activity implements OnApiResponse {
	
	private EditText mEmailEdittext;
	private ImageView mEmailValidView;
	private Button mLoginButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgotpassword);

		mEmailEdittext = (EditText)findViewById(R.id.emailEdittext);

		mEmailValidView = (ImageView)findViewById(R.id.emailValidView);

		mLoginButton = (Button)findViewById(R.id.ButtonLogin);
		
		mLoginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (!TextUtils.isEmpty(mEmailEdittext.getText().toString())) {
					doRetrivePassword(mEmailEdittext.getText().toString());
				}else {
					Toast.makeText(ForgotPasswordActivity.this, getString(R.string.please_enter_email_address), Toast.LENGTH_SHORT).show();
				}
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
				
				if(isValidEmail(mEmailEdittext.getText().toString().trim())) {
					mEmailValidView.setImageResource(R.drawable.reg_ok);
				}else {
					mEmailValidView.setImageResource(R.drawable.reg_error);
				}
			}
		});
	}

	
	public void onClickConfirm(View v) {
		Intent intent = new Intent(ForgotPasswordActivity.this,HomeActivity.class);
		startActivity(intent);
		finish();
	}

	public static boolean isValidEmail(CharSequence target) {
	    return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
	}

	private void doRetrivePassword(String email) {
		try {
			
			String URL = Utils.FORGOT_PASSWORD;
			JSONObject jsonBody = new JSONObject();
			jsonBody.put("email", email);
			new Utils().callApis(ForgotPasswordActivity.this,URL,jsonBody, ForgotPasswordActivity.this);

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

		LoginResponse loginResponse = gson.fromJson(resString,
				LoginResponse.class);

		if(loginResponse.getStatus()){



			Toast.makeText(ForgotPasswordActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
finish();

		}else{
			new Utils().showErrorDialog(ForgotPasswordActivity.this,loginResponse.getMessage());
		}
		
	}


}


