package com.retailboosters;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangePasswordActivity extends Activity implements OnApiResponse {
	
	private EditText oldPassEditText,newPAssEditText,conPassEditText;
	private Button mLoginButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);

		oldPassEditText = (EditText)findViewById(R.id.oldPAssEdittext);
		newPAssEditText = (EditText)findViewById(R.id.newPAssEdittext);
		conPassEditText = (EditText)findViewById(R.id.conPasslEdittext);


		mLoginButton = (Button)findViewById(R.id.ButtonSubmit);
		
		mLoginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				if(TextUtils.isEmpty(oldPassEditText.getText().toString())){
					Toast.makeText(ChangePasswordActivity.this,"Please enter old password", Toast.LENGTH_SHORT).show();
				}else if(TextUtils.isEmpty(newPAssEditText.getText().toString())){
					Toast.makeText(ChangePasswordActivity.this,"Please enter new password", Toast.LENGTH_SHORT).show();
				}else if(TextUtils.isEmpty(conPassEditText.getText().toString())){
					Toast.makeText(ChangePasswordActivity.this,"Please enter confirm password", Toast.LENGTH_SHORT).show();
				}else if(!newPAssEditText.getText().toString().equals(conPassEditText.getText().toString())){
					Toast.makeText(ChangePasswordActivity.this,"Password does not match", Toast.LENGTH_SHORT).show();
				}else{
					doChangePassword();
				}

			}
		});
		

	}

	
	public void onClickConfirm(View v) {
		Intent intent = new Intent(ChangePasswordActivity.this,HomeActivity.class);
		startActivity(intent);
		finish();
	}

	public static boolean isValidEmail(CharSequence target) {
	    return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
	}

	private void doChangePassword() {
		try {
			
			String URL = Utils.CHANGE_PASSWORD;
			JSONObject jsonBody = new JSONObject();
			jsonBody.put("oldPassword", oldPassEditText.getText().toString());
			jsonBody.put("password", newPAssEditText.getText().toString());
			jsonBody.put("confirmPassword", conPassEditText.getText().toString());
			new Utils().callApis(ChangePasswordActivity.this,URL,jsonBody, ChangePasswordActivity.this);

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



			Toast.makeText(ChangePasswordActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
			finish();

		}else{
			new Utils().showErrorDialog(ChangePasswordActivity.this,loginResponse.getMessage());
		}
		
	}


}


