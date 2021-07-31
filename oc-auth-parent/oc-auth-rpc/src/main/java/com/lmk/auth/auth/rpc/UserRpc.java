package com.lmk.auth.auth.rpc;


import com.lmk.auth.Constants;
import com.lmk.auth.auth.api.UserApi;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@FeignClient(name = Constants.AUTH_SERVICE_NAME)
@RefreshScope
public interface UserRpc extends UserApi{
 
}