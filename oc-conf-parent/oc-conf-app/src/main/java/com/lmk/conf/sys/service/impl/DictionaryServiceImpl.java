package com.lmk.conf.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmk.common.web.rdbms.service.impl.BaseServiceImpl;
import com.lmk.conf.sys.dao.DictionaryMapper;
import com.lmk.conf.sys.entity.Dictionary;
import com.lmk.conf.sys.service.IDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Service
@Transactional
public class DictionaryServiceImpl extends BaseServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {
	@Override
	public Wrapper<Dictionary> buildWrapper(Dictionary example) {
		QueryWrapper<Dictionary> q = new QueryWrapper<>();
		return q;
	}

	@Override
	public Dictionary findById(Integer id) {
		return this.getById(id);
	}

	@Override
	public void create(Dictionary item) {
		this.save(item);
	}

	@Override
	public void update(Dictionary item) {
		this.updateById(item);
	}

	@Override
	public void deleteById(Integer id) {
		this.removeById(id);
	}
}
