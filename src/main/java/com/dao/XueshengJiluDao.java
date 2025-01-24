package com.dao;

import com.entity.XueshengJiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengJiluView;

/**
 * 每日记录 Dao 接口
 *
 * @author 
 */
public interface XueshengJiluDao extends BaseMapper<XueshengJiluEntity> {

   List<XueshengJiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
