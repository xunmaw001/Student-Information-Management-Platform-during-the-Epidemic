package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JieshoudiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 接受地
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jieshoudi")
public class JieshoudiView extends JieshoudiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 接受地类型的值
	*/
	@ColumnInfo(comment="接受地类型的字典表值",type="varchar(200)")
	private String jieshoudiValue;




	public JieshoudiView() {

	}

	public JieshoudiView(JieshoudiEntity jieshoudiEntity) {
		try {
			BeanUtils.copyProperties(this, jieshoudiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 接受地类型的值
	*/
	public String getJieshoudiValue() {
		return jieshoudiValue;
	}
	/**
	* 设置： 接受地类型的值
	*/
	public void setJieshoudiValue(String jieshoudiValue) {
		this.jieshoudiValue = jieshoudiValue;
	}




	@Override
	public String toString() {
		return "JieshoudiView{" +
			", jieshoudiValue=" + jieshoudiValue +
			"} " + super.toString();
	}
}
