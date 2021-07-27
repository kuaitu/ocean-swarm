package com.lmk.common.rdbms.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private String creatorAcct;

    @TableField(fill = FieldFill.INSERT)
    private String creatorName;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updaterAcct;

    @TableField(fill = FieldFill.UPDATE)
    private String updaterName;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableField
    private String remark;

    @TableLogic
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
}
