
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
 * 学生健康
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengJiankang")
public class XueshengJiankangController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengJiankangController.class);

    private static final String TABLE_NAME = "xueshengJiankang";

    @Autowired
    private XueshengJiankangService xueshengJiankangService;


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
        PageUtils page = xueshengJiankangService.queryPage(params);

        //字典表数据转换
        List<XueshengJiankangView> list =(List<XueshengJiankangView>)page.getList();
        for(XueshengJiankangView c:list){
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
        XueshengJiankangEntity xueshengJiankang = xueshengJiankangService.selectById(id);
        if(xueshengJiankang !=null){
            //entity转view
            XueshengJiankangView view = new XueshengJiankangView();
            BeanUtils.copyProperties( xueshengJiankang , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(xueshengJiankang.getXueshengId());
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
    public R save(@RequestBody XueshengJiankangEntity xueshengJiankang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengJiankang:{}",this.getClass().getName(),xueshengJiankang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengJiankang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengJiankangEntity> queryWrapper = new EntityWrapper<XueshengJiankangEntity>()
            .eq("xuesheng_id", xueshengJiankang.getXueshengId())
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(xueshengJiankang.getSuoshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengJiankangEntity xueshengJiankangEntity = xueshengJiankangService.selectOne(queryWrapper);
        if(xueshengJiankangEntity==null){
            xueshengJiankang.setInsertTime(new Date());
            xueshengJiankang.setCreateTime(new Date());
            xueshengJiankangService.insert(xueshengJiankang);
            return R.ok();
        }else {
            return R.error(511,"该学生该天已有健康记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengJiankangEntity xueshengJiankang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xueshengJiankang:{}",this.getClass().getName(),xueshengJiankang.toString());
        XueshengJiankangEntity oldXueshengJiankangEntity = xueshengJiankangService.selectById(xueshengJiankang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengJiankang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xueshengJiankang.getXueshengJiankangFile()) || "null".equals(xueshengJiankang.getXueshengJiankangFile())){
                xueshengJiankang.setXueshengJiankangFile(null);
        }

            xueshengJiankangService.updateById(xueshengJiankang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XueshengJiankangEntity> oldXueshengJiankangList =xueshengJiankangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xueshengJiankangService.deleteBatchIds(Arrays.asList(ids));

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
            List<XueshengJiankangEntity> xueshengJiankangList = new ArrayList<>();//上传的东西
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
                            XueshengJiankangEntity xueshengJiankangEntity = new XueshengJiankangEntity();
//                            xueshengJiankangEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengJiankangEntity.setXueshengJiankangUuidNumber(data.get(0));                    //记录编号 要改的
//                            xueshengJiankangEntity.setXueshengJiankangFile(data.get(0));                    //附件 要改的
//                            xueshengJiankangEntity.setXueshengJiankangTypes(Integer.valueOf(data.get(0)));   //健康状态 要改的
//                            xueshengJiankangEntity.setSuoshuTime(sdf.parse(data.get(0)));          //所属日期 要改的
//                            xueshengJiankangEntity.setXueshengJiankangContent("");//详情和图片
//                            xueshengJiankangEntity.setInsertTime(date);//时间
//                            xueshengJiankangEntity.setCreateTime(date);//时间
                            xueshengJiankangList.add(xueshengJiankangEntity);


                            //把要查询是否重复的字段放入map中
                                //记录编号
                                if(seachFields.containsKey("xueshengJiankangUuidNumber")){
                                    List<String> xueshengJiankangUuidNumber = seachFields.get("xueshengJiankangUuidNumber");
                                    xueshengJiankangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengJiankangUuidNumber = new ArrayList<>();
                                    xueshengJiankangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengJiankangUuidNumber",xueshengJiankangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //记录编号
                        List<XueshengJiankangEntity> xueshengJiankangEntities_xueshengJiankangUuidNumber = xueshengJiankangService.selectList(new EntityWrapper<XueshengJiankangEntity>().in("xuesheng_jiankang_uuid_number", seachFields.get("xueshengJiankangUuidNumber")));
                        if(xueshengJiankangEntities_xueshengJiankangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengJiankangEntity s:xueshengJiankangEntities_xueshengJiankangUuidNumber){
                                repeatFields.add(s.getXueshengJiankangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [记录编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueshengJiankangService.insertBatch(xueshengJiankangList);
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
        PageUtils page = xueshengJiankangService.queryPage(params);

        //字典表数据转换
        List<XueshengJiankangView> list =(List<XueshengJiankangView>)page.getList();
        for(XueshengJiankangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XueshengJiankangEntity xueshengJiankang = xueshengJiankangService.selectById(id);
            if(xueshengJiankang !=null){


                //entity转view
                XueshengJiankangView view = new XueshengJiankangView();
                BeanUtils.copyProperties( xueshengJiankang , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(xueshengJiankang.getXueshengId());
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
    public R add(@RequestBody XueshengJiankangEntity xueshengJiankang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xueshengJiankang:{}",this.getClass().getName(),xueshengJiankang.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengJiankang.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<XueshengJiankangEntity> queryWrapper = new EntityWrapper<XueshengJiankangEntity>()
            .eq("xuesheng_id", xueshengJiankang.getXueshengId())
            .eq("suoshu_time", new SimpleDateFormat("yyyy-MM-dd").format(xueshengJiankang.getSuoshuTime()))
            ;
        XueshengJiankangEntity xueshengJiankangEntity = xueshengJiankangService.selectOne(queryWrapper);
        if(xueshengJiankangEntity==null){
            xueshengJiankang.setInsertTime(new Date());
            xueshengJiankang.setCreateTime(new Date());
        xueshengJiankangService.insert(xueshengJiankang);

            return R.ok();
        }else {
            return R.error(511,"该学生该天已有健康记录");
        }
    }

}

