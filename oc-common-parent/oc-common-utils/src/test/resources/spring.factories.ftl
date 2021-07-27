<#assign packagePath="${package.Controller?substring(0,package.Controller?last_index_of(package.ModuleName) - 1)}"/>
<#assign packageName="${(packagePath?substring(packagePath?last_index_of('.') + 1))?cap_first}"/>
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
${packagePath}.${packageName}RpcAutoConfiguration


