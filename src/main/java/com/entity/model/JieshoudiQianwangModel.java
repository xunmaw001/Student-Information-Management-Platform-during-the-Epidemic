package com.entity.model;

import com.entity.JieshoudiQianwangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 接受地前往
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JieshoudiQianwangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 接受地
     */
    private Integer jieshoudiId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 接受地前往编号
     */
    private String jieshoudiQianwangUuidNumber;


    /**
     * 附件
     */
    private String jieshoudiQianwangFile;


    /**
     * 前往类型
     */
    private Integer jieshoudiQianwangTypes;


    /**
     * 前往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qianwangTime;


    /**
     * 抵达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date didaTime;


    /**
     * 前往缘由
     */
    private String jieshoudiQianwangContent;


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
