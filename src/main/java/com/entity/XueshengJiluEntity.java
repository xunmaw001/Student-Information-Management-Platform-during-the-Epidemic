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
 * 每日记录
 *
 * @author 
 * @email
 */
@TableName("xuesheng_jilu")
public class XueshengJiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengJiluEntity() {

	}

	public XueshengJiluEntity(T t) {
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
     * 每日记录编号
     */
    @ColumnInfo(comment="每日记录编号",type="varchar(200)")
    @TableField(value = "xuesheng_jilu_uuid_number")

    private String xueshengJiluUuidNumber;


    /**
     * 记录标题
     */
    @ColumnInfo(comment="记录标题",type="varchar(200)")
    @TableField(value = "xuesheng_jilu_name")

    private String xueshengJiluName;


    /**
     * 记录附件
     */
    @ColumnInfo(comment="记录附件",type="varchar(200)")
    @TableField(value = "xuesheng_jilu_file")

    private String xueshengJiluFile;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "xuesheng_jilu_time")

    private Date xueshengJiluTime;


    /**
     * 记录内容
     */
    @ColumnInfo(comment="记录内容",type="longtext")
    @TableField(value = "xuesheng_jilu_content")

    private String xueshengJiluContent;


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
	 * 获取：每日记录编号
	 */
    public String getXueshengJiluUuidNumber() {
        return xueshengJiluUuidNumber;
    }
    /**
	 * 设置：每日记录编号
	 */

    public void setXueshengJiluUuidNumber(String xueshengJiluUuidNumber) {
        this.xueshengJiluUuidNumber = xueshengJiluUuidNumber;
    }
    /**
	 * 获取：记录标题
	 */
    public String getXueshengJiluName() {
        return xueshengJiluName;
    }
    /**
	 * 设置：记录标题
	 */

    public void setXueshengJiluName(String xueshengJiluName) {
        this.xueshengJiluName = xueshengJiluName;
    }
    /**
	 * 获取：记录附件
	 */
    public String getXueshengJiluFile() {
        return xueshengJiluFile;
    }
    /**
	 * 设置：记录附件
	 */

    public void setXueshengJiluFile(String xueshengJiluFile) {
        this.xueshengJiluFile = xueshengJiluFile;
    }
    /**
	 * 获取：所属日期
	 */
    public Date getXueshengJiluTime() {
        return xueshengJiluTime;
    }
    /**
	 * 设置：所属日期
	 */

    public void setXueshengJiluTime(Date xueshengJiluTime) {
        this.xueshengJiluTime = xueshengJiluTime;
    }
    /**
	 * 获取：记录内容
	 */
    public String getXueshengJiluContent() {
        return xueshengJiluContent;
    }
    /**
	 * 设置：记录内容
	 */

    public void setXueshengJiluContent(String xueshengJiluContent) {
        this.xueshengJiluContent = xueshengJiluContent;
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
        return "XueshengJilu{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", xueshengJiluUuidNumber=" + xueshengJiluUuidNumber +
            ", xueshengJiluName=" + xueshengJiluName +
            ", xueshengJiluFile=" + xueshengJiluFile +
            ", xueshengJiluTime=" + DateUtil.convertString(xueshengJiluTime,"yyyy-MM-dd") +
            ", xueshengJiluContent=" + xueshengJiluContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
