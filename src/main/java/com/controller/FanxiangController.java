
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
 * 返校申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fanxiang")
public class FanxiangController {
    private static final Logger logger = LoggerFactory.getLogger(FanxiangController.class);

    private static final String TABLE_NAME = "fanxiang";

    @Autowired
    private FanxiangService fanxiangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
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
        PageUtils page = fanxiangService.queryPage(params);

        //字典表数据转换
        List<FanxiangView> list =(List<FanxiangView>)page.getList();
        for(FanxiangView c:list){
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
        FanxiangEntity fanxiang = fanxiangService.selectById(id);
        if(fanxiang !=null){
            //entity转view
            FanxiangView view = new FanxiangView();
            BeanUtils.copyProperties( fanxiang , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(fanxiang.getXueshengId());
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
    public R save(@RequestBody FanxiangEntity fanxiang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fanxiang:{}",this.getClass().getName(),fanxiang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            fanxiang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FanxiangEntity> queryWrapper = new EntityWrapper<FanxiangEntity>()
            .eq("xuesheng_id", fanxiang.getXueshengId())
            .eq("fanxiang_name", fanxiang.getFanxiangName())
            .eq("fanxiang_address", fanxiang.getFanxiangAddress())
            .eq("fanxiang_types", fanxiang.getFanxiangTypes())
            .eq("fanxiang_fangshi_types", fanxiang.getFanxiangFangshiTypes())
            .eq("fanxiang_lujing", fanxiang.getFanxiangLujing())
            .in("fanxiang_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanxiangEntity fanxiangEntity = fanxiangService.selectOne(queryWrapper);
        if(fanxiangEntity==null){
            fanxiang.setInsertTime(new Date());
            fanxiang.setFanxiangYesnoTypes(1);
            fanxiang.setCreateTime(new Date());
            fanxiangService.insert(fanxiang);
            return R.ok();
        }else {
            if(fanxiangEntity.getFanxiangYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fanxiangEntity.getFanxiangYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FanxiangEntity fanxiang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fanxiang:{}",this.getClass().getName(),fanxiang.toString());
        FanxiangEntity oldFanxiangEntity = fanxiangService.selectById(fanxiang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            fanxiang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(fanxiang.getFanxiangFile()) || "null".equals(fanxiang.getFanxiangFile())){
                fanxiang.setFanxiangFile(null);
        }

            fanxiangService.updateById(fanxiang);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody FanxiangEntity fanxiangEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,fanxiangEntity:{}",this.getClass().getName(),fanxiangEntity.toString());

        FanxiangEntity oldFanxiang = fanxiangService.selectById(fanxiangEntity.getId());//查询原先数据

//        if(fanxiangEntity.getFanxiangYesnoTypes() == 2){//通过
//            fanxiangEntity.setFanxiangTypes();
//        }else if(fanxiangEntity.getFanxiangYesnoTypes() == 3){//拒绝
//            fanxiangEntity.setFanxiangTypes();
//        }
        fanxiangEntity.setFanxiangShenheTime(new Date());//审核时间
        fanxiangService.updateById(fanxiangEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FanxiangEntity> oldFanxiangList =fanxiangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fanxiangService.deleteBatchIds(Arrays.asList(ids));

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
            List<FanxiangEntity> fanxiangList = new ArrayList<>();//上传的东西
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
                            FanxiangEntity fanxiangEntity = new FanxiangEntity();
//                            fanxiangEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            fanxiangEntity.setFanxiangUuidNumber(data.get(0));                    //返校申请编号 要改的
//                            fanxiangEntity.setFanxiangName(data.get(0));                    //申请标题 要改的
//                            fanxiangEntity.setFanxiangAddress(data.get(0));                    //现在地点 要改的
//                            fanxiangEntity.setFanxiangFile(data.get(0));                    //附件 要改的
//                            fanxiangEntity.setFanxiangTypes(Integer.valueOf(data.get(0)));   //返校申请类型 要改的
//                            fanxiangEntity.setFanxiangFangshiTypes(Integer.valueOf(data.get(0)));   //返校方式 要改的
//                            fanxiangEntity.setFanxiangLujing(data.get(0));                    //返校路径 要改的
//                            fanxiangEntity.setDaoxiaoTime(sdf.parse(data.get(0)));          //预计到校日期 要改的
//                            fanxiangEntity.setFanxiangContent("");//详情和图片
//                            fanxiangEntity.setInsertTime(date);//时间
//                            fanxiangEntity.setFanxiangYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            fanxiangEntity.setFanxiangYesnoText(data.get(0));                    //回复话语 要改的
//                            fanxiangEntity.setFanxiangShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            fanxiangEntity.setCreateTime(date);//时间
                            fanxiangList.add(fanxiangEntity);


                            //把要查询是否重复的字段放入map中
                                //返校申请编号
                                if(seachFields.containsKey("fanxiangUuidNumber")){
                                    List<String> fanxiangUuidNumber = seachFields.get("fanxiangUuidNumber");
                                    fanxiangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fanxiangUuidNumber = new ArrayList<>();
                                    fanxiangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fanxiangUuidNumber",fanxiangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //返校申请编号
                        List<FanxiangEntity> fanxiangEntities_fanxiangUuidNumber = fanxiangService.selectList(new EntityWrapper<FanxiangEntity>().in("fanxiang_uuid_number", seachFields.get("fanxiangUuidNumber")));
                        if(fanxiangEntities_fanxiangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FanxiangEntity s:fanxiangEntities_fanxiangUuidNumber){
                                repeatFields.add(s.getFanxiangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [返校申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fanxiangService.insertBatch(fanxiangList);
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
        PageUtils page = fanxiangService.queryPage(params);

        //字典表数据转换
        List<FanxiangView> list =(List<FanxiangView>)page.getList();
        for(FanxiangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanxiangEntity fanxiang = fanxiangService.selectById(id);
            if(fanxiang !=null){


                //entity转view
                FanxiangView view = new FanxiangView();
                BeanUtils.copyProperties( fanxiang , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(fanxiang.getXueshengId());
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
    public R add(@RequestBody FanxiangEntity fanxiang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fanxiang:{}",this.getClass().getName(),fanxiang.toString());
        Wrapper<FanxiangEntity> queryWrapper = new EntityWrapper<FanxiangEntity>()
            .eq("xuesheng_id", fanxiang.getXueshengId())
            .eq("fanxiang_uuid_number", fanxiang.getFanxiangUuidNumber())
            .eq("fanxiang_name", fanxiang.getFanxiangName())
            .eq("fanxiang_address", fanxiang.getFanxiangAddress())
            .eq("fanxiang_types", fanxiang.getFanxiangTypes())
            .eq("fanxiang_fangshi_types", fanxiang.getFanxiangFangshiTypes())
            .eq("fanxiang_lujing", fanxiang.getFanxiangLujing())
            .in("fanxiang_yesno_types", new Integer[]{1,2})
            .eq("fanxiang_yesno_text", fanxiang.getFanxiangYesnoText())
//            .notIn("fanxiang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanxiangEntity fanxiangEntity = fanxiangService.selectOne(queryWrapper);
        if(fanxiangEntity==null){
            fanxiang.setInsertTime(new Date());
            fanxiang.setFanxiangYesnoTypes(1);
            fanxiang.setCreateTime(new Date());
        fanxiangService.insert(fanxiang);

            return R.ok();
        }else {
            if(fanxiangEntity.getFanxiangYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fanxiangEntity.getFanxiangYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

