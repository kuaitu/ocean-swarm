package com.lmk.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@AllArgsConstructor
public enum ModuleEnum {

    SYSTEM_LOG("systemLog","日志");

    String code;
    String name;

    /**
     * 获取枚举
     *
     * @param code
     * @return
     */
    public static ModuleEnum transCode2Enum(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (ModuleEnum value : ModuleEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
