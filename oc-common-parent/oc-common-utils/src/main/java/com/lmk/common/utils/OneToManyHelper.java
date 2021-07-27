package com.lmk.common.utils;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneToManyHelper {
    /**
     * 将两个列表进行一对多关联, 例如对Teacher, Student进行关联
     *
     * @param oneList            代表一的列表，例如Teacher列表
     * @param manyList           代表多的列表, 例如Student列表
     * @param oneIdFetcher       一的类中获取id的方法, 例如Teacher::getId
     * @param oneChildrenFetcher 一的类中获取多的类的列表的防范，例如Teacher::getStudentList
     * @param manyPidFetcher     多的类中获取父类id的方案，例如Student::getTeacherId
     */
    public static <One, Many> void wire(List<One> oneList, List<Many> manyList, SFunction<One, Integer> oneIdFetcher,
                                        SFunction<One, List<Many>> oneChildrenFetcher, SFunction<Many, Integer> manyPidFetcher) {
        if (CollectionUtils.isEmpty(oneList) || CollectionUtils.isEmpty(manyList)) {
            return;
        }

        Map<Integer, One> idToOneMap = new HashMap<Integer, One>();
        for (One o : oneList) {
            Integer id = oneIdFetcher.apply(o);
            if (id != null) {
                idToOneMap.put(id, o);
            }
        }

        for (Many many : manyList) {
            if (manyPidFetcher.apply(many) != null) {
                One parent = idToOneMap.get(manyPidFetcher.apply(many));
                if (null != parent) {
                    List<Many> children = oneChildrenFetcher.apply(parent);
                    children.add(many);
                }
            }
        }
    }
}
