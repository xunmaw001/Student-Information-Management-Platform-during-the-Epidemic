package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XueshengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学生
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuesheng")
public class XueshengView extends XueshengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 学院的值
	*/
	@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
	private String xueyuanValue;
	/**
	* 班级的值
	*/
	@ColumnInfo(comment="班级的字典表值",type="varchar(200)")
	private String banjiValue;
	/**
	* 账户状态的值
	*/
	@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
	private String jinyongValue;




	public XueshengView() {

	}

	public XueshengView(XueshengEntity xueshengEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 学院的值
	*/
	public String getXueyuanValue() {
		return xueyuanValue;
	}
	/**
	* 设置： 学院的值
	*/
	public void setXueyuanValue(String xueyuanValue) {
		this.xueyuanValue = xueyuanValue;
	}
	//当前表的
	/**
	* 获取： 班级的值
	*/
	public String getBanjiValue() {
		return banjiValue;
	}
	/**
	* 设置： 班级的值
	*/
	public void setBanjiValue(String banjiValue) {
		this.banjiValue = banjiValue;
	}
	//当前表的
	/**
	* 获取： 账户状态的值
	*/
	public String getJinyongValue() {
		return jinyongValue;
	}
	/**
	* 设置： 账户状态的值
	*/
	public void setJinyongValue(String jinyongValue) {
		this.jinyongValue = jinyongValue;
	}




	@Override
	public String toString() {
		return "XueshengView{" +
			", sexValue=" + sexValue +
			", xueyuanValue=" + xueyuanValue +
			", banjiValue=" + banjiValue +
			", jinyongValue=" + jinyongValue +
			"} " + super.toString();
	}
}
