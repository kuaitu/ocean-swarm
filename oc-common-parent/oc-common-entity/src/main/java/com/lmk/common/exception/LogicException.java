package com.lmk.common.exception;

public class LogicException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private LogicException(String msg) {
        super(msg);
    }

    private LogicException(String msg, Throwable e) {
        super(msg, e);
    }

    public static LogicException newEx(String msg) {
        return new LogicException(msg);
    }

    public static LogicException newEx(String msg, Throwable e) {
        return new LogicException(msg);
    }
}
