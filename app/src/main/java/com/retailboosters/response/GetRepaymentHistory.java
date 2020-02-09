package com.retailboosters.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRepaymentHistory {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

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

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }



    public class Datum {

            @SerializedName("orderId")
            @Expose
            private String orderId;
            @SerializedName("productDetails")
            @Expose
            private ProductDetails productDetails;
            @SerializedName("interest")
            @Expose
            private float interest;
            @SerializedName("tenorAgreed")
            @Expose
            private String tenorAgreed;
            @SerializedName("loanAmount")
            @Expose
            private float loanAmount;
            @SerializedName("quantity")
            @Expose
            private Integer quantity;
            @SerializedName("totalAmount")
            @Expose
            private float totalAmount;
            @SerializedName("creditedBalance")
            @Expose
            private float creditedBalance;
            @SerializedName("applicationStatus")
            @Expose
            private String applicationStatus;
            @SerializedName("createdDate")
            @Expose
            private String createdDate;
            @SerializedName("repaymentHistory")
            @Expose
            private ArrayList<RepaymentHistory> repaymentHistory = null;
            @SerializedName("transactionHistory")
            @Expose
            private List<TransactionHistory> transactionHistory = null;
            @SerializedName("remainPrincipalAmount")
            @Expose
            private float remainPrincipalAmount;
            @SerializedName("adminFeePaid")
            @Expose
            private float adminFeePaid;
            @SerializedName("vatFeePaid")
            @Expose
            private float vatFeePaid;
            @SerializedName("shippingFeePaid")
            @Expose
            private float shippingFeePaid;
            @SerializedName("expectedDeliveryDate")
            @Expose
            private String expectedDeliveryDate;
            @SerializedName("repaymentAmount")
            @Expose
            private float repaymentAmount;
            @SerializedName("nextTransactionDate")
            @Expose
            private String nextTransactionDate;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public ProductDetails getProductDetails() {
                return productDetails;
            }

            public void setProductDetails(ProductDetails productDetails) {
                this.productDetails = productDetails;
            }

            public float getInterest() {
                return interest;
            }

            public void setInterest(float interest) {
                this.interest = interest;
            }

            public String getTenorAgreed() {
                return tenorAgreed;
            }

            public void setTenorAgreed(String tenorAgreed) {
                this.tenorAgreed = tenorAgreed;
            }

            public float getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(float loanAmount) {
                this.loanAmount = loanAmount;
            }

            public Integer getQuantity() {
                return quantity;
            }

            public void setQuantity(Integer quantity) {
                this.quantity = quantity;
            }

            public float getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(float totalAmount) {
                this.totalAmount = totalAmount;
            }

            public float getCreditedBalance() {
                return creditedBalance;
            }

            public void setCreditedBalance(float creditedBalance) {
                this.creditedBalance = creditedBalance;
            }

            public String getApplicationStatus() {
                return applicationStatus;
            }

            public void setApplicationStatus(String applicationStatus) {
                this.applicationStatus = applicationStatus;
            }

            public String getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(String createdDate) {
                this.createdDate = createdDate;
            }

            public ArrayList<RepaymentHistory> getRepaymentHistory() {
                return repaymentHistory;
            }

            public void setRepaymentHistory(ArrayList<RepaymentHistory> repaymentHistory) {
                this.repaymentHistory = repaymentHistory;
            }

            public List<TransactionHistory> getTransactionHistory() {
                return transactionHistory;
            }

            public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
                this.transactionHistory = transactionHistory;
            }

            public float getRemainPrincipalAmount() {
                return remainPrincipalAmount;
            }

            public void setRemainPrincipalAmount(float remainPrincipalAmount) {
                this.remainPrincipalAmount = remainPrincipalAmount;
            }

            public float getAdminFeePaid() {
                return adminFeePaid;
            }

            public void setAdminFeePaid(float adminFeePaid) {
                this.adminFeePaid = adminFeePaid;
            }

            public float getVatFeePaid() {
                return vatFeePaid;
            }

            public void setVatFeePaid(float vatFeePaid) {
                this.vatFeePaid = vatFeePaid;
            }

            public float getShippingFeePaid() {
                return shippingFeePaid;
            }

            public void setShippingFeePaid(float shippingFeePaid) {
                this.shippingFeePaid = shippingFeePaid;
            }

            public String getExpectedDeliveryDate() {
                return expectedDeliveryDate;
            }

            public void setExpectedDeliveryDate(String expectedDeliveryDate) {
                this.expectedDeliveryDate = expectedDeliveryDate;
            }

            public float getRepaymentAmount() {
                return repaymentAmount;
            }

            public void setRepaymentAmount(float repaymentAmount) {
                this.repaymentAmount = repaymentAmount;
            }

            public String getNextTransactionDate() {
                return nextTransactionDate;
            }

            public void setNextTransactionDate(String nextTransactionDate) {
                this.nextTransactionDate = nextTransactionDate;
            }


        public class TransactionHistory {

            @SerializedName("amount")
            @Expose
            private String amount;
            @SerializedName("lastStatusUpdateTime")
            @Expose
            private String lastStatusUpdateTime;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("statuscode")
            @Expose
            private String statuscode;
            @SerializedName("RRR")
            @Expose
            private String rRR;
            @SerializedName("transactionRef")
            @Expose
            private String transactionRef;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getLastStatusUpdateTime() {
                return lastStatusUpdateTime;
            }

            public void setLastStatusUpdateTime(String lastStatusUpdateTime) {
                this.lastStatusUpdateTime = lastStatusUpdateTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatuscode() {
                return statuscode;
            }

            public void setStatuscode(String statuscode) {
                this.statuscode = statuscode;
            }

            public String getRRR() {
                return rRR;
            }

            public void setRRR(String rRR) {
                this.rRR = rRR;
            }

            public String getTransactionRef() {
                return transactionRef;
            }

            public void setTransactionRef(String transactionRef) {
                this.transactionRef = transactionRef;
            }

        }
        public class RepaymentHistory {

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
        public class ProductDetails {

            @SerializedName("_id")
            @Expose
            private String id;
            @SerializedName("shippingFee")
            @Expose
            private Integer shippingFee;
            @SerializedName("VAT")
            @Expose
            private String vAT;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("store")
            @Expose
            private String store;
            @SerializedName("unitprice")
            @Expose
            private Integer unitprice;
            @SerializedName("productName")
            @Expose
            private String productName;
            @SerializedName("productImage")
            @Expose
            private String productImage;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Integer getShippingFee() {
                return shippingFee;
            }

            public void setShippingFee(Integer shippingFee) {
                this.shippingFee = shippingFee;
            }

            public String getVAT() {
                return vAT;
            }

            public void setVAT(String vAT) {
                this.vAT = vAT;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStore() {
                return store;
            }

            public void setStore(String store) {
                this.store = store;
            }

            public Integer getUnitprice() {
                return unitprice;
            }

            public void setUnitprice(Integer unitprice) {
                this.unitprice = unitprice;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductImage() {
                return productImage;
            }

            public void setProductImage(String productImage) {
                this.productImage = productImage;
            }

        }



    }
}