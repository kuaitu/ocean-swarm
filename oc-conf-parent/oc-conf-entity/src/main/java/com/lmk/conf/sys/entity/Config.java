package com.lmk.conf.sys.entity;

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
 * 系统配置表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_config")
@ApiModel(value = "Config对象", description = "系统配置表")
@Accessors(chain = true)
public class Config extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "配置项代码")
	@JsonProperty("configCode")
	private String configCode;

	@ApiModelProperty(value = "配置项名称")
	@JsonProperty("configName")
	private String configName;

	@ApiModelProperty(value = "配置项描述")
	@JsonProperty("configDesc")
	private String configDesc;

	@ApiModelProperty(value = "配置项的值")
	@JsonProperty("configValue")
	private String configValue;

	@ApiModelProperty(value = "配置类型：text-文本类型，boolean-布尔类型")
	@JsonProperty("configType")
	private String configType;
}