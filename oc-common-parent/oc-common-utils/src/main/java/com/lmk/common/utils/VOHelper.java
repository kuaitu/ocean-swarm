package com.lmk.common.utils;

import com.lmk.common.exception.LogicException;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VOHelper {
    public static <T, VO extends T> List<VO> toVO(List<T> src, Class<VO> targetClass) {
        List<VO> targetList = new ArrayList<VO>(src.size());
        for (T item : src) {
            targetList.add(toVO(item, targetClass));
        }
        return targetList;
    }

    @SuppressWarnings("AlibabaAvoidApacheBeanUtilsCopy")
    public static <T, VO extends T> VO toVO(T src, Class<VO> targetClass) {
        try {
            VO target = targetClass.newInstance();
            BeanUtils.copyProperties(target, src);
            return target;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw LogicException.newEx("创建VO对象失败" + e.getMessage() + "，目标类名称：" + targetClass.getName());
        }
    }
}
