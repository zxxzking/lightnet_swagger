package com.lightnet.api.controller.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.lightnet.core.dto.BalanceInfo;
import com.lightnet.core.enums.Currency;
import io.swagger.annotations.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/v1/transfers")
public class PaymentsController {

    @Getter
    @Setter
    @ApiModel
    @Builder
    public static class PaymentResp {
        String id;
        @ApiModelProperty(value = "your user id")
        String user;
        @ApiModelProperty(value = "recipient account id")
        String targetAccount;
        String sourceAccount;
        @ApiModelProperty(value = "quote id")
        String quote;
        String status;
        String reference;
        float rate;
        String created;
        @ApiModelProperty(value = "your business profile id")
        String bussiness;
        String transferRequest;
        Details details;
        boolean hasActiveIssues;
        Currency sourceCurrency;
        float sourceValue;
        Currency targetCurrency;
        float targetValue;
        String customerTransactionId;

    }

    @Getter
    @Setter
    @ApiModel
    public static class CreatRequest {
        String sourceAccount;
        String targetAccount;
        String quoteUuid;
        String customerTransactionId;
        Details details;
    }

    @Getter
    @Setter
    @ApiModel
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Details {
        String reference;
        String transferPurpose;
        String sourceOfFunds;

        public Details() {
        }

        public Details(String reference) {
            this.reference = reference;
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true)
    })
    @ApiOperation(value = "create transfer")
    @PostMapping()
    public PaymentResp createPayment(@RequestBody CreatRequest request) {
        return getDemoResp();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "transferId", value = "transferId", required = true)
    })
    @ApiOperation(value = "cancel transfer")
    @PutMapping(value = "{transferId}/cancel")
    public PaymentResp cancelPayment() {

        return getDemoResp();
    }

    private PaymentResp getDemoResp() {
        PaymentResp.PaymentRespBuilder builder = new PaymentResp.PaymentRespBuilder();
        builder.id("468956").user("user id").targetAccount("target account")
                .quote(" ").status("incoming_payment_waiting").reference("to my friend")
                .rate(0.9065f).created("2018-08-28 07:43:55").bussiness("<your business profile id>")
                .sourceCurrency(Currency.EUR).sourceValue(661.89f).targetCurrency(Currency.GBP).targetValue(600f)
                .customerTransactionId("bd244a95-dcf8-4c31-aac8-bf5e2f3e54c0").details(new Details("to my friend"));

        return builder.build();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "offset", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "limit", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "profile", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "status", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createdDateStart", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createdDateEnd", required = true)
    })
    @ApiOperation(value = "list transfer")
    @GetMapping()
    public String getTransferList() {

        return "[\n" +
                "  {\n" +
                "    \"id\": 15574445,\n" +
                "    \"user\": 294205,\n" +
                "    \"targetAccount\": 7993919,\n" +
                "    \"sourceAccount\": null,\n" +
                "    \"quote\": 113379,\n" +
                "    \"status\": \"funds_refunded\",\n" +
                "    \"reference\": \"good times\",\n" +
                "    \"rate\": 1.1179,\n" +
                "    \"created\": \"2018-12-16 15:25:51\",\n" +
                "    \"business\": null,\n" +
                "    \"transferRequest\": null,\n" +
                "    \"details\": {\n" +
                "      \"reference\": \"good times\"\n" +
                "    },\n" +
                "    \"hasActiveIssues\": false,\n" +
                "    \"sourceValue\": 1000,\n" +
                "    \"sourceCurrency\": \"EUR\",\n" +
                "    \"targetValue\": 895.32,\n" +
                "    \"targetCurrency\": \"GPB\",\n" +
                "    \"customerTransactionId\": \"6D9188CF-FA59-44C3-87A2-4506CE9C1EA3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 14759252,\n" +
                "    \"user\": 294205,\n" +
                "    \"targetAccount\": 5570192,\n" +
                "    \"sourceAccount\": null,\n" +
                "    \"quote\": 113371,\n" +
                "    \"status\": \"funds_refunded\",\n" +
                "    \"reference\": \"\",\n" +
                "    \"rate\": 1.1179,\n" +
                "    \"created\": \"2018-12-26 15:25:51\",\n" +
                "    \"business\": null,\n" +
                "    \"transferRequest\": null,\n" +
                "    \"details\": {\n" +
                "      \"reference\": \"\"\n" +
                "    },\n" +
                "    \"hasActiveIssues\": false,\n" +
                "    \"sourceValue\": 1000,\n" +
                "    \"sourceCurrency\": \"EUR\",\n" +
                "    \"targetValue\": 895.32,\n" +
                "    \"targetCurrency\": \"GPB\",\n" +
                "    \"customerTransactionId\": \"785C67AD-7E29-4DBC-9D4A-4C45D4D5333A\"\n" +
                "  }\n" +
                "]";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "transferId", required = true)
    })
    @ApiOperation(value = "get transfer by id")
    @GetMapping("/{transferId}")
    public String getTransferById() {

        return "{\n" +
                "  \"id\": 15574445,\n" +
                "  \"user\": 294205,\n" +
                "  \"targetAccount\": 7993919,\n" +
                "  \"sourceAccount\": null,\n" +
                "  \"quote\": 113379,\n" +
                "  \"status\": \"incoming_payment_waiting\",\n" +
                "  \"reference\": \"good times\",\n" +
                "  \"rate\": 1.2151,\n" +
                "  \"created\": \"2017-03-14 15:25:51\",\n" +
                "  \"business\": null,\n" +
                "  \"transferRequest\": null,\n" +
                "  \"details\": {\n" +
                "    \"reference\": \"good times\"\n" +
                "  },\n" +
                "  \"hasActiveIssues\": false,\n" +
                "  \"sourceValue\": 1000,\n" +
                "  \"sourceCurrency\": \"EUR\",\n" +
                "  \"targetValue\": 895.32,\n" +
                "  \"targetCurrency\": \"GPB\",\n" +
                "  \"customerTransactionId\": \"6D9188CF-FA59-44C3-87A2-4506CE9C1EA3\"\n" +
                "}";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "transferId", required = true)
    })
    @ApiOperation(value = "Get Transactions with Issues")
    @GetMapping("/{transferId}/issues")
    public String getTransactionseWithIssues() {

        return "[\n" +
                "  {\n" +
                "    \"type\": \"Payment has bounced back\",\n" +
                "    \"state\": \"OPENED\",\n" +
                "    \"description\": \"Incorrect recipient account number\"\n" +
                "  }\n" +
                "]";
    }
}
