package com.lmk.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPublicColumn {
    ID("id", "记录id"),

    CREATOR_ACCT("creator_acct", "创建人账号"),

    CREATOR_NAME("creator_name", "创建人姓名"),

    CREATE_TIME("create_time", "创建时间"),

    UPDATER_ACCT("updater_acct", "更新人账号"),

    UPDATER_NAME("updater_name", "更新人姓名"),

    UPDATE_TIME("update_time", "更新时间"),

    REMARK("remark", "备注"),

    IS_DELETE("is_delete", "是否删除");

    private String code;

    private String name;
}
