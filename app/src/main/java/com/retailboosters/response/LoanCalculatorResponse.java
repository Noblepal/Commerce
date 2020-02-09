package com.retailboosters.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoanCalculatorResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("Repayment")
    @Expose
    private String repayment;
    @SerializedName("totalInterset")
    @Expose
    private String totalInterset;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRepayment() {
        return repayment;
    }

    public void setRepayment(String repayment) {
        this.repayment = repayment;
    }

    public String getTotalInterset() {
        return totalInterset;
    }

    public void setTotalInterset(String totalInterset) {
        this.totalInterset = totalInterset;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }


    public class Datum {

        @SerializedName("DueDate")
        @Expose
        private String dueDate;
        @SerializedName("Payment_Due")
        @Expose
        private String paymentDue;
        @SerializedName("Interest")
        @Expose
        private String interest;
        @SerializedName("Principal")
        @Expose
        private String principal;
        @SerializedName("Balance")
        @Expose
        private String balance;

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getPaymentDue() {
            return paymentDue;
        }

        public void setPaymentDue(String paymentDue) {
            this.paymentDue = paymentDue;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getPrincipal() {
            return principal;
        }

        public void setPrincipal(String principal) {
            this.principal = principal;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

    }
}