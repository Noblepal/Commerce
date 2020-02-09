package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetLgaFromStateResponse {

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

        @SerializedName("lgas")
        @Expose
        private ArrayList<String> lgas = null;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("alias")
        @Expose
        private String alias;

        public ArrayList<String> getLgas() {
            return lgas;
        }

        public void setLgas(ArrayList<String> lgas) {
            this.lgas = lgas;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

    }
}