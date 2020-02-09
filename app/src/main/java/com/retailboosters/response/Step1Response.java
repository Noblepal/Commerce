package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step1Response {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    public class Data {

        @SerializedName("bankStatement")
        @Expose
        private BankStatement bankStatement;
        @SerializedName("govermentId")
        @Expose
        private GovermentId govermentId;
        @SerializedName("passportPhoto")
        @Expose
        private PassportPhoto passportPhoto;
        @SerializedName("passport")
        @Expose
        private Passport passport;
        @SerializedName("license")
        @Expose
        private License license;
        @SerializedName("utilityBill")
        @Expose
        private UtilityBill utilityBill;
        @SerializedName("applicationStatus")
        @Expose
        private String applicationStatus;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("maritalStatus")
        @Expose
        private String maritalStatus;
        @SerializedName("meansOfIdentification")
        @Expose
        private String meansOfIdentification;
        @SerializedName("identificationNumber")
        @Expose
        private String identificationNumber;
        @SerializedName("expiryDateOfId")
        @Expose
        private String expiryDateOfId;
        @SerializedName("dateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("numberOfDependents")
        @Expose
        private Integer numberOfDependents;
        @SerializedName("age")
        @Expose
        private String age;
        @SerializedName("educationalBackGround")
        @Expose
        private String educationalBackGround;
        @SerializedName("residentialAddress")
        @Expose
        private String residentialAddress;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("applicationNumber")
        @Expose
        private String applicationNumber;

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

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String status){
            maritalStatus = status;
        }
        public Passport getPassport() {
            return passport;
        }

        public void setPassport(Passport passport) {
            this.passport = passport;
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

        public String getApplicationStatus() {
            return applicationStatus;
        }

        public void setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMeansOfIdentification() {
            return meansOfIdentification;
        }

        public void setMeansOfIdentification(String meansOfIdentification) {
            this.meansOfIdentification = meansOfIdentification;
        }

        public String getIdentificationNumber() {
            return identificationNumber;
        }

        public void setIdentificationNumber(String identificationNumber) {
            this.identificationNumber = identificationNumber;
        }

        public String getExpiryDateOfId() {
            return expiryDateOfId;
        }

        public void setExpiryDateOfId(String expiryDateOfId) {
            this.expiryDateOfId = expiryDateOfId;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Integer getNumberOfDependents() {
            return numberOfDependents;
        }

        public void setNumberOfDependents(Integer numberOfDependents) {
            this.numberOfDependents = numberOfDependents;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getEducationalBackGround() {
            return educationalBackGround;
        }

        public void setEducationalBackGround(String educationalBackGround) {
            this.educationalBackGround = educationalBackGround;
        }

        public String getResidentialAddress() {
            return residentialAddress;
        }

        public void setResidentialAddress(String residentialAddress) {
            this.residentialAddress = residentialAddress;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getApplicationNumber() {
            return applicationNumber;
        }

        public void setApplicationNumber(String applicationNumber) {
            this.applicationNumber = applicationNumber;
        }



        public class BankStatement {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class GovermentId {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class License {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }


        public class Passport {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }


        public class PassportPhoto {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

        public class UtilityBill {

            @SerializedName("status")
            @Expose
            private String status;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }

    }
}