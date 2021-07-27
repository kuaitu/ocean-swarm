package com.lmk.common.rdbms.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery<T> {
    private Integer start;

    private Integer limit;

    private T query;

    public static <VO extends T, T> PageQuery<T> cast(PageQuery<VO> q) {
        PageQuery<T> tmp = new PageQuery<T>();
        tmp.setStart(q.getStart());
        tmp.setLimit(q.getLimit());
        tmp.setQuery(q.getQuery());
        return tmp;
    }
}
