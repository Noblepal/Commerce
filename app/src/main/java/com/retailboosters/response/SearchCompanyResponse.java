package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchCompanyResponse {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("sectore")
    @Expose
    private String sectore;
    @SerializedName("score")
    @Expose
    private Integer score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSectore() {
        return sectore;
    }

    public void setSectore(String sectore) {
        this.sectore = sectore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}