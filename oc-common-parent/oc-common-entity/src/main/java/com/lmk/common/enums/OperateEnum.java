package com.lmk.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@AllArgsConstructor
public enum OperateEnum {
    LOGIN("login","登录"),
    QUERY("query","查询"),
    ADD("add","添加"),
    EDIT("edit","更新"),
    DEL("del","删除"),
    IMPORT("import","导入"),
    EXPORT("export","导出"),
    DOWNLOAD("download","下载");

    String code;
    String name;

    /**
     * 获取枚举
     *
     * @param code
     * @return
     */
    public static OperateEnum transCode2Enum(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (OperateEnum value : OperateEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
