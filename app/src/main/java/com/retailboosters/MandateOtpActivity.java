package com.retailboosters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.retailboosters.response.OrderCreatedResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MandateOtpActivity extends Activity implements OnApiResponse {

    OrderCreatedResponse orderCreatedResponse;
    private LinearLayout mAddViewLayout;
    private String mOrderId;
    JSONArray authJsonArray;
    private ArrayList<EditText> mEditTexts = new ArrayList<>();
    private TextView mResendTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mandate_otp);
        mAddViewLayout = (LinearLayout) findViewById(R.id.addViewLayout);

        mResendTextView = (TextView) findViewById(R.id.resendTv);

        Bundle bundle = getIntent().getExtras();
        orderCreatedResponse = (OrderCreatedResponse) bundle.getSerializable("order");
        mOrderId = bundle.getString("orderId");

        String jsonString = new Gson().toJson(orderCreatedResponse.getOtpDetails().getAuthParams());

        try {
            authJsonArray = new JSONArray(jsonString);
            for (int i = 0; i < authJsonArray.length(); i++) {

                View child = getLayoutInflater().inflate(R.layout.manadate_add_view, null);

                TextView label = (TextView) child.findViewById(R.id.titleTextView);
                EditText editText = (EditText) child.findViewById(R.id.emailEdittext);

                label.setText(authJsonArray.getJSONObject(i).getString("label" + (i + 1)));

                mAddViewLayout.addView(child);

                mEditTexts.add(editText);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mResendTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("orderId", mOrderId);
                    new Utils().callApis(MandateOtpActivity.this, Utils.RESEND_MANDATE_OTP, jsonBody, MandateOtpActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });


    }

    public void onClickConfirm(View v) {
        mandateOtp();
    }


    private void mandateOtp() {
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("remitaTransRef", orderCreatedResponse.getOtpDetails().getRemitaTransRef());
            jsonBody.put("orderId", mOrderId);

            for (int i = 0; i < authJsonArray.length(); i++) {

                authJsonArray.getJSONObject(i).remove("label" + (i + 1));
                authJsonArray.getJSONObject(i).remove("description" + (i + 1));
                authJsonArray.getJSONObject(i).put("value", mEditTexts.get(i).getText().toString());

            }

            jsonBody.put("authParams", authJsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Utils().callApis(MandateOtpActivity.this, Utils.MANDATE_VALIDATE_OTP, jsonBody, MandateOtpActivity.this);
        Log.e("Jsonbody", "" + jsonBody);
    }


    @Override
    public void onSuccess(String method, String response) {

        if (method.equals(Utils.RESEND_MANDATE_OTP)) {

            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();
            OrderCreatedResponse createOrderResponse = gson.fromJson(response,
                    OrderCreatedResponse.class);

            orderCreatedResponse = createOrderResponse;


        } else {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getBoolean("status")) {
                    Intent intent = new Intent();
                    intent.putExtra("isMandate", true);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onError(String response) {

    }
}
