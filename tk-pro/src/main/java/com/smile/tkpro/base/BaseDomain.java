package com.smile.tkpro.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述：基础domain.
 *
 * @author liuguanghui
 * @since 2018-05-17
 */
@Getter
@Setter
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -2721739505707883933L;
    /**
     * 返回错误结果
     */
    public static final Integer ERROR = 0;
    public static final Integer SUCCESS = 1;

    /**
     * 排序字段 ：默认"createTime desc"
     */
    @Transient
    @JsonIgnore
    private String orderByClause;

    /**
     * 分页参数：起始页
     */
    @Transient
    @JsonIgnore
    private Integer page;

    /**
     * 分页参数：行数
     */
    @Transient
    @JsonIgnore
    private Integer rowsddd;

    /**
     * 序列号
     * 注意 在这里 基本数据类型 会直接忽略库表字段映射，不需要加@Transient
     * 但是你写成 Integer 类型 就必须 加 @Transient ，否则报错，找不到这个字段
     */
    private int serialNumber;


    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;
}