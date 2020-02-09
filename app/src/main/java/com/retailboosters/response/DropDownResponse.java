package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DropDownResponse {

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

        @SerializedName("interest")
        @Expose
        private Interest interest;
        @SerializedName("loanApplicationCredit")
        @Expose
        private LoanApplicationCredit loanApplicationCredit;
        @SerializedName("dropDown")
        @Expose
        private DropDown dropDown;
        @SerializedName("Anual_Interest_rate")
        @Expose
        private Integer anualInterestRate;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("company")
        @Expose
        private List<Company> company = null;
        @SerializedName("productSetting")
        @Expose
        private ProductSetting productSetting;
        public ProductSetting getProductSetting() {
            return productSetting;
        }

        public void setProductSetting(ProductSetting productSetting) {
            this.productSetting = productSetting;
        }
        public Interest getInterest() {
            return interest;
        }

        public void setInterest(Interest interest) {
            this.interest = interest;
        }

        public LoanApplicationCredit getLoanApplicationCredit() {
            return loanApplicationCredit;
        }

        public void setLoanApplicationCredit(LoanApplicationCredit loanApplicationCredit) {
            this.loanApplicationCredit = loanApplicationCredit;
        }

        public DropDown getDropDown() {
            return dropDown;
        }

        public void setDropDown(DropDown dropDown) {
            this.dropDown = dropDown;
        }

        public Integer getAnualInterestRate() {
            return anualInterestRate;
        }

        public void setAnualInterestRate(Integer anualInterestRate) {
            this.anualInterestRate = anualInterestRate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Company> getCompany() {
            return company;
        }

        public void setCompany(List<Company> company) {
            this.company = company;
        }

        public class ProductSetting {

            @SerializedName("VAT")
            @Expose
            private Integer vAT;
            @SerializedName("shippinFee")
            @Expose
            private Integer shippinFee;
            @SerializedName("adminFee")
            @Expose
            private Integer adminFee;

            public Integer getVAT() {
                return vAT;
            }

            public void setVAT(Integer vAT) {
                this.vAT = vAT;
            }

            public Integer getShippinFee() {
                return shippinFee;
            }

            public void setShippinFee(Integer shippinFee) {
                this.shippinFee = shippinFee;
            }

            public Integer getAdminFee() {
                return adminFee;
            }

            public void setAdminFee(Integer adminFee) {
                this.adminFee = adminFee;
            }

        }

        public class LoanApplicationCredit {

            @SerializedName("FormCompletion")
            @Expose
            private Integer formCompletion;
            @SerializedName("ageband")
            @Expose
            private Integer ageband;
            @SerializedName("numberOfDependents")
            @Expose
            private Integer numberOfDependents;
            @SerializedName("educationalBackground")
            @Expose
            private Integer educationalBackground;
            @SerializedName("homeAddress")
            @Expose
            private Integer homeAddress;
            @SerializedName("timeOfStayAtCurrentAddress")
            @Expose
            private Integer timeOfStayAtCurrentAddress;
            @SerializedName("typeOfAccommodation")
            @Expose
            private Integer typeOfAccommodation;
            @SerializedName("typeOfApartment")
            @Expose
            private Integer typeOfApartment;
            @SerializedName("sex")
            @Expose
            private Integer sex;
            @SerializedName("maritalStatus")
            @Expose
            private Integer maritalStatus;
            @SerializedName("refereeMobileNumber")
            @Expose
            private Integer refereeMobileNumber;
            @SerializedName("spouseMobileNumber")
            @Expose
            private Integer spouseMobileNumber;
            @SerializedName("employerMobileNumber")
            @Expose
            private Integer employerMobileNumber;
            @SerializedName("DeclarationOfExistingObligation")
            @Expose
            private Integer declarationOfExistingObligation;
            @SerializedName("positiveCreditBureauRecord")
            @Expose
            private Integer positiveCreditBureauRecord;
            @SerializedName("loanPaidOnDueDates")
            @Expose
            private Integer loanPaidOnDueDates;
            @SerializedName("yearsSpentInCurrentEmployment")
            @Expose
            private Integer yearsSpentInCurrentEmployment;
            @SerializedName("employmentTerm")
            @Expose
            private Integer employmentTerm;
            @SerializedName("insurableItemcategory")
            @Expose
            private Integer insurableItemcategory;
            @SerializedName("monthlyNetSalary")
            @Expose
            private Integer monthlyNetSalary;
            @SerializedName("loanRepaymentSum")
            @Expose
            private Integer loanRepaymentSum;

            public Integer getFormCompletion() {
                return formCompletion;
            }

            public void setFormCompletion(Integer formCompletion) {
                this.formCompletion = formCompletion;
            }

            public Integer getAgeband() {
                return ageband;
            }

            public void setAgeband(Integer ageband) {
                this.ageband = ageband;
            }

            public Integer getNumberOfDependents() {
                return numberOfDependents;
            }

            public void setNumberOfDependents(Integer numberOfDependents) {
                this.numberOfDependents = numberOfDependents;
            }

            public Integer getEducationalBackground() {
                return educationalBackground;
            }

            public void setEducationalBackground(Integer educationalBackground) {
                this.educationalBackground = educationalBackground;
            }

            public Integer getHomeAddress() {
                return homeAddress;
            }

            public void setHomeAddress(Integer homeAddress) {
                this.homeAddress = homeAddress;
            }

            public Integer getTimeOfStayAtCurrentAddress() {
                return timeOfStayAtCurrentAddress;
            }

            public void setTimeOfStayAtCurrentAddress(Integer timeOfStayAtCurrentAddress) {
                this.timeOfStayAtCurrentAddress = timeOfStayAtCurrentAddress;
            }

            public Integer getTypeOfAccommodation() {
                return typeOfAccommodation;
            }

            public void setTypeOfAccommodation(Integer typeOfAccommodation) {
                this.typeOfAccommodation = typeOfAccommodation;
            }

            public Integer getTypeOfApartment() {
                return typeOfApartment;
            }

            public void setTypeOfApartment(Integer typeOfApartment) {
                this.typeOfApartment = typeOfApartment;
            }

            public Integer getSex() {
                return sex;
            }

            public void setSex(Integer sex) {
                this.sex = sex;
            }

            public Integer getMaritalStatus() {
                return maritalStatus;
            }

            public void setMaritalStatus(Integer maritalStatus) {
                this.maritalStatus = maritalStatus;
            }

            public Integer getRefereeMobileNumber() {
                return refereeMobileNumber;
            }

            public void setRefereeMobileNumber(Integer refereeMobileNumber) {
                this.refereeMobileNumber = refereeMobileNumber;
            }

            public Integer getSpouseMobileNumber() {
                return spouseMobileNumber;
            }

            public void setSpouseMobileNumber(Integer spouseMobileNumber) {
                this.spouseMobileNumber = spouseMobileNumber;
            }

            public Integer getEmployerMobileNumber() {
                return employerMobileNumber;
            }

            public void setEmployerMobileNumber(Integer employerMobileNumber) {
                this.employerMobileNumber = employerMobileNumber;
            }

            public Integer getDeclarationOfExistingObligation() {
                return declarationOfExistingObligation;
            }

            public void setDeclarationOfExistingObligation(Integer declarationOfExistingObligation) {
                this.declarationOfExistingObligation = declarationOfExistingObligation;
            }

            public Integer getPositiveCreditBureauRecord() {
                return positiveCreditBureauRecord;
            }

            public void setPositiveCreditBureauRecord(Integer positiveCreditBureauRecord) {
                this.positiveCreditBureauRecord = positiveCreditBureauRecord;
            }

            public Integer getLoanPaidOnDueDates() {
                return loanPaidOnDueDates;
            }

            public void setLoanPaidOnDueDates(Integer loanPaidOnDueDates) {
                this.loanPaidOnDueDates = loanPaidOnDueDates;
            }

            public Integer getYearsSpentInCurrentEmployment() {
                return yearsSpentInCurrentEmployment;
            }

            public void setYearsSpentInCurrentEmployment(Integer yearsSpentInCurrentEmployment) {
                this.yearsSpentInCurrentEmployment = yearsSpentInCurrentEmployment;
            }

            public Integer getEmploymentTerm() {
                return employmentTerm;
            }

            public void setEmploymentTerm(Integer employmentTerm) {
                this.employmentTerm = employmentTerm;
            }

            public Integer getInsurableItemcategory() {
                return insurableItemcategory;
            }

            public void setInsurableItemcategory(Integer insurableItemcategory) {
                this.insurableItemcategory = insurableItemcategory;
            }

            public Integer getMonthlyNetSalary() {
                return monthlyNetSalary;
            }

            public void setMonthlyNetSalary(Integer monthlyNetSalary) {
                this.monthlyNetSalary = monthlyNetSalary;
            }

            public Integer getLoanRepaymentSum() {
                return loanRepaymentSum;
            }

            public void setLoanRepaymentSum(Integer loanRepaymentSum) {
                this.loanRepaymentSum = loanRepaymentSum;
            }

        }

        public class DropDown {

            @SerializedName("title")
            @Expose
            private List<String> title = null;
            @SerializedName("gender")
            @Expose
            private List<String> gender = null;
            @SerializedName("maritalStatus")
            @Expose
            private List<String> maritalStatus = null;


            @SerializedName("meansOfIdentification")
            @Expose
            private List<String> meansOfIdentification = null;
            @SerializedName("numberOfDependents")
            @Expose
            private List<String> numberOfDependents = null;
            @SerializedName("educationalBackground")
            @Expose
            private List<String> educationalBackground = null;
            @SerializedName("LGA")
            @Expose
            private List<String> lGA = null;
            @SerializedName("typeOfHouse")
            @Expose
            private List<String> typeOfHouse = null;
            @SerializedName("typeOfAppartment")
            @Expose
            private List<String> typeOfAppartment = null;
            @SerializedName("accommodationType")
            @Expose
            private List<String> accommodationType = null;
            @SerializedName("lengthOfStay")
            @Expose
            private List<String> lengthOfStay = null;
            @SerializedName("eployementLGA")
            @Expose
            private List<String> eployementLGA = null;
            @SerializedName("state")
            @Expose
            private List<String> state = null;
            @SerializedName("timeAtOrganisation")
            @Expose
            private List<String> timeAtOrganisation = null;
            @SerializedName("yearSpentAtLastOrganisation")
            @Expose
            private List<String> yearSpentAtLastOrganisation = null;
            @SerializedName("jobsInLast5Years")
            @Expose
            private List<String> jobsInLast5Years = null;
            @SerializedName("annualRevenue")
            @Expose
            private List<String> annualRevenue = null;
            @SerializedName("tenor")
            @Expose
            private List<String> tenor = null;
            @SerializedName("otherSourseOfIncome")
            @Expose
            private List<String> otherSourseOfIncome = null;
            @SerializedName("HowmuchMonth")
            @Expose
            private List<String> howmuchMonth = null;
            @SerializedName("repaymentBankbank")
            @Expose
            private List<String> repaymentBankbank = null;
            @SerializedName("OtherBank")
            @Expose
            private List<String> otherBank = null;

            @SerializedName("employmentStatus")
            @Expose
            private List<String> employementStatus = null;
            @SerializedName("ageBand")
            @Expose
            private List<String> ageBand = null;


            @SerializedName("repaymentPeriod")
            @Expose
            private List<String> repaymentPeriod = null;


            public List<String> getEmployementStatus() {
                return employementStatus;
            }
            public List<String> getAgeBand() {
                return ageBand;
            }
            public List<String> getRepaymentPeriod() {
                return repaymentPeriod;
            }

            public void setEmployementStatus(List<String> employementStatus) {
                this.employementStatus = employementStatus;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<String> getGender() {
                return gender;
            }

            public List<String> getMaritalStatus() {
                return maritalStatus;
            }

            public void setGender(List<String> gender) {
                this.gender = gender;
            }

            public List<String> getMeansOfIdentification() {
                return meansOfIdentification;
            }

            public void setMeansOfIdentification(List<String> meansOfIdentification) {
                this.meansOfIdentification = meansOfIdentification;
            }

            public List<String> getNumberOfDependents() {
                return numberOfDependents;
            }

            public void setNumberOfDependents(List<String> numberOfDependents) {
                this.numberOfDependents = numberOfDependents;
            }

            public List<String> getEducationalBackground() {
                return educationalBackground;
            }

            public void setEducationalBackground(List<String> educationalBackground) {
                this.educationalBackground = educationalBackground;
            }

            public List<String> getLGA() {
                return lGA;
            }

            public void setLGA(List<String> lGA) {
                this.lGA = lGA;
            }

            public List<String> getTypeOfHouse() {
                return typeOfHouse;
            }

            public void setTypeOfHouse(List<String> typeOfHouse) {
                this.typeOfHouse = typeOfHouse;
            }

            public List<String> getTypeOfAppartment() {
                return typeOfAppartment;
            }

            public void setTypeOfAppartment(List<String> typeOfAppartment) {
                this.typeOfAppartment = typeOfAppartment;
            }

            public List<String> getAccommodationType() {
                return accommodationType;
            }

            public void setAccommodationType(List<String> accommodationType) {
                this.accommodationType = accommodationType;
            }

            public List<String> getLengthOfStay() {
                return lengthOfStay;
            }

            public void setLengthOfStay(List<String> lengthOfStay) {
                this.lengthOfStay = lengthOfStay;
            }

            public List<String> getEployementLGA() {
                return eployementLGA;
            }

            public void setEployementLGA(List<String> eployementLGA) {
                this.eployementLGA = eployementLGA;
            }

            public List<String> getState() {
                return state;
            }

            public void setState(List<String> state) {
                this.state = state;
            }

            public List<String> getTimeAtOrganisation() {
                return timeAtOrganisation;
            }

            public void setTimeAtOrganisation(List<String> timeAtOrganisation) {
                this.timeAtOrganisation = timeAtOrganisation;
            }

            public List<String> getYearSpentAtLastOrganisation() {
                return yearSpentAtLastOrganisation;
            }

            public void setYearSpentAtLastOrganisation(List<String> yearSpentAtLastOrganisation) {
                this.yearSpentAtLastOrganisation = yearSpentAtLastOrganisation;
            }

            public List<String> getJobsInLast5Years() {
                return jobsInLast5Years;
            }

            public void setJobsInLast5Years(List<String> jobsInLast5Years) {
                this.jobsInLast5Years = jobsInLast5Years;
            }

            public List<String> getAnnualRevenue() {
                return annualRevenue;
            }

            public void setAnnualRevenue(List<String> annualRevenue) {
                this.annualRevenue = annualRevenue;
            }

            public List<String> getTenor() {
                return tenor;
            }

            public void setTenor(List<String> tenor) {
                this.tenor = tenor;
            }

            public List<String> getOtherSourseOfIncome() {
                return otherSourseOfIncome;
            }

            public void setOtherSourseOfIncome(List<String> otherSourseOfIncome) {
                this.otherSourseOfIncome = otherSourseOfIncome;
            }

            public List<String> getHowmuchMonth() {
                return howmuchMonth;
            }

            public void setHowmuchMonth(List<String> howmuchMonth) {
                this.howmuchMonth = howmuchMonth;
            }

            public List<String> getRepaymentBankbank() {
                return repaymentBankbank;
            }

            public void setRepaymentBankbank(List<String> repaymentBankbank) {
                this.repaymentBankbank = repaymentBankbank;
            }

            public List<String> getOtherBank() {
                return otherBank;
            }

            public void setOtherBank(List<String> otherBank) {
                this.otherBank = otherBank;
            }

        }



        public class Company {

            @SerializedName("_id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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


        public class Interest {

            @SerializedName("minAmount")
            @Expose
            private Integer minAmount;
            @SerializedName("maxAmount")
            @Expose
            private Integer maxAmount;

            public Integer getMinAmount() {
                return minAmount;
            }

            public void setMinAmount(Integer minAmount) {
                this.minAmount = minAmount;
            }

            public Integer getMaxAmount() {
                return maxAmount;
            }

            public void setMaxAmount(Integer maxAmount) {
                this.maxAmount = maxAmount;
            }

        }


    }
}