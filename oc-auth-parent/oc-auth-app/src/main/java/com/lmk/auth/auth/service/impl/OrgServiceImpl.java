package com.lmk.auth.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.auth.auth.dao.OrgMapper;
import com.lmk.auth.auth.entity.Org;
import com.lmk.auth.auth.service.IOrgService;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class OrgServiceImpl extends BaseServiceImpl<OrgMapper, Org> implements IOrgService {
	@Override
	public Wrapper<Org> buildWrapper(Org example) {
		QueryWrapper<Org> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Org findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Org item) {
		this.save(item);
	}

	@Override
	public void update(Org item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}
