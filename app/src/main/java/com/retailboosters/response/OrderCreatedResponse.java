package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderCreatedResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("isOtp")
    @Expose
    private Boolean isOtp;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("mandateDetails")
    @Expose
    private MandateDetails mandateDetails;
    @SerializedName("otpDetails")
    @Expose
    private OtpDetails otpDetails;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsOtp() {
        return isOtp;
    }

    public void setIsOtp(Boolean isOtp) {
        this.isOtp = isOtp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MandateDetails getMandateDetails() {
        return mandateDetails;
    }

    public void setMandateDetails(MandateDetails mandateDetails) {
        this.mandateDetails = mandateDetails;
    }

    public OtpDetails getOtpDetails() {
        return otpDetails;
    }

    public void setOtpDetails(OtpDetails otpDetails) {
        this.otpDetails = otpDetails;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    public class AuthParam  implements Serializable {

        @SerializedName("label1")
        @Expose
        private String label1;
        @SerializedName("param1")
        @Expose
        private String param1;
        @SerializedName("description1")
        @Expose
        private String description1;
        @SerializedName("label2")
        @Expose
        private String label2;
        @SerializedName("param2")
        @Expose
        private String param2;
        @SerializedName("description2")
        @Expose
        private String description2;

        public String getLabel1() {
            return label1;
        }

        public void setLabel1(String label1) {
            this.label1 = label1;
        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getDescription1() {
            return description1;
        }

        public void setDescription1(String description1) {
            this.description1 = description1;
        }

        public String getLabel2() {
            return label2;
        }

        public void setLabel2(String label2) {
            this.label2 = label2;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }

        public String getDescription2() {
            return description2;
        }

        public void setDescription2(String description2) {
            this.description2 = description2;
        }

    }

    public class BankStatement  implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("document")
        @Expose
        private String document;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("isEditable")
        @Expose
        private Boolean isEditable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(Boolean isEditable) {
            this.isEditable = isEditable;
        }

    }

    public class Data  implements Serializable {

        @SerializedName("bankStatement")
        @Expose
        private BankStatement bankStatement;
        @SerializedName("govermentId")
        @Expose
        private GovermentId govermentId;
        @SerializedName("passportOrDrivingLicense")
        @Expose
        private PassportOrDrivingLicense passportOrDrivingLicense;
        @SerializedName("utilityBill")
        @Expose
        private UtilityBill utilityBill;
        @SerializedName("offerLetter")
        @Expose
        private OfferLetter offerLetter;
        @SerializedName("salesAgentApplicationStatus")
        @Expose
        private SalesAgentApplicationStatus salesAgentApplicationStatus;
        @SerializedName("dueDiligenceApplicationStatus")
        @Expose
        private DueDiligenceApplicationStatus dueDiligenceApplicationStatus;
        @SerializedName("productIdArray")
        @Expose
        private List<Object> productIdArray = null;
        @SerializedName("repaymentSchedule")
        @Expose
        private List<RepaymentSchedule> repaymentSchedule = null;
        @SerializedName("transactionHistory")
        @Expose
        private List<Object> transactionHistory = null;
        @SerializedName("bankParserData")
        @Expose
        private List<Object> bankParserData = null;
        @SerializedName("salaryPaymentDetails")
        @Expose
        private List<SalaryPaymentDetail> salaryPaymentDetails = null;
        @SerializedName("loanHistoryDetails")
        @Expose
        private List<Object> loanHistoryDetails = null;
        @SerializedName("mandateGenerate")
        @Expose
        private Boolean mandateGenerate;
        @SerializedName("mandateActive")
        @Expose
        private Boolean mandateActive;
        @SerializedName("directDebit")
        @Expose
        private Boolean directDebit;
        @SerializedName("cancelDebit")
        @Expose
        private Boolean cancelDebit;
        @SerializedName("salaryAndBankStatementStatus")
        @Expose
        private Boolean salaryAndBankStatementStatus;
        @SerializedName("repaymentScheduleStatus")
        @Expose
        private Boolean repaymentScheduleStatus;
        @SerializedName("delieveryStatus")
        @Expose
        private Boolean delieveryStatus;
        @SerializedName("paidToBankAmount")
        @Expose
        private float paidToBankAmount;
        @SerializedName("numberOfDirectDebitDone")
        @Expose
        private String numberOfDirectDebitDone;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("loanId")
        @Expose
        private String loanId;
        @SerializedName("storeId")
        @Expose
        private String storeId;
        @SerializedName("productId")
        @Expose
        private String productId;
        @SerializedName("unitPrice")
        @Expose
        private float unitPrice;
        @SerializedName("quantity")
        @Expose
        private float quantity;
        @SerializedName("totalAmount")
        @Expose
        private float totalAmount;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("bvn")
        @Expose
        private String bvn;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("createdDate")
        @Expose
        private String createdDate;
        @SerializedName("updatedDate")
        @Expose
        private String updatedDate;
        @SerializedName("orderApplicationNumber")
        @Expose
        private String orderApplicationNumber;
        @SerializedName("salaryAmount")
        @Expose
        private String salaryAmount;
        @SerializedName("eligibleLoanAmount")
        @Expose
        private float eligibleLoanAmount;
        @SerializedName("tenorAgreed")
        @Expose
        private String tenorAgreed;
        @SerializedName("balancePaid")
        @Expose
        private float balancePaid;
        @SerializedName("interest")
        @Expose
        private float interest;
        @SerializedName("loanDisbursementDate")
        @Expose
        private String loanDisbursementDate;
        @SerializedName("repaymentAmount")
        @Expose
        private float repaymentAmount;
        @SerializedName("employeeId")
        @Expose
        private String employeeId;
        @SerializedName("whereWork")
        @Expose
        private String whereWork;
        @SerializedName("adminFee")
        @Expose
        private float adminFee;
        @SerializedName("applicationStatus")
        @Expose
        private String applicationStatus;
        @SerializedName("delieveryAddress")
        @Expose
        private String delieveryAddress;
        @SerializedName("emi")
        @Expose
        private float emi;
        @SerializedName("loanAmount")
        @Expose
        private float loanAmount;
        @SerializedName("shippingFee")
        @Expose
        private float shippingFee;
        @SerializedName("subTotal")
        @Expose
        private float subTotal;
        @SerializedName("totalCost")
        @Expose
        private float totalCost;
        @SerializedName("vatFee")
        @Expose
        private float vatFee;
        @SerializedName("mandate")
        @Expose
        private Mandate mandate;
        @SerializedName("mandateId")
        @Expose
        private String mandateId;
        @SerializedName("mandateType")
        @Expose
        private String mandateType;
        @SerializedName("maxNoOfDebits")
        @Expose
        private String maxNoOfDebits;
        @SerializedName("merchantId")
        @Expose
        private String merchantId;
        @SerializedName("nextTransactionDate")
        @Expose
        private String nextTransactionDate;
        @SerializedName("payerAccount")
        @Expose
        private String payerAccount;
        @SerializedName("payerBankCode")
        @Expose
        private String payerBankCode;
        @SerializedName("payerEmail")
        @Expose
        private String payerEmail;
        @SerializedName("payerName")
        @Expose
        private String payerName;
        @SerializedName("payerPhone")
        @Expose
        private String payerPhone;
        @SerializedName("requestId")
        @Expose
        private String requestId;
        @SerializedName("serviceTypeId")
        @Expose
        private String serviceTypeId;
        @SerializedName("transactionEndDate")
        @Expose
        private String transactionEndDate;
        @SerializedName("transactionStartDate")
        @Expose
        private String transactionStartDate;

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

        public PassportOrDrivingLicense getPassportOrDrivingLicense() {
            return passportOrDrivingLicense;
        }

        public void setPassportOrDrivingLicense(PassportOrDrivingLicense passportOrDrivingLicense) {
            this.passportOrDrivingLicense = passportOrDrivingLicense;
        }

        public UtilityBill getUtilityBill() {
            return utilityBill;
        }

        public void setUtilityBill(UtilityBill utilityBill) {
            this.utilityBill = utilityBill;
        }

        public OfferLetter getOfferLetter() {
            return offerLetter;
        }

        public void setOfferLetter(OfferLetter offerLetter) {
            this.offerLetter = offerLetter;
        }

        public SalesAgentApplicationStatus getSalesAgentApplicationStatus() {
            return salesAgentApplicationStatus;
        }

        public void setSalesAgentApplicationStatus(SalesAgentApplicationStatus salesAgentApplicationStatus) {
            this.salesAgentApplicationStatus = salesAgentApplicationStatus;
        }

        public DueDiligenceApplicationStatus getDueDiligenceApplicationStatus() {
            return dueDiligenceApplicationStatus;
        }

        public void setDueDiligenceApplicationStatus(DueDiligenceApplicationStatus dueDiligenceApplicationStatus) {
            this.dueDiligenceApplicationStatus = dueDiligenceApplicationStatus;
        }

        public List<Object> getProductIdArray() {
            return productIdArray;
        }

        public void setProductIdArray(List<Object> productIdArray) {
            this.productIdArray = productIdArray;
        }

        public List<RepaymentSchedule> getRepaymentSchedule() {
            return repaymentSchedule;
        }

        public void setRepaymentSchedule(List<RepaymentSchedule> repaymentSchedule) {
            this.repaymentSchedule = repaymentSchedule;
        }

        public List<Object> getTransactionHistory() {
            return transactionHistory;
        }

        public void setTransactionHistory(List<Object> transactionHistory) {
            this.transactionHistory = transactionHistory;
        }

        public List<Object> getBankParserData() {
            return bankParserData;
        }

        public void setBankParserData(List<Object> bankParserData) {
            this.bankParserData = bankParserData;
        }

        public List<SalaryPaymentDetail> getSalaryPaymentDetails() {
            return salaryPaymentDetails;
        }

        public void setSalaryPaymentDetails(List<SalaryPaymentDetail> salaryPaymentDetails) {
            this.salaryPaymentDetails = salaryPaymentDetails;
        }

        public List<Object> getLoanHistoryDetails() {
            return loanHistoryDetails;
        }

        public void setLoanHistoryDetails(List<Object> loanHistoryDetails) {
            this.loanHistoryDetails = loanHistoryDetails;
        }

        public Boolean getMandateGenerate() {
            return mandateGenerate;
        }

        public void setMandateGenerate(Boolean mandateGenerate) {
            this.mandateGenerate = mandateGenerate;
        }

        public Boolean getMandateActive() {
            return mandateActive;
        }

        public void setMandateActive(Boolean mandateActive) {
            this.mandateActive = mandateActive;
        }

        public Boolean getDirectDebit() {
            return directDebit;
        }

        public void setDirectDebit(Boolean directDebit) {
            this.directDebit = directDebit;
        }

        public Boolean getCancelDebit() {
            return cancelDebit;
        }

        public void setCancelDebit(Boolean cancelDebit) {
            this.cancelDebit = cancelDebit;
        }

        public Boolean getSalaryAndBankStatementStatus() {
            return salaryAndBankStatementStatus;
        }

        public void setSalaryAndBankStatementStatus(Boolean salaryAndBankStatementStatus) {
            this.salaryAndBankStatementStatus = salaryAndBankStatementStatus;
        }

        public Boolean getRepaymentScheduleStatus() {
            return repaymentScheduleStatus;
        }

        public void setRepaymentScheduleStatus(Boolean repaymentScheduleStatus) {
            this.repaymentScheduleStatus = repaymentScheduleStatus;
        }

        public Boolean getDelieveryStatus() {
            return delieveryStatus;
        }

        public void setDelieveryStatus(Boolean delieveryStatus) {
            this.delieveryStatus = delieveryStatus;
        }

        public float getPaidToBankAmount() {
            return paidToBankAmount;
        }

        public void setPaidToBankAmount(Integer paidToBankAmount) {
            this.paidToBankAmount = paidToBankAmount;
        }

        public String getNumberOfDirectDebitDone() {
            return numberOfDirectDebitDone;
        }

        public void setNumberOfDirectDebitDone(String numberOfDirectDebitDone) {
            this.numberOfDirectDebitDone = numberOfDirectDebitDone;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public float getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Integer unitPrice) {
            this.unitPrice = unitPrice;
        }

        public float getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

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

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
        }

        public String getOrderApplicationNumber() {
            return orderApplicationNumber;
        }

        public void setOrderApplicationNumber(String orderApplicationNumber) {
            this.orderApplicationNumber = orderApplicationNumber;
        }

        public String getSalaryAmount() {
            return salaryAmount;
        }

        public void setSalaryAmount(String salaryAmount) {
            this.salaryAmount = salaryAmount;
        }

        public float getEligibleLoanAmount() {
            return eligibleLoanAmount;
        }

        public void setEligibleLoanAmount(Integer eligibleLoanAmount) {
            this.eligibleLoanAmount = eligibleLoanAmount;
        }

        public String getTenorAgreed() {
            return tenorAgreed;
        }

        public void setTenorAgreed(String tenorAgreed) {
            this.tenorAgreed = tenorAgreed;
        }

        public float getBalancePaid() {
            return balancePaid;
        }

        public void setBalancePaid(Integer balancePaid) {
            this.balancePaid = balancePaid;
        }

        public float getInterest() {
            return interest;
        }

        public void setInterest(float interest) {
            this.interest = interest;
        }

        public String getLoanDisbursementDate() {
            return loanDisbursementDate;
        }

        public void setLoanDisbursementDate(String loanDisbursementDate) {
            this.loanDisbursementDate = loanDisbursementDate;
        }

        public float getRepaymentAmount() {
            return repaymentAmount;
        }

        public void setRepaymentAmount(Integer repaymentAmount) {
            this.repaymentAmount = repaymentAmount;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getWhereWork() {
            return whereWork;
        }

        public void setWhereWork(String whereWork) {
            this.whereWork = whereWork;
        }

        public float getAdminFee() {
            return adminFee;
        }

        public void setAdminFee(Integer adminFee) {
            this.adminFee = adminFee;
        }

        public String getApplicationStatus() {
            return applicationStatus;
        }

        public void setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
        }

        public String getDelieveryAddress() {
            return delieveryAddress;
        }

        public void setDelieveryAddress(String delieveryAddress) {
            this.delieveryAddress = delieveryAddress;
        }

        public float getEmi() {
            return emi;
        }

        public void setEmi(Integer emi) {
            this.emi = emi;
        }

        public float getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(Integer loanAmount) {
            this.loanAmount = loanAmount;
        }

        public float getShippingFee() {
            return shippingFee;
        }

        public void setShippingFee(Integer shippingFee) {
            this.shippingFee = shippingFee;
        }

        public float getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(Integer subTotal) {
            this.subTotal = subTotal;
        }

        public float getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(Integer totalCost) {
            this.totalCost = totalCost;
        }

        public float getVatFee() {
            return vatFee;
        }

        public void setVatFee(Integer vatFee) {
            this.vatFee = vatFee;
        }

        public Mandate getMandate() {
            return mandate;
        }

        public void setMandate(Mandate mandate) {
            this.mandate = mandate;
        }

        public String getMandateId() {
            return mandateId;
        }

        public void setMandateId(String mandateId) {
            this.mandateId = mandateId;
        }

        public String getMandateType() {
            return mandateType;
        }

        public void setMandateType(String mandateType) {
            this.mandateType = mandateType;
        }

        public String getMaxNoOfDebits() {
            return maxNoOfDebits;
        }

        public void setMaxNoOfDebits(String maxNoOfDebits) {
            this.maxNoOfDebits = maxNoOfDebits;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getNextTransactionDate() {
            return nextTransactionDate;
        }

        public void setNextTransactionDate(String nextTransactionDate) {
            this.nextTransactionDate = nextTransactionDate;
        }

        public String getPayerAccount() {
            return payerAccount;
        }

        public void setPayerAccount(String payerAccount) {
            this.payerAccount = payerAccount;
        }

        public String getPayerBankCode() {
            return payerBankCode;
        }

        public void setPayerBankCode(String payerBankCode) {
            this.payerBankCode = payerBankCode;
        }

        public String getPayerEmail() {
            return payerEmail;
        }

        public void setPayerEmail(String payerEmail) {
            this.payerEmail = payerEmail;
        }

        public String getPayerName() {
            return payerName;
        }

        public void setPayerName(String payerName) {
            this.payerName = payerName;
        }

        public String getPayerPhone() {
            return payerPhone;
        }

        public void setPayerPhone(String payerPhone) {
            this.payerPhone = payerPhone;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getServiceTypeId() {
            return serviceTypeId;
        }

        public void setServiceTypeId(String serviceTypeId) {
            this.serviceTypeId = serviceTypeId;
        }

        public String getTransactionEndDate() {
            return transactionEndDate;
        }

        public void setTransactionEndDate(String transactionEndDate) {
            this.transactionEndDate = transactionEndDate;
        }

        public String getTransactionStartDate() {
            return transactionStartDate;
        }

        public void setTransactionStartDate(String transactionStartDate) {
            this.transactionStartDate = transactionStartDate;
        }

    }

    public class DueDiligenceApplicationStatus  implements Serializable {

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

    public class GovermentId  implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("document")
        @Expose
        private String document;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("isEditable")
        @Expose
        private Boolean isEditable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(Boolean isEditable) {
            this.isEditable = isEditable;
        }

    }

    public class Mandate  implements Serializable {

        @SerializedName("statuscode")
        @Expose
        private String statuscode;
        @SerializedName("requestId")
        @Expose
        private String requestId;
        @SerializedName("mandateId")
        @Expose
        private String mandateId;
        @SerializedName("status")
        @Expose
        private String status;

        public String getStatuscode() {
            return statuscode;
        }

        public void setStatuscode(String statuscode) {
            this.statuscode = statuscode;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getMandateId() {
            return mandateId;
        }

        public void setMandateId(String mandateId) {
            this.mandateId = mandateId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
    public class MandateDetails  implements Serializable {

        @SerializedName("statuscode")
        @Expose
        private String statuscode;
        @SerializedName("requestId")
        @Expose
        private String requestId;
        @SerializedName("mandateId")
        @Expose
        private String mandateId;
        @SerializedName("status")
        @Expose
        private String status;

        public String getStatuscode() {
            return statuscode;
        }

        public void setStatuscode(String statuscode) {
            this.statuscode = statuscode;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getMandateId() {
            return mandateId;
        }

        public void setMandateId(String mandateId) {
            this.mandateId = mandateId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

    public class OfferLetter  implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("document")
        @Expose
        private String document;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("isEditable")
        @Expose
        private Boolean isEditable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(Boolean isEditable) {
            this.isEditable = isEditable;
        }

    }



    public class OtpDetails  implements Serializable {

        @SerializedName("statuscode")
        @Expose
        private String statuscode;
        @SerializedName("authParams")
        @Expose
        private List<AuthParam> authParams = null;
        @SerializedName("requestId")
        @Expose
        private String requestId;
        @SerializedName("mandateId")
        @Expose
        private String mandateId;
        @SerializedName("remitaTransRef")
        @Expose
        private String remitaTransRef;
        @SerializedName("status")
        @Expose
        private String status;

        public String getStatuscode() {
            return statuscode;
        }

        public void setStatuscode(String statuscode) {
            this.statuscode = statuscode;
        }

        public List<AuthParam> getAuthParams() {
            return authParams;
        }

        public void setAuthParams(List<AuthParam> authParams) {
            this.authParams = authParams;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getMandateId() {
            return mandateId;
        }

        public void setMandateId(String mandateId) {
            this.mandateId = mandateId;
        }

        public String getRemitaTransRef() {
            return remitaTransRef;
        }

        public void setRemitaTransRef(String remitaTransRef) {
            this.remitaTransRef = remitaTransRef;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

    public class PassportOrDrivingLicense  implements Serializable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("document")
        @Expose
        private String document;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("isEditable")
        @Expose
        private Boolean isEditable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(Boolean isEditable) {
            this.isEditable = isEditable;
        }

    }
    public class RepaymentSchedule  implements Serializable {

        @SerializedName("DueDate")
        @Expose
        private String dueDate;
        @SerializedName("Payment_Due")
        @Expose
        private String paymentDue;
        @SerializedName("Interest")
        @Expose
        private String interest;
        @SerializedName("Principal")
        @Expose
        private String principal;
        @SerializedName("Balance")
        @Expose
        private String balance;

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getPaymentDue() {
            return paymentDue;
        }

        public void setPaymentDue(String paymentDue) {
            this.paymentDue = paymentDue;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getPrincipal() {
            return principal;
        }

        public void setPrincipal(String principal) {
            this.principal = principal;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

    }
    public class SalaryPaymentDetail  implements Serializable {

        @SerializedName("paymentDate")
        @Expose
        private String paymentDate;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("accountNumber")
        @Expose
        private String accountNumber;
        @SerializedName("bankCode")
        @Expose
        private String bankCode;

        public String getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

    }

    public class SalesAgentApplicationStatus implements Serializable  {

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
    public class UtilityBill implements Serializable  {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("document")
        @Expose
        private String document;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("isEditable")
        @Expose
        private Boolean isEditable;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getIsEditable() {
            return isEditable;
        }

        public void setIsEditable(Boolean isEditable) {
            this.isEditable = isEditable;
        }

    }

}