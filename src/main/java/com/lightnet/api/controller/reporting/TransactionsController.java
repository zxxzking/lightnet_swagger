package com.lightnet.api.controller.reporting;

import com.google.common.collect.Lists;
import com.lightnet.core.dto.DepositInfo;
import com.lightnet.core.enums.Currency;
import com.lightnet.core.resp.CommonResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"Transactions"})
@RestController
@RequestMapping(value = "/api/v1")
public class TransactionsController {

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "from_created_at", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "to_created_at", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page_num", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page_size", required = true),
    })
    @ApiOperation(value = "get deposits list")
    @GetMapping(value = "/deposits")
    public CommonResp<DepositInfo> getDepositsList() {
        CommonResp<DepositInfo> resp = new CommonResp<>();
        List<DepositInfo> depositInfoList = Lists.newLinkedList();
        DepositInfo info = new DepositInfo(12794.27f,
                "2017-03-20T14:00:01+1100", Currency.USD,
                "67f687fe-dcf4-4462-92fa-20335301d9d8",
                "67f687fe-dcf4-4462-92fa-20335321d9d8", "statement_ref");
        depositInfoList.add(info);
        resp.setItems(depositInfoList);
        return resp;
    }
}
