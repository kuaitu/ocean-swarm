package com.lmk.conf.sys.repository;

import com.lmk.conf.sys.entity.EsSystemLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsSystemLogRepository extends ElasticsearchRepository<EsSystemLog, Long> {
}
