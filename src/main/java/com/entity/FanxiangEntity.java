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
 * 返校申请
 *
 * @author 
 * @email
 */
@TableName("fanxiang")
public class FanxiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FanxiangEntity() {

	}

	public FanxiangEntity(T t) {
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
     * 返校申请编号
     */
    @ColumnInfo(comment="返校申请编号",type="varchar(200)")
    @TableField(value = "fanxiang_uuid_number")

    private String fanxiangUuidNumber;


    /**
     * 申请标题
     */
    @ColumnInfo(comment="申请标题",type="varchar(200)")
    @TableField(value = "fanxiang_name")

    private String fanxiangName;


    /**
     * 现在地点
     */
    @ColumnInfo(comment="现在地点",type="varchar(200)")
    @TableField(value = "fanxiang_address")

    private String fanxiangAddress;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "fanxiang_file")

    private String fanxiangFile;


    /**
     * 返校申请类型
     */
    @ColumnInfo(comment="返校申请类型",type="int(11)")
    @TableField(value = "fanxiang_types")

    private Integer fanxiangTypes;


    /**
     * 返校方式
     */
    @ColumnInfo(comment="返校方式",type="int(11)")
    @TableField(value = "fanxiang_fangshi_types")

    private Integer fanxiangFangshiTypes;


    /**
     * 返校路径
     */
    @ColumnInfo(comment="返校路径",type="varchar(200)")
    @TableField(value = "fanxiang_lujing")

    private String fanxiangLujing;


    /**
     * 预计到校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预计到校日期",type="timestamp")
    @TableField(value = "daoxiao_time")

    private Date daoxiaoTime;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="longtext")
    @TableField(value = "fanxiang_content")

    private String fanxiangContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "fanxiang_yesno_types")

    private Integer fanxiangYesnoTypes;


    /**
     * 回复话语
     */
    @ColumnInfo(comment="回复话语",type="longtext")
    @TableField(value = "fanxiang_yesno_text")

    private String fanxiangYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "fanxiang_shenhe_time")

    private Date fanxiangShenheTime;


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
	 * 获取：返校申请编号
	 */
    public String getFanxiangUuidNumber() {
        return fanxiangUuidNumber;
    }
    /**
	 * 设置：返校申请编号
	 */

    public void setFanxiangUuidNumber(String fanxiangUuidNumber) {
        this.fanxiangUuidNumber = fanxiangUuidNumber;
    }
    /**
	 * 获取：申请标题
	 */
    public String getFanxiangName() {
        return fanxiangName;
    }
    /**
	 * 设置：申请标题
	 */

    public void setFanxiangName(String fanxiangName) {
        this.fanxiangName = fanxiangName;
    }
    /**
	 * 获取：现在地点
	 */
    public String getFanxiangAddress() {
        return fanxiangAddress;
    }
    /**
	 * 设置：现在地点
	 */

    public void setFanxiangAddress(String fanxiangAddress) {
        this.fanxiangAddress = fanxiangAddress;
    }
    /**
	 * 获取：附件
	 */
    public String getFanxiangFile() {
        return fanxiangFile;
    }
    /**
	 * 设置：附件
	 */

    public void setFanxiangFile(String fanxiangFile) {
        this.fanxiangFile = fanxiangFile;
    }
    /**
	 * 获取：返校申请类型
	 */
    public Integer getFanxiangTypes() {
        return fanxiangTypes;
    }
    /**
	 * 设置：返校申请类型
	 */

    public void setFanxiangTypes(Integer fanxiangTypes) {
        this.fanxiangTypes = fanxiangTypes;
    }
    /**
	 * 获取：返校方式
	 */
    public Integer getFanxiangFangshiTypes() {
        return fanxiangFangshiTypes;
    }
    /**
	 * 设置：返校方式
	 */

    public void setFanxiangFangshiTypes(Integer fanxiangFangshiTypes) {
        this.fanxiangFangshiTypes = fanxiangFangshiTypes;
    }
    /**
	 * 获取：返校路径
	 */
    public String getFanxiangLujing() {
        return fanxiangLujing;
    }
    /**
	 * 设置：返校路径
	 */

    public void setFanxiangLujing(String fanxiangLujing) {
        this.fanxiangLujing = fanxiangLujing;
    }
    /**
	 * 获取：预计到校日期
	 */
    public Date getDaoxiaoTime() {
        return daoxiaoTime;
    }
    /**
	 * 设置：预计到校日期
	 */

    public void setDaoxiaoTime(Date daoxiaoTime) {
        this.daoxiaoTime = daoxiaoTime;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getFanxiangContent() {
        return fanxiangContent;
    }
    /**
	 * 设置：申请缘由
	 */

    public void setFanxiangContent(String fanxiangContent) {
        this.fanxiangContent = fanxiangContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getFanxiangYesnoTypes() {
        return fanxiangYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setFanxiangYesnoTypes(Integer fanxiangYesnoTypes) {
        this.fanxiangYesnoTypes = fanxiangYesnoTypes;
    }
    /**
	 * 获取：回复话语
	 */
    public String getFanxiangYesnoText() {
        return fanxiangYesnoText;
    }
    /**
	 * 设置：回复话语
	 */

    public void setFanxiangYesnoText(String fanxiangYesnoText) {
        this.fanxiangYesnoText = fanxiangYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFanxiangShenheTime() {
        return fanxiangShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setFanxiangShenheTime(Date fanxiangShenheTime) {
        this.fanxiangShenheTime = fanxiangShenheTime;
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
        return "Fanxiang{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", fanxiangUuidNumber=" + fanxiangUuidNumber +
            ", fanxiangName=" + fanxiangName +
            ", fanxiangAddress=" + fanxiangAddress +
            ", fanxiangFile=" + fanxiangFile +
            ", fanxiangTypes=" + fanxiangTypes +
            ", fanxiangFangshiTypes=" + fanxiangFangshiTypes +
            ", fanxiangLujing=" + fanxiangLujing +
            ", daoxiaoTime=" + DateUtil.convertString(daoxiaoTime,"yyyy-MM-dd") +
            ", fanxiangContent=" + fanxiangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", fanxiangYesnoTypes=" + fanxiangYesnoTypes +
            ", fanxiangYesnoText=" + fanxiangYesnoText +
            ", fanxiangShenheTime=" + DateUtil.convertString(fanxiangShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
