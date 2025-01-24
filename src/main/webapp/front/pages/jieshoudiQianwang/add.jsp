<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>接受地前往添加</title>
    <!-- bootstrap样式，地图插件使用 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css" />
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css" />
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css" />
</head>
<style>
    html::after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        display: block;
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
        z-index: -1;
    }
    #swiper {
        overflow: hidden;
        margin: 0 auto;
    }
    #swiper .layui-carousel-ind li {
        width: 20px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,.3);
        border-radius: 6px;
        background-color: #f7f7f7;
        box-shadow: 0 0 6px rgba(255,0,0,.8);
    }
    #swiper .layui-carousel-ind li.layui-this {
        width: 30px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0,0,0,.3);
        border-radius: 6px;
    }

    button, button:focus {
        outline: none;
    }

    .data-add-container .add .layui-select-title .layui-unselect {
        padding: 0 12px;
        height: 40px;
        font-size: 15px;
        border-radius: 4px;
        border-width: 1px;
        border-style: solid;
        text-align: center;
    }
    .data-add-container .add .layui-form-item {
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .data-add-container .layui-form-pane .layui-form-item[pane] .layui-form-label {
        margin: 0;
        position: inherit;
        background: transparent;
        border: 0;
    }
    .data-add-container .add .layui-input-block {
        margin: 0;
        flex: 1;
    }
    .data-add-container .layui-form-pane .layui-form-item[pane] .layui-input-inline {
        margin: 0;
        flex: 1;
        display: flex;
    }
</style>
<body style="background: #fff; ">
    <div id="app">
        <div class="data-add-container  sub_borderColor" :style='{"padding":"20px","margin":"30px auto","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"10px","borderWidth":"1px","borderStyle":"solid"}'>

            <form class="layui-form layui-form-pane add" lay-filter="myForm">
                <!-- 级联表 接受地 -->
                <!--<div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        接受地：
                    </label>
                    <div class="layui-input-block">
                        <select name="jieshoudiId" id="jieshoudiId" lay-filter="jieshoudiId">
                            <option v-for="(item,index) in jieshoudiList" v-bind:key="index" :value="item.id" :selected="detail.jieshoudiId == item.id?true:false" :key="item.id">{{ item.jieshoudiName }}</option>
                        </select>
                    </div>
                </div>-->
                <!-- 级联表 学生 -->
                <!--<div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        学生：
                    </label>
                    <div class="layui-input-block">
                        <select name="xueshengId" id="xueshengId" lay-filter="xueshengId">
                            <option v-for="(item,index) in xueshengList" v-bind:key="index" :value="item.id" :selected="detail.xueshengId == item.id?true:false" :key="item.id">{{ item.xueshengName }}</option>
                        </select>
                    </div>
                </div>-->
    <!-- 当前表的 -->
                <!-- 级联表的表id -->
                <input type="hidden" :value="detail.jieshoudiId" id="jieshoudiId" name="jieshoudiId"/>
                <!-- 级联表的表id -->
                <input type="hidden" :value="detail.xueshengId" id="xueshengId" name="xueshengId"/>
<!-- 唯一uuid -->
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        接受地前往编号：
                    </label>
                    <div class="layui-input-block">
                        <input class="layui-input main_borderColor" :style='{"padding":"0 12px","boxShadow":"0 0 0px rgba(160, 67, 26, 1)","backgroundColor":"#fff","color":"rgba(135, 206, 250, 1)","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"15px","borderStyle":"solid","height":"40px"}'
                               v-model="detail.jieshoudiQianwangUuidNumber" lay-verify="required" type="text" :readonly="ro.jieshoudiQianwangUuidNumber" name="jieshoudiQianwangUuidNumber" id="jieshoudiQianwangUuidNumber" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        附件：
                    </label>
                    <div class="layui-input-block">
                        <div v-if="detail.jieshoudiQianwangFile" style="display:inline-block;margin-right:10px;">
                            <button v-if="detail.jieshoudiQianwangFile != null" @click="jump(baseUrl+detail.jieshoudiQianwangFile)" id="jieshoudiQianwangFileImg" type="button" class="layui-btn layui-btn-success">点击查看</button>
                            <span v-if="detail.jieshoudiQianwangFile == null">暂无文件</span>
                            <input type="hidden" :value="detail.jieshoudiQianwangFile" id="jieshoudiQianwangFile" name="jieshoudiQianwangFile" />
                        </div>
                        <button v-if="!ro.jieshoudiQianwangFile" :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.5)","margin":"0 10px 0 0","borderColor":"#ccc","color":"#fff","borderRadius":"8px","borderWidth":"0","width":"auto","fontSize":"14px","borderStyle":"solid","height":"44px"}' type="button" class="layui-btn btn-theme main_backgroundColor" id="jieshoudiQianwangFileUpload">
                            <i v-if="true" :style='{"color":"#fff","show":true,"fontSize":"14px"}' class="layui-icon">&#xe67c;</i>上传附件
                        </button>
                    </div>
                </div>
                    <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        前往类型：
                    </label>
                    <div class="layui-input-block">
                        <select name="jieshoudiQianwangTypes" id="jieshoudiQianwangTypes" lay-filter="jieshoudiQianwangTypes" :disabled="ro.jieshoudiQianwangTypes">
                            <option v-for="(item,index) in jieshoudiQianwangTypesList" v-bind:key="index" :value="item.codeIndex" :selected="detail.jieshoudiQianwangTypes == item.codeIndex?true:false" :key="item.codeIndex">{{ item.indexName }}</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        前往时间：
                    </label>
                    <div class="layui-input-block">
                        <input class="layui-input main_borderColor" :style='{"padding":"0 12px","boxShadow":"0 0 0px rgba(160, 67, 26, 1)","backgroundColor":"#fff","color":"rgba(135, 206, 250, 1)","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"15px","borderStyle":"solid","height":"40px"}'
                           type="text" :readonly="ro.qianwangTime" lay-verify="required" name="qianwangTime" id="qianwangTime" autocomplete="off">
                    </div>
                </div>
                <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                        抵达时间：
                    </label>
                    <div class="layui-input-block">
                        <input class="layui-input main_borderColor" :style='{"padding":"0 12px","boxShadow":"0 0 0px rgba(160, 67, 26, 1)","backgroundColor":"#fff","color":"rgba(135, 206, 250, 1)","borderRadius":"4px","textAlign":"left","borderWidth":"1px","fontSize":"15px","borderStyle":"solid","height":"40px"}'
                           type="text" :readonly="ro.didaTime" lay-verify="required" name="didaTime" id="didaTime" autocomplete="off">
                    </div>
                </div>
            <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                <label  :style='{"width":"auto","borderColor": "rgba(255, 255, 255, 0)","padding":"0 12px 0 0","backgroundColor":"rgba(255, 255, 255, 0)","fontSize":"15px","color":"#333","textAlign":"left"}' class="layui-form-label">
                    前往缘由：
                </label>
                <div class="layui-input-block">
                    <textarea class="main_borderColor layui-input" style="width: 100%;height: 100px;border-radius: 5px;padding: 10px" v-model="detail.jieshoudiQianwangContent" lay-verify="required" :readonly="ro.jieshoudiQianwangContent" name="jieshoudiQianwangContent" id="jieshoudiQianwangContent" autocomplete="off"></textarea>
                </div>
            </div>
                    <div class="layui-form-item main_borderColor" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 0 10px 0","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"1px","borderWidth":"0 0 1px 0","borderStyle":"solid"}'>
                    <div class="layui-input-block" style="text-align: right;">
                        <button :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.5)","margin":"0 10px","borderColor":"#ccc","backgroundColor":"rgba(75, 92, 196, 1)","color":"#fff","borderRadius":"8px","borderWidth":"0","width":"25%","fontSize":"14px","borderStyle":"solid","height":"44px"}' class="layui-btn btn-submit" lay-submit lay-filter="thisSubmit">提交</button>
                    </div>
                </div>

            </form>
        </div>
    </div>

    <script src="../../layui/layui.js"></script>
    <script src="../../js/vue.js"></script>
    <!-- 引入element组件库 -->
    <script src="../../xznstatic/js/element.min.js"></script>
    <!-- 引入element样式 -->
    <link rel="stylesheet" href="../../xznstatic/css/element.min.css">
    <!-- 组件配置信息 -->
    <script src="../../js/config.js"></script>
    <!-- 扩展插件配置信息 -->
    <script src="../../modules/config.js"></script>
    <!-- 工具方法 -->
    <script src="../../js/utils.js"></script>
    <!-- 校验格式工具类 -->
    <script src="../../js/validate.js"></script>
    <!-- 地图 -->
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>

    <script>
        var jquery = $;

        var vue = new Vue({
            el: '#app',
            data: {
                //项目路径
                baseUrl:"",
                dataList: [],
                ro:{
                    jieshoudiId: false,
                    xueshengId: false,
                    jieshoudiQianwangUuidNumber: true,
                    jieshoudiQianwangFile: false,
                    jieshoudiQianwangTypes: false,
                    qianwangTime: false,
                    didaTime: false,
                    jieshoudiQianwangContent: false,
                    insertTime: false,
                    createTime: false,
                },
                detail: {
                    jieshoudiId: '',
                    xueshengId: '',
                    jieshoudiQianwangUuidNumber: new Date().getTime(),//数字
                    jieshoudiQianwangFile: '',
                    jieshoudiQianwangTypes: '',//数字
                    jieshoudiQianwangValue: '',//数字对应的值
                    qianwangTime: '',
                    didaTime: '',
                    jieshoudiQianwangContent: '',
                    insertTime: '',
                    createTime: '',
                },
                jieshoudiList:[],//级联表列表 接受地
                jieshoudi: {},//级联表单个 接受地
                xueshengList:[],//级联表列表 学生
                xuesheng: {},//级联表单个 学生

                // 下拉框
                jieshoudiQianwangTypesList: [],

                centerMenu: centerMenu
            },
            updated: function() {
                layui.form.render('select', 'myForm');
            },
            computed: {
            },
            methods: {
                jump(url) {
                    jump(url)
                }
            }
        })


        layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate','tinymce'], function() {
            var layer = layui.layer;
            var element = layui.element;
            var carousel = layui.carousel;
            var http = layui.http;
            var jquery = layui.jquery;
            var form = layui.form;
            var upload = layui.upload;
            var laydate = layui.laydate;
            var tinymce = layui.tinymce;
            vue.baseUrl = http.baseurl

            localStorage.setItem("goUtl","./pages/jieshoudiQianwang/list.jsp")

            var jieshoudiId = http.getParam('jieshoudiId');
            // let jieshoudiId = localStorage.getItem("jieshoudiId")
            if(jieshoudiId != null && jieshoudiId != ""){
                //单个 接受地查询
                initializationJieshoudi(jieshoudiId);
            }
            //列表 接受地查询
            initializationJieshoudiList();
            //var xueshengId = http.getParam('xueshengId');
            let xueshengId = localStorage.getItem("xueshengId")
            if(xueshengId != null && xueshengId != ""){
                //单个 学生查询
                initializationXuesheng(xueshengId);
            }
            //列表 学生查询
            initializationXueshengList();
            // 下拉框
            // 前往类型的查询和初始化
            jieshoudiQianwangTypesSelect();

           // 上传文件
            // 附件的文件上传
            upload.render({
                //绑定元素
                elem: '#jieshoudiQianwangFileUpload',
                //上传接口
                url: http.baseurl + 'file/upload',
                // 请求头
                headers: {
                    Token: localStorage.getItem('Token')
                },
                // 允许上传时校验的文件类型
                accept: 'file',
                before: function () {
                    //loading层
                    var index = layer.load(1, {
                        shade: [0.1, '#fff'] //0.1透明度的白色背景
                    });
                },
                // 上传成功
                done: function (res) {
                    console.log(res);
                    layer.closeAll();
                    if (res.code == 0) {
                        layer.msg("上传成功", {
                            time: 2000,
                            icon: 6
                        })
                        var url = 'upload/' + res.file;
                        jquery('#jieshoudiQianwangFile').val(url);
                        vue.detail.jieshoudiQianwangFile = url;
                        jquery('#jieshoudiQianwangFileImg').attr('src', url);
                    } else {
                        layer.msg(res.msg, {
                            time: 2000,
                            icon: 5
                        })
                    }
                },
                //请求异常回调
                error: function () {
                    layer.closeAll();
                    layer.msg("请求接口异常", {
                        time: 2000,
                        icon: 5
                    })
                }
            });
            // 日期效验规则及格式
            dateTimePick();
            // 表单效验规则
            form.verify({
                // 正整数效验规则
                integer: [
                    /^[1-9][0-9]*$/
                    ,'必须是正整数'
                ]
                // 小数效验规则
                ,double: [
                    /^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/
                    ,'最大整数位为6为,小数最大两位'
                ]
            });

            // session独取
            let table = localStorage.getItem("userTable");
            http.request(table+"/session", 'get', {}, function (data) {
                // 表单赋值
                //form.val("myForm", data.data);
                // data = data.data;
                for (var key in data) {
                    vue.detail[table+"Id"] = data.id
                }
            });

            //修改
            if(http.getParam('jieshoudiQianwangId')){
                http.request(`jieshoudiQianwang/info/${http.getParam('jieshoudiQianwangId')}`, 'get', {}, function(data) {
                    vue.detail = data.data
                    jquery("#qianwangTime").val(vue.detail.qianwangTime)
                    jquery("#didaTime").val(vue.detail.didaTime)
                    jquery("#insertTime").val(vue.detail.insertTime)
                    jquery("#createTime").val(vue.detail.createTime)
                });
            }

            // 提交
            form.on('submit(thisSubmit)', function (data) {
                data = data.field;
                    data["xueshengId"]= localStorage.getItem("userid");
                if(http.getParam('jieshoudiQianwangId')){
                    data["id"]= http.getParam('jieshoudiQianwangId')
                }
                // 提交数据
                http.requestJson(`jieshoudiQianwang/${http.getParam("jieshoudiQianwangId")?"update":"add"}`, 'post', data, function (res) {
                    if(res.code == 0){
                        layer.msg('提交成功', {
                            time: 2000,
                            icon: 6
                        }, function () {
                            vue.jump("../jieshoudiQianwang/list.jsp");
                                http.remove('jieshoudiQianwangId')
                            // back();
                        });
                    }else{
                        layer.msg(res.msg, {time: 5000,icon: 5});
                    }
                });
                return false
            });

        });
        // 日期框初始化
        function dateTimePick(){
            var myDate = new Date();  //获取当前时间
            /*
                ,change: function(value, date, endDate){
                    value       得到日期生成的值，如：2017-08-18
                    date        得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                    endDate     得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            */
            // 前往时间的开始时间和结束时间的效验及格式
            var qianwangTime = layui.laydate.render({
                elem: '#qianwangTime'
	            ,type: 'datetime'
                ,btns: ['clear', 'confirm']
                ,min:myDate.toLocaleString()
                ,change: function(value, date, endDate){
                    vue.detail.qianwangTime = value;
                }
            });
            // 抵达时间的开始时间和结束时间的效验及格式
            var didaTime = layui.laydate.render({
                elem: '#didaTime'
	            ,type: 'datetime'
                ,btns: ['clear', 'confirm']
                ,min:myDate.toLocaleString()
                ,change: function(value, date, endDate){
                    vue.detail.didaTime = value;
                }
            });
        }




       // 前往类型的查询
       function jieshoudiQianwangTypesSelect() {
           //填充下拉框选项
           layui.http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jieshoudi_qianwang_types", "GET", {}, (res) => {
               if(res.code == 0){
                   vue.jieshoudiQianwangTypesList = res.data.list;
               }
           });
       }



        //单个 接受地查询
        function initializationJieshoudi(id){
            layui.http.request("jieshoudi/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.jieshoudi = res.data;
                    vue.detail.jieshoudiId=vue.jieshoudi.id//赋值给detail
                }
            });
        }
        //列表 接受地查询
        function initializationJieshoudiList(){
            layui.http.request("jieshoudi/page?page=1&limit=100&sort=&order=", 'get', {}, function (res) {
                if(res.code ==0){
                    vue.jieshoudiList = res.data.list;
                }
            });
        }
        //单个 学生查询
        function initializationXuesheng(id){
            layui.http.request("xuesheng/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.xuesheng = res.data;
                    vue.detail.xueshengId=vue.xuesheng.id//赋值给detail
                }
            });
        }
        //列表 学生查询
        function initializationXueshengList(){
            layui.http.request("xuesheng/page?page=1&limit=100&sort=&order=", 'get', {}, function (res) {
                if(res.code ==0){
                    vue.xueshengList = res.data.list;
                }
            });
        }
    </script>
</body>
</html>
