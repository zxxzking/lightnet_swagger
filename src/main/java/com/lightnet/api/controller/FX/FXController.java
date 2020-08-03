package com.lightnet.api.controller.FX;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.lightnet.core.enums.Currency;
import com.lightnet.core.enums.ProfileType;
import io.swagger.annotations.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"FX"})
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

    @Getter
    @Setter
    @Builder
    @ApiModel
    public static class PaymentOption {
        boolean disabled;
        String estimatedDelivery;
        String formattedEstimatedDelivery;
        List<String> estimatedDeliveryDelays;
        Fee fee;
        float sourceAmount;
        float targetAmount;
        Currency sourceCurrency;
        Currency targetCurrency;
        String payIn;
        String payOut;
        List<ProfileType> allowedProfileTypes;
        String payInProduct;
        float feePercentage;
    }

    @Getter
    @Setter
    @Builder
    @ApiModel
    public static class Fee {
        float transferwise;
        float payIn;
        float discount;
        float partner;
        float total;

        public Fee(float transferwise, float payIn, float discount, float partner, float total) {
            this.transferwise = transferwise;
            this.payIn = payIn;
            this.discount = discount;
            this.partner = partner;
            this.total = total;
        }

        public Fee() {
        }
    }

    @Getter
    @Setter
    @Builder
    @ApiModel
    public static class InquireQuoteResp {

        private Currency sourceCurrency;
        private Currency targetCurrency;
        private float targetAmount;
        private String payOut;
        private float rate;
        private String createdTime;
        private String rateType;
        private boolean guaranteedTargetAmountAllowed;
        private boolean targetAmountAllowed;
        private boolean guaranteedTargetAmount;
        private String providedAmountType;
        @ApiModelProperty
        private List<PaymentOption> paymentOptions;
        private List<Notice> notices;

    }


    @ApiImplicitParams({
    })
    @ApiOperation(value = "Inquire Quote")
    @PostMapping()
    public InquireQuoteResp inquireQuote(@RequestBody InquireQuoteRequest inquireQuoteRequest) {
        InquireQuoteResp.InquireQuoteRespBuilder builder = new InquireQuoteResp.InquireQuoteRespBuilder();
        builder.sourceCurrency(Currency.GBP).targetCurrency(Currency.USD).targetAmount(110f).payOut("BANK_TRANSFER")
                .rate(1.30745f).createdTime("2019-04-09T11:46:38Z").rateType("FIXED").guaranteedTargetAmountAllowed(true)
                .targetAmountAllowed(true).guaranteedTargetAmount(false).providedAmountType("TARGET");


        builder.paymentOptions(getPaymentOptionList()).notices(Lists.newLinkedList());
        return builder.build();
    }

    @Getter
    @Setter
    @ApiModel
    public static class Notice {
        String text;
        String link;
        String type;

        public Notice(String text, String link, String type) {
            this.text = text;
            this.link = link;
            this.type = type;
        }

        public Notice() {
        }
    }

    @Getter
    @Setter
    @ApiModel
    public static class CreateQuoteResp {
        String id;
        Currency sourceCurrency;
        Currency targetCurrency;
        float sourceAmount;
        String payOut;
        float rate;
        String createdTime;
        int user;
        int profile;
        String rateType;
        String rateExpirationTime;
        boolean guaranteedTargetAmountAllowed;
        boolean targetAmountAllowed;
        boolean guaranteedTargetAmount;
        String providedAmountType;
        List<PaymentOption> paymentOptions;
        String status;
        String expirationTime;
        List<Notice> notices;

        public CreateQuoteResp(String id, Currency sourceCurrency, Currency targetCurrency, float sourceAmount,
                               String payOut, float rate, String createdTime, int user, int profile, String rateType,
                               String rateExpirationTime, boolean guaranteedTargetAmountAllowed, boolean targetAmountAllowed,
                               boolean guaranteedTargetAmount, String providedAmountType, List<PaymentOption> paymentOptions,
                               String status, String expirationTime, List<Notice> notices) {
            this.id = id;
            this.sourceCurrency = sourceCurrency;
            this.targetCurrency = targetCurrency;
            this.sourceAmount = sourceAmount;
            this.payOut = payOut;
            this.rate = rate;
            this.createdTime = createdTime;
            this.user = user;
            this.profile = profile;
            this.rateType = rateType;
            this.rateExpirationTime = rateExpirationTime;
            this.guaranteedTargetAmountAllowed = guaranteedTargetAmountAllowed;
            this.targetAmountAllowed = targetAmountAllowed;
            this.guaranteedTargetAmount = guaranteedTargetAmount;
            this.providedAmountType = providedAmountType;
            this.paymentOptions = paymentOptions;
            this.status = status;
            this.expirationTime = expirationTime;
            this.notices = notices;
        }

        public CreateQuoteResp() {
        }
    }

    @ApiImplicitParams({
    })
    @ApiOperation(value = "create")
    @PostMapping("/create")
    public CreateQuoteResp create(@RequestBody InquireQuoteRequest inquireQuoteRequest) {
        CreateQuoteResp resp = new CreateQuoteResp("11144c35-9fe8-4c32-b7fd-d05c2a7734bf", Currency.GBP, Currency.USD,
                100f, "BANK_TRANSFER", 1.30445f, "2019-04-05T13:18:58Z", 55,
                101, "FIXED", "2019-04-08T13:18:57Z", true,
                true, false, "SOURCE", getPaymentOptionList(),
                "PENDING", "2019-04-05T13:48:58Z", getNoticeList());
        return resp;
    }

    private List<PaymentOption> getPaymentOptionList() {
        Fee fee1 = new Fee(0.87f, 0, 0, 0, 0.87f);
        List<ProfileType> profileTypes = Lists.newLinkedList();
        profileTypes.add(ProfileType.PERSONAL);
        profileTypes.add(ProfileType.BUSINESS);

        PaymentOption.PaymentOptionBuilder optionBuilder1 = new PaymentOption.PaymentOptionBuilder();
        optionBuilder1.disabled(false).estimatedDelivery("2019-04-10T12:30:00Z").formattedEstimatedDelivery("by Apr 10")
                .estimatedDeliveryDelays(Lists.newArrayList()).fee(fee1).sourceAmount(85f).targetAmount(110f)
                .sourceCurrency(Currency.GBP).targetCurrency(Currency.USD).payIn("BANK_TRANSFER").payOut("BANK_TRANSFER")
                .allowedProfileTypes(profileTypes).payInProduct("CHEAP").feePercentage(0.0102f);
        List<PaymentOption> options = Lists.newLinkedList();
        options.add(optionBuilder1.build());

        return options;
    }

    private List<Notice> getNoticeList() {
        List<Notice> list = Lists.newLinkedList();
        Notice notice = new Notice("You can have a maximum of 3 open transfers with a guaranteed rate. After that, " +
                "they'll be transferred using the live rate. Complete or cancel your other transfers to regain the use " +
                "of guaranteed rate.", "", "WARNING");
        list.add(notice);
        return list;
    }
}
