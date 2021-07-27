package com.lmk.auth.biz.rpc;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import com.lmk.auth.Constants;
import com.lmk.auth.biz.api.ClassroomApi;


/**
 * <p>
 * 教室 前端控制器
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
@FeignClient(name = Constants.AUTH_SERVICE_NAME)
@RefreshScope
public interface ClassroomRpc extends ClassroomApi{
 
}