package com.entity.model;

import com.entity.JieshoudiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 接受地
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JieshoudiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 接受地编号
     */
    private String jieshoudiUuidNumber;


    /**
     * 接受地名称
     */
    private String jieshoudiName;


    /**
     * 接受地位置
     */
    private String jieshoudiAddress;


    /**
     * 接受地类型
     */
    private Integer jieshoudiTypes;


    /**
     * 接受地介绍
     */
    private String jieshoudiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
