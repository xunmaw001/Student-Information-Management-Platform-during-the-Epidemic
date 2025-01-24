package com.dao;

import com.entity.XueshengJiankangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengJiankangView;

/**
 * 学生健康 Dao 接口
 *
 * @author 
 */
public interface XueshengJiankangDao extends BaseMapper<XueshengJiankangEntity> {

   List<XueshengJiankangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
