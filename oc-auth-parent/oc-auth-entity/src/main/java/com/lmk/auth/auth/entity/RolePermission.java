package com.lmk.auth.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmk.common.rdbms.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_role_permission")
@ApiModel(value = "RolePermission对象", description = "角色权限关系表")
@Accessors(chain = true)
public class RolePermission extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色id")
	@JsonProperty("roleId")
	private Integer roleId;

	@ApiModelProperty(value = "权限代码")
	@JsonProperty("permissionCode")
	private String permissionCode;
}