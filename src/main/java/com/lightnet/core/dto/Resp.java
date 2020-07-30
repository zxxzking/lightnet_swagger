package com.lightnet.core.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@ApiModel
public class Resp {

    @ApiModelProperty(value = "认证token", required = true)
    private String access_token;
    @ApiModelProperty(value = "token类型", required = true)
    private String token_type;

    private String refresh_token;

    private long expires_in;

    private String scope;

}