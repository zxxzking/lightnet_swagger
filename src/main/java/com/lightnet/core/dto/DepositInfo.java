package com.lightnet.core.dto;

import com.lightnet.core.enums.Currency;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class DepositInfo {

    private float amount;
    private String created_at;
    private Currency currency;
    private String deposit_id;
    private String global_account_id;
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
