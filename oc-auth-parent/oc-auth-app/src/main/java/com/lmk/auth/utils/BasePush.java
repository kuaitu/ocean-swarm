package com.lmk.auth.utils;

import java.io.IOException;
import java.util.Map;

public interface BasePush<T> {
    T push(Map<String, Map<String, Object>> paramsMap) throws IOException;
}
