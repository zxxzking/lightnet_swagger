package com.lightnet.api.controller.globalaccounts;

import com.google.common.collect.Lists;
import com.lightnet.core.enums.Currency;
import io.swagger.annotations.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"Account"})
@RestController
@RequestMapping(value = "/api/v1/global_accounts/")
public class AccountController {

    @ApiModel
    @Getter
    @Setter
    public static class OpenAccountRequest {

        @ApiModelProperty
        String country_code;
        @ApiModelProperty
        String currency;
        @ApiModelProperty
        String nick_name;
        @ApiModelProperty
        List<String> payment_methods;
        @ApiModelProperty
        String request_id;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true)
    })
    @ApiOperation(value = "open account")
    @PostMapping("/create")
    private Account openAccount(@RequestBody OpenAccountRequest openAccountRequest) {
        Account.AccountBuilder builder = Account.builder();
        builder.account_name("string").account_number("88888888").account_routing_type("aba")
                .account_routing_value("026073150").branch_code("447").country_code("AU").currency(Currency.AUD)
                .id("7f687fe6-dcf4-4462-92fa-80335301d9d2").institution_name("Saxo Payments A/S")
                .nick_name("GBP in UK for Subsidiary Company ABC").request_id("8d411ad4-aed6-1261-92fa-51225212e2e1")
                .status("ACTIVE").swift_code("SXPYDEHH");

        return builder.build();
    }

    @Getter
    @Setter
    @Builder
    @ApiModel
    public static class Account {

        String account_name;
        String account_number;
        String account_routing_type;
        String account_routing_value;
        String branch_code;
        List<String> clearing_systems;
        String country_code;
        Currency currency;
        String id;
        String institution_name;
        String nick_name;
        List<String> payment_methods;
        String request_id;
        String status;
        String swift_code;

    }
}
