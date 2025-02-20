package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FanxiangEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import java.util.List;

/**
 * 返校申请 服务类
 */
public interface FanxiangService extends IService<FanxiangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}