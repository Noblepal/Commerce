package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileUploadResponse {

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
        private String salaryAndBankStatementStatus;
        @SerializedName("repaymentScheduleStatus")
        @Expose
        private String repaymentScheduleStatus;
        @SerializedName("delieveryStatus")
        @Expose
        private String delieveryStatus;
        @SerializedName("paidToBankAmount")
        @Expose
        private Integer paidToBankAmount;
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
        private Integer unitPrice;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("totalAmount")
        @Expose
        private Integer totalAmount;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("userEligibleForLoan")
        @Expose
        private String userEligibleForLoan;
        @SerializedName("whereWork")
        @Expose
        private String whereWork;

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

        public Integer getPaidToBankAmount() {
            return paidToBankAmount;
        }

        public void setPaidToBankAmount(Integer paidToBankAmount) {
            this.paidToBankAmount = paidToBankAmount;
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

        public Integer getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Integer unitPrice) {
            this.unitPrice = unitPrice;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getTotalAmount() {
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

        public String getUserEligibleForLoan() {
            return userEligibleForLoan;
        }

        public void setUserEligibleForLoan(String userEligibleForLoan) {
            this.userEligibleForLoan = userEligibleForLoan;
        }

        public String getWhereWork() {
            return whereWork;
        }

        public void setWhereWork(String whereWork) {
            this.whereWork = whereWork;
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

        public class PassportOrDrivingLicense {

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