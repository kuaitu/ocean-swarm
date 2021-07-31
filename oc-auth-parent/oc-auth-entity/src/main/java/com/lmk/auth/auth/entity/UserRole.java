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
 * 用户角色关系表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色关系表")
@Accessors(chain = true)
public class UserRole extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名")
	@JsonProperty("username")
	private String username;

	@ApiModelProperty(value = "角色id")
	@JsonProperty("roleId")
	private Integer roleId;
}