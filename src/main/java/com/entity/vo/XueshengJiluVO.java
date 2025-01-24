package com.entity.vo;

import com.entity.XueshengJiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 每日记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuesheng_jilu")
public class XueshengJiluVO implements Serializable {
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
     * 每日记录编号
     */

    @TableField(value = "xuesheng_jilu_uuid_number")
    private String xueshengJiluUuidNumber;


    /**
     * 记录标题
     */

    @TableField(value = "xuesheng_jilu_name")
    private String xueshengJiluName;


    /**
     * 记录附件
     */

    @TableField(value = "xuesheng_jilu_file")
    private String xueshengJiluFile;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xuesheng_jilu_time")
    private Date xueshengJiluTime;


    /**
     * 记录内容
     */

    @TableField(value = "xuesheng_jilu_content")
    private String xueshengJiluContent;


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
	 * 设置：每日记录编号
	 */
    public String getXueshengJiluUuidNumber() {
        return xueshengJiluUuidNumber;
    }


    /**
	 * 获取：每日记录编号
	 */

    public void setXueshengJiluUuidNumber(String xueshengJiluUuidNumber) {
        this.xueshengJiluUuidNumber = xueshengJiluUuidNumber;
    }
    /**
	 * 设置：记录标题
	 */
    public String getXueshengJiluName() {
        return xueshengJiluName;
    }


    /**
	 * 获取：记录标题
	 */

    public void setXueshengJiluName(String xueshengJiluName) {
        this.xueshengJiluName = xueshengJiluName;
    }
    /**
	 * 设置：记录附件
	 */
    public String getXueshengJiluFile() {
        return xueshengJiluFile;
    }


    /**
	 * 获取：记录附件
	 */

    public void setXueshengJiluFile(String xueshengJiluFile) {
        this.xueshengJiluFile = xueshengJiluFile;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getXueshengJiluTime() {
        return xueshengJiluTime;
    }


    /**
	 * 获取：所属日期
	 */

    public void setXueshengJiluTime(Date xueshengJiluTime) {
        this.xueshengJiluTime = xueshengJiluTime;
    }
    /**
	 * 设置：记录内容
	 */
    public String getXueshengJiluContent() {
        return xueshengJiluContent;
    }


    /**
	 * 获取：记录内容
	 */

    public void setXueshengJiluContent(String xueshengJiluContent) {
        this.xueshengJiluContent = xueshengJiluContent;
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
