package com.dao;

import com.entity.WenjianbiaoCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenjianbiaoCollectionView;

/**
 * 学校文件收藏 Dao 接口
 *
 * @author 
 */
public interface WenjianbiaoCollectionDao extends BaseMapper<WenjianbiaoCollectionEntity> {

   List<WenjianbiaoCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
