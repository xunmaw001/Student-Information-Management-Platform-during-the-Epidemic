package com.entity.vo;

import com.entity.JieshoudiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 接受地
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jieshoudi")
public class JieshoudiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 接受地编号
     */

    @TableField(value = "jieshoudi_uuid_number")
    private String jieshoudiUuidNumber;


    /**
     * 接受地名称
     */

    @TableField(value = "jieshoudi_name")
    private String jieshoudiName;


    /**
     * 接受地位置
     */

    @TableField(value = "jieshoudi_address")
    private String jieshoudiAddress;


    /**
     * 接受地类型
     */

    @TableField(value = "jieshoudi_types")
    private Integer jieshoudiTypes;


    /**
     * 接受地介绍
     */

    @TableField(value = "jieshoudi_content")
    private String jieshoudiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：接受地编号
	 */
    public String getJieshoudiUuidNumber() {
        return jieshoudiUuidNumber;
    }


    /**
	 * 获取：接受地编号
	 */

    public void setJieshoudiUuidNumber(String jieshoudiUuidNumber) {
        this.jieshoudiUuidNumber = jieshoudiUuidNumber;
    }
    /**
	 * 设置：接受地名称
	 */
    public String getJieshoudiName() {
        return jieshoudiName;
    }


    /**
	 * 获取：接受地名称
	 */

    public void setJieshoudiName(String jieshoudiName) {
        this.jieshoudiName = jieshoudiName;
    }
    /**
	 * 设置：接受地位置
	 */
    public String getJieshoudiAddress() {
        return jieshoudiAddress;
    }


    /**
	 * 获取：接受地位置
	 */

    public void setJieshoudiAddress(String jieshoudiAddress) {
        this.jieshoudiAddress = jieshoudiAddress;
    }
    /**
	 * 设置：接受地类型
	 */
    public Integer getJieshoudiTypes() {
        return jieshoudiTypes;
    }


    /**
	 * 获取：接受地类型
	 */

    public void setJieshoudiTypes(Integer jieshoudiTypes) {
        this.jieshoudiTypes = jieshoudiTypes;
    }
    /**
	 * 设置：接受地介绍
	 */
    public String getJieshoudiContent() {
        return jieshoudiContent;
    }


    /**
	 * 获取：接受地介绍
	 */

    public void setJieshoudiContent(String jieshoudiContent) {
        this.jieshoudiContent = jieshoudiContent;
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
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
