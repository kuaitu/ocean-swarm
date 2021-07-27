package com.lmk.common.rdbms.vo;

import com.lmk.common.exception.LogicException;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ret<T> {
    enum ErrorCode {
        c_200, c_500, c_403
    }

    private ErrorCode code;

    private T data;

    private Boolean success;

    private String message;

    public static <T> Ret<T> ok(T data) {
        return new Ret<>(ErrorCode.c_200, data, true, "操作成功");
    }

    public static Ret<Void> ok() {
        return new Ret<Void>(ErrorCode.c_200, null, true, "操作成功");
    }

    public static <T> Ret<T> err(String msg) {
        return new Ret<>(ErrorCode.c_500, null, false, msg);
    }

    public static <T> Ret<T> noAuth(String msg) {
        return new Ret<>(ErrorCode.c_403, null, false, msg);
    }

    public void valideOrThrow(String msg) throws LogicException {
        if (!success) {
            log.error("调用接口异常, 返回=[{}]", this.getMessage());
            throw LogicException.newEx(msg + "," + this.getMessage());
        }
    }

    public void valideOrThrow() throws LogicException {
        this.valideOrThrow("");
    }
}
