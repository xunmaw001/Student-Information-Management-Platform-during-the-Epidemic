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
 * 学生健康
 *
 * @author 
 * @email
 */
@TableName("xuesheng_jiankang")
public class XueshengJiankangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengJiankangEntity() {

	}

	public XueshengJiankangEntity(T t) {
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
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 记录编号
     */
    @ColumnInfo(comment="记录编号",type="varchar(200)")
    @TableField(value = "xuesheng_jiankang_uuid_number")

    private String xueshengJiankangUuidNumber;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "xuesheng_jiankang_file")

    private String xueshengJiankangFile;


    /**
     * 健康状态
     */
    @ColumnInfo(comment="健康状态",type="int(11)")
    @TableField(value = "xuesheng_jiankang_types")

    private Integer xueshengJiankangTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "suoshu_time")

    private Date suoshuTime;


    /**
     * 记录详情
     */
    @ColumnInfo(comment="记录详情",type="longtext")
    @TableField(value = "xuesheng_jiankang_content")

    private String xueshengJiankangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 设置：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：记录编号
	 */
    public String getXueshengJiankangUuidNumber() {
        return xueshengJiankangUuidNumber;
    }
    /**
	 * 设置：记录编号
	 */

    public void setXueshengJiankangUuidNumber(String xueshengJiankangUuidNumber) {
        this.xueshengJiankangUuidNumber = xueshengJiankangUuidNumber;
    }
    /**
	 * 获取：附件
	 */
    public String getXueshengJiankangFile() {
        return xueshengJiankangFile;
    }
    /**
	 * 设置：附件
	 */

    public void setXueshengJiankangFile(String xueshengJiankangFile) {
        this.xueshengJiankangFile = xueshengJiankangFile;
    }
    /**
	 * 获取：健康状态
	 */
    public Integer getXueshengJiankangTypes() {
        return xueshengJiankangTypes;
    }
    /**
	 * 设置：健康状态
	 */

    public void setXueshengJiankangTypes(Integer xueshengJiankangTypes) {
        this.xueshengJiankangTypes = xueshengJiankangTypes;
    }
    /**
	 * 获取：所属日期
	 */
    public Date getSuoshuTime() {
        return suoshuTime;
    }
    /**
	 * 设置：所属日期
	 */

    public void setSuoshuTime(Date suoshuTime) {
        this.suoshuTime = suoshuTime;
    }
    /**
	 * 获取：记录详情
	 */
    public String getXueshengJiankangContent() {
        return xueshengJiankangContent;
    }
    /**
	 * 设置：记录详情
	 */

    public void setXueshengJiankangContent(String xueshengJiankangContent) {
        this.xueshengJiankangContent = xueshengJiankangContent;
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "XueshengJiankang{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", xueshengJiankangUuidNumber=" + xueshengJiankangUuidNumber +
            ", xueshengJiankangFile=" + xueshengJiankangFile +
            ", xueshengJiankangTypes=" + xueshengJiankangTypes +
            ", suoshuTime=" + DateUtil.convertString(suoshuTime,"yyyy-MM-dd") +
            ", xueshengJiankangContent=" + xueshengJiankangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
