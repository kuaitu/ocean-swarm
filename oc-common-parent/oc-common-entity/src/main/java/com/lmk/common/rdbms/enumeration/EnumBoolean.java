package com.lmk.common.rdbms.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumBoolean {
    NO("0", "否"),

    YES("1", "是");

    private String code;

    private String name;
}
