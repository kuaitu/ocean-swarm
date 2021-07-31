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
 * 字典表
 * </p>
 *
 * @author lenovo
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dictionary")
@ApiModel(value = "Dictionary对象", description = "字典表")
@Accessors(chain = true)
public class Dictionary extends BaseModel {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典类别代码")
	@JsonProperty("dictCode")
	private String dictCode;

	@ApiModelProperty(value = "字典类别名称")
	@JsonProperty("dictName")
	private String dictName;

	@ApiModelProperty(value = "字典项代码")
	@JsonProperty("dictItemCode")
	private String dictItemCode;

	@ApiModelProperty(value = "字典项值")
	@JsonProperty("dictItemValue")
	private String dictItemValue;

	@ApiModelProperty(value = "是否启用：0-禁用，1-启用")
	@JsonProperty("isEnable")
	private String isEnable;

	@ApiModelProperty(value = "排序号码")
	@JsonProperty("sortNum")
	private Integer sortNum;
}