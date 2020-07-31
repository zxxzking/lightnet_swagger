package com.lightnet.core.dto;

import com.lightnet.core.enums.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel
public class BalanceInfo {

    @ApiModelProperty
    private String user_id;
    @ApiModelProperty
    private Currency currency;
    @ApiModelProperty
    private float available_amount;
    @ApiModelProperty
    private float pending_amount;
    @ApiModelProperty
    private float reserved_amount;
    @ApiModelProperty
    private float total_amount;


}
