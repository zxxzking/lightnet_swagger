package com.lightnet.api.controller.reporting;

import com.google.common.collect.Lists;
import com.lightnet.annotation.UserAuthenticate;
import com.lightnet.core.dto.BalanceHistory;
import com.lightnet.core.dto.BalanceInfo;
import com.lightnet.core.enums.Capability;
import com.lightnet.core.enums.Currency;
import com.lightnet.core.resp.CommonResp;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"Balance"})
@RestController
@RequestMapping(value = "/api/v1/balances")
public class BalancesController {

    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "Authorization", value = "token", required = true)})
    @ApiOperation(value = "获取当前余额")
    @GetMapping(value = "/current")
    public List<BalanceInfo> getCurrentBalance(@RequestHeader(value = "Authorization") String token) {
        List<BalanceInfo> infoList = Lists.newArrayList();
        BalanceInfo.BalanceInfoBuilder builder = BalanceInfo.builder();
        builder.user_id("xxx")
                .currency(Currency.AUD)
                .available_amount(100000f)
                .pending_amount(50000f)
                .reserved_amount(0)
                .total_amount(150000f);
        infoList.add(builder.build());

        return infoList;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "currency", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "from_post_at", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page_num", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "page_size", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "request_id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "to_post_at", required = true),
    })
    @ApiOperation(value = "获取余额历史记录")
    @GetMapping(value = "/history")
    @UserAuthenticate(capability = Capability.UPDATE)
    public CommonResp<BalanceHistory> getBalanceHistory() {
        CommonResp<BalanceHistory> resp = new CommonResp<>();
        resp.setHas_more(false);
        List<BalanceHistory> list = Lists.newLinkedList();
        BalanceHistory history = new BalanceHistory(
                50f, 1050f, Currency.AUD,
                "desc", 25f, "2017-04-01T03:52:34+0000",
                "a08c0f2f-3f26-4443-b5df-fad15582eb94", "PAYMENT");
        list.add(history);
        resp.setItems(list);

        return resp;
    }
}
