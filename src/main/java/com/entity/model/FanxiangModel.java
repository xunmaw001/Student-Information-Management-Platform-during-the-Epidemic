package com.entity.model;

import com.entity.FanxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 返校申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FanxiangModel implements Serializable {
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
     * 返校申请编号
     */
    private String fanxiangUuidNumber;


    /**
     * 申请标题
     */
    private String fanxiangName;


    /**
     * 现在地点
     */
    private String fanxiangAddress;


    /**
     * 附件
     */
    private String fanxiangFile;


    /**
     * 返校申请类型
     */
    private Integer fanxiangTypes;


    /**
     * 返校方式
     */
    private Integer fanxiangFangshiTypes;


    /**
     * 返校路径
     */
    private String fanxiangLujing;


    /**
     * 预计到校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date daoxiaoTime;


    /**
     * 申请缘由
     */
    private String fanxiangContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer fanxiangYesnoTypes;


    /**
     * 回复话语
     */
    private String fanxiangYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fanxiangShenheTime;


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
	 * 获取：返校申请编号
	 */
    public String getFanxiangUuidNumber() {
        return fanxiangUuidNumber;
    }


    /**
	 * 设置：返校申请编号
	 */
    public void setFanxiangUuidNumber(String fanxiangUuidNumber) {
        this.fanxiangUuidNumber = fanxiangUuidNumber;
    }
    /**
	 * 获取：申请标题
	 */
    public String getFanxiangName() {
        return fanxiangName;
    }


    /**
	 * 设置：申请标题
	 */
    public void setFanxiangName(String fanxiangName) {
        this.fanxiangName = fanxiangName;
    }
    /**
	 * 获取：现在地点
	 */
    public String getFanxiangAddress() {
        return fanxiangAddress;
    }


    /**
	 * 设置：现在地点
	 */
    public void setFanxiangAddress(String fanxiangAddress) {
        this.fanxiangAddress = fanxiangAddress;
    }
    /**
	 * 获取：附件
	 */
    public String getFanxiangFile() {
        return fanxiangFile;
    }


    /**
	 * 设置：附件
	 */
    public void setFanxiangFile(String fanxiangFile) {
        this.fanxiangFile = fanxiangFile;
    }
    /**
	 * 获取：返校申请类型
	 */
    public Integer getFanxiangTypes() {
        return fanxiangTypes;
    }


    /**
	 * 设置：返校申请类型
	 */
    public void setFanxiangTypes(Integer fanxiangTypes) {
        this.fanxiangTypes = fanxiangTypes;
    }
    /**
	 * 获取：返校方式
	 */
    public Integer getFanxiangFangshiTypes() {
        return fanxiangFangshiTypes;
    }


    /**
	 * 设置：返校方式
	 */
    public void setFanxiangFangshiTypes(Integer fanxiangFangshiTypes) {
        this.fanxiangFangshiTypes = fanxiangFangshiTypes;
    }
    /**
	 * 获取：返校路径
	 */
    public String getFanxiangLujing() {
        return fanxiangLujing;
    }


    /**
	 * 设置：返校路径
	 */
    public void setFanxiangLujing(String fanxiangLujing) {
        this.fanxiangLujing = fanxiangLujing;
    }
    /**
	 * 获取：预计到校日期
	 */
    public Date getDaoxiaoTime() {
        return daoxiaoTime;
    }


    /**
	 * 设置：预计到校日期
	 */
    public void setDaoxiaoTime(Date daoxiaoTime) {
        this.daoxiaoTime = daoxiaoTime;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getFanxiangContent() {
        return fanxiangContent;
    }


    /**
	 * 设置：申请缘由
	 */
    public void setFanxiangContent(String fanxiangContent) {
        this.fanxiangContent = fanxiangContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getFanxiangYesnoTypes() {
        return fanxiangYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setFanxiangYesnoTypes(Integer fanxiangYesnoTypes) {
        this.fanxiangYesnoTypes = fanxiangYesnoTypes;
    }
    /**
	 * 获取：回复话语
	 */
    public String getFanxiangYesnoText() {
        return fanxiangYesnoText;
    }


    /**
	 * 设置：回复话语
	 */
    public void setFanxiangYesnoText(String fanxiangYesnoText) {
        this.fanxiangYesnoText = fanxiangYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFanxiangShenheTime() {
        return fanxiangShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setFanxiangShenheTime(Date fanxiangShenheTime) {
        this.fanxiangShenheTime = fanxiangShenheTime;
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
