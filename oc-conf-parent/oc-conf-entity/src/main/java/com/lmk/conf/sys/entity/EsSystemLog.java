package com.lmk.conf.sys.entity;

import com.lmk.common.es.BaseIndex;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "slog", type = "product",shards = 1,replicas = 0)
@Data
public class EsSystemLog extends BaseIndex {
    private static final long serialVersionUID = -5799557782242219062L;

    @ApiModelProperty(value = "模块")
    @Field(type = FieldType.Keyword)
    private String module;

    @ApiModelProperty(value = "子模块")
    @Field(type = FieldType.Keyword)
    private String subModule;

    @ApiModelProperty(value = "操作")
    @Field(type = FieldType.Keyword)
    private String operate;

    @ApiModelProperty(value = "内容")
    @Field(type = FieldType.Keyword)
    private String content;

    @ApiModelProperty(value = "模块主键")
    @Field(type = FieldType.Keyword)
    private String srcId;

    @ApiModelProperty(value = "机构名称")
    @Field(type = FieldType.Keyword)
    private String orgName;

    @ApiModelProperty(value = "机构路径")
    @Field(type = FieldType.Keyword)
    private String orgPath;
}
