package com.lightnet.core.dto;

import com.lightnet.core.enums.Currency;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel
public class BalanceInfo {

    private String user_id;
    private Currency currency;
    private float available_amount;
    private float pending_amount;
    private float reserved_amount;
    private float total_amount;


}
