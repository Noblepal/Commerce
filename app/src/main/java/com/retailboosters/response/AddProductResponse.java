package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProductResponse {

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

    public class Data {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("store")
        @Expose
        private String store;
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
        @SerializedName("productImage")
        @Expose
        private String productImage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
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

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

    }



}