package com.retailboosters.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemitaGetUrlResponse {

    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("responseCode")
    @Expose
    private String responseCode;
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;
    @SerializedName("iResponseCode")
    @Expose
    private Object iResponseCode;
    @SerializedName("iResponseMessage")
    @Expose
    private Object iResponseMessage;
    @SerializedName("appVersionCode")
    @Expose
    private Object appVersionCode;
    @SerializedName("responseData")
    @Expose
    private List<ResponseDatum> responseData = null;
    @SerializedName("data")
    @Expose
    private Object data;

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Object getIResponseCode() {
        return iResponseCode;
    }

    public void setIResponseCode(Object iResponseCode) {
        this.iResponseCode = iResponseCode;
    }

    public Object getIResponseMessage() {
        return iResponseMessage;
    }

    public void setIResponseMessage(Object iResponseMessage) {
        this.iResponseMessage = iResponseMessage;
    }

    public Object getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Object appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public List<ResponseDatum> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public class ResponseDatum {

        @SerializedName("authorizationUrl")
        @Expose
        private String authorizationUrl;
        @SerializedName("rrr")
        @Expose
        private String rrr;

        public String getAuthorizationUrl() {
            return authorizationUrl;
        }

        public void setAuthorizationUrl(String authorizationUrl) {
            this.authorizationUrl = authorizationUrl;
        }

        public String getRrr() {
            return rrr;
        }

        public void setRrr(String rrr) {
            this.rrr = rrr;
        }

    }

}