package com.jerrypro.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jerrypro.common.util.StringConstantUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jerrypro
 * @date 2021/7/22
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 启用状态.
     */
    public static final int ENABLE_STATE = 1;
    /**
     * 禁用状态.
     */
    public static final int DISABLE_STATE = 0;
    private static final long serialVersionUID = -1147932588953780317L;
    /**
     *
     */
    @Id
    private String id;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = StringConstantUtil.DATE_TIME_FORMAT_STRING)
    @JsonFormat(pattern = StringConstantUtil.DATE_TIME_FORMAT_STRING)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = StringConstantUtil.DATE_TIME_FORMAT_STRING)
    @JsonFormat(pattern = StringConstantUtil.DATE_TIME_FORMAT_STRING)
    private LocalDateTime updateTime;
}
