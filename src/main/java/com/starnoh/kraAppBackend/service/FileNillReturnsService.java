package com.starnoh.kraAppBackend.service;

import com.starnoh.kraAppBackend.dto.FileReturnsDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileNillReturnsService {

    private final KraAuthService kraAuthService;

    public FileNillReturnsService(KraAuthService kraAuthService) {
        this.kraAuthService = kraAuthService;
    }

    public String fileReturns(FileReturnsDto request) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            String accessToken = kraAuthService.getAccessToken();

            if(accessToken == null || accessToken.isEmpty()){
                throw new RuntimeException("Access Token is not provided");
            }

            System.out.println("Here is the access token " + accessToken);

            String url = "https://sbx.kra.go.ke/dtd/return/v1/nil";
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String , Map<String , Object> > mainBody = new HashMap<>();
            Map<String , Object> body = new HashMap<>();

            /*

              For now , we want to create an application that files nill returns for individual resident with no income
              taxPayerPIN = KRA PIN

              obligationCode = Obligation unique identifier tied to a certain tax obligation.
                Possible Values:
                "1" - Income Tax - Individual Resident
                "2" - Income Tax - Individual Non-Resident
                "3" - Income Tax - Individual Partnership
                "4" - Income Tax - Company
                "5" - Value Added Tax (VAT)
                "6" - Income Tax - PAYE
                "7" - Excise
                "8" - Income Tax - Rent Income (MRI)



                month = Month of the respective monthly return for which taxpayer wants to file NIL return (in two digit format e.g. "01" for January)

                NOTE - For annual returns, indicate the month as per the accounting period e.g. For Individual Returns the value should be "12" for December

                year = Year of the respective monthly return for which taxpayer wants to file NIL return (in four digit format e.g. "2025")



            * */


            String taxPayerPIN = request.getTaxPayerPIN();
            String obligationCode = "1";
            String month = "12";
            String year = "2000";

            body.put("TaxpayerPIN" , taxPayerPIN);
            body.put("ObligationCode" , obligationCode);
            body.put("Month" , month);
            body.put("Year" , year);

            mainBody.put("TAXPAYERDETAILS" , body);

            System.out.println("Request payload: " + mainBody);

            HttpEntity<Map<String, Map<String , Object>>> entity =
                    new HttpEntity<>(mainBody, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, entity, String.class);

            if(!response.getStatusCode().is2xxSuccessful()){
                throw new RuntimeException("KRA request failed: " + response.getStatusCode());
            }

            return response.getBody();


        }

        catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
            return "Failed to initiate payment: " + e.getMessage();
        }

    }
}
