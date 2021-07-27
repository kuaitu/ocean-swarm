package com.lmk.auth.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lmk.common.rdbms.entity.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教室
 * </p>
 *
 * @author lenovo
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("biz_classroom")
@ApiModel(value = "Classroom对象", description = "教室")
@Accessors(chain = true)
public class Classroom extends BaseModel {
	private static final long serialVersionUID = 1L;

	@JsonProperty("classroomName")
	private String classroomName;

	@JsonProperty("schoolName")
	private String schoolName;
}