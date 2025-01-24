package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieshoudiQianwangEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import java.util.List;

/**
 * 接受地前往 服务类
 */
public interface JieshoudiQianwangService extends IService<JieshoudiQianwangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}