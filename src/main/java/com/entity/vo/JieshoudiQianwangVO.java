package com.entity.vo;

import com.entity.JieshoudiQianwangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 接受地前往
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jieshoudi_qianwang")
public class JieshoudiQianwangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 接受地
     */

    @TableField(value = "jieshoudi_id")
    private Integer jieshoudiId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 接受地前往编号
     */

    @TableField(value = "jieshoudi_qianwang_uuid_number")
    private String jieshoudiQianwangUuidNumber;


    /**
     * 附件
     */

    @TableField(value = "jieshoudi_qianwang_file")
    private String jieshoudiQianwangFile;


    /**
     * 前往类型
     */

    @TableField(value = "jieshoudi_qianwang_types")
    private Integer jieshoudiQianwangTypes;


    /**
     * 前往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qianwang_time")
    private Date qianwangTime;


    /**
     * 抵达时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "dida_time")
    private Date didaTime;


    /**
     * 前往缘由
     */

    @TableField(value = "jieshoudi_qianwang_content")
    private String jieshoudiQianwangContent;


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
	 * 设置：接受地
	 */
    public Integer getJieshoudiId() {
        return jieshoudiId;
    }


    /**
	 * 获取：接受地
	 */

    public void setJieshoudiId(Integer jieshoudiId) {
        this.jieshoudiId = jieshoudiId;
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
	 * 设置：接受地前往编号
	 */
    public String getJieshoudiQianwangUuidNumber() {
        return jieshoudiQianwangUuidNumber;
    }


    /**
	 * 获取：接受地前往编号
	 */

    public void setJieshoudiQianwangUuidNumber(String jieshoudiQianwangUuidNumber) {
        this.jieshoudiQianwangUuidNumber = jieshoudiQianwangUuidNumber;
    }
    /**
	 * 设置：附件
	 */
    public String getJieshoudiQianwangFile() {
        return jieshoudiQianwangFile;
    }


    /**
	 * 获取：附件
	 */

    public void setJieshoudiQianwangFile(String jieshoudiQianwangFile) {
        this.jieshoudiQianwangFile = jieshoudiQianwangFile;
    }
    /**
	 * 设置：前往类型
	 */
    public Integer getJieshoudiQianwangTypes() {
        return jieshoudiQianwangTypes;
    }


    /**
	 * 获取：前往类型
	 */

    public void setJieshoudiQianwangTypes(Integer jieshoudiQianwangTypes) {
        this.jieshoudiQianwangTypes = jieshoudiQianwangTypes;
    }
    /**
	 * 设置：前往时间
	 */
    public Date getQianwangTime() {
        return qianwangTime;
    }


    /**
	 * 获取：前往时间
	 */

    public void setQianwangTime(Date qianwangTime) {
        this.qianwangTime = qianwangTime;
    }
    /**
	 * 设置：抵达时间
	 */
    public Date getDidaTime() {
        return didaTime;
    }


    /**
	 * 获取：抵达时间
	 */

    public void setDidaTime(Date didaTime) {
        this.didaTime = didaTime;
    }
    /**
	 * 设置：前往缘由
	 */
    public String getJieshoudiQianwangContent() {
        return jieshoudiQianwangContent;
    }


    /**
	 * 获取：前往缘由
	 */

    public void setJieshoudiQianwangContent(String jieshoudiQianwangContent) {
        this.jieshoudiQianwangContent = jieshoudiQianwangContent;
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
