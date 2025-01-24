package com.entity.model;

import com.entity.XueshengJiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 每日记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengJiluModel implements Serializable {
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
     * 每日记录编号
     */
    private String xueshengJiluUuidNumber;


    /**
     * 记录标题
     */
    private String xueshengJiluName;


    /**
     * 记录附件
     */
    private String xueshengJiluFile;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xueshengJiluTime;


    /**
     * 记录内容
     */
    private String xueshengJiluContent;


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
