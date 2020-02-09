package com.retailboosters.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetOrderHistoryResponse {

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
        @SerializedName("paid")
        @Expose
        private Integer paid;
        @SerializedName("amount")
        @Expose
        private float amount;


        @SerializedName("orderDate")
        @Expose
        private String orderDate;

        @SerializedName("expectedDeliveryDate")
        @Expose
        private String expectedDeliveryDate;


        @SerializedName("offerLetter")
        @Expose
        private String offerLetter;

        public String getOfferLetter() {
            return offerLetter;
        }

        public String getExpectedDeliveryDate() {
            return expectedDeliveryDate;
        }

        public String getOrderDate() {
            return orderDate;
        }

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

        public Integer getPaid() {
            return paid;
        }

        public void setPaid(Integer paid) {
            this.paid = paid;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
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



}