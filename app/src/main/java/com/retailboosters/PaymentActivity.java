package com.retailboosters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
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
import com.retailboosters.fragment.AppSubmittedFragment;
import com.retailboosters.fragment.BuyProductPaymentFragment;
import com.retailboosters.response.RemitaGetUrlResponse;
import com.retailboosters.response.RemitaPaymentResponse;
import com.retailboosters.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import static com.retailboosters.fragment.BuyLoanInfoFragment.MANDATE_REQUEST_CODE;

public class PaymentActivity extends Activity {
	private WebView mWebView;

	private String paymentUrl = "https://remitademo.net/payment/v1/payment/extended/initialize";
	private String transactionId = "";
	private String publicKey="QzAwMDAxNTUzNjd8NDI3NzY0NzR8NzZjNTJkMjY5YTE0MDA1MGEyZTRlNzQ2YTM4YzJlMjc0OTQwMTk0NGFjN2VkNDBjZDcxMGViODhjM2VmOGI0MGE3YTNmNTA2ZTJlZDZjNTMxOTQ1MDNmNGM4ZTA0YjdjYjEyMTFkZmQ5OTA3ODllZjg0ZGRlYzcwMmFlYzFiZWI=";
	private String secretKey = "403c8c0b03443e790811399f4569cf4b63c0873d47d4671e0e3a11929c8966c135f6be03094d55d8f613d6e5df2a2bffebabc16901f1a868e00de8ec9fb50a96";
	private String transctionUrl = "https://remitademo.net/payment/v1/payment/query/";
	private int amount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_product_payment);


		mWebView = (WebView) findViewById(R.id.webView);

		transactionId = ""+System.currentTimeMillis();



		amount = getIntent().getIntExtra("amount",0);
		Log.e("TID",""+amount);

		WebSettings webSetting = mWebView.getSettings();
		webSetting.setBuiltInZoomControls(true);
		webSetting.setJavaScriptEnabled(true);

		mWebView.setWebViewClient(new WebViewClient());

		getWebUrl();
	}

	public void onSuccess(String method, String response) {

		Log.e("Response","==> "+response);

		if(method.contains(paymentUrl)) {
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			RemitaGetUrlResponse getUrlResponse = gson.fromJson(response,
					RemitaGetUrlResponse.class);
			if (getUrlResponse.getResponseCode().equals("00")) {
				String url = getUrlResponse.getResponseData().get(0).getAuthorizationUrl();
				mWebView.loadUrl(url);
			}
		}else{
			GsonBuilder gsonb = new GsonBuilder();
			Gson gson = gsonb.create();
			RemitaPaymentResponse remitaPaymentResponse = gson.fromJson(response,
					RemitaPaymentResponse.class);
			if(remitaPaymentResponse.getResponseCode().equalsIgnoreCase("00")){


//				getFragmentManager().popBackStack();
				Intent intent = new Intent();
				intent.putExtra("response",response);
				intent.putExtra("isPaymentDone",true);
				setResult(RESULT_OK,intent);
                finish();

			}
		}

	}


	public void onError(String response) {

	}

	private void getWebUrl(){

		try {

			String URL = paymentUrl;
			JSONObject jsonBody = new JSONObject();
			jsonBody.put("transactionId", transactionId);
			jsonBody.put("email","oshadami@specs.com");
			jsonBody.put("amount", amount);
			jsonBody.put("currency","NGN");
			jsonBody.put("firstName", "Mike");
			jsonBody.put("lastName","Oshadami");
			jsonBody.put("phoneNumber", "080231456789");
			jsonBody.put("customerid","oshadami@specs.com");
			jsonBody.put("narration","payment tst");
			jsonBody.put("extendedData", "null");
			jsonBody.put("returnUrl","https://remitademo.net/");
			callApis(PaymentActivity.this,URL,jsonBody);

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private String generateSha512(String string){
		StringBuilder sb = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] digest = md.digest(string.getBytes());
			sb = new StringBuilder();
			for (int i = 0; i < digest.length; i++) {
				sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
			}
			Log.e("Sha512",""+sb);
		}catch (Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}

	public class WebViewJavaScriptInterface{

		private Context context;

		/*
		 * Need a reference to the context in order to sent a post message
		 */
		public WebViewJavaScriptInterface(Context context){
			this.context = context;
		}

		/*
		 * This method can be called from Android. @JavascriptInterface
		 * required after SDK version 17.
		 */
		@JavascriptInterface
		public void makeToast(String message){
			Log.e("Response",""+message);
//            Toast.makeText(context, message,Toast.LENGTH_SHORT).show();
		}
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			Log.e("URL",""+url);
			if(url.contains("https://remitademo.net/")){

				String traUrl = transctionUrl+transactionId;
				String shaKey = generateSha512(transactionId+secretKey);
				callGetApi(PaymentActivity.this,traUrl,true,shaKey);
			}
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageFinished(WebView view, String url) {

		}
	}




	public void callApis(final Context context, final String URL, JSONObject jsonBody){

		final ProgressDialog dialog = new ProgressDialog(context);
		dialog.setMessage("Please wait...");
		dialog.show();

		RequestQueue requestQueue = Volley.newRequestQueue(context);


		final String mRequestBody = jsonBody.toString();

		StringRequest stringRequest = new StringRequest(
				Request.Method.POST, URL, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.i("LOG_VOLLEY_RESPONEe", response);

				onSuccess(URL,response);
				dialog.dismiss();
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
						new Utils().showErrorDialog(context,obj.getString("message"));

					} catch (UnsupportedEncodingException e1) {
						// Couldn't properly decode data to string
						e1.printStackTrace();
					} catch (JSONException e2) {
						// returned data is not JSONObject?
						e2.printStackTrace();
					}
				}
				dialog.dismiss();
			}
		}) {
			@Override
			public String getBodyContentType() {
				return "application/json";
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
			public Map<String, String> getHeaders() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();
				params.put("Content-Type", "application/json");
				params.put("publicKey", publicKey);

				return params;
			}




			@Override
			protected Response<String> parseNetworkResponse(
					NetworkResponse response) {
				String responseString = "";
				if (response != null) {

					responseString = String.valueOf(response.statusCode);
					Log.e("Res Net String",""+responseString);

				}
				return super.parseNetworkResponse(response);
				// return Response.success(responseString,
				// HttpHeaderParser.parseCacheHeaders(response));
			}
		};

		stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
				0,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

		requestQueue.add(stringRequest);

	}



	public void callGetApi(Context context,final String url,boolean isShowProgress,final String shaKey){

		final ProgressDialog dialog = new ProgressDialog(context);
		dialog.setMessage("Please wait...");
		if(isShowProgress) {

			dialog.show();
		}
		RequestQueue requestQueue = Volley.newRequestQueue(context);
		StringRequest stringRequest = new StringRequest(
				Request.Method.GET, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.i("LOG_VOLLEY_RESPONEe", response);
				dialog.dismiss();
				onSuccess(url,response);

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
			public Map<String, String> getHeaders() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();
				params.put("Content-Type", "application/json; charset=UTF-8");
				params.put("publicKey", publicKey);
				params.put("TXN_HASH", shaKey);

				return params;
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

	}


}
