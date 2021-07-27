package com.lmk.common.web.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmk.common.exception.LogicException;
import com.lmk.common.rdbms.entity.BaseModel;
import com.lmk.common.rdbms.vo.PageQuery;
import com.lmk.common.utils.VOHelper;
import com.lmk.common.web.rdbms.service.BaseService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> extends ServiceImpl<M, T>
        implements BaseService<T> {
    @Override
    public <V extends T> IPage<T> search(PageQuery<V> q) {
        return page(new Page<>(q.getStart(), q.getLimit()), buildWrapper(q.getQuery()));
    }

    @SuppressWarnings("AlibabaAvoidApacheBeanUtilsCopy")
    @Override
    public <V extends T> IPage<V> searchVO(PageQuery<V> q, Class<V> voClass) {
        IPage<T> page = page(new Page<>(q.getStart(), q.getLimit()), buildWrapper(q.getQuery()));
        IPage<V> pageVo = new Page<V>();
        try {
            BeanUtils.copyProperties(page, pageVo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw LogicException.newEx("无法复制到vo", e);
        }
        pageVo.setTotal(page.getTotal());
        pageVo.setRecords(VOHelper.toVO(page.getRecords(), voClass));
        return pageVo;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        return getOne(queryWrapper, false);
    }

    protected abstract Wrapper<T> buildWrapper(T q);
}
