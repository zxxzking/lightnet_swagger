package com.lightnet.api.controller.FX;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lightnet.core.enums.Currency;
import io.swagger.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/v2/quotes/")
public class FXController {

    @Setter
    @Getter
    @ApiModel
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class InquireQuoteRequest {

        @ApiModelProperty
        private Currency sourceCurrency;
        @ApiModelProperty
        private Currency targetCurrency;
        @ApiModelProperty
        private float sourceAmount;
        @ApiModelProperty
        private float targetAmount;
        @ApiModelProperty
        private long profile;

    }

    @ApiImplicitParams({
    })
    @ApiOperation(value = "Inquire Quote")
    @PostMapping()
    public String inquireQuote(@RequestBody InquireQuoteRequest inquireQuoteRequest) {


        return "{\n" +
                "    \"sourceCurrency\": \"GBP\",\n" +
                "    \"targetCurrency\": \"USD\",\n" +
                "    \"targetAmount\": 110,\n" +
                "    \"payOut\": \"BANK_TRANSFER\",\n" +
                "    \"rate\": 1.30745,\n" +
                "    \"createdTime\": \"2019-04-09T11:46:38Z\",\n" +
                "    \"rateType\": \"FIXED\",\n" +
                "    \"guaranteedTargetAmountAllowed\": true,\n" +
                "    \"targetAmountAllowed\": true,\n" +
                "    \"guaranteedTargetAmount\": false,\n" +
                "    \"providedAmountType\": \"TARGET\",\n" +
                "    \"paymentOptions\": [\n" +
                "        {\n" +
                "            \"disabled\": false,\n" +
                "            \"estimatedDelivery\": \"2019-04-10T12:30:00Z\",\n" +
                "            \"formattedEstimatedDelivery\": \"by Apr 10\",\n" +
                "            \"estimatedDeliveryDelays\": [],\n" +
                "            \"fee\": {\n" +
                "                \"transferwise\": 0.87,\n" +
                "                \"payIn\": 0,\n" +
                "                \"discount\": 0,\n" +
                "                \"partner\": 0,\n" +
                "                \"total\": 0.87\n" +
                "            },\n" +
                "            \"sourceAmount\": 85,\n" +
                "            \"targetAmount\": 110,\n" +
                "            \"sourceCurrency\": \"GBP\",\n" +
                "            \"targetCurrency\": \"USD\",\n" +
                "            \"payIn\": \"BANK_TRANSFER\",\n" +
                "            \"payOut\": \"BANK_TRANSFER\",\n" +
                "            \"allowedProfileTypes\": [\n" +
                "                \"PERSONAL\",\n" +
                "                \"BUSINESS\"\n" +
                "            ],\n" +
                "            \"payInProduct\": \"CHEAP\",\n" +
                "            \"feePercentage\": 0.0102\n" +
                "        },\n" +
                "        {\n" +
                "            \"disabled\": true,\n" +
                "            \"estimatedDelivery\": null,\n" +
                "            \"formattedEstimatedDelivery\": null,\n" +
                "            \"estimatedDeliveryDelays\": [],\n" +
                "            \"fee\": {\n" +
                "                \"transferwise\": 1.15,\n" +
                "                \"payIn\": 0,\n" +
                "                \"discount\": 0,\n" +
                "                \"partner\": 0,\n" +
                "                \"total\": 1.15\n" +
                "            },\n" +
                "            \"sourceAmount\": 85.28,\n" +
                "            \"targetAmount\": 110,\n" +
                "            \"sourceCurrency\": \"GBP\",\n" +
                "            \"targetCurrency\": \"USD\",\n" +
                "            \"payIn\": \"BALANCE\",\n" +
                "            \"payOut\": \"BANK_TRANSFER\",\n" +
                "            \"allowedProfileTypes\": [\n" +
                "                \"PERSONAL\",\n" +
                "                \"BUSINESS\"\n" +
                "            ],\n" +
                "            \"disabledReason\": {\n" +
                "                \"code\": \"error.payInmethod.disabled\",\n" +
                "                \"message\": \"Open a borderless account and add funds to instantly pay for your transfers.\"\n" +
                "            },\n" +
                "            \"payInProduct\": \"BALANCE\",\n" +
                "            \"feePercentage\": 0.0135\n" +
                "        }\n" +
                "    ],\n" +
                "    \"notices\": []\n" +
                "}\n";
    }

