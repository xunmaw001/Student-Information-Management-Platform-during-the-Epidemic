package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.XueshengJiluDao;
import com.entity.XueshengJiluEntity;
import com.service.XueshengJiluService;
import com.entity.view.XueshengJiluView;

/**
 * 每日记录 服务实现类
 */
@Service("xueshengJiluService")
@Transactional
public class XueshengJiluServiceImpl extends ServiceImpl<XueshengJiluDao, XueshengJiluEntity> implements XueshengJiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<XueshengJiluView> page =new Query<XueshengJiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
