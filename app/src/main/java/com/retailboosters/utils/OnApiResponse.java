package com.retailboosters.utils;

public interface OnApiResponse {

    public void onSuccess(String method,String response);
    public void onError(String response);

}
