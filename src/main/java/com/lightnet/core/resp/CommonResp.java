package com.lightnet.core.resp;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel
public class CommonResp<T> {

    private boolean has_more;
    private List<T> items;
}
