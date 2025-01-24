
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
 * 学校文件收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenjianbiaoCollection")
public class WenjianbiaoCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(WenjianbiaoCollectionController.class);

    private static final String TABLE_NAME = "wenjianbiaoCollection";

    @Autowired
    private WenjianbiaoCollectionService wenjianbiaoCollectionService;


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
    private XueshengService xueshengService;//学生
    @Autowired
    private XueshengJiankangService xueshengJiankangService;//学生健康
    @Autowired
    private XueshengJiluService xueshengJiluService;//每日记录
    @Autowired
    private ZixunService zixunService;//资讯
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
        PageUtils page = wenjianbiaoCollectionService.queryPage(params);

        //字典表数据转换
        List<WenjianbiaoCollectionView> list =(List<WenjianbiaoCollectionView>)page.getList();
        for(WenjianbiaoCollectionView c:list){
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
        WenjianbiaoCollectionEntity wenjianbiaoCollection = wenjianbiaoCollectionService.selectById(id);
        if(wenjianbiaoCollection !=null){
            //entity转view
            WenjianbiaoCollectionView view = new WenjianbiaoCollectionView();
            BeanUtils.copyProperties( wenjianbiaoCollection , view );//把实体数据重构到view中
            //级联表 学校文件
            //级联表
            WenjianbiaoEntity wenjianbiao = wenjianbiaoService.selectById(wenjianbiaoCollection.getWenjianbiaoId());
            if(wenjianbiao != null){
            BeanUtils.copyProperties( wenjianbiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWenjianbiaoId(wenjianbiao.getId());
            }
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(wenjianbiaoCollection.getXueshengId());
            if(xuesheng != null){
            BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXueshengId(xuesheng.getId());
            }
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
    public R save(@RequestBody WenjianbiaoCollectionEntity wenjianbiaoCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenjianbiaoCollection:{}",this.getClass().getName(),wenjianbiaoCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            wenjianbiaoCollection.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WenjianbiaoCollectionEntity> queryWrapper = new EntityWrapper<WenjianbiaoCollectionEntity>()
            .eq("wenjianbiao_id", wenjianbiaoCollection.getWenjianbiaoId())
            .eq("xuesheng_id", wenjianbiaoCollection.getXueshengId())
            .eq("wenjianbiao_collection_types", wenjianbiaoCollection.getWenjianbiaoCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianbiaoCollectionEntity wenjianbiaoCollectionEntity = wenjianbiaoCollectionService.selectOne(queryWrapper);
        if(wenjianbiaoCollectionEntity==null){
            wenjianbiaoCollection.setInsertTime(new Date());
            wenjianbiaoCollection.setCreateTime(new Date());
            wenjianbiaoCollectionService.insert(wenjianbiaoCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenjianbiaoCollectionEntity wenjianbiaoCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenjianbiaoCollection:{}",this.getClass().getName(),wenjianbiaoCollection.toString());
        WenjianbiaoCollectionEntity oldWenjianbiaoCollectionEntity = wenjianbiaoCollectionService.selectById(wenjianbiaoCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            wenjianbiaoCollection.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wenjianbiaoCollectionService.updateById(wenjianbiaoCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenjianbiaoCollectionEntity> oldWenjianbiaoCollectionList =wenjianbiaoCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wenjianbiaoCollectionService.deleteBatchIds(Arrays.asList(ids));

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
            List<WenjianbiaoCollectionEntity> wenjianbiaoCollectionList = new ArrayList<>();//上传的东西
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
                            WenjianbiaoCollectionEntity wenjianbiaoCollectionEntity = new WenjianbiaoCollectionEntity();
//                            wenjianbiaoCollectionEntity.setWenjianbiaoId(Integer.valueOf(data.get(0)));   //学校文件 要改的
//                            wenjianbiaoCollectionEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            wenjianbiaoCollectionEntity.setWenjianbiaoCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            wenjianbiaoCollectionEntity.setInsertTime(date);//时间
//                            wenjianbiaoCollectionEntity.setCreateTime(date);//时间
                            wenjianbiaoCollectionList.add(wenjianbiaoCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wenjianbiaoCollectionService.insertBatch(wenjianbiaoCollectionList);
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
        PageUtils page = wenjianbiaoCollectionService.queryPage(params);

        //字典表数据转换
        List<WenjianbiaoCollectionView> list =(List<WenjianbiaoCollectionView>)page.getList();
        for(WenjianbiaoCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenjianbiaoCollectionEntity wenjianbiaoCollection = wenjianbiaoCollectionService.selectById(id);
            if(wenjianbiaoCollection !=null){


                //entity转view
                WenjianbiaoCollectionView view = new WenjianbiaoCollectionView();
                BeanUtils.copyProperties( wenjianbiaoCollection , view );//把实体数据重构到view中

                //级联表
                    WenjianbiaoEntity wenjianbiao = wenjianbiaoService.selectById(wenjianbiaoCollection.getWenjianbiaoId());
                if(wenjianbiao != null){
                    BeanUtils.copyProperties( wenjianbiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWenjianbiaoId(wenjianbiao.getId());
                }
                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(wenjianbiaoCollection.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
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
    public R add(@RequestBody WenjianbiaoCollectionEntity wenjianbiaoCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenjianbiaoCollection:{}",this.getClass().getName(),wenjianbiaoCollection.toString());
        Wrapper<WenjianbiaoCollectionEntity> queryWrapper = new EntityWrapper<WenjianbiaoCollectionEntity>()
            .eq("wenjianbiao_id", wenjianbiaoCollection.getWenjianbiaoId())
            .eq("xuesheng_id", wenjianbiaoCollection.getXueshengId())
            .eq("wenjianbiao_collection_types", wenjianbiaoCollection.getWenjianbiaoCollectionTypes())
//            .notIn("wenjianbiao_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianbiaoCollectionEntity wenjianbiaoCollectionEntity = wenjianbiaoCollectionService.selectOne(queryWrapper);
        if(wenjianbiaoCollectionEntity==null){
            wenjianbiaoCollection.setInsertTime(new Date());
            wenjianbiaoCollection.setCreateTime(new Date());
        wenjianbiaoCollectionService.insert(wenjianbiaoCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

