package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step4Response {

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
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("annualMonthlyRevenue")
        @Expose
        private String annualMonthlyRevenue;
        @SerializedName("annualRevenue")
        @Expose
        private String annualRevenue;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("employmentLga")
        @Expose
        private String employmentLga;
        @SerializedName("employmentStatus")
        @Expose
        private String employmentStatus;
        @SerializedName("grossMonthlySalary")
        @Expose
        private String grossMonthlySalary;
        @SerializedName("jobsInLast5Years")
        @Expose
        private String jobsInLast5Years;
        @SerializedName("keyLandMark")
        @Expose
        private String keyLandMark;
        @SerializedName("lastEmployment")
        @Expose
        private String lastEmployment;
        @SerializedName("netMonthlySalary")
        @Expose
        private String netMonthlySalary;
        @SerializedName("officeAddress")
        @Expose
        private String officeAddress;
        @SerializedName("officePhone")
        @Expose
        private String officePhone;
        @SerializedName("officialEmail")
        @Expose
        private String officialEmail;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("taxId")
        @Expose
        private String taxId;
        @SerializedName("timeAtOrganisation")
        @Expose
        private String timeAtOrganisation;
        @SerializedName("yearsSpentAtLastEmployment")
        @Expose
        private String yearsSpentAtLastEmployment;
        @SerializedName("CurrentlyOwingAnyOrganisation")
        @Expose
        private String currentlyOwingAnyOrganisation;
        @SerializedName("contractEnding")
        @Expose
        private String contractEnding;
        @SerializedName("contribution")
        @Expose
        private String contribution;
        @SerializedName("disbursed")
        @Expose
        private String disbursed;
        @SerializedName("employmentTerm")
        @Expose
        private String employmentTerm;
        @SerializedName("fromWhere")
        @Expose
        private String fromWhere;
        @SerializedName("itemOfPurchase")
        @Expose
        private String itemOfPurchase;
        @SerializedName("missedRepaymentDate")
        @Expose
        private String missedRepaymentDate;
        @SerializedName("month")
        @Expose
        private String month;
        @SerializedName("otherAccount")
        @Expose
        private String otherAccount;
        @SerializedName("otherBank")
        @Expose
        private String otherBank;
        @SerializedName("otherSourceOfIncome")
        @Expose
        private String otherSourceOfIncome;
        @SerializedName("outstanding")
        @Expose
        private String outstanding;
        @SerializedName("reasonForMissingRepayment")
        @Expose
        private String reasonForMissingRepayment;
        @SerializedName("repaymentAccount")
        @Expose
        private String repaymentAccount;
        @SerializedName("repaymentBank")
        @Expose
        private String repaymentBank;
        @SerializedName("stateValueOfLoan")
        @Expose
        private String stateValueOfLoan;
        @SerializedName("tenor")
        @Expose
        private String tenor;
        @SerializedName("tenorOfContract")
        @Expose
        private String tenorOfContract;
        @SerializedName("tenorOfCreditPayment")
        @Expose
        private String tenorOfCreditPayment;
        @SerializedName("value")
        @Expose
        private String value;

        @SerializedName("repaymentAccountName")
        @Expose
        private String repaymentAccountName;

        @SerializedName("otherAccountName")
        @Expose
        private String otherAccountName;

        @SerializedName("accountDetailForRepayment")
        @Expose
        private String accountDetailForRepayment;


        public String getAccountDetailForRepayment() {
            return accountDetailForRepayment;
        }

        public void setAccountDetailForRepayment(String accountDetailForRepayment) {
            this.accountDetailForRepayment = accountDetailForRepayment;
        }

        public String getOtherAccountName() {
            return otherAccountName;
        }

        public void setOtherAccountName(String otherAccountName) {
            this.otherAccountName = otherAccountName;
        }

        public String getRepaymentAccountName() {
            return repaymentAccountName;
        }

        public void setRepaymentAccountName(String repaymentAccountName) {
            this.repaymentAccountName = repaymentAccountName;
        }

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAnnualMonthlyRevenue() {
            return annualMonthlyRevenue;
        }

        public void setAnnualMonthlyRevenue(String annualMonthlyRevenue) {
            this.annualMonthlyRevenue = annualMonthlyRevenue;
        }

        public String getAnnualRevenue() {
            return annualRevenue;
        }

        public void setAnnualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmploymentLga() {
            return employmentLga;
        }

        public void setEmploymentLga(String employmentLga) {
            this.employmentLga = employmentLga;
        }

        public String getEmploymentStatus() {
            return employmentStatus;
        }

        public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
        }

        public String getGrossMonthlySalary() {
            return grossMonthlySalary;
        }

        public void setGrossMonthlySalary(String grossMonthlySalary) {
            this.grossMonthlySalary = grossMonthlySalary;
        }

        public String getJobsInLast5Years() {
            return jobsInLast5Years;
        }

        public void setJobsInLast5Years(String jobsInLast5Years) {
            this.jobsInLast5Years = jobsInLast5Years;
        }

        public String getKeyLandMark() {
            return keyLandMark;
        }

        public void setKeyLandMark(String keyLandMark) {
            this.keyLandMark = keyLandMark;
        }

        public String getLastEmployment() {
            return lastEmployment;
        }

        public void setLastEmployment(String lastEmployment) {
            this.lastEmployment = lastEmployment;
        }

        public String getNetMonthlySalary() {
            return netMonthlySalary;
        }

        public void setNetMonthlySalary(String netMonthlySalary) {
            this.netMonthlySalary = netMonthlySalary;
        }

        public String getOfficeAddress() {
            return officeAddress;
        }

        public void setOfficeAddress(String officeAddress) {
            this.officeAddress = officeAddress;
        }

        public String getOfficePhone() {
            return officePhone;
        }

        public void setOfficePhone(String officePhone) {
            this.officePhone = officePhone;
        }

        public String getOfficialEmail() {
            return officialEmail;
        }

        public void setOfficialEmail(String officialEmail) {
            this.officialEmail = officialEmail;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTaxId() {
            return taxId;
        }

        public void setTaxId(String taxId) {
            this.taxId = taxId;
        }

        public String getTimeAtOrganisation() {
            return timeAtOrganisation;
        }

        public void setTimeAtOrganisation(String timeAtOrganisation) {
            this.timeAtOrganisation = timeAtOrganisation;
        }

        public String getYearsSpentAtLastEmployment() {
            return yearsSpentAtLastEmployment;
        }

        public void setYearsSpentAtLastEmployment(String yearsSpentAtLastEmployment) {
            this.yearsSpentAtLastEmployment = yearsSpentAtLastEmployment;
        }

        public String getCurrentlyOwingAnyOrganisation() {
            return currentlyOwingAnyOrganisation;
        }

        public void setCurrentlyOwingAnyOrganisation(String currentlyOwingAnyOrganisation) {
            this.currentlyOwingAnyOrganisation = currentlyOwingAnyOrganisation;
        }

        public String getContractEnding() {
            return contractEnding;
        }

        public void setContractEnding(String contractEnding) {
            this.contractEnding = contractEnding;
        }

        public String getContribution() {
            return contribution;
        }

        public void setContribution(String contribution) {
            this.contribution = contribution;
        }

        public String getDisbursed() {
            return disbursed;
        }

        public void setDisbursed(String disbursed) {
            this.disbursed = disbursed;
        }

        public String getEmploymentTerm() {
            return employmentTerm;
        }

        public void setEmploymentTerm(String employmentTerm) {
            this.employmentTerm = employmentTerm;
        }

        public String getFromWhere() {
            return fromWhere;
        }

        public void setFromWhere(String fromWhere) {
            this.fromWhere = fromWhere;
        }

        public String getItemOfPurchase() {
            return itemOfPurchase;
        }

        public void setItemOfPurchase(String itemOfPurchase) {
            this.itemOfPurchase = itemOfPurchase;
        }

        public String getMissedRepaymentDate() {
            return missedRepaymentDate;
        }

        public void setMissedRepaymentDate(String missedRepaymentDate) {
            this.missedRepaymentDate = missedRepaymentDate;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getOtherAccount() {
            return otherAccount;
        }

        public void setOtherAccount(String otherAccount) {
            this.otherAccount = otherAccount;
        }

        public String getOtherBank() {
            return otherBank;
        }

        public void setOtherBank(String otherBank) {
            this.otherBank = otherBank;
        }

        public String getOtherSourceOfIncome() {
            return otherSourceOfIncome;
        }

        public void setOtherSourceOfIncome(String otherSourceOfIncome) {
            this.otherSourceOfIncome = otherSourceOfIncome;
        }

        public String getOutstanding() {
            return outstanding;
        }

        public void setOutstanding(String outstanding) {
            this.outstanding = outstanding;
        }

        public String getReasonForMissingRepayment() {
            return reasonForMissingRepayment;
        }

        public void setReasonForMissingRepayment(String reasonForMissingRepayment) {
            this.reasonForMissingRepayment = reasonForMissingRepayment;
        }

        public String getRepaymentAccount() {
            return repaymentAccount;
        }

        public void setRepaymentAccount(String repaymentAccount) {
            this.repaymentAccount = repaymentAccount;
        }

        public String getRepaymentBank() {
            return repaymentBank;
        }

        public void setRepaymentBank(String repaymentBank) {
            this.repaymentBank = repaymentBank;
        }

        public String getStateValueOfLoan() {
            return stateValueOfLoan;
        }

        public void setStateValueOfLoan(String stateValueOfLoan) {
            this.stateValueOfLoan = stateValueOfLoan;
        }

        public String getTenor() {
            return tenor;
        }

        public void setTenor(String tenor) {
            this.tenor = tenor;
        }

        public String getTenorOfContract() {
            return tenorOfContract;
        }

        public void setTenorOfContract(String tenorOfContract) {
            this.tenorOfContract = tenorOfContract;
        }

        public String getTenorOfCreditPayment() {
            return tenorOfCreditPayment;
        }

        public void setTenorOfCreditPayment(String tenorOfCreditPayment) {
            this.tenorOfCreditPayment = tenorOfCreditPayment;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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