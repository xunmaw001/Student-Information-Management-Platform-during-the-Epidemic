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
 * 接受地
 *
 * @author 
 * @email
 */
@TableName("jieshoudi")
public class JieshoudiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JieshoudiEntity() {

	}

	public JieshoudiEntity(T t) {
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
     * 接受地编号
     */
    @ColumnInfo(comment="接受地编号",type="varchar(200)")
    @TableField(value = "jieshoudi_uuid_number")

    private String jieshoudiUuidNumber;


    /**
     * 接受地名称
     */
    @ColumnInfo(comment="接受地名称",type="varchar(200)")
    @TableField(value = "jieshoudi_name")

    private String jieshoudiName;


    /**
     * 接受地位置
     */
    @ColumnInfo(comment="接受地位置",type="varchar(200)")
    @TableField(value = "jieshoudi_address")

    private String jieshoudiAddress;


    /**
     * 接受地类型
     */
    @ColumnInfo(comment="接受地类型",type="int(11)")
    @TableField(value = "jieshoudi_types")

    private Integer jieshoudiTypes;


    /**
     * 接受地介绍
     */
    @ColumnInfo(comment="接受地介绍",type="longtext")
    @TableField(value = "jieshoudi_content")

    private String jieshoudiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：接受地编号
	 */
    public String getJieshoudiUuidNumber() {
        return jieshoudiUuidNumber;
    }
    /**
	 * 设置：接受地编号
	 */

    public void setJieshoudiUuidNumber(String jieshoudiUuidNumber) {
        this.jieshoudiUuidNumber = jieshoudiUuidNumber;
    }
    /**
	 * 获取：接受地名称
	 */
    public String getJieshoudiName() {
        return jieshoudiName;
    }
    /**
	 * 设置：接受地名称
	 */

    public void setJieshoudiName(String jieshoudiName) {
        this.jieshoudiName = jieshoudiName;
    }
    /**
	 * 获取：接受地位置
	 */
    public String getJieshoudiAddress() {
        return jieshoudiAddress;
    }
    /**
	 * 设置：接受地位置
	 */

    public void setJieshoudiAddress(String jieshoudiAddress) {
        this.jieshoudiAddress = jieshoudiAddress;
    }
    /**
	 * 获取：接受地类型
	 */
    public Integer getJieshoudiTypes() {
        return jieshoudiTypes;
    }
    /**
	 * 设置：接受地类型
	 */

    public void setJieshoudiTypes(Integer jieshoudiTypes) {
        this.jieshoudiTypes = jieshoudiTypes;
    }
    /**
	 * 获取：接受地介绍
	 */
    public String getJieshoudiContent() {
        return jieshoudiContent;
    }
    /**
	 * 设置：接受地介绍
	 */

    public void setJieshoudiContent(String jieshoudiContent) {
        this.jieshoudiContent = jieshoudiContent;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jieshoudi{" +
            ", id=" + id +
            ", jieshoudiUuidNumber=" + jieshoudiUuidNumber +
            ", jieshoudiName=" + jieshoudiName +
            ", jieshoudiAddress=" + jieshoudiAddress +
            ", jieshoudiTypes=" + jieshoudiTypes +
            ", jieshoudiContent=" + jieshoudiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
