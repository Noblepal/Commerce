package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BVNResponse {

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

        @SerializedName("bvn")
        @Expose
        private String bvn;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("middle_name")
        @Expose
        private String middleName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("registration_date")
        @Expose
        private String registrationDate;
        @SerializedName("enrollment_bank")
        @Expose
        private String enrollmentBank;
        @SerializedName("enrollment_branch")
        @Expose
        private String enrollmentBranch;
        @SerializedName("image_base_64")
        @Expose
        private Object imageBase64;
        @SerializedName("address")
        @Expose
        private Object address;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("watch_listed")
        @Expose
        private Object watchListed;
        @SerializedName("nationality")
        @Expose
        private String nationality;
        @SerializedName("marital_status")
        @Expose
        private Object maritalStatus;
        @SerializedName("state_of_residence")
        @Expose
        private Object stateOfResidence;
        @SerializedName("lga_of_residence")
        @Expose
        private Object lgaOfResidence;
        @SerializedName("image")
        @Expose
        private Object image;

        public String getBvn() {
            return bvn;
        }

        public void setBvn(String bvn) {
            this.bvn = bvn;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        public String getEnrollmentBank() {
            return enrollmentBank;
        }

        public void setEnrollmentBank(String enrollmentBank) {
            this.enrollmentBank = enrollmentBank;
        }

        public String getEnrollmentBranch() {
            return enrollmentBranch;
        }

        public void setEnrollmentBranch(String enrollmentBranch) {
            this.enrollmentBranch = enrollmentBranch;
        }

        public Object getImageBase64() {
            return imageBase64;
        }

        public void setImageBase64(Object imageBase64) {
            this.imageBase64 = imageBase64;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getWatchListed() {
            return watchListed;
        }

        public void setWatchListed(Object watchListed) {
            this.watchListed = watchListed;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Object getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(Object maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public Object getStateOfResidence() {
            return stateOfResidence;
        }

        public void setStateOfResidence(Object stateOfResidence) {
            this.stateOfResidence = stateOfResidence;
        }

        public Object getLgaOfResidence() {
            return lgaOfResidence;
        }

        public void setLgaOfResidence(Object lgaOfResidence) {
            this.lgaOfResidence = lgaOfResidence;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

    }
}
