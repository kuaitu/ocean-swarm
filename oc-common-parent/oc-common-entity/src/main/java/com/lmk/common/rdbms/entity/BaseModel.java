package com.lmk.common.rdbms.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class BaseModel implements Serializable {
    private static final long serialVersionUID = -8664610684116075193L;

    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建人账号")
    @TableField(fill = FieldFill.INSERT)
    private String creatorAcct;

    @ApiModelProperty(value = "创建人姓名")
    @TableField(fill = FieldFill.INSERT)
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "编辑人账号")
    @TableField(fill = FieldFill.UPDATE)
    private String updaterAcct;

    @ApiModelProperty(value = "编辑人姓名")
    @TableField(fill = FieldFill.UPDATE)
    private String updaterName;

    @ApiModelProperty(value = "编辑时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    @TableField
    private String remark;

    @ApiModelProperty(value = "是否删除，0 未删除，1 已删除")
    @TableLogic
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
}
