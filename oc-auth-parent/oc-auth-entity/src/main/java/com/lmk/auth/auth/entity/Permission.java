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
 * 权限表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_permission")
@ApiModel(value = "Permission对象", description = "权限表")
@Accessors(chain = true)
public class Permission extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "权限名称")
	@JsonProperty("permissionName")
	private String permissionName;

	@ApiModelProperty(value = "权限描述")
	@JsonProperty("permissionDesc")
	private String permissionDesc;

	@ApiModelProperty(value = "权限对应的uri")
	@JsonProperty("permissionUri")
	private String permissionUri;

	@ApiModelProperty(value = "权限包含的其他uri")
	@JsonProperty("grantedUri")
	private String grantedUri;

	@ApiModelProperty(value = "权限代码")
	@JsonProperty("permissionCode")
	private String permissionCode;

	@ApiModelProperty(value = "父权限id")
	@JsonProperty("parentPermissionId")
	private Integer parentPermissionId;

	@ApiModelProperty(value = "是否菜单：0-否，1-是")
	@JsonProperty("isMenu")
	private String isMenu;

	@ApiModelProperty(value = "菜单图标")
	@JsonProperty("menuIcon")
	private String menuIcon;
}