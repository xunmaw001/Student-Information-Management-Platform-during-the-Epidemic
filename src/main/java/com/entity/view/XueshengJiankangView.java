package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XueshengJiankangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学生健康
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuesheng_jiankang")
public class XueshengJiankangView extends XueshengJiankangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 健康状态的值
	*/
	@ColumnInfo(comment="健康状态的字典表值",type="varchar(200)")
	private String xueshengJiankangValue;

	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String xueshengName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String xueshengPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String xueshengIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String xueshengPhoto;
		/**
		* 学院
		*/
		@ColumnInfo(comment="学院",type="int(11)")
		private Integer xueyuanTypes;
			/**
			* 学院的值
			*/
			@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
			private String xueyuanValue;
		/**
		* 班级
		*/
		@ColumnInfo(comment="班级",type="int(11)")
		private Integer banjiTypes;
			/**
			* 班级的值
			*/
			@ColumnInfo(comment="班级的字典表值",type="varchar(200)")
			private String banjiValue;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String xueshengEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public XueshengJiankangView() {

	}

	public XueshengJiankangView(XueshengJiankangEntity xueshengJiankangEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengJiankangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 健康状态的值
	*/
	public String getXueshengJiankangValue() {
		return xueshengJiankangValue;
	}
	/**
	* 设置： 健康状态的值
	*/
	public void setXueshengJiankangValue(String xueshengJiankangValue) {
		this.xueshengJiankangValue = xueshengJiankangValue;
	}


	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getXueshengName() {
			return xueshengName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setXueshengName(String xueshengName) {
			this.xueshengName = xueshengName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getXueshengPhone() {
			return xueshengPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setXueshengPhone(String xueshengPhone) {
			this.xueshengPhone = xueshengPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getXueshengIdNumber() {
			return xueshengIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setXueshengIdNumber(String xueshengIdNumber) {
			this.xueshengIdNumber = xueshengIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getXueshengPhoto() {
			return xueshengPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setXueshengPhoto(String xueshengPhoto) {
			this.xueshengPhoto = xueshengPhoto;
		}
		/**
		* 获取： 学院
		*/
		public Integer getXueyuanTypes() {
			return xueyuanTypes;
		}
		/**
		* 设置： 学院
		*/
		public void setXueyuanTypes(Integer xueyuanTypes) {
			this.xueyuanTypes = xueyuanTypes;
		}


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
		/**
		* 获取： 班级
		*/
		public Integer getBanjiTypes() {
			return banjiTypes;
		}
		/**
		* 设置： 班级
		*/
		public void setBanjiTypes(Integer banjiTypes) {
			this.banjiTypes = banjiTypes;
		}


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

		/**
		* 获取： 学生邮箱
		*/
		public String getXueshengEmail() {
			return xueshengEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setXueshengEmail(String xueshengEmail) {
			this.xueshengEmail = xueshengEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


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
		return "XueshengJiankangView{" +
			", xueshengJiankangValue=" + xueshengJiankangValue +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			"} " + super.toString();
	}
}
