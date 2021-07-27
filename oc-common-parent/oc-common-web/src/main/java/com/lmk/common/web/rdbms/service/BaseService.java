package com.lmk.common.web.rdbms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lmk.common.rdbms.entity.BaseModel;
import com.lmk.common.rdbms.vo.PageQuery;

public interface BaseService<T extends BaseModel> extends IService<T> {
    <V extends T> IPage<T> search(PageQuery<V> q);

    <V extends T> IPage<V> searchVO(PageQuery<V> q, Class<V> voClass);
}
