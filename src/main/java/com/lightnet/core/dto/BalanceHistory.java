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
public class BalanceHistory {

    @ApiModelProperty
    private float amount;
    @ApiModelProperty
    private float balance;
    @ApiModelProperty
    private Currency currency;
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private float fee;
    @ApiModelProperty
    private String posted_at;
    @ApiModelProperty
    private String source;
    @ApiModelProperty
    private String source_type;

    public BalanceHistory(float amount, float balance, Currency currency, String description, float fee, String posted_at, String source, String source_type) {
        this.amount = amount;
        this.balance = balance;
        this.currency = currency;
        this.description = description;
        this.fee = fee;
        this.posted_at = posted_at;
        this.source = source;
        this.source_type = source_type;
    }
}
