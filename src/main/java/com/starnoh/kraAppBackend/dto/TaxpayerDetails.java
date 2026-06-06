package com.starnoh.kraAppBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxpayerDetails {

    @JsonProperty("TaxpayerPIN")
    private String TaxpayerPIN;

    @JsonProperty("ObligationCode")
    private String ObligationCode;

    @JsonProperty("Month")
    private String Month;

    @JsonProperty("Year")
    private String Year;

    public String getTaxpayerPIN() {
        return TaxpayerPIN;
    }

    public void setTaxpayerPIN(String taxpayerPIN) {
        TaxpayerPIN = taxpayerPIN;
    }

    public String getObligationCode() {
        return ObligationCode;
    }

    public void setObligationCode(String obligationCode) {
        ObligationCode = obligationCode;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    @Override
    public String toString() {
        return "TaxpayerDetails{" +
                "TaxpayerPIN='" + TaxpayerPIN + '\'' +
                ", ObligationCode='" + ObligationCode + '\'' +
                ", Month='" + Month + '\'' +
                ", Year='" + Year + '\'' +
                '}';
    }
}
