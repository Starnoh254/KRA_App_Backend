package com.starnoh.kraAppBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KraRequest {

    @JsonProperty("TAXPAYERDETAILS")
    private TaxpayerDetails taxpayerDetails;

    public TaxpayerDetails getTaxpayerDetails() {
        return taxpayerDetails;
    }

    public void setTaxpayerDetails(TaxpayerDetails taxpayerDetails) {
        this.taxpayerDetails = taxpayerDetails;
    }
}
