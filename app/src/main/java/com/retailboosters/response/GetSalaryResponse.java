package com.retailboosters.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetSalaryResponse {

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

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("hasData")
        @Expose
        private Boolean hasData;
        @SerializedName("responseId")
        @Expose
        private String responseId;
        @SerializedName("responseDate")
        @Expose
        private String responseDate;
        @SerializedName("requestDate")
        @Expose
        private String requestDate;
        @SerializedName("responseCode")
        @Expose
        private String responseCode;
        @SerializedName("responseMsg")
        @Expose
        private String responseMsg;
        @SerializedName("data")
        @Expose
        private Data_ _data;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Boolean getHasData() {
            return hasData;
        }

        public void setHasData(Boolean hasData) {
            this.hasData = hasData;
        }

        public String getResponseId() {
            return responseId;
        }

        public void setResponseId(String responseId) {
            this.responseId = responseId;
        }

        public String getResponseDate() {
            return responseDate;
        }

        public void setResponseDate(String responseDate) {
            this.responseDate = responseDate;
        }

        public String getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(String requestDate) {
            this.requestDate = requestDate;
        }

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public void setResponseMsg(String responseMsg) {
            this.responseMsg = responseMsg;
        }

        public Data_ getData() {
            return _data;
        }

        public void setData(Data_ data) {
            this._data = data;
        }



        public class Data_ {

            @SerializedName("customerId")
            @Expose
            private String customerId;
            @SerializedName("accountNumber")
            @Expose
            private String accountNumber;
            @SerializedName("bankCode")
            @Expose
            private String bankCode;
            @SerializedName("bvn")
            @Expose
            private Object bvn;
            @SerializedName("companyName")
            @Expose
            private String companyName;
            @SerializedName("customerName")
            @Expose
            private String customerName;
            @SerializedName("category")
            @Expose
            private Object category;
            @SerializedName("firstPaymentDate")
            @Expose
            private String firstPaymentDate;
            @SerializedName("salaryCount")
            @Expose
            private String salaryCount;
            @SerializedName("salaryPaymentDetails")
            @Expose
            private ArrayList<SalaryPaymentDetail> salaryPaymentDetails = null;
            @SerializedName("loanHistoryDetails")
            @Expose
            private List<LoanHistoryDetail> loanHistoryDetails = null;

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
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

            public Object getBvn() {
                return bvn;
            }

            public void setBvn(Object bvn) {
                this.bvn = bvn;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public Object getCategory() {
                return category;
            }

            public void setCategory(Object category) {
                this.category = category;
            }

            public String getFirstPaymentDate() {
                return firstPaymentDate;
            }

            public void setFirstPaymentDate(String firstPaymentDate) {
                this.firstPaymentDate = firstPaymentDate;
            }

            public String getSalaryCount() {
                return salaryCount;
            }

            public void setSalaryCount(String salaryCount) {
                this.salaryCount = salaryCount;
            }

            public ArrayList<SalaryPaymentDetail> getSalaryPaymentDetails() {
                return salaryPaymentDetails;
            }

            public void setSalaryPaymentDetails(ArrayList<SalaryPaymentDetail> salaryPaymentDetails) {
                this.salaryPaymentDetails = salaryPaymentDetails;
            }

            public List<LoanHistoryDetail> getLoanHistoryDetails() {
                return loanHistoryDetails;
            }

            public void setLoanHistoryDetails(List<LoanHistoryDetail> loanHistoryDetails) {
                this.loanHistoryDetails = loanHistoryDetails;
            }


            public class LoanHistoryDetail {

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

                public void setRepaymentAmount(float repaymentAmount) {
                    this.repaymentAmount = repaymentAmount;
                }

                public String getRepaymentFreq() {
                    return repaymentFreq;
                }

                public void setRepaymentFreq(String repaymentFreq) {
                    this.repaymentFreq = repaymentFreq;
                }

            }



            public class SalaryPaymentDetail {

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



        }

    }


}