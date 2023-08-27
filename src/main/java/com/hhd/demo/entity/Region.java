package com.hhd.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author -无心
 * @since 2023-3-21
 */
@Data
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    @TableField(value = "regionName")
    private String regionName;

    @TableField(exist = false)
    private List<Citys> citys;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "modifiedTime", fill = FieldFill.INSERT_UPDATE)
    private String modifiedTime;


}
