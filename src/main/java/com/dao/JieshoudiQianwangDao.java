package com.dao;

import com.entity.JieshoudiQianwangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JieshoudiQianwangView;

/**
 * 接受地前往 Dao 接口
 *
 * @author 
 */
public interface JieshoudiQianwangDao extends BaseMapper<JieshoudiQianwangEntity> {

   List<JieshoudiQianwangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
