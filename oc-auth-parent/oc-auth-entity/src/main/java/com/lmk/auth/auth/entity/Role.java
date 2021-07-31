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
 * 角色表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_role")
@ApiModel(value = "Role对象", description = "角色表")
@Accessors(chain = true)
public class Role extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色名称")
	@JsonProperty("roleName")
	private String roleName;

	@ApiModelProperty(value = "角色描述")
	@JsonProperty("roleDesc")
	private String roleDesc;

	@ApiModelProperty(value = "是否启用：0-未启用，1-已启用")
	@JsonProperty("isEnable")
	private String isEnable;

	@ApiModelProperty(value = "是否只读：0-否，1-是")
	@JsonProperty("isReadonly")
	private String isReadonly;
}