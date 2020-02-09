package com.retailboosters.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoanStatusResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("loan")
    @Expose
    private Boolean loan;
    @SerializedName("bvn")
    @Expose
    private Boolean bvn;
    @SerializedName("applicationStatus")
    @Expose
    private Boolean applicationStatus;
    @SerializedName("salaryAndBankStatementStatus")
    @Expose
    private Boolean salaryAndBankStatementStatus;
    @SerializedName("repaymentScheduleStatus")
    @Expose
    private Boolean repaymentScheduleStatus;
    @SerializedName("approvalStatus")
    @Expose
    private Boolean approvalStatus;
    @SerializedName("delieveryStatus")
    @Expose
    private Boolean delieveryStatus;
    @SerializedName("productDetails")
    @Expose
    private ProductDetails productDetails;
    @SerializedName("totalCost")
    @Expose
    private float totalCost;
    @SerializedName("offerAmount")
    @Expose
    private float offerAmount;
    @SerializedName("balancePaid")
    @Expose
    private float balancePaid;
    @SerializedName("repaymentAmount")
    @Expose
    private float repaymentAmount;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getLoan() {
        return loan;
    }

    public void setLoan(Boolean loan) {
        this.loan = loan;
    }

    public Boolean getBvn() {
        return bvn;
    }

    public void setBvn(Boolean bvn) {
        this.bvn = bvn;
    }

    public Boolean getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Boolean applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Boolean getSalaryAndBankStatementStatus() {
        return salaryAndBankStatementStatus;
    }

    public void setSalaryAndBankStatementStatus(Boolean salaryAndBankStatementStatus) {
        this.salaryAndBankStatementStatus = salaryAndBankStatementStatus;
    }

    public Boolean getRepaymentScheduleStatus() {
        return repaymentScheduleStatus;
    }

    public void setRepaymentScheduleStatus(Boolean repaymentScheduleStatus) {
        this.repaymentScheduleStatus = repaymentScheduleStatus;
    }

    public Boolean getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Boolean getDelieveryStatus() {
        return delieveryStatus;
    }

    public void setDelieveryStatus(Boolean delieveryStatus) {
        this.delieveryStatus = delieveryStatus;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public float getOfferAmount() {
        return (int)offerAmount;
    }

    public void setOfferAmount(Integer offerAmount) {
        this.offerAmount = offerAmount;
    }

    public float getBalancePaid() {
        return (int)balancePaid;
    }

    public void setBalancePaid(Integer balancePaid) {
        this.balancePaid = balancePaid;
    }

    public float getRepaymentAmount() {
        return (int)repaymentAmount;
    }

    public void setRepaymentAmount(Integer repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("StatusName")
        @Expose
        private String statusName;
        @SerializedName("Value")
        @Expose
        private Boolean value;

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public Boolean getValue() {
            return value;
        }

        public void setValue(Boolean value) {
            this.value = value;
        }

    }


    public class ProductDetails {

        @SerializedName("isFeatured")
        @Expose
        private Boolean isFeatured;
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

        public Boolean getIsFeatured() {
            return isFeatured;
        }

        public void setIsFeatured(Boolean isFeatured) {
            this.isFeatured = isFeatured;
        }

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