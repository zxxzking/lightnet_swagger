package com.lightnet.core.dto;

import com.lightnet.core.enums.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class DepositInfo {

    @ApiModelProperty
    private float amount;
    @ApiModelProperty
    private String created_at;
    @ApiModelProperty
    private Currency currency;
    @ApiModelProperty
    private String deposit_id;
    @ApiModelProperty
    private String global_account_id;
    @ApiModelProperty
    private String statement_ref;

    public DepositInfo(float amount, String created_at, Currency currency, String deposit_id, String global_account_id, String statement_ref) {
        this.amount = amount;
        this.created_at = created_at;
        this.currency = currency;
        this.deposit_id = deposit_id;
        this.global_account_id = global_account_id;
        this.statement_ref = statement_ref;
    }
}
