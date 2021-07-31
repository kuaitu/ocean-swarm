package com.lmk.conf.sys.rpc;


import com.lmk.conf.Constants;
import com.lmk.conf.sys.api.SystemLogApi;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@FeignClient(name = Constants.AUTH_SERVICE_NAME)
@RefreshScope
public interface SystemLogRpc extends SystemLogApi{
 
}