package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductByIdResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("store")
    @Expose
    private Store store;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }


    public class Product {

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

    public class Store {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("storeId")
        @Expose
        private String storeId;
        @SerializedName("storeName")
        @Expose
        private String storeName;
        @SerializedName("phoneNo")
        @Expose
        private String phoneNo;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("storeImage")
        @Expose
        private String storeImage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStoreImage() {
            return storeImage;
        }

        public void setStoreImage(String storeImage) {
            this.storeImage = storeImage;
        }

    }

}