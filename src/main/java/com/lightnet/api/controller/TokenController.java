package com.lightnet.api.controller;

import com.lightnet.core.dto.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
@RequestMapping(value = "/oauth")
public class TokenController {

    @ApiImplicitParams({
    })
    @ApiOperation(value = "获取token")
    @GetMapping(value = "token")
    public Resp tokenAuth(){

        Resp.RespBuilder builder = Resp.builder();
        builder.access_token("be69d566-971e-4e15-9648-85a486195863")
                .token_type("bearer")
                .refresh_token("1d0ec7b9-b569-426d-a18d-8dead5b6a3cc")
                .expires_in(12345)
                .scope("transfers");

        return builder.build();
    }
}
