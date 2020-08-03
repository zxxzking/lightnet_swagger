package com.lightnet.api.controller.payments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lightnet.core.enums.Currency;
import io.swagger.annotations.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"Payments"})
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
        @ApiModelProperty
        String sourceAccount;
        @ApiModelProperty(value = "quote id")
        String quote;
        @ApiModelProperty
        String status;
        @ApiModelProperty
        String reference;
        @ApiModelProperty
        float rate;
        @ApiModelProperty
        String created;
        @ApiModelProperty(value = "your business profile id")
        String business;
        @ApiModelProperty
        String transferRequest;
        @ApiModelProperty
        Details details;
        @ApiModelProperty
        boolean hasActiveIssues;
        @ApiModelProperty
        Currency sourceCurrency;
        @ApiModelProperty
        float sourceValue;
        @ApiModelProperty
        Currency targetCurrency;
        @ApiModelProperty
        float targetValue;
        @ApiModelProperty
        String customerTransactionId;

    }

    @Getter
    @Setter
    @ApiModel
    public static class CreatRequest {
        @ApiModelProperty
        String sourceAccount;
        @ApiModelProperty
        String targetAccount;
        @ApiModelProperty
        String quoteUuid;
        @ApiModelProperty
        String customerTransactionId;
        @ApiModelProperty
        Details details;
    }

    @Getter
    @Setter
    @ApiModel
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class Details {
        @ApiModelProperty
        String reference;
        @ApiModelProperty
        String transferPurpose;
        @ApiModelProperty
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
    public PaymentResp cancelPayment(@PathVariable String transferId) {

        return getDemoResp();
    }

    private PaymentResp getDemoResp() {
        return getDemoResp(null);
    }

    private PaymentResp getDemoResp(String id) {
        PaymentResp.PaymentRespBuilder builder = new PaymentResp.PaymentRespBuilder();
        builder.id(Strings.isNullOrEmpty(id) ? "468956" : id).user("user id").targetAccount("target account")
                .quote(" ").status("incoming_payment_waiting").reference("to my friend")
                .rate(0.9065f).created("2018-08-28 07:43:55").business("<your business profile id>")
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
    public List<PaymentResp> getTransferList() {

        List<PaymentResp> list = Lists.newLinkedList();
        list.add(getDemoResp());
        list.add(getDemoResp());

        return list;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "transferId", required = true)
    })
    @ApiOperation(value = "get transfer by id")
    @GetMapping("/{transferId}")
    public PaymentResp getTransferById(@PathVariable String transferId) {

        return getDemoResp(transferId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "transferId", required = true)
    })
    @ApiOperation(value = "Get Transactions with Issues")
    @GetMapping("/{transferId}/issues")
    public List<TransferWithIssues> getTransferWithIssues(@PathVariable String transferId) {

        List<TransferWithIssues> list = Lists.newLinkedList();
        TransferWithIssues issues = new TransferWithIssues("Payment has bounced back",
                "OPENED", "Incorrect recipient account number");
        list.add(issues);
        return list;
    }

    @Getter
    @Setter
    @ApiModel
    public static class TransferWithIssues {
        String type;
        String state;
        String description;

        public TransferWithIssues(String type, String state, String description) {
            this.type = type;
            this.state = state;
            this.description = description;
        }

        public TransferWithIssues() {
        }
    }
}
