package com.retailboosters.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserOrdersResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }


    public class Datum {

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
        @SerializedName("salesAgentApplicationStatus")
        @Expose
        private SalesAgentApplicationStatus salesAgentApplicationStatus;
        @SerializedName("dueDiligenceApplicationStatus")
        @Expose
        private DueDiligenceApplicationStatus dueDiligenceApplicationStatus;
        @SerializedName("repaymentSchedule")
        @Expose
        private ArrayList<RepaymentSchedule> repaymentSchedule = null;
        @SerializedName("bankParserData")
        @Expose
        private List<Object> bankParserData = null;
        @SerializedName("salaryPaymentDetails")
        @Expose
        private List<SalaryPaymentDetail> salaryPaymentDetails = null;
        @SerializedName("loanHistoryDetails")
        @Expose
        private List<LoanHistoryDetail> loanHistoryDetails = null;
        @SerializedName("mandateGenerate")
        @Expose
        private Boolean mandateGenerate;
        @SerializedName("mandateActive")
        @Expose
        private Boolean mandateActive;
        @SerializedName("salaryAndBankStatementStatus")
        @Expose
        private String salaryAndBankStatementStatus;
        @SerializedName("repaymentScheduleStatus")
        @Expose
        private String repaymentScheduleStatus;
        @SerializedName("delieveryStatus")
        @Expose
        private String delieveryStatus;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("passportPhoto")
        @Expose
        private PassportPhoto passportPhoto;
        @SerializedName("internationalPassport")
        @Expose
        private InternationalPassport internationalPassport;
        @SerializedName("license")
        @Expose
        private License license;
        @SerializedName("loanId")
        @Expose
        private String loanId;
        @SerializedName("storeId")
        @Expose
        private String storeId;
        @SerializedName("productId")
        @Expose


        private ProductId productId;
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
        @SerializedName("whereWork")
        @Expose
        private String whereWork;
        @SerializedName("salaryAmount")
        @Expose
        private String salaryAmount;
        @SerializedName("eligibleLoanAmount")
        @Expose
        private float eligibleLoanAmount;
        @SerializedName("tenorAgreed")
        @Expose
        private String tenorAgreed;
        @SerializedName("interest")
        @Expose
        private Double interest;
        @SerializedName("repaymentAmount")
        @Expose
        private Double repaymentAmount;
        @SerializedName("applicationStatus")
        @Expose
        private String applicationStatus;
        @SerializedName("balancePaid")
        @Expose
        private float balancePaid;
        @SerializedName("delieveryAddress")
        @Expose
        private String delieveryAddress;
        @SerializedName("emi")
        @Expose
        private Double emi;
        @SerializedName("loanAmount")
        @Expose
        private float loanAmount;
        @SerializedName("shippingFee")
        @Expose
        private float shippingFee;
        @SerializedName("subTotal")
        @Expose
        private float subTotal;


        @SerializedName("loanDisbursementDate")
        @Expose
        private String loanDisbursementDate;

        public String getLoanDisbursementDate() {
            return loanDisbursementDate;
        }

        public class ProductId {

            @SerializedName("isFeatured")
            @Expose
            private Boolean isFeatured;
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

            public Boolean getIsFeatured() {
                return isFeatured;
            }

            public void setIsFeatured(Boolean isFeatured) {
                this.isFeatured = isFeatured;
            }

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

        public ProductId getProductId() {
            return productId;
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

        public ArrayList<RepaymentSchedule> getRepaymentSchedule() {
            return repaymentSchedule;
        }

        public void setRepaymentSchedule(ArrayList<RepaymentSchedule> repaymentSchedule) {
            this.repaymentSchedule = repaymentSchedule;
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

        public List<LoanHistoryDetail> getLoanHistoryDetails() {
            return loanHistoryDetails;
        }

        public void setLoanHistoryDetails(List<LoanHistoryDetail> loanHistoryDetails) {
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

        public String getSalaryAndBankStatementStatus() {
            return salaryAndBankStatementStatus;
        }

        public void setSalaryAndBankStatementStatus(String salaryAndBankStatementStatus) {
            this.salaryAndBankStatementStatus = salaryAndBankStatementStatus;
        }

        public String getRepaymentScheduleStatus() {
            return repaymentScheduleStatus;
        }

        public void setRepaymentScheduleStatus(String repaymentScheduleStatus) {
            this.repaymentScheduleStatus = repaymentScheduleStatus;
        }

        public String getDelieveryStatus() {
            return delieveryStatus;
        }

        public void setDelieveryStatus(String delieveryStatus) {
            this.delieveryStatus = delieveryStatus;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public PassportPhoto getPassportPhoto() {
            return passportPhoto;
        }

        public void setPassportPhoto(PassportPhoto passportPhoto) {
            this.passportPhoto = passportPhoto;
        }

        public InternationalPassport getInternationalPassport() {
            return internationalPassport;
        }

        public void setInternationalPassport(InternationalPassport internationalPassport) {
            this.internationalPassport = internationalPassport;
        }

        public License getLicense() {
            return license;
        }

        public void setLicense(License license) {
            this.license = license;
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

        public String getWhereWork() {
            return whereWork;
        }

        public void setWhereWork(String whereWork) {
            this.whereWork = whereWork;
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

        public Double getInterest() {
            return interest;
        }

        public void setInterest(Double interest) {
            this.interest = interest;
        }

        public Double getRepaymentAmount() {
            return repaymentAmount;
        }

        public void setRepaymentAmount(Double repaymentAmount) {
            this.repaymentAmount = repaymentAmount;
        }

        public String getApplicationStatus() {
            return applicationStatus;
        }

        public void setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
        }

        public float getBalancePaid() {
            return (int)balancePaid;
        }

        public void setBalancePaid(Integer balancePaid) {
            this.balancePaid = balancePaid;
        }

        public String getDelieveryAddress() {
            return delieveryAddress;
        }

        public void setDelieveryAddress(String delieveryAddress) {
            this.delieveryAddress = delieveryAddress;
        }

        public Double getEmi() {
            return emi;
        }

        public void setEmi(Double emi) {
            this.emi = emi;
        }

        public float getLoanAmount() {
            return (int)loanAmount;
        }

        public void setLoanAmount(float loanAmount) {
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



        public class BankStatement {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }

        public class GovermentId {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }
        public class InternationalPassport {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }

        public class License {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }

        public class PassportOrDrivingLicense {

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
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }

        public class UtilityBill {

            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("document")
            @Expose
            private String document;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDocument() {
                return document;
            }

            public void setDocument(String document) {
                this.document = document;
            }

        }

        public class SalesAgentApplicationStatus {

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

        public class SalaryPaymentDetail {

            @SerializedName("loanProvider")
            @Expose
            private String loanProvider;
            @SerializedName("loanAmount")
            @Expose
            private float loanAmount;
            @SerializedName("outstandingAmount")
            @Expose
            private float outstandingAmount;
            @SerializedName("loanDisbursementDate")
            @Expose
            private String loanDisbursementDate;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("repaymentAmount")
            @Expose
            private float repaymentAmount;
            @SerializedName("repaymentFreq")
            @Expose
            private String repaymentFreq;



            public String getLoanProvider() {
                return loanProvider;
            }

            public void setLoanProvider(String loanProvider) {
                this.loanProvider = loanProvider;
            }

            public float getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(float loanAmount) {
                this.loanAmount = loanAmount;
            }

            public float getOutstandingAmount() {
                return outstandingAmount;
            }

            public void setOutstandingAmount(float outstandingAmount) {
                this.outstandingAmount = outstandingAmount;
            }

            public String getLoanDisbursementDate() {
                return loanDisbursementDate;
            }

            public void setLoanDisbursementDate(String loanDisbursementDate) {
                this.loanDisbursementDate = loanDisbursementDate;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public float getRepaymentAmount() {
                return repaymentAmount;
            }

            public void setRepaymentAmount(Integer repaymentAmount) {
                this.repaymentAmount = repaymentAmount;
            }

            public String getRepaymentFreq() {
                return repaymentFreq;
            }

            public void setRepaymentFreq(String repaymentFreq) {
                this.repaymentFreq = repaymentFreq;
            }

        }

        public class RepaymentSchedule {

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

        public class LoanHistoryDetail {

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
        public class DueDiligenceApplicationStatus {

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