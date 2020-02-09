package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step2Response {

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
        @SerializedName("HowtogetToYourHome")
        @Expose
        private String howtogetToYourHome;
        @SerializedName("accomodationType")
        @Expose
        private String accomodationType;
        @SerializedName("buildingDiscription")
        @Expose
        private String buildingDiscription;
        @SerializedName("buildingDiscriptionOfPrevious")
        @Expose
        private String buildingDiscriptionOfPrevious;
        @SerializedName("commonNameCalledAtHome")
        @Expose
        private String commonNameCalledAtHome;
        @SerializedName("contactLga")
        @Expose
        private String contactLga;
        @SerializedName("state1")
        @Expose
        private String state;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("homeAddress")
        @Expose
        private String homeAddress;
        @SerializedName("lengthOfStay")
        @Expose
        private String lengthOfStay;
        @SerializedName("mobileNo1")
        @Expose
        private String mobileNo1;
        @SerializedName("mobileNo2")
        @Expose
        private String mobileNo2;
        @SerializedName("mobileNo3")
        @Expose
        private String mobileNo3;
        @SerializedName("nearestBusStop")
        @Expose
        private String nearestBusStop;
        @SerializedName("nearestBusStopOfPrevious")
        @Expose
        private String nearestBusStopOfPrevious;
        @SerializedName("previousResidentialAddress")
        @Expose
        private String previousResidentialAddress;
        @SerializedName("refereeMobileNo")
        @Expose
        private String refereeMobileNo;
        @SerializedName("refereeName")
        @Expose
        private String refereeName;
        @SerializedName("spouseEmail")
        @Expose
        private String spouseEmail;
        @SerializedName("spouseMobileNo")
        @Expose
        private String spouseMobileNo;
        @SerializedName("spouseName")
        @Expose
        private String spouseName;
        @SerializedName("typeOfApartment")
        @Expose
        private String typeOfApartment;
        @SerializedName("typeOfHouse")
        @Expose
        private String typeOfHouse;

        public String getState() {
            return state;
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

        public String getHowtogetToYourHome() {
            return howtogetToYourHome;
        }

        public void setHowtogetToYourHome(String howtogetToYourHome) {
            this.howtogetToYourHome = howtogetToYourHome;
        }

        public String getAccomodationType() {
            return accomodationType;
        }

        public void setAccomodationType(String accomodationType) {
            this.accomodationType = accomodationType;
        }

        public String getBuildingDiscription() {
            return buildingDiscription;
        }

        public void setBuildingDiscription(String buildingDiscription) {
            this.buildingDiscription = buildingDiscription;
        }

        public void setState(String state){
            this.state = state;
        }

        public String getBuildingDiscriptionOfPrevious() {
            return buildingDiscriptionOfPrevious;
        }

        public void setBuildingDiscriptionOfPrevious(String buildingDiscriptionOfPrevious) {
            this.buildingDiscriptionOfPrevious = buildingDiscriptionOfPrevious;
        }

        public String getCommonNameCalledAtHome() {
            return commonNameCalledAtHome;
        }

        public void setCommonNameCalledAtHome(String commonNameCalledAtHome) {
            this.commonNameCalledAtHome = commonNameCalledAtHome;
        }

        public String getContactLga() {
            return contactLga;
        }

        public void setContactLga(String contactLga) {
            this.contactLga = contactLga;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
        }

        public String getLengthOfStay() {
            return lengthOfStay;
        }

        public void setLengthOfStay(String lengthOfStay) {
            this.lengthOfStay = lengthOfStay;
        }

        public String getMobileNo1() {
            return mobileNo1;
        }

        public void setMobileNo1(String mobileNo1) {
            this.mobileNo1 = mobileNo1;
        }

        public String getMobileNo2() {
            return mobileNo2;
        }

        public void setMobileNo2(String mobileNo2) {
            this.mobileNo2 = mobileNo2;
        }

        public String getMobileNo3() {
            return mobileNo3;
        }

        public void setMobileNo3(String mobileNo3) {
            this.mobileNo3 = mobileNo3;
        }

        public String getNearestBusStop() {
            return nearestBusStop;
        }

        public void setNearestBusStop(String nearestBusStop) {
            this.nearestBusStop = nearestBusStop;
        }

        public String getNearestBusStopOfPrevious() {
            return nearestBusStopOfPrevious;
        }

        public void setNearestBusStopOfPrevious(String nearestBusStopOfPrevious) {
            this.nearestBusStopOfPrevious = nearestBusStopOfPrevious;
        }

        public String getPreviousResidentialAddress() {
            return previousResidentialAddress;
        }

        public void setPreviousResidentialAddress(String previousResidentialAddress) {
            this.previousResidentialAddress = previousResidentialAddress;
        }

        public String getRefereeMobileNo() {
            return refereeMobileNo;
        }

        public void setRefereeMobileNo(String refereeMobileNo) {
            this.refereeMobileNo = refereeMobileNo;
        }

        public String getRefereeName() {
            return refereeName;
        }

        public void setRefereeName(String refereeName) {
            this.refereeName = refereeName;
        }

        public String getSpouseEmail() {
            return spouseEmail;
        }

        public void setSpouseEmail(String spouseEmail) {
            this.spouseEmail = spouseEmail;
        }

        public String getSpouseMobileNo() {
            return spouseMobileNo;
        }

        public void setSpouseMobileNo(String spouseMobileNo) {
            this.spouseMobileNo = spouseMobileNo;
        }

        public String getSpouseName() {
            return spouseName;
        }

        public void setSpouseName(String spouseName) {
            this.spouseName = spouseName;
        }

        public String getTypeOfApartment() {
            return typeOfApartment;
        }

        public void setTypeOfApartment(String typeOfApartment) {
            this.typeOfApartment = typeOfApartment;
        }

        public String getTypeOfHouse() {
            return typeOfHouse;
        }

        public void setTypeOfHouse(String typeOfHouse) {
            this.typeOfHouse = typeOfHouse;
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