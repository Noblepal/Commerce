package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateOrderResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    public class Data implements Serializable {

        @SerializedName("bankStatement")
        @Expose
        private BankStatement bankStatement;
        @SerializedName("govermentId")
        @Expose
        private GovermentId govermentId;
        @SerializedName("passportPhoto")
        @Expose
        private PassportPhoto passportPhoto;
        @SerializedName("passportOrDrivingLicense")
        @Expose
        private InternationalPassport internationalPassport;
        @SerializedName("license")
        @Expose
        private License license;
        @SerializedName("utilityBill")
        @Expose
        private UtilityBill utilityBill;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("loanId")
        @Expose
        private String loanId;
        @SerializedName("storeId")
        @Expose
        private String storeId;
        @SerializedName("productId")
        @Expose
        private String productId;
        @SerializedName("unitPrice")
        @Expose
        private Integer unitPrice;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("totalAmount")
        @Expose
        private Integer totalAmount;
        @SerializedName("userId")
        @Expose
        private String userId;

        public BankStatement getBankStatement() {
            return bankStatement;
        }

        public void setBankStatement(BankStatement bankStatement) {
            this.bankStatement = bankStatement;
        }

        public GovermentId getGovermentId() {
            return govermentId;
        }

        public void setGovermentId(GovermentId govermentId) {
            this.govermentId = govermentId;
        }

        public PassportPhoto getPassportPhoto() {
            return passportPhoto;
        }

        public void setPassportPhoto(PassportPhoto passportPhoto) {
            this.passportPhoto = passportPhoto;
        }

        public InternationalPassport getInternationalPassport() {
            return internationalPassport;
        }

        public void setInternationalPassport(InternationalPassport internationalPassport) {
            this.internationalPassport = internationalPassport;
        }

        public License getLicense() {
            return license;
        }

        public void setLicense(License license) {
            this.license = license;
        }

        public UtilityBill getUtilityBill() {
            return utilityBill;
        }

        public void setUtilityBill(UtilityBill utilityBill) {
            this.utilityBill = utilityBill;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Integer getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Integer unitPrice) {
            this.unitPrice = unitPrice;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }



        public class GovermentId implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;



            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }

            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class InternationalPassport implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }
            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }
            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class License implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }
            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }
            public String getStatus() {
                return status;
            }



            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class PassportPhoto implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }
            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }
            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class UtilityBill implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }
            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }
            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class BankStatement implements Serializable {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;
            @SerializedName("isEditable")
            @Expose
            private boolean isEditable;
            public boolean isEditable() {
                return isEditable;
            }
            public void setDocument(String document) {
                this.document = document;
            }

            public String getDocument() {
                return document;
            }
            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }


    }
}