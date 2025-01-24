package com.entity.vo;

import com.entity.XueshengJiankangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生健康
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuesheng_jiankang")
public class XueshengJiankangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 记录编号
     */

    @TableField(value = "xuesheng_jiankang_uuid_number")
    private String xueshengJiankangUuidNumber;


    /**
     * 附件
     */

    @TableField(value = "xuesheng_jiankang_file")
    private String xueshengJiankangFile;


    /**
     * 健康状态
     */

    @TableField(value = "xuesheng_jiankang_types")
    private Integer xueshengJiankangTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "suoshu_time")
    private Date suoshuTime;


    /**
     * 记录详情
     */

    @TableField(value = "xuesheng_jiankang_content")
    private String xueshengJiankangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：记录编号
	 */
    public String getXueshengJiankangUuidNumber() {
        return xueshengJiankangUuidNumber;
    }


    /**
	 * 获取：记录编号
	 */

    public void setXueshengJiankangUuidNumber(String xueshengJiankangUuidNumber) {
        this.xueshengJiankangUuidNumber = xueshengJiankangUuidNumber;
    }
    /**
	 * 设置：附件
	 */
    public String getXueshengJiankangFile() {
        return xueshengJiankangFile;
    }


    /**
	 * 获取：附件
	 */

    public void setXueshengJiankangFile(String xueshengJiankangFile) {
        this.xueshengJiankangFile = xueshengJiankangFile;
    }
    /**
	 * 设置：健康状态
	 */
    public Integer getXueshengJiankangTypes() {
        return xueshengJiankangTypes;
    }


    /**
	 * 获取：健康状态
	 */

    public void setXueshengJiankangTypes(Integer xueshengJiankangTypes) {
        this.xueshengJiankangTypes = xueshengJiankangTypes;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getSuoshuTime() {
        return suoshuTime;
    }


    /**
	 * 获取：所属日期
	 */

    public void setSuoshuTime(Date suoshuTime) {
        this.suoshuTime = suoshuTime;
    }
    /**
	 * 设置：记录详情
	 */
    public String getXueshengJiankangContent() {
        return xueshengJiankangContent;
    }


    /**
	 * 获取：记录详情
	 */

    public void setXueshengJiankangContent(String xueshengJiankangContent) {
        this.xueshengJiankangContent = xueshengJiankangContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
