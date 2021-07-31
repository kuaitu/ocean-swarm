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
 * 机构表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_org")
@ApiModel(value = "Org对象", description = "机构表")
@Accessors(chain = true)
public class Org extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构编号")
	@JsonProperty("orgNum")
	private String orgNum;

	@ApiModelProperty(value = "机构名称")
	@JsonProperty("orgName")
	private String orgName;

	@ApiModelProperty(value = "机构类别：bzi-业务部门，base-技术支撑部门，adm-行政部门，sales-销售部门")
	@JsonProperty("orgType")
	private String orgType;

	@ApiModelProperty(value = "机构路径")
	@JsonProperty("orgPath")
	private String orgPath;

	@ApiModelProperty(value = "机构名称路径")
	@JsonProperty("orgNamePath")
	private String orgNamePath;

	@ApiModelProperty(value = "机构描述")
	@JsonProperty("orgDesc")
	private String orgDesc;

	@ApiModelProperty(value = "父机构id")
	@JsonProperty("parentOrgId")
	private Integer parentOrgId;
}