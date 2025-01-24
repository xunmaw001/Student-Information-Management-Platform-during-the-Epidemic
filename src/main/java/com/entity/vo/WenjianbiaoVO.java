package com.entity.vo;

import com.entity.WenjianbiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学校文件
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wenjianbiao")
public class WenjianbiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 文件名称
     */

    @TableField(value = "wenjianbiao_name")
    private String wenjianbiaoName;


    /**
     * 学校文件编号
     */

    @TableField(value = "wenjianbiao_uuid_number")
    private String wenjianbiaoUuidNumber;


    /**
     * 文件照片
     */

    @TableField(value = "wenjianbiao_photo")
    private String wenjianbiaoPhoto;


    /**
     * 文件
     */

    @TableField(value = "wenjianbiao_file")
    private String wenjianbiaoFile;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 学校文件类型
     */

    @TableField(value = "wenjianbiao_types")
    private Integer wenjianbiaoTypes;


    /**
     * 文件介绍
     */

    @TableField(value = "wenjianbiao_content")
    private String wenjianbiaoContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "wenjianbiao_delete")
    private Integer wenjianbiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：文件名称
	 */
    public String getWenjianbiaoName() {
        return wenjianbiaoName;
    }


    /**
	 * 获取：文件名称
	 */

    public void setWenjianbiaoName(String wenjianbiaoName) {
        this.wenjianbiaoName = wenjianbiaoName;
    }
    /**
	 * 设置：学校文件编号
	 */
    public String getWenjianbiaoUuidNumber() {
        return wenjianbiaoUuidNumber;
    }


    /**
	 * 获取：学校文件编号
	 */

    public void setWenjianbiaoUuidNumber(String wenjianbiaoUuidNumber) {
        this.wenjianbiaoUuidNumber = wenjianbiaoUuidNumber;
    }
    /**
	 * 设置：文件照片
	 */
    public String getWenjianbiaoPhoto() {
        return wenjianbiaoPhoto;
    }


    /**
	 * 获取：文件照片
	 */

    public void setWenjianbiaoPhoto(String wenjianbiaoPhoto) {
        this.wenjianbiaoPhoto = wenjianbiaoPhoto;
    }
    /**
	 * 设置：文件
	 */
    public String getWenjianbiaoFile() {
        return wenjianbiaoFile;
    }


    /**
	 * 获取：文件
	 */

    public void setWenjianbiaoFile(String wenjianbiaoFile) {
        this.wenjianbiaoFile = wenjianbiaoFile;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：学校文件类型
	 */
    public Integer getWenjianbiaoTypes() {
        return wenjianbiaoTypes;
    }


    /**
	 * 获取：学校文件类型
	 */

    public void setWenjianbiaoTypes(Integer wenjianbiaoTypes) {
        this.wenjianbiaoTypes = wenjianbiaoTypes;
    }
    /**
	 * 设置：文件介绍
	 */
    public String getWenjianbiaoContent() {
        return wenjianbiaoContent;
    }


    /**
	 * 获取：文件介绍
	 */

    public void setWenjianbiaoContent(String wenjianbiaoContent) {
        this.wenjianbiaoContent = wenjianbiaoContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWenjianbiaoDelete() {
        return wenjianbiaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWenjianbiaoDelete(Integer wenjianbiaoDelete) {
        this.wenjianbiaoDelete = wenjianbiaoDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
