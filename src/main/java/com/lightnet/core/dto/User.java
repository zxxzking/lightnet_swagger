package com.lightnet.core.dto;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
public class User {

    private String name;

    private int age;

}
