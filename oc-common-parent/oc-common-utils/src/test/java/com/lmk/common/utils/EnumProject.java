package com.lmk.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumProject {

    APP("app", "app"),

    API("api", "api"),

    RPC("rpc", "rpc"),

    ENTITY("entity", "entity");

    private String code;

    private String name;
}
