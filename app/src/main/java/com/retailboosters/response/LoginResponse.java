package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("companyName")
    @Expose
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public class Data {

        @SerializedName("bvnVerification")
        @Expose
        private Boolean bvnVerification;
        @SerializedName("loanStep")
        @Expose
        private String loanStep;
        @SerializedName("loanAppSubmit")
        @Expose
        private Boolean loanAppSubmit;
        @SerializedName("roles")
        @Expose
        private List<Object> roles = null;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("hashedPassword")
        @Expose
        private String hashedPassword;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("loanId")
        @Expose
        private String loanId;

        @SerializedName("firstName")
        @Expose
        private String firstName;

        @SerializedName("lastName")
        @Expose
        private String lastName;


        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Boolean getBvnVerification() {
            return bvnVerification;
        }

        public void setBvnVerification(Boolean bvnVerification) {
            this.bvnVerification = bvnVerification;
        }

        public String getLoanStep() {
            return loanStep;
        }

        public void setLoanStep(String loanStep) {
            this.loanStep = loanStep;
        }

        public Boolean getLoanAppSubmit() {
            return loanAppSubmit;
        }

        public void setLoanAppSubmit(Boolean loanAppSubmit) {
            this.loanAppSubmit = loanAppSubmit;
        }

        public List<Object> getRoles() {
            return roles;
        }

        public void setRoles(List<Object> roles) {
            this.roles = roles;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getHashedPassword() {
            return hashedPassword;
        }

        public void setHashedPassword(String hashedPassword) {
            this.hashedPassword = hashedPassword;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

    }
}