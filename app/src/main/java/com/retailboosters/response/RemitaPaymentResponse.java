package com.retailboosters.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemitaPaymentResponse {

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

        @SerializedName("paymentReference")
        @Expose
        private String paymentReference;
        @SerializedName("amount")
        @Expose
        private Double amount;
        @SerializedName("paymentState")
        @Expose
        private String paymentState;
        @SerializedName("paymentDate")
        @Expose
        private long paymentDate;
        @SerializedName("processorId")
        @Expose
        private String processorId;
        @SerializedName("transactionId")
        @Expose
        private String transactionId;
        @SerializedName("tokenized")
        @Expose
        private Boolean tokenized;
        @SerializedName("paymentToken")
        @Expose
        private Object paymentToken;
        @SerializedName("cardType")
        @Expose
        private Object cardType;
        @SerializedName("debitedAmount")
        @Expose
        private Double debitedAmount;
        @SerializedName("message")
        @Expose
        private String message;

        public String getPaymentReference() {
            return paymentReference;
        }

        public void setPaymentReference(String paymentReference) {
            this.paymentReference = paymentReference;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getPaymentState() {
            return paymentState;
        }

        public void setPaymentState(String paymentState) {
            this.paymentState = paymentState;
        }

        public long getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(long paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getProcessorId() {
            return processorId;
        }

        public void setProcessorId(String processorId) {
            this.processorId = processorId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public Boolean getTokenized() {
            return tokenized;
        }

        public void setTokenized(Boolean tokenized) {
            this.tokenized = tokenized;
        }

        public Object getPaymentToken() {
            return paymentToken;
        }

        public void setPaymentToken(Object paymentToken) {
            this.paymentToken = paymentToken;
        }

        public Object getCardType() {
            return cardType;
        }

        public void setCardType(Object cardType) {
            this.cardType = cardType;
        }

        public Double getDebitedAmount() {
            return debitedAmount;
        }

        public void setDebitedAmount(Double debitedAmount) {
            this.debitedAmount = debitedAmount;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

}