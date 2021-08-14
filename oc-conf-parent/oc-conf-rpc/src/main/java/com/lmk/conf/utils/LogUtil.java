package com.lmk.conf.utils;

import com.lmk.common.enums.Constants;
import com.lmk.common.enums.ModuleEnum;
import com.lmk.common.enums.OperateEnum;
import com.lmk.common.utils.SpringContextUtils;
import com.lmk.conf.sys.rpc.SystemLogRpc;

public class LogUtil {
    private static final SystemLogRpc systemLogRpc = (SystemLogRpc) SpringContextUtils.getBeanByClass(SystemLogRpc.class);

    public static void addOperateLog(OperateEnum operate, ModuleEnum module, ModuleEnum subModule, String srcId, String... agrs){
        String agrStr = String.join(Constants.AT, agrs);
        systemLogRpc.addOperateLog(operate, module, subModule, srcId, agrStr);
    }

    public static void addOperateLog(String operate, String module, String subModule, String srcId, String... agrs){
        String agrStr = String.join(Constants.AT, agrs);
        systemLogRpc.addOperateLog(operate, module, subModule, srcId, agrStr);
    }
}
