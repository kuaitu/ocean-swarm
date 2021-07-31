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
 * 用户表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("auth_user")
@ApiModel(value = "User对象", description = "用户表")
@Accessors(chain = true)
public class User extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户名")
	@JsonProperty("username")
	private String username;

	@ApiModelProperty(value = "用户登录密码")
	@JsonProperty("password")
	private String password;

	@ApiModelProperty(value = "用户工号")
	@JsonProperty("userEmplyNum")
	private String userEmplyNum;

	@ApiModelProperty(value = "用户中文姓名")
	@JsonProperty("userCnName")
	private String userCnName;

	@ApiModelProperty(value = "姓名拼音")
	@JsonProperty("userNameSpell")
	private String userNameSpell;

	@ApiModelProperty(value = "联系方式")
	@JsonProperty("phoneNum")
	private String phoneNum;

	@ApiModelProperty(value = "用户性别：unknow-未知，male-男，female-女")
	@JsonProperty("gender")
	private String gender;

	@ApiModelProperty(value = "用户年龄")
	@JsonProperty("age")
	private Integer age;

	@ApiModelProperty(value = "是否在职：0-否，1-是")
	@JsonProperty("isOnDuty")
	private String isOnDuty;

	@ApiModelProperty(value = "用户职位")
	@JsonProperty("userTitle")
	private String userTitle;

	@ApiModelProperty(value = "机构id")
	@JsonProperty("orgId")
	private Integer orgId;

	@ApiModelProperty(value = "机构编号")
	@JsonProperty("orgNum")
	private String orgNum;

	@ApiModelProperty(value = "机构名称")
	@JsonProperty("orgName")
	private String orgName;

	@ApiModelProperty(value = "机构类别：province-省，city-市，county-区县，street-街道，community-社区")
	@JsonProperty("orgType")
	private String orgType;

	@ApiModelProperty(value = "机构路径")
	@JsonProperty("orgPath")
	private String orgPath;

	@ApiModelProperty(value = "单位编码")
	@JsonProperty("companyCode")
	private String companyCode;

	@ApiModelProperty(value = "单位名称")
	@JsonProperty("companyName")
	private String companyName;

	@ApiModelProperty(value = "是否首次登录：0-否，1-是")
	@JsonProperty("isFirstLogin")
	private String isFirstLogin;

	@ApiModelProperty(value = "设备唯一码")
	@JsonProperty("deviceUniCode")
	private String deviceUniCode;

	@ApiModelProperty(value = "登录失败次数")
	@JsonProperty("loginFailedCount")
	private Integer loginFailedCount;
}