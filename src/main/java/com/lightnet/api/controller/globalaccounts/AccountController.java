package com.lightnet.api.controller.globalaccounts;

import io.swagger.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
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
    private Object openAccount(@RequestBody OpenAccountRequest openAccountRequest) {

        return "{\n" +
                "  \"account_name\": \"string\",\n" +
                "  \"account_number\": \"88888888\",\n" +
                "  \"account_routing_type\": \"aba\",\n" +
                "  \"account_routing_value\": \"026073150\",\n" +
                "  \"branch_code\": \"447\",\n" +
                "  \"clearing_systems\": [\n" +
                "    \"ACH\"\n" +
                "  ],\n" +
                "  \"country_code\": \"AU\",\n" +
                "  \"currency\": \"AUD\",\n" +
                "  \"id\": \"7f687fe6-dcf4-4462-92fa-80335301d9d2\",\n" +
                "  \"institution_name\": \"Saxo Payments A/S\",\n" +
                "  \"nick_name\": \"GBP in UK for Subsidiary Company ABC\",\n" +
                "  \"payment_methods\": [\n" +
                "    \"LOCAL\"\n" +
                "  ],\n" +
                "  \"request_id\": \"8d411ad4-aed6-1261-92fa-51225212e2e1\",\n" +
                "  \"status\": \"ACTIVE\",\n" +
                "  \"swift_code\": \"SXPYDEHH\"";
    }
}
