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
 * 接受地前往
 *
 * @author 
 * @email
 */
@TableName("jieshoudi_qianwang")
public class JieshoudiQianwangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JieshoudiQianwangEntity() {

	}

	public JieshoudiQianwangEntity(T t) {
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
     * 接受地
     */
    @ColumnInfo(comment="接受地",type="int(11)")
    @TableField(value = "jieshoudi_id")

    private Integer jieshoudiId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 接受地前往编号
     */
    @ColumnInfo(comment="接受地前往编号",type="varchar(200)")
    @TableField(value = "jieshoudi_qianwang_uuid_number")

    private String jieshoudiQianwangUuidNumber;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "jieshoudi_qianwang_file")

    private String jieshoudiQianwangFile;


    /**
     * 前往类型
     */
    @ColumnInfo(comment="前往类型",type="int(11)")
    @TableField(value = "jieshoudi_qianwang_types")

    private Integer jieshoudiQianwangTypes;


    /**
     * 前往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="前往时间",type="timestamp")
    @TableField(value = "qianwang_time")

    private Date qianwangTime;


    /**
     * 抵达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="抵达时间",type="timestamp")
    @TableField(value = "dida_time")

    private Date didaTime;


    /**
     * 前往缘由
     */
    @ColumnInfo(comment="前往缘由",type="longtext")
    @TableField(value = "jieshoudi_qianwang_content")

    private String jieshoudiQianwangContent;


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
	 * 获取：接受地
	 */
    public Integer getJieshoudiId() {
        return jieshoudiId;
    }
    /**
	 * 设置：接受地
	 */

    public void setJieshoudiId(Integer jieshoudiId) {
        this.jieshoudiId = jieshoudiId;
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
	 * 获取：接受地前往编号
	 */
    public String getJieshoudiQianwangUuidNumber() {
        return jieshoudiQianwangUuidNumber;
    }
    /**
	 * 设置：接受地前往编号
	 */

    public void setJieshoudiQianwangUuidNumber(String jieshoudiQianwangUuidNumber) {
        this.jieshoudiQianwangUuidNumber = jieshoudiQianwangUuidNumber;
    }
    /**
	 * 获取：附件
	 */
    public String getJieshoudiQianwangFile() {
        return jieshoudiQianwangFile;
    }
    /**
	 * 设置：附件
	 */

    public void setJieshoudiQianwangFile(String jieshoudiQianwangFile) {
        this.jieshoudiQianwangFile = jieshoudiQianwangFile;
    }
    /**
	 * 获取：前往类型
	 */
    public Integer getJieshoudiQianwangTypes() {
        return jieshoudiQianwangTypes;
    }
    /**
	 * 设置：前往类型
	 */

    public void setJieshoudiQianwangTypes(Integer jieshoudiQianwangTypes) {
        this.jieshoudiQianwangTypes = jieshoudiQianwangTypes;
    }
    /**
	 * 获取：前往时间
	 */
    public Date getQianwangTime() {
        return qianwangTime;
    }
    /**
	 * 设置：前往时间
	 */

    public void setQianwangTime(Date qianwangTime) {
        this.qianwangTime = qianwangTime;
    }
    /**
	 * 获取：抵达时间
	 */
    public Date getDidaTime() {
        return didaTime;
    }
    /**
	 * 设置：抵达时间
	 */

    public void setDidaTime(Date didaTime) {
        this.didaTime = didaTime;
    }
    /**
	 * 获取：前往缘由
	 */
    public String getJieshoudiQianwangContent() {
        return jieshoudiQianwangContent;
    }
    /**
	 * 设置：前往缘由
	 */

    public void setJieshoudiQianwangContent(String jieshoudiQianwangContent) {
        this.jieshoudiQianwangContent = jieshoudiQianwangContent;
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
        return "JieshoudiQianwang{" +
            ", id=" + id +
            ", jieshoudiId=" + jieshoudiId +
            ", xueshengId=" + xueshengId +
            ", jieshoudiQianwangUuidNumber=" + jieshoudiQianwangUuidNumber +
            ", jieshoudiQianwangFile=" + jieshoudiQianwangFile +
            ", jieshoudiQianwangTypes=" + jieshoudiQianwangTypes +
            ", qianwangTime=" + DateUtil.convertString(qianwangTime,"yyyy-MM-dd") +
            ", didaTime=" + DateUtil.convertString(didaTime,"yyyy-MM-dd") +
            ", jieshoudiQianwangContent=" + jieshoudiQianwangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
