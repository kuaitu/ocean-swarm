package com.lmk.conf.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmk.common.rdbms.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_system_log")
@ApiModel(value = "SystemLog对象", description = "系统日志表")
@Accessors(chain = true)
public class SystemLog extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名")
	@JsonProperty("username")
	private String username;

	@ApiModelProperty(value = "用户中文姓名")
	@JsonProperty("userCnName")
	private String userCnName;

	@ApiModelProperty(value = "机构名称")
	@JsonProperty("orgName")
	private String orgName;

	@ApiModelProperty(value = "机构路径")
	@JsonProperty("orgPath")
	private String orgPath;

	@ApiModelProperty(value = "操作时间")
	@JsonProperty("optTime")
	private Date optTime;

	@ApiModelProperty(value = "日志内容")
	@JsonProperty("logContent")
	private String logContent;
}