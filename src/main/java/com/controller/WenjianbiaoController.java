
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
 * 学校文件
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenjianbiao")
public class WenjianbiaoController {
    private static final Logger logger = LoggerFactory.getLogger(WenjianbiaoController.class);

    private static final String TABLE_NAME = "wenjianbiao";

    @Autowired
    private WenjianbiaoService wenjianbiaoService;


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
    private WenjianbiaoCollectionService wenjianbiaoCollectionService;//学校文件收藏
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
        params.put("wenjianbiaoDeleteStart",1);params.put("wenjianbiaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wenjianbiaoService.queryPage(params);

        //字典表数据转换
        List<WenjianbiaoView> list =(List<WenjianbiaoView>)page.getList();
        for(WenjianbiaoView c:list){
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
        WenjianbiaoEntity wenjianbiao = wenjianbiaoService.selectById(id);
        if(wenjianbiao !=null){
            //entity转view
            WenjianbiaoView view = new WenjianbiaoView();
            BeanUtils.copyProperties( wenjianbiao , view );//把实体数据重构到view中
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
    public R save(@RequestBody WenjianbiaoEntity wenjianbiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenjianbiao:{}",this.getClass().getName(),wenjianbiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WenjianbiaoEntity> queryWrapper = new EntityWrapper<WenjianbiaoEntity>()
            .eq("wenjianbiao_name", wenjianbiao.getWenjianbiaoName())
            .eq("zan_number", wenjianbiao.getZanNumber())
            .eq("cai_number", wenjianbiao.getCaiNumber())
            .eq("wenjianbiao_types", wenjianbiao.getWenjianbiaoTypes())
            .eq("shangxia_types", wenjianbiao.getShangxiaTypes())
            .eq("wenjianbiao_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianbiaoEntity wenjianbiaoEntity = wenjianbiaoService.selectOne(queryWrapper);
        if(wenjianbiaoEntity==null){
            wenjianbiao.setShangxiaTypes(1);
            wenjianbiao.setWenjianbiaoDelete(1);
            wenjianbiao.setInsertTime(new Date());
            wenjianbiao.setCreateTime(new Date());
            wenjianbiaoService.insert(wenjianbiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenjianbiaoEntity wenjianbiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenjianbiao:{}",this.getClass().getName(),wenjianbiao.toString());
        WenjianbiaoEntity oldWenjianbiaoEntity = wenjianbiaoService.selectById(wenjianbiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wenjianbiao.getWenjianbiaoPhoto()) || "null".equals(wenjianbiao.getWenjianbiaoPhoto())){
                wenjianbiao.setWenjianbiaoPhoto(null);
        }
        if("".equals(wenjianbiao.getWenjianbiaoFile()) || "null".equals(wenjianbiao.getWenjianbiaoFile())){
                wenjianbiao.setWenjianbiaoFile(null);
        }

            wenjianbiaoService.updateById(wenjianbiao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenjianbiaoEntity> oldWenjianbiaoList =wenjianbiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WenjianbiaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WenjianbiaoEntity wenjianbiaoEntity = new WenjianbiaoEntity();
            wenjianbiaoEntity.setId(id);
            wenjianbiaoEntity.setWenjianbiaoDelete(2);
            list.add(wenjianbiaoEntity);
        }
        if(list != null && list.size() >0){
            wenjianbiaoService.updateBatchById(list);
        }

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
            List<WenjianbiaoEntity> wenjianbiaoList = new ArrayList<>();//上传的东西
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
                            WenjianbiaoEntity wenjianbiaoEntity = new WenjianbiaoEntity();
//                            wenjianbiaoEntity.setWenjianbiaoName(data.get(0));                    //文件名称 要改的
//                            wenjianbiaoEntity.setWenjianbiaoUuidNumber(data.get(0));                    //学校文件编号 要改的
//                            wenjianbiaoEntity.setWenjianbiaoPhoto("");//详情和图片
//                            wenjianbiaoEntity.setWenjianbiaoFile(data.get(0));                    //文件 要改的
//                            wenjianbiaoEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            wenjianbiaoEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            wenjianbiaoEntity.setWenjianbiaoTypes(Integer.valueOf(data.get(0)));   //学校文件类型 要改的
//                            wenjianbiaoEntity.setWenjianbiaoContent("");//详情和图片
//                            wenjianbiaoEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            wenjianbiaoEntity.setWenjianbiaoDelete(1);//逻辑删除字段
//                            wenjianbiaoEntity.setInsertTime(date);//时间
//                            wenjianbiaoEntity.setCreateTime(date);//时间
                            wenjianbiaoList.add(wenjianbiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //学校文件编号
                                if(seachFields.containsKey("wenjianbiaoUuidNumber")){
                                    List<String> wenjianbiaoUuidNumber = seachFields.get("wenjianbiaoUuidNumber");
                                    wenjianbiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wenjianbiaoUuidNumber = new ArrayList<>();
                                    wenjianbiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wenjianbiaoUuidNumber",wenjianbiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //学校文件编号
                        List<WenjianbiaoEntity> wenjianbiaoEntities_wenjianbiaoUuidNumber = wenjianbiaoService.selectList(new EntityWrapper<WenjianbiaoEntity>().in("wenjianbiao_uuid_number", seachFields.get("wenjianbiaoUuidNumber")).eq("wenjianbiao_delete", 1));
                        if(wenjianbiaoEntities_wenjianbiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WenjianbiaoEntity s:wenjianbiaoEntities_wenjianbiaoUuidNumber){
                                repeatFields.add(s.getWenjianbiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学校文件编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wenjianbiaoService.insertBatch(wenjianbiaoList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WenjianbiaoView> returnWenjianbiaoViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("xueshengId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wenjianbiaoCollectionService.queryPage(params1);
        List<WenjianbiaoCollectionView> collectionViewsList =(List<WenjianbiaoCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WenjianbiaoCollectionView collectionView:collectionViewsList){
            Integer wenjianbiaoTypes = collectionView.getWenjianbiaoTypes();
            if(typeMap.containsKey(wenjianbiaoTypes)){
                typeMap.put(wenjianbiaoTypes,typeMap.get(wenjianbiaoTypes)+1);
            }else{
                typeMap.put(wenjianbiaoTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wenjianbiaoTypes",type);
            PageUtils pageUtils1 = wenjianbiaoService.queryPage(params2);
            List<WenjianbiaoView> wenjianbiaoViewList =(List<WenjianbiaoView>)pageUtils1.getList();
            returnWenjianbiaoViewList.addAll(wenjianbiaoViewList);
            if(returnWenjianbiaoViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wenjianbiaoService.queryPage(params);
        if(returnWenjianbiaoViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWenjianbiaoViewList.size();//要添加的数量
            List<WenjianbiaoView> wenjianbiaoViewList =(List<WenjianbiaoView>)page.getList();
            for(WenjianbiaoView wenjianbiaoView:wenjianbiaoViewList){
                Boolean addFlag = true;
                for(WenjianbiaoView returnWenjianbiaoView:returnWenjianbiaoViewList){
                    if(returnWenjianbiaoView.getId().intValue() ==wenjianbiaoView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWenjianbiaoViewList.add(wenjianbiaoView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWenjianbiaoViewList = returnWenjianbiaoViewList.subList(0, limit);
        }

        for(WenjianbiaoView c:returnWenjianbiaoViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWenjianbiaoViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wenjianbiaoService.queryPage(params);

        //字典表数据转换
        List<WenjianbiaoView> list =(List<WenjianbiaoView>)page.getList();
        for(WenjianbiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenjianbiaoEntity wenjianbiao = wenjianbiaoService.selectById(id);
            if(wenjianbiao !=null){


                //entity转view
                WenjianbiaoView view = new WenjianbiaoView();
                BeanUtils.copyProperties( wenjianbiao , view );//把实体数据重构到view中

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
    public R add(@RequestBody WenjianbiaoEntity wenjianbiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenjianbiao:{}",this.getClass().getName(),wenjianbiao.toString());
        Wrapper<WenjianbiaoEntity> queryWrapper = new EntityWrapper<WenjianbiaoEntity>()
            .eq("wenjianbiao_name", wenjianbiao.getWenjianbiaoName())
            .eq("wenjianbiao_uuid_number", wenjianbiao.getWenjianbiaoUuidNumber())
            .eq("zan_number", wenjianbiao.getZanNumber())
            .eq("cai_number", wenjianbiao.getCaiNumber())
            .eq("wenjianbiao_types", wenjianbiao.getWenjianbiaoTypes())
            .eq("shangxia_types", wenjianbiao.getShangxiaTypes())
            .eq("wenjianbiao_delete", wenjianbiao.getWenjianbiaoDelete())
//            .notIn("wenjianbiao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenjianbiaoEntity wenjianbiaoEntity = wenjianbiaoService.selectOne(queryWrapper);
        if(wenjianbiaoEntity==null){
                wenjianbiao.setZanNumber(1);
                wenjianbiao.setCaiNumber(1);
            wenjianbiao.setWenjianbiaoDelete(1);
            wenjianbiao.setInsertTime(new Date());
            wenjianbiao.setCreateTime(new Date());
        wenjianbiaoService.insert(wenjianbiao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

