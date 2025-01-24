package com.entity.model;

import com.entity.WenjianbiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学校文件
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenjianbiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 文件名称
     */
    private String wenjianbiaoName;


    /**
     * 学校文件编号
     */
    private String wenjianbiaoUuidNumber;


    /**
     * 文件照片
     */
    private String wenjianbiaoPhoto;


    /**
     * 文件
     */
    private String wenjianbiaoFile;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 学校文件类型
     */
    private Integer wenjianbiaoTypes;


    /**
     * 文件介绍
     */
    private String wenjianbiaoContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer wenjianbiaoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：文件名称
	 */
    public String getWenjianbiaoName() {
        return wenjianbiaoName;
    }


    /**
	 * 设置：文件名称
	 */
    public void setWenjianbiaoName(String wenjianbiaoName) {
        this.wenjianbiaoName = wenjianbiaoName;
    }
    /**
	 * 获取：学校文件编号
	 */
    public String getWenjianbiaoUuidNumber() {
        return wenjianbiaoUuidNumber;
    }


    /**
	 * 设置：学校文件编号
	 */
    public void setWenjianbiaoUuidNumber(String wenjianbiaoUuidNumber) {
        this.wenjianbiaoUuidNumber = wenjianbiaoUuidNumber;
    }
    /**
	 * 获取：文件照片
	 */
    public String getWenjianbiaoPhoto() {
        return wenjianbiaoPhoto;
    }


    /**
	 * 设置：文件照片
	 */
    public void setWenjianbiaoPhoto(String wenjianbiaoPhoto) {
        this.wenjianbiaoPhoto = wenjianbiaoPhoto;
    }
    /**
	 * 获取：文件
	 */
    public String getWenjianbiaoFile() {
        return wenjianbiaoFile;
    }


    /**
	 * 设置：文件
	 */
    public void setWenjianbiaoFile(String wenjianbiaoFile) {
        this.wenjianbiaoFile = wenjianbiaoFile;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：学校文件类型
	 */
    public Integer getWenjianbiaoTypes() {
        return wenjianbiaoTypes;
    }


    /**
	 * 设置：学校文件类型
	 */
    public void setWenjianbiaoTypes(Integer wenjianbiaoTypes) {
        this.wenjianbiaoTypes = wenjianbiaoTypes;
    }
    /**
	 * 获取：文件介绍
	 */
    public String getWenjianbiaoContent() {
        return wenjianbiaoContent;
    }


    /**
	 * 设置：文件介绍
	 */
    public void setWenjianbiaoContent(String wenjianbiaoContent) {
        this.wenjianbiaoContent = wenjianbiaoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWenjianbiaoDelete() {
        return wenjianbiaoDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setWenjianbiaoDelete(Integer wenjianbiaoDelete) {
        this.wenjianbiaoDelete = wenjianbiaoDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
