
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 资讯
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zixun")
public class ZixunController {
    private static final Logger logger = LoggerFactory.getLogger(ZixunController.class);

    private static final String TABLE_NAME = "zixun";

    @Autowired
    private ZixunService zixunService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FanxiangService fanxiangService;//返校申请
    @Autowired
    private JieshoudiService jieshoudiService;//接受地
    @Autowired
    private JieshoudiQianwangService jieshoudiQianwangService;//接受地前往
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private TongzhiService tongzhiService;//通知
    @Autowired
    private WenjianbiaoService wenjianbiaoService;//学校文件
    @Autowired
    private WenjianbiaoCollectionService wenjianbiaoCollectionService;//学校文件收藏
    @Autowired
    private XueshengService xueshengService;//学生
    @Autowired
    private XueshengJiankangService xueshengJiankangService;//学生健康
    @Autowired
    private XueshengJiluService xueshengJiluService;//每日记录
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zixunService.queryPage(params);

        //字典表数据转换
        List<ZixunView> list =(List<ZixunView>)page.getList();
        for(ZixunView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZixunEntity zixun = zixunService.selectById(id);
        if(zixun !=null){
            //entity转view
            ZixunView view = new ZixunView();
            BeanUtils.copyProperties( zixun , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunEntity zixun, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZixunEntity> queryWrapper = new EntityWrapper<ZixunEntity>()
            .eq("zixun_name", zixun.getZixunName())
            .eq("zixun_types", zixun.getZixunTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunEntity zixunEntity = zixunService.selectOne(queryWrapper);
        if(zixunEntity==null){
            zixun.setInsertTime(new Date());
            zixun.setCreateTime(new Date());
            zixunService.insert(zixun);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunEntity zixun, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());
        ZixunEntity oldZixunEntity = zixunService.selectById(zixun.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zixun.getZixunPhoto()) || "null".equals(zixun.getZixunPhoto())){
                zixun.setZixunPhoto(null);
        }

            zixunService.updateById(zixun);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZixunEntity> oldZixunList =zixunService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zixunService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer xueshengId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZixunEntity> zixunList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZixunEntity zixunEntity = new ZixunEntity();
//                            zixunEntity.setZixunName(data.get(0));                    //资讯名称 要改的
//                            zixunEntity.setZixunPhoto("");//详情和图片
//                            zixunEntity.setZixunTypes(Integer.valueOf(data.get(0)));   //资讯类型 要改的
//                            zixunEntity.setInsertTime(date);//时间
//                            zixunEntity.setZixunContent("");//详情和图片
//                            zixunEntity.setCreateTime(date);//时间
                            zixunList.add(zixunEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zixunService.insertBatch(zixunList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zixunService.queryPage(params);

        //字典表数据转换
        List<ZixunView> list =(List<ZixunView>)page.getList();
        for(ZixunView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZixunEntity zixun = zixunService.selectById(id);
            if(zixun !=null){


                //entity转view
                ZixunView view = new ZixunView();
                BeanUtils.copyProperties( zixun , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunEntity zixun, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zixun:{}",this.getClass().getName(),zixun.toString());
        Wrapper<ZixunEntity> queryWrapper = new EntityWrapper<ZixunEntity>()
            .eq("zixun_name", zixun.getZixunName())
            .eq("zixun_types", zixun.getZixunTypes())
//            .notIn("zixun_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZixunEntity zixunEntity = zixunService.selectOne(queryWrapper);
        if(zixunEntity==null){
            zixun.setInsertTime(new Date());
            zixun.setCreateTime(new Date());
        zixunService.insert(zixun);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

