package com.retailboosters.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.response.DropDownResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Utils {


    //	public static String ROOT_API = "http://103.101.59.95:4000/api/";
    public static String ROOT_API = "https://retailboosters.ng:4000/api/";


    public static String LOGIN = ROOT_API + "auth/login";
    public static String REGISTER = ROOT_API + "auth/register";
    public static String VERIFY_BVN = ROOT_API + "loanapp/bvnVerify";
    public static String NEW_LOAN = ROOT_API + "loanapp/newLoanApp";
    public static String SETTING = ROOT_API + "setting";
    public static String GET_PRODUCT = ROOT_API + "product/getProductByStoreId";
    public static String GET_STORE = ROOT_API + "store/getStore";
    public static String GET_PRODUCT_BY_ID = ROOT_API + "product/getProductByProductId";
    public static String GET_SALARY_HISTORY = ROOT_API + "admin/salaryHistory";
    public static String ADD_PRODUCT = ROOT_API + "product/addproduct";
    public static String SERCH_COMPANY = ROOT_API + "buyProduct/findCompany/";
    public static String ADD_ORDER = ROOT_API + "buyProduct/add";
    public static String UPLOAD_DOC_BUY_PRODUCT = ROOT_API + "buyProduct/fileUpload";
    public static String LOAN_ELIGIBILITY = ROOT_API + "loanapp/loanEligible";
    public static String LOAN_CALCULATOR = ROOT_API + "loanapp/LoanCalculator";
    public static String LOAN_STATUS = ROOT_API + "buyProduct/getLoanStatus";
    public static String GET_ALL_USERS = ROOT_API + "buyProduct/getUserOrders";
    public static String FIND_PRODUCT = ROOT_API + "product/findProduct/";
    public static String APPROVE_LOAN = ROOT_API + "admin/approveLoan";
    public static String BANK_PARSER = ROOT_API + "admin/bankParser";
    public static String GET_LGA_FROM_STATE = ROOT_API + "statelga/findOneState";
    public static String GET_REPAYMENT_HISTORY = ROOT_API + "buyProduct/getUserRepaymentHistory";
    public static String FORGOT_PASSWORD = ROOT_API + "auth/forgetPassword";
    public static String CHANGE_PASSWORD = ROOT_API + "user/changePassword";
    public static String GET_ORDER_HISTORY = ROOT_API + "buyProduct/loginUserOrderHistory";
    public static String GET_LOAN_DETAILS = ROOT_API + "loanapp/getdetail";
    public static String GET_USER_DOCS = ROOT_API + "buyProduct/getDocumentByorderId";
    public static String UPLOAD_DOC = ROOT_API + "buyProduct/fileEdit";
    public static String SEND_OTP = ROOT_API + "otp/sendOtp";
    public static String VERIFY_OTP = ROOT_API + "otp/verifyOtp";
    public static String MANDATE_VALIDATE_OTP = ROOT_API + "admin/mandateActivateOTP";
    public static String GET_FEATURE_PRODUCT = ROOT_API + "product/featuredProducts";
    public static String RESEND_MANDATE_OTP = ROOT_API + "admin/resendMandateRequestOTP";


    public void showErrorDialog(Context context, String message) {

        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setMessage(message);
        adb.setPositiveButton("OK", null);
        adb.show();
    }

    public void callApis(final Context context, final String URL, JSONObject jsonBody, final OnApiResponse onApiResponse) {

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Please wait...");
        dialog.show();
        HttpsTrustManager.allowAllSSL();

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        final String mRequestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("LOG_VOLLEY_RESPONEe", URL + "==>" + response);

                onApiResponse.onSuccess(URL, response);
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
                        showErrorDialog(context, obj.getString("message"));

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
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                if (Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY) != null) {
                    params.put("Authorization", "Bearer " + Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY));
                }
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

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(stringRequest);

    }


    public void callDropDownApi(final Context context) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        HttpsTrustManager.allowAllSSL();
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, SETTING, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("LOG_VOLLEY_RESPONEe", response);

                GsonBuilder gsonb = new GsonBuilder();
                Gson gson = gsonb.create();

                DropDownResponse dropDownResponse = gson.fromJson(response, DropDownResponse.class);
                Global.DROP_DOWN_RESPONSE = dropDownResponse;
                Pref.saveStringPref(context, Pref.DROP_DOWN_KEY, response);


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG_VOLLEY_ERROR", error.toString());
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


    public void callGetApi(Context context, final String url, final OnApiResponse onApiResponse, boolean isShowProgress) {

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Please wait...");
        if (isShowProgress) {

            dialog.show();
        }
        HttpsTrustManager.allowAllSSL();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("LOG_VOLLEY_RESPONEe", response);
                dialog.dismiss();
                onApiResponse.onSuccess(url, response);

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

    public void callGetApiWithHeader(final Context context, final String url, final OnApiResponse onApiResponse, boolean isShowProgress) {

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Please wait...");
        if (isShowProgress) {

            dialog.show();
        }
        HttpsTrustManager.allowAllSSL();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("LOG_VOLLEY_RESPONEe", response);
                dialog.dismiss();
                onApiResponse.onSuccess(url, response);

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
                if (Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY) != null) {
                    Log.e("header", "" + Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY));
                    params.put("Authorization", "Bearer " + Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY));
                }
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

    public void uploadImage(final Context context, final String url, final Map<String, String> _params,
                            final Map<String, Bitmap> imagesParams, final OnApiResponse onApiResponse) {

        HttpsTrustManager.allowAllSSL();
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, url,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        Log.d("ressssssoo", new String(response.data));
                        requestQueue.getCache().clear();
                        onApiResponse.onSuccess(url, new String(response.data));


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            /*
             * If you want to add more parameters with the image
             * you can do it here
             * here we have only one parameter with the image
             * which is tags
             * */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (_params.size() > 0) {
                    Map<String, String> params = new HashMap<>();
                    params = _params;
                    return params;
                } else {
                    return super.getParams();
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                if (Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY) != null) {
                    params.put("Authorization", "Bearer " + Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY));
                }
                return params;
            }

            /*
             *pass files using below method
             * */
            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                for (String key : imagesParams.keySet()) {
                    Log.e("key", key);
                    params.put(key, new DataPart(imagename + ".png", getFileDataFromDrawable(imagesParams.get(key))));
                }

                return params;
            }
        };


        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(volleyMultipartRequest);
    }


    public void uploadFile(final Context context, final String url, final Map<String, String> _params,
                           final Map<String, String> imagesParams, final OnApiResponse onApiResponse) {
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("Please wait...");
        dialog.show();
        HttpsTrustManager.allowAllSSL();
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, url,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        Log.d("ressssssoo", new String(response.data));
                        requestQueue.getCache().clear();
                        onApiResponse.onSuccess(url, new String(response.data));

                        dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {

            /*
             * If you want to add more parameters with the image
             * you can do it here
             * here we have only one parameter with the image
             * which is tags
             * */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params = _params;
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                if (Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY) != null) {
                    params.put("Authorization", "Bearer " + Pref.loadStringPref(context, Pref.AUTH_TOKEN_KEY));
                }
                return params;
            }

            /*
             *pass files using below method
             * */
            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();

                for (String key : imagesParams.keySet()) {
                    Log.e("key", key);
                    String extension = imagesParams.get(key).substring(imagesParams.get(key).lastIndexOf("."));

                    params.put(key, new DataPart(imagename + extension, getByteFromFile(imagesParams.get(key))));
                }

                return params;
            }
        };


        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(volleyMultipartRequest);
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getByteFromFile(String path) {
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bytes;
    }


}
