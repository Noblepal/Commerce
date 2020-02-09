package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendOtpResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("smsData")
    @Expose
    private SmsData smsData;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public SmsData getSmsData() {
        return smsData;
    }

    public void setSmsData(SmsData smsData) {
        this.smsData = smsData;
    }


    public class SmsData {

        @SerializedName("SMSMessageData")
        @Expose
        private SMSMessageData sMSMessageData;

        public SMSMessageData getSMSMessageData() {
            return sMSMessageData;
        }

        public void setSMSMessageData(SMSMessageData sMSMessageData) {
            this.sMSMessageData = sMSMessageData;
        }


        public class SMSMessageData {

            @SerializedName("Message")
            @Expose
            private String message;
            @SerializedName("Recipients")
            @Expose
            private List<Recipient> recipients = null;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public List<Recipient> getRecipients() {
                return recipients;
            }

            public void setRecipients(List<Recipient> recipients) {
                this.recipients = recipients;
            }

            public class Recipient {

                @SerializedName("statusCode")
                @Expose
                private Integer statusCode;
                @SerializedName("number")
                @Expose
                private String number;
                @SerializedName("cost")
                @Expose
                private String cost;
                @SerializedName("status")
                @Expose
                private String status;
                @SerializedName("messageId")
                @Expose
                private String messageId;

                public Integer getStatusCode() {
                    return statusCode;
                }

                public void setStatusCode(Integer statusCode) {
                    this.statusCode = statusCode;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getCost() {
                    return cost;
                }

                public void setCost(String cost) {
                    this.cost = cost;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getMessageId() {
                    return messageId;
                }

                public void setMessageId(String messageId) {
                    this.messageId = messageId;
                }

            }

        }

    }


    public class Data {

        @SerializedName("isVerify")
        @Expose
        private Boolean isVerify;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("otp")
        @Expose
        private String otp;
        @SerializedName("mobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("otpNumber")
        @Expose
        private String otpNumber;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public Boolean getIsVerify() {
            return isVerify;
        }

        public void setIsVerify(Boolean isVerify) {
            this.isVerify = isVerify;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getOtpNumber() {
            return otpNumber;
        }

        public void setOtpNumber(String otpNumber) {
            this.otpNumber = otpNumber;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

    }
}