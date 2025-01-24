package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WenjianbiaoCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学校文件收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wenjianbiao_collection")
public class WenjianbiaoCollectionView extends WenjianbiaoCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String wenjianbiaoCollectionValue;

	//级联表 学校文件
		/**
		* 文件名称
		*/

		@ColumnInfo(comment="文件名称",type="varchar(200)")
		private String wenjianbiaoName;
		/**
		* 学校文件编号
		*/

		@ColumnInfo(comment="学校文件编号",type="varchar(200)")
		private String wenjianbiaoUuidNumber;
		/**
		* 文件照片
		*/

		@ColumnInfo(comment="文件照片",type="varchar(200)")
		private String wenjianbiaoPhoto;
		/**
		* 文件
		*/

		@ColumnInfo(comment="文件",type="varchar(200)")
		private String wenjianbiaoFile;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 学校文件类型
		*/
		@ColumnInfo(comment="学校文件类型",type="int(11)")
		private Integer wenjianbiaoTypes;
			/**
			* 学校文件类型的值
			*/
			@ColumnInfo(comment="学校文件类型的字典表值",type="varchar(200)")
			private String wenjianbiaoValue;
		/**
		* 文件介绍
		*/

		@ColumnInfo(comment="文件介绍",type="longtext")
		private String wenjianbiaoContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wenjianbiaoDelete;
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



	public WenjianbiaoCollectionView() {

	}

	public WenjianbiaoCollectionView(WenjianbiaoCollectionEntity wenjianbiaoCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, wenjianbiaoCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getWenjianbiaoCollectionValue() {
		return wenjianbiaoCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setWenjianbiaoCollectionValue(String wenjianbiaoCollectionValue) {
		this.wenjianbiaoCollectionValue = wenjianbiaoCollectionValue;
	}


	//级联表的get和set 学校文件

		/**
		* 获取： 文件名称
		*/
		public String getWenjianbiaoName() {
			return wenjianbiaoName;
		}
		/**
		* 设置： 文件名称
		*/
		public void setWenjianbiaoName(String wenjianbiaoName) {
			this.wenjianbiaoName = wenjianbiaoName;
		}

		/**
		* 获取： 学校文件编号
		*/
		public String getWenjianbiaoUuidNumber() {
			return wenjianbiaoUuidNumber;
		}
		/**
		* 设置： 学校文件编号
		*/
		public void setWenjianbiaoUuidNumber(String wenjianbiaoUuidNumber) {
			this.wenjianbiaoUuidNumber = wenjianbiaoUuidNumber;
		}

		/**
		* 获取： 文件照片
		*/
		public String getWenjianbiaoPhoto() {
			return wenjianbiaoPhoto;
		}
		/**
		* 设置： 文件照片
		*/
		public void setWenjianbiaoPhoto(String wenjianbiaoPhoto) {
			this.wenjianbiaoPhoto = wenjianbiaoPhoto;
		}

		/**
		* 获取： 文件
		*/
		public String getWenjianbiaoFile() {
			return wenjianbiaoFile;
		}
		/**
		* 设置： 文件
		*/
		public void setWenjianbiaoFile(String wenjianbiaoFile) {
			this.wenjianbiaoFile = wenjianbiaoFile;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 学校文件类型
		*/
		public Integer getWenjianbiaoTypes() {
			return wenjianbiaoTypes;
		}
		/**
		* 设置： 学校文件类型
		*/
		public void setWenjianbiaoTypes(Integer wenjianbiaoTypes) {
			this.wenjianbiaoTypes = wenjianbiaoTypes;
		}


			/**
			* 获取： 学校文件类型的值
			*/
			public String getWenjianbiaoValue() {
				return wenjianbiaoValue;
			}
			/**
			* 设置： 学校文件类型的值
			*/
			public void setWenjianbiaoValue(String wenjianbiaoValue) {
				this.wenjianbiaoValue = wenjianbiaoValue;
			}

		/**
		* 获取： 文件介绍
		*/
		public String getWenjianbiaoContent() {
			return wenjianbiaoContent;
		}
		/**
		* 设置： 文件介绍
		*/
		public void setWenjianbiaoContent(String wenjianbiaoContent) {
			this.wenjianbiaoContent = wenjianbiaoContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWenjianbiaoDelete() {
			return wenjianbiaoDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWenjianbiaoDelete(Integer wenjianbiaoDelete) {
			this.wenjianbiaoDelete = wenjianbiaoDelete;
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
		return "WenjianbiaoCollectionView{" +
			", wenjianbiaoCollectionValue=" + wenjianbiaoCollectionValue +
			", wenjianbiaoName=" + wenjianbiaoName +
			", wenjianbiaoUuidNumber=" + wenjianbiaoUuidNumber +
			", wenjianbiaoPhoto=" + wenjianbiaoPhoto +
			", wenjianbiaoFile=" + wenjianbiaoFile +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", wenjianbiaoContent=" + wenjianbiaoContent +
			", wenjianbiaoDelete=" + wenjianbiaoDelete +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			"} " + super.toString();
	}
}
