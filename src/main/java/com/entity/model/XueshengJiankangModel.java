package com.entity.model;

import com.entity.XueshengJiankangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生健康
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengJiankangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 记录编号
     */
    private String xueshengJiankangUuidNumber;


    /**
     * 附件
     */
    private String xueshengJiankangFile;


    /**
     * 健康状态
     */
    private Integer xueshengJiankangTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date suoshuTime;


    /**
     * 记录详情
     */
    private String xueshengJiankangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
