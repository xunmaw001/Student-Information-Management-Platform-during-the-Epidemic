package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 学校文件
 *
 * @author 
 * @email
 */
@TableName("wenjianbiao")
public class WenjianbiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WenjianbiaoEntity() {

	}

	public WenjianbiaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 文件名称
     */
    @ColumnInfo(comment="文件名称",type="varchar(200)")
    @TableField(value = "wenjianbiao_name")

    private String wenjianbiaoName;


    /**
     * 学校文件编号
     */
    @ColumnInfo(comment="学校文件编号",type="varchar(200)")
    @TableField(value = "wenjianbiao_uuid_number")

    private String wenjianbiaoUuidNumber;


    /**
     * 文件照片
     */
    @ColumnInfo(comment="文件照片",type="varchar(200)")
    @TableField(value = "wenjianbiao_photo")

    private String wenjianbiaoPhoto;


    /**
     * 文件
     */
    @ColumnInfo(comment="文件",type="varchar(200)")
    @TableField(value = "wenjianbiao_file")

    private String wenjianbiaoFile;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 学校文件类型
     */
    @ColumnInfo(comment="学校文件类型",type="int(11)")
    @TableField(value = "wenjianbiao_types")

    private Integer wenjianbiaoTypes;


    /**
     * 文件介绍
     */
    @ColumnInfo(comment="文件介绍",type="longtext")
    @TableField(value = "wenjianbiao_content")

    private String wenjianbiaoContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wenjianbiao_delete")

    private Integer wenjianbiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：文件名称
	 */
    public String getWenjianbiaoName() {
        return wenjianbiaoName;
    }
    /**
	 * 设置：文件名称
	 */

    public void setWenjianbiaoName(String wenjianbiaoName) {
        this.wenjianbiaoName = wenjianbiaoName;
    }
    /**
	 * 获取：学校文件编号
	 */
    public String getWenjianbiaoUuidNumber() {
        return wenjianbiaoUuidNumber;
    }
    /**
	 * 设置：学校文件编号
	 */

    public void setWenjianbiaoUuidNumber(String wenjianbiaoUuidNumber) {
        this.wenjianbiaoUuidNumber = wenjianbiaoUuidNumber;
    }
    /**
	 * 获取：文件照片
	 */
    public String getWenjianbiaoPhoto() {
        return wenjianbiaoPhoto;
    }
    /**
	 * 设置：文件照片
	 */

    public void setWenjianbiaoPhoto(String wenjianbiaoPhoto) {
        this.wenjianbiaoPhoto = wenjianbiaoPhoto;
    }
    /**
	 * 获取：文件
	 */
    public String getWenjianbiaoFile() {
        return wenjianbiaoFile;
    }
    /**
	 * 设置：文件
	 */

    public void setWenjianbiaoFile(String wenjianbiaoFile) {
        this.wenjianbiaoFile = wenjianbiaoFile;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：学校文件类型
	 */
    public Integer getWenjianbiaoTypes() {
        return wenjianbiaoTypes;
    }
    /**
	 * 设置：学校文件类型
	 */

    public void setWenjianbiaoTypes(Integer wenjianbiaoTypes) {
        this.wenjianbiaoTypes = wenjianbiaoTypes;
    }
    /**
	 * 获取：文件介绍
	 */
    public String getWenjianbiaoContent() {
        return wenjianbiaoContent;
    }
    /**
	 * 设置：文件介绍
	 */

    public void setWenjianbiaoContent(String wenjianbiaoContent) {
        this.wenjianbiaoContent = wenjianbiaoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWenjianbiaoDelete() {
        return wenjianbiaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWenjianbiaoDelete(Integer wenjianbiaoDelete) {
        this.wenjianbiaoDelete = wenjianbiaoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wenjianbiao{" +
            ", id=" + id +
            ", wenjianbiaoName=" + wenjianbiaoName +
            ", wenjianbiaoUuidNumber=" + wenjianbiaoUuidNumber +
            ", wenjianbiaoPhoto=" + wenjianbiaoPhoto +
            ", wenjianbiaoFile=" + wenjianbiaoFile +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", wenjianbiaoTypes=" + wenjianbiaoTypes +
            ", wenjianbiaoContent=" + wenjianbiaoContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", wenjianbiaoDelete=" + wenjianbiaoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
