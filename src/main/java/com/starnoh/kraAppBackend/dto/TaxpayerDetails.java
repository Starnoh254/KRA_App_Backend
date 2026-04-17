package com.starnoh.kraAppBackend.dto;

public class TaxpayerDetails {

    private String TaxpayerPIN;
    private String ObligationCode;
    private String Month;
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
}