    @ApiImplicitParams({
    })
    @ApiOperation(value = "create")
    @PostMapping("/create")
    public String create(@RequestBody InquireQuoteRequest inquireQuoteRequest) {

        return "{\n" +
                "    \"id\": \"11144c35-9fe8-4c32-b7fd-d05c2a7734bf\",\n" +
                "    \"sourceCurrency\": \"GBP\",\n" +
                "    \"targetCurrency\": \"USD\",\n" +
                "    \"sourceAmount\": 100,\n" +
                "    \"payOut\": \"BANK_TRANSFER\",\n" +
                "    \"rate\": 1.30445,\n" +
                "    \"createdTime\": \"2019-04-05T13:18:58Z\",\n" +
                "    \"user\": 55,\n" +
                "    \"profile\": 101,\n" +
                "    \"rateType\": \"FIXED\",\n" +
                "    \"rateExpirationTime\": \"2019-04-08T13:18:57Z\",\n" +
                "    \"guaranteedTargetAmountAllowed\": true,\n" +
                "    \"targetAmountAllowed\": true,\n" +
                "    \"guaranteedTargetAmount\": false,\n" +
                "    \"providedAmountType\": \"SOURCE\",\n" +
                "    \"paymentOptions\": [\n" +
                "        {\n" +
                "            \"disabled\": false,\n" +
                "            \"estimatedDelivery\": \"2019-04-08T12:30:00Z\",\n" +
                "            \"formattedEstimatedDelivery\": \"by Apr 8\",\n" +
                "            \"estimatedDeliveryDelays\": [],\n" +
                "            \"fee\": {\n" +
                "                \"transferwise\": 0.92,\n" +
                "                \"payIn\": 0,\n" +
                "                \"discount\": 0,\n" +
                "                \"partner\": 0,\n" +
                "                \"total\": 0.92\n" +
                "            },\n" +
                "            \"sourceAmount\": 100,\n" +
                "            \"targetAmount\": 129.24,\n" +
                "            \"sourceCurrency\": \"GBP\",\n" +
                "            \"targetCurrency\": \"USD\",\n" +
                "            \"payIn\": \"BANK_TRANSFER\",\n" +
                "            \"payOut\": \"BANK_TRANSFER\",\n" +
                "            \"allowedProfileTypes\": [\n" +
                "                \"PERSONAL\",\n" +
                "                \"BUSINESS\"\n" +
                "            ],\n" +
                "            \"payInProduct\": \"CHEAP\",\n" +
                "            \"feePercentage\": 0.0092\n" +
                "        },\n" +
                "        {\n" +
                "            \"disabled\": true,\n" +
                "            \"estimatedDelivery\": null,\n" +
                "            \"formattedEstimatedDelivery\": null,\n" +
                "            \"estimatedDeliveryDelays\": [],\n" +
                "            \"fee\": {\n" +
                "                \"transferwise\": 1.11,\n" +
                "                \"payIn\": 0,\n" +
                "                \"discount\": 0,\n" +
                "                \"partner\": 0,\n" +
                "                \"total\": 1.11\n" +
                "            },\n" +
                "            \"sourceAmount\": 100,\n" +
                "            \"targetAmount\": 129,\n" +
                "            \"sourceCurrency\": \"GBP\",\n" +
                "            \"targetCurrency\": \"USD\",\n" +
                "            \"payIn\": \"BALANCE\",\n" +
                "            \"payOut\": \"BANK_TRANSFER\",\n" +
                "            \"allowedProfileTypes\": [\n" +
                "                \"PERSONAL\",\n" +
                "                \"BUSINESS\"\n" +
                "            ],\n" +
                "            \"disabledReason\": {\n" +
                "                \"code\": \"error.payInmethod.disabled\",\n" +
                "                \"message\": \"Open a borderless account and add funds to instantly pay for your transfers.\"\n" +
                "            },\n" +
                "            \"payInProduct\": \"BALANCE\",\n" +
                "            \"feePercentage\": 0.0111\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"PENDING\",\n" +
                "    \"expirationTime\": \"2019-04-05T13:48:58Z\",\n" +
                "    \"notices\": [{\n" +
                "        \"text\": \"You can have a maximum of 3 open transfers with a guaranteed rate. After that, they'll be transferred using the live rate. Complete or cancel your other transfers to regain the use of guaranteed rate.\",\n" +
                "        \"link\": null,\n" +
                "        \"type\": \"WARNING\"\n" +
                "    }]\n" +
                "}";
    }
}
