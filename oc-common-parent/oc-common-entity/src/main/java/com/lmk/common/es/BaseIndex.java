package com.lmk.common.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lmk.common.enums.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class BaseIndex implements Serializable {

    private static final long serialVersionUID = -8520707563284713806L;

    @ApiModelProperty(value = "id主键")
    @Id
    private Long id;

    @ApiModelProperty(value = "表")
    @Field(type = FieldType.Keyword)
    private String table;

    @ApiModelProperty(value = "创建人账号")
    @Field(type = FieldType.Keyword)
    private String creatorAcct;

    @ApiModelProperty(value = "创建人姓名")
    @Field(type = FieldType.Keyword)
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = Constants.DATE_FULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FULL)
    private Date createTime;

    @ApiModelProperty(value = "编辑人账号")
    @Field(type = FieldType.Keyword)
    private String updaterAcct;

    @ApiModelProperty(value = "编辑人姓名")
    @Field(type = FieldType.Keyword)
    private String updaterName;

    @ApiModelProperty(value = "编辑时间")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = Constants.DATE_FULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FULL)
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    @Field(type = FieldType.Text , analyzer = "ik_max_word")
    private String remark;
}
