package com.entity.vo;

import com.entity.FanxiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 返校申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fanxiang")
public class FanxiangVO implements Serializable {
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
     * 返校申请编号
     */

    @TableField(value = "fanxiang_uuid_number")
    private String fanxiangUuidNumber;


    /**
     * 申请标题
     */

    @TableField(value = "fanxiang_name")
    private String fanxiangName;


    /**
     * 现在地点
     */

    @TableField(value = "fanxiang_address")
    private String fanxiangAddress;


    /**
     * 附件
     */

    @TableField(value = "fanxiang_file")
    private String fanxiangFile;


    /**
     * 返校申请类型
     */

    @TableField(value = "fanxiang_types")
    private Integer fanxiangTypes;


    /**
     * 返校方式
     */

    @TableField(value = "fanxiang_fangshi_types")
    private Integer fanxiangFangshiTypes;


    /**
     * 返校路径
     */

    @TableField(value = "fanxiang_lujing")
    private String fanxiangLujing;


    /**
     * 预计到校日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "daoxiao_time")
    private Date daoxiaoTime;


    /**
     * 申请缘由
     */

    @TableField(value = "fanxiang_content")
    private String fanxiangContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "fanxiang_yesno_types")
    private Integer fanxiangYesnoTypes;


    /**
     * 回复话语
     */

    @TableField(value = "fanxiang_yesno_text")
    private String fanxiangYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fanxiang_shenhe_time")
    private Date fanxiangShenheTime;


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
	 * 设置：返校申请编号
	 */
    public String getFanxiangUuidNumber() {
        return fanxiangUuidNumber;
    }


    /**
	 * 获取：返校申请编号
	 */

    public void setFanxiangUuidNumber(String fanxiangUuidNumber) {
        this.fanxiangUuidNumber = fanxiangUuidNumber;
    }
    /**
	 * 设置：申请标题
	 */
    public String getFanxiangName() {
        return fanxiangName;
    }


    /**
	 * 获取：申请标题
	 */

    public void setFanxiangName(String fanxiangName) {
        this.fanxiangName = fanxiangName;
    }
    /**
	 * 设置：现在地点
	 */
    public String getFanxiangAddress() {
        return fanxiangAddress;
    }


    /**
	 * 获取：现在地点
	 */

    public void setFanxiangAddress(String fanxiangAddress) {
        this.fanxiangAddress = fanxiangAddress;
    }
    /**
	 * 设置：附件
	 */
    public String getFanxiangFile() {
        return fanxiangFile;
    }


    /**
	 * 获取：附件
	 */

    public void setFanxiangFile(String fanxiangFile) {
        this.fanxiangFile = fanxiangFile;
    }
    /**
	 * 设置：返校申请类型
	 */
    public Integer getFanxiangTypes() {
        return fanxiangTypes;
    }


    /**
	 * 获取：返校申请类型
	 */

    public void setFanxiangTypes(Integer fanxiangTypes) {
        this.fanxiangTypes = fanxiangTypes;
    }
    /**
	 * 设置：返校方式
	 */
    public Integer getFanxiangFangshiTypes() {
        return fanxiangFangshiTypes;
    }


    /**
	 * 获取：返校方式
	 */

    public void setFanxiangFangshiTypes(Integer fanxiangFangshiTypes) {
        this.fanxiangFangshiTypes = fanxiangFangshiTypes;
    }
    /**
	 * 设置：返校路径
	 */
    public String getFanxiangLujing() {
        return fanxiangLujing;
    }


    /**
	 * 获取：返校路径
	 */

    public void setFanxiangLujing(String fanxiangLujing) {
        this.fanxiangLujing = fanxiangLujing;
    }
    /**
	 * 设置：预计到校日期
	 */
    public Date getDaoxiaoTime() {
        return daoxiaoTime;
    }


    /**
	 * 获取：预计到校日期
	 */

    public void setDaoxiaoTime(Date daoxiaoTime) {
        this.daoxiaoTime = daoxiaoTime;
    }
    /**
	 * 设置：申请缘由
	 */
    public String getFanxiangContent() {
        return fanxiangContent;
    }


    /**
	 * 获取：申请缘由
	 */

    public void setFanxiangContent(String fanxiangContent) {
        this.fanxiangContent = fanxiangContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getFanxiangYesnoTypes() {
        return fanxiangYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setFanxiangYesnoTypes(Integer fanxiangYesnoTypes) {
        this.fanxiangYesnoTypes = fanxiangYesnoTypes;
    }
    /**
	 * 设置：回复话语
	 */
    public String getFanxiangYesnoText() {
        return fanxiangYesnoText;
    }


    /**
	 * 获取：回复话语
	 */

    public void setFanxiangYesnoText(String fanxiangYesnoText) {
        this.fanxiangYesnoText = fanxiangYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFanxiangShenheTime() {
        return fanxiangShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFanxiangShenheTime(Date fanxiangShenheTime) {
        this.fanxiangShenheTime = fanxiangShenheTime;
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
