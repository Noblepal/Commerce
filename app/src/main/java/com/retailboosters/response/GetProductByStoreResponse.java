package com.retailboosters.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductByStoreResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }


    public class Datum implements Serializable{

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("productName")
        @Expose
        private String productName;
        @SerializedName("unitprice")
        @Expose
        private Integer unitprice;
        @SerializedName("VAT")
        @Expose
        private String vAT;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("store")
        @Expose
        private String store;
        @SerializedName("productImage")
        @Expose
        private String productImage;

        @SerializedName("shippingFee")
        @Expose
        private float shippingFee;

        @SerializedName("isFeatured")
        @Expose
        private boolean isFeatured;


        private int quantity;

        public boolean isFeatured() {
            return isFeatured;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        public float getShippingFee() {
            return shippingFee;
        }

        public void setShippingFee(float shippingFee) {
            this.shippingFee = shippingFee;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getUnitprice() {
            return unitprice;
        }

        public void setUnitprice(Integer unitprice) {
            this.unitprice = unitprice;
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

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

    }

}