package com.lightnet.api.controller.access;

import com.lightnet.annotation.NoAuth;
import com.lightnet.core.dto.TokenAuthResp;
import io.swagger.annotations.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
@RequestMapping(value = "/oauth")
public class APIAccessController {

    @ApiModel
    @Getter
    @Setter
    public static class TokenAuthRequest {
        @ApiModelProperty
        String grant_type;
        @ApiModelProperty
        String refresh_token;
    }

    @ApiImplicitParams({
    })
    @ApiOperation(value = "获取token")
    @PostMapping(value = "token")
    public TokenAuthResp tokenAuth(@RequestBody TokenAuthRequest request){

        TokenAuthResp.TokenAuthRespBuilder builder = TokenAuthResp.builder();
        builder.access_token("be69d566-971e-4e15-9648-85a486195863")
                .token_type("bearer")
                .refresh_token("1d0ec7b9-b569-426d-a18d-8dead5b6a3cc")
                .expires_in(12345)
                .scope("transfers");

        return builder.build();
    }
}
