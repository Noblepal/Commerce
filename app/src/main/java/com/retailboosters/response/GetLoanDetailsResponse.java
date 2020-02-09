package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLoanDetailsResponse {

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

        @SerializedName("obtainScores")
        @Expose
        private ObtainScores obtainScores;
        @SerializedName("salaryPaymentDetails")
        @Expose
        private List<Object> salaryPaymentDetails = null;
        @SerializedName("loanHistoryDetails")
        @Expose
        private List<Object> loanHistoryDetails = null;
        @SerializedName("salaryAndBankStatementStatus")
        @Expose
        private Boolean salaryAndBankStatementStatus;
        @SerializedName("salaryRecord")
        @Expose
        private List<Object> salaryRecord = null;
        @SerializedName("remitaUser")
        @Expose
        private String remitaUser;
        @SerializedName("applicationStatus")
        @Expose
        private String applicationStatus;
        @SerializedName("step1Score")
        @Expose
        private Integer step1Score;
        @SerializedName("step2Score")
        @Expose
        private Integer step2Score;
        @SerializedName("step3Score")
        @Expose
        private Integer step3Score;
        @SerializedName("step4Score")
        @Expose
        private Integer step4Score;
        @SerializedName("emiscore")
        @Expose
        private Integer emiscore;
        @SerializedName("totalScore")
        @Expose
        private Integer totalScore;
        @SerializedName("editApplicationForm")
        @Expose
        private Boolean editApplicationForm;
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
        @SerializedName("bvn")
        @Expose
        private String bvn;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("createdBy")
        @Expose
        private String createdBy;
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
        @SerializedName("commonNameCalledAtHome")
        @Expose
        private String commonNameCalledAtHome;
        @SerializedName("contactLga")
        @Expose
        private String contactLga;
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
        @SerializedName("nearestBusStop")
        @Expose
        private String nearestBusStop;
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
        @SerializedName("state1")
        @Expose
        private String state1;
        @SerializedName("typeOfApartment")
        @Expose
        private String typeOfApartment;
        @SerializedName("companyAddress")
        @Expose
        private String companyAddress;
        @SerializedName("companyHrContactNumber")
        @Expose
        private String companyHrContactNumber;
        @SerializedName("companyHrEmail")
        @Expose
        private String companyHrEmail;
        @SerializedName("companyName")
        @Expose
        private String companyName;
        @SerializedName("employmentStatus")
        @Expose
        private String employmentStatus;
        @SerializedName("employmentTerm")
        @Expose
        private String employmentTerm;
        @SerializedName("netMonthlySalary")
        @Expose
        private String netMonthlySalary;
        @SerializedName("timeAtOrganisation")
        @Expose
        private String timeAtOrganisation;
        @SerializedName("CurrentlyOwingAnyOrganisation")
        @Expose
        private String currentlyOwingAnyOrganisation;
        @SerializedName("accountDetailForRepayment")
        @Expose
        private String accountDetailForRepayment;
        @SerializedName("disbursed")
        @Expose
        private String disbursed;
        @SerializedName("missedRepaymentDate")
        @Expose
        private String missedRepaymentDate;
        @SerializedName("month")
        @Expose
        private String month;
        @SerializedName("otherAccount")
        @Expose
        private String otherAccount;
        @SerializedName("otherAccountName")
        @Expose
        private String otherAccountName;
        @SerializedName("otherBank")
        @Expose
        private String otherBank;
        @SerializedName("otherSourceOfIncome")
        @Expose
        private String otherSourceOfIncome;
        @SerializedName("outstanding")
        @Expose
        private String outstanding;
        @SerializedName("repaymentAccount")
        @Expose
        private String repaymentAccount;
        @SerializedName("repaymentAccountName")
        @Expose
        private String repaymentAccountName;
        @SerializedName("repaymentBank")
        @Expose
        private String repaymentBank;
        @SerializedName("repaymentBankCode")
        @Expose
        private String repaymentBankCode;
        @SerializedName("stateValueOfLoan")
        @Expose
        private String stateValueOfLoan;
        @SerializedName("tenor")
        @Expose
        private String tenor;

        public ObtainScores getObtainScores() {
            return obtainScores;
        }

        public void setObtainScores(ObtainScores obtainScores) {
            this.obtainScores = obtainScores;
        }

        public List<Object> getSalaryPaymentDetails() {
            return salaryPaymentDetails;
        }

        public void setSalaryPaymentDetails(List<Object> salaryPaymentDetails) {
            this.salaryPaymentDetails = salaryPaymentDetails;
        }

        public List<Object> getLoanHistoryDetails() {
            return loanHistoryDetails;
        }

        public void setLoanHistoryDetails(List<Object> loanHistoryDetails) {
            this.loanHistoryDetails = loanHistoryDetails;
        }

        public Boolean getSalaryAndBankStatementStatus() {
            return salaryAndBankStatementStatus;
        }

        public void setSalaryAndBankStatementStatus(Boolean salaryAndBankStatementStatus) {
            this.salaryAndBankStatementStatus = salaryAndBankStatementStatus;
        }

        public List<Object> getSalaryRecord() {
            return salaryRecord;
        }

        public void setSalaryRecord(List<Object> salaryRecord) {
            this.salaryRecord = salaryRecord;
        }

        public String getRemitaUser() {
            return remitaUser;
        }

        public void setRemitaUser(String remitaUser) {
            this.remitaUser = remitaUser;
        }

        public String getApplicationStatus() {
            return applicationStatus;
        }

        public void setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
        }

        public Integer getStep1Score() {
            return step1Score;
        }

        public void setStep1Score(Integer step1Score) {
            this.step1Score = step1Score;
        }

        public Integer getStep2Score() {
            return step2Score;
        }

        public void setStep2Score(Integer step2Score) {
            this.step2Score = step2Score;
        }

        public Integer getStep3Score() {
            return step3Score;
        }

        public void setStep3Score(Integer step3Score) {
            this.step3Score = step3Score;
        }

        public Integer getStep4Score() {
            return step4Score;
        }

        public void setStep4Score(Integer step4Score) {
            this.step4Score = step4Score;
        }

        public Integer getEmiscore() {
            return emiscore;
        }

        public void setEmiscore(Integer emiscore) {
            this.emiscore = emiscore;
        }

        public Integer getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(Integer totalScore) {
            this.totalScore = totalScore;
        }

        public Boolean getEditApplicationForm() {
            return editApplicationForm;
        }

        public void setEditApplicationForm(Boolean editApplicationForm) {
            this.editApplicationForm = editApplicationForm;
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

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
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

        public String getBvn() {
            return bvn;
        }

        public void setBvn(String bvn) {
            this.bvn = bvn;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
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

        public String getNearestBusStop() {
            return nearestBusStop;
        }

        public void setNearestBusStop(String nearestBusStop) {
            this.nearestBusStop = nearestBusStop;
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

        public String getState1() {
            return state1;
        }

        public void setState1(String state1) {
            this.state1 = state1;
        }

        public String getTypeOfApartment() {
            return typeOfApartment;
        }

        public void setTypeOfApartment(String typeOfApartment) {
            this.typeOfApartment = typeOfApartment;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getCompanyHrContactNumber() {
            return companyHrContactNumber;
        }

        public void setCompanyHrContactNumber(String companyHrContactNumber) {
            this.companyHrContactNumber = companyHrContactNumber;
        }

        public String getCompanyHrEmail() {
            return companyHrEmail;
        }

        public void setCompanyHrEmail(String companyHrEmail) {
            this.companyHrEmail = companyHrEmail;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getEmploymentStatus() {
            return employmentStatus;
        }

        public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
        }

        public String getEmploymentTerm() {
            return employmentTerm;
        }

        public void setEmploymentTerm(String employmentTerm) {
            this.employmentTerm = employmentTerm;
        }

        public String getNetMonthlySalary() {
            return netMonthlySalary;
        }

        public void setNetMonthlySalary(String netMonthlySalary) {
            this.netMonthlySalary = netMonthlySalary;
        }

        public String getTimeAtOrganisation() {
            return timeAtOrganisation;
        }

        public void setTimeAtOrganisation(String timeAtOrganisation) {
            this.timeAtOrganisation = timeAtOrganisation;
        }

        public String getCurrentlyOwingAnyOrganisation() {
            return currentlyOwingAnyOrganisation;
        }

        public void setCurrentlyOwingAnyOrganisation(String currentlyOwingAnyOrganisation) {
            this.currentlyOwingAnyOrganisation = currentlyOwingAnyOrganisation;
        }

        public String getAccountDetailForRepayment() {
            return accountDetailForRepayment;
        }

        public void setAccountDetailForRepayment(String accountDetailForRepayment) {
            this.accountDetailForRepayment = accountDetailForRepayment;
        }

        public String getDisbursed() {
            return disbursed;
        }

        public void setDisbursed(String disbursed) {
            this.disbursed = disbursed;
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

        public String getOtherAccountName() {
            return otherAccountName;
        }

        public void setOtherAccountName(String otherAccountName) {
            this.otherAccountName = otherAccountName;
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

        public String getRepaymentAccount() {
            return repaymentAccount;
        }

        public void setRepaymentAccount(String repaymentAccount) {
            this.repaymentAccount = repaymentAccount;
        }

        public String getRepaymentAccountName() {
            return repaymentAccountName;
        }

        public void setRepaymentAccountName(String repaymentAccountName) {
            this.repaymentAccountName = repaymentAccountName;
        }

        public String getRepaymentBank() {
            return repaymentBank;
        }

        public void setRepaymentBank(String repaymentBank) {
            this.repaymentBank = repaymentBank;
        }

        public String getRepaymentBankCode() {
            return repaymentBankCode;
        }

        public void setRepaymentBankCode(String repaymentBankCode) {
            this.repaymentBankCode = repaymentBankCode;
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

        public class ObtainScores {

            @SerializedName("genderScore")
            @Expose
            private Integer genderScore;
            @SerializedName("maritalStatusScore")
            @Expose
            private Integer maritalStatusScore;
            @SerializedName("ageScore")
            @Expose
            private Integer ageScore;
            @SerializedName("numberOfDependentsScore")
            @Expose
            private Integer numberOfDependentsScore;
            @SerializedName("educationalBackGroundScore")
            @Expose
            private Integer educationalBackGroundScore;
            @SerializedName("homeAddressScore")
            @Expose
            private Integer homeAddressScore;
            @SerializedName("lengthOfStayScore")
            @Expose
            private Integer lengthOfStayScore;
            @SerializedName("accomodationTypeScore")
            @Expose
            private Integer accomodationTypeScore;
            @SerializedName("typeOfApartmentScore")
            @Expose
            private Integer typeOfApartmentScore;
            @SerializedName("refereeMobileNoScore")
            @Expose
            private Integer refereeMobileNoScore;
            @SerializedName("spouseMobileNoScore")
            @Expose
            private Integer spouseMobileNoScore;
            @SerializedName("officePhoneScore")
            @Expose
            private Integer officePhoneScore;
            @SerializedName("yearsSpentAtLastEmploymentScore")
            @Expose
            private Integer yearsSpentAtLastEmploymentScore;
            @SerializedName("employmentTermScore")
            @Expose
            private Integer employmentTermScore;
            @SerializedName("currentlyOwingAnyOrganisationScore")
            @Expose
            private Integer currentlyOwingAnyOrganisationScore;
            @SerializedName("percentageFormApplicationScore")
            @Expose
            private Integer percentageFormApplicationScore;
            @SerializedName("companyScore")
            @Expose
            private Integer companyScore;
            @SerializedName("declarationOfExistingObligation")
            @Expose
            private Integer declarationOfExistingObligation;
            @SerializedName("positiveCreditBureauScore")
            @Expose
            private Integer positiveCreditBureauScore;
            @SerializedName("crcLoanPaidOnDueDateScore")
            @Expose
            private Integer crcLoanPaidOnDueDateScore;
            @SerializedName("monthlyNetSalaryScore")
            @Expose
            private Integer monthlyNetSalaryScore;
            @SerializedName("monthlyNetSalaryGreterRepaySum")
            @Expose
            private Integer monthlyNetSalaryGreterRepaySum;

            public Integer getGenderScore() {
                return genderScore;
            }

            public void setGenderScore(Integer genderScore) {
                this.genderScore = genderScore;
            }

            public Integer getMaritalStatusScore() {
                return maritalStatusScore;
            }

            public void setMaritalStatusScore(Integer maritalStatusScore) {
                this.maritalStatusScore = maritalStatusScore;
            }

            public Integer getAgeScore() {
                return ageScore;
            }

            public void setAgeScore(Integer ageScore) {
                this.ageScore = ageScore;
            }

            public Integer getNumberOfDependentsScore() {
                return numberOfDependentsScore;
            }

            public void setNumberOfDependentsScore(Integer numberOfDependentsScore) {
                this.numberOfDependentsScore = numberOfDependentsScore;
            }

            public Integer getEducationalBackGroundScore() {
                return educationalBackGroundScore;
            }

            public void setEducationalBackGroundScore(Integer educationalBackGroundScore) {
                this.educationalBackGroundScore = educationalBackGroundScore;
            }

            public Integer getHomeAddressScore() {
                return homeAddressScore;
            }

            public void setHomeAddressScore(Integer homeAddressScore) {
                this.homeAddressScore = homeAddressScore;
            }

            public Integer getLengthOfStayScore() {
                return lengthOfStayScore;
            }

            public void setLengthOfStayScore(Integer lengthOfStayScore) {
                this.lengthOfStayScore = lengthOfStayScore;
            }

            public Integer getAccomodationTypeScore() {
                return accomodationTypeScore;
            }

            public void setAccomodationTypeScore(Integer accomodationTypeScore) {
                this.accomodationTypeScore = accomodationTypeScore;
            }

            public Integer getTypeOfApartmentScore() {
                return typeOfApartmentScore;
            }

            public void setTypeOfApartmentScore(Integer typeOfApartmentScore) {
                this.typeOfApartmentScore = typeOfApartmentScore;
            }

            public Integer getRefereeMobileNoScore() {
                return refereeMobileNoScore;
            }

            public void setRefereeMobileNoScore(Integer refereeMobileNoScore) {
                this.refereeMobileNoScore = refereeMobileNoScore;
            }

            public Integer getSpouseMobileNoScore() {
                return spouseMobileNoScore;
            }

            public void setSpouseMobileNoScore(Integer spouseMobileNoScore) {
                this.spouseMobileNoScore = spouseMobileNoScore;
            }

            public Integer getOfficePhoneScore() {
                return officePhoneScore;
            }

            public void setOfficePhoneScore(Integer officePhoneScore) {
                this.officePhoneScore = officePhoneScore;
            }

            public Integer getYearsSpentAtLastEmploymentScore() {
                return yearsSpentAtLastEmploymentScore;
            }

            public void setYearsSpentAtLastEmploymentScore(Integer yearsSpentAtLastEmploymentScore) {
                this.yearsSpentAtLastEmploymentScore = yearsSpentAtLastEmploymentScore;
            }

            public Integer getEmploymentTermScore() {
                return employmentTermScore;
            }

            public void setEmploymentTermScore(Integer employmentTermScore) {
                this.employmentTermScore = employmentTermScore;
            }

            public Integer getCurrentlyOwingAnyOrganisationScore() {
                return currentlyOwingAnyOrganisationScore;
            }

            public void setCurrentlyOwingAnyOrganisationScore(Integer currentlyOwingAnyOrganisationScore) {
                this.currentlyOwingAnyOrganisationScore = currentlyOwingAnyOrganisationScore;
            }

            public Integer getPercentageFormApplicationScore() {
                return percentageFormApplicationScore;
            }

            public void setPercentageFormApplicationScore(Integer percentageFormApplicationScore) {
                this.percentageFormApplicationScore = percentageFormApplicationScore;
            }

            public Integer getCompanyScore() {
                return companyScore;
            }

            public void setCompanyScore(Integer companyScore) {
                this.companyScore = companyScore;
            }

            public Integer getDeclarationOfExistingObligation() {
                return declarationOfExistingObligation;
            }

            public void setDeclarationOfExistingObligation(Integer declarationOfExistingObligation) {
                this.declarationOfExistingObligation = declarationOfExistingObligation;
            }

            public Integer getPositiveCreditBureauScore() {
                return positiveCreditBureauScore;
            }

            public void setPositiveCreditBureauScore(Integer positiveCreditBureauScore) {
                this.positiveCreditBureauScore = positiveCreditBureauScore;
            }

            public Integer getCrcLoanPaidOnDueDateScore() {
                return crcLoanPaidOnDueDateScore;
            }

            public void setCrcLoanPaidOnDueDateScore(Integer crcLoanPaidOnDueDateScore) {
                this.crcLoanPaidOnDueDateScore = crcLoanPaidOnDueDateScore;
            }

            public Integer getMonthlyNetSalaryScore() {
                return monthlyNetSalaryScore;
            }

            public void setMonthlyNetSalaryScore(Integer monthlyNetSalaryScore) {
                this.monthlyNetSalaryScore = monthlyNetSalaryScore;
            }

            public Integer getMonthlyNetSalaryGreterRepaySum() {
                return monthlyNetSalaryGreterRepaySum;
            }

            public void setMonthlyNetSalaryGreterRepaySum(Integer monthlyNetSalaryGreterRepaySum) {
                this.monthlyNetSalaryGreterRepaySum = monthlyNetSalaryGreterRepaySum;
            }

        }

    }
}
