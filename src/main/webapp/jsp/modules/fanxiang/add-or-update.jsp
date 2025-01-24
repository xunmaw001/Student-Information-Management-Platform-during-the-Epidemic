<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto"></ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑返校申请</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">返校申请管理</li>
                        <li class="breadcrumb-item active">编辑返校申请</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">返校申请信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa xuesheng">
                                        <label>学生</label>
                                        <div>
                                            <select style="width: 450px" id="xueshengSelect" name="xueshengSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 xuesheng">
                                        <label>学生姓名</label>
                                        <input style="width: 450px" id="xueshengName" name="xueshengName" placeholder="学生姓名" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 xuesheng">
                                        <label>学生手机号</label>
                                        <input style="width: 450px" id="xueshengPhone" name="xueshengPhone" placeholder="学生手机号" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 xuesheng">
                                        <label>学生头像</label>
                                        <img id="xueshengPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="xueshengId" name="xueshengId" type="hidden">
                                    <div class="form-group col-md-6 fanxiangUuidNumberDiv">
                                        <label>返校申请编号</label>
                                        <input style="width: 450px" id="fanxiangUuidNumber" name="fanxiangUuidNumber" class="form-control"
                                               placeholder="返校申请编号">
                                    </div>
                                    <div class="form-group col-md-6 fanxiangNameDiv">
                                        <label>申请标题</label>
                                        <input style="width: 450px" id="fanxiangName" name="fanxiangName" class="form-control"
                                               placeholder="申请标题">
                                    </div>
                                    <div class="form-group col-md-6 fanxiangAddressDiv">
                                        <label>现在地点</label>
                                        <input style="width: 450px" id="fanxiangAddress" name="fanxiangAddress" class="form-control"
                                               placeholder="现在地点">
                                    </div>
                                    <div class="form-group col-md-6 fanxiangFileDiv">
                                        <label>附件</label>
                                        <input name="file" type="file" class="form-control-file" id="fanxiangFileupload">
                                        <label id="fanxiangFileName"></label>
                                        <input name="fanxiangFile" id="fanxiangFile-input" type="hidden">
                                    </div>
                                    <div class="form-group col-md-6 fanxiangTypesDiv">
                                        <label>返校申请类型</label>
                                        <select style="width: 450px" id="fanxiangTypesSelect" name="fanxiangTypes" class="form-control"></select>
                                    </div>
                                    <div class="form-group col-md-6 fanxiangFangshiTypesDiv">
                                        <label>返校方式</label>
                                        <select style="width: 450px" id="fanxiangFangshiTypesSelect" name="fanxiangFangshiTypes" class="form-control"></select>
                                    </div>
                                    <div class="form-group col-md-6 fanxiangLujingDiv">
                                        <label>返校路径</label>
                                        <input style="width: 450px" id="fanxiangLujing" name="fanxiangLujing" class="form-control"
                                               placeholder="返校路径">
                                    </div>
                                    <div class="form-group col-md-6 daoxiaoTimeDiv">
                                        <label>预计到校日期</label>
                                        <input style="width: 450px" id="daoxiaoTime-input" name="daoxiaoTime" type="text" class="form-control layui-input">
                                    </div>
                                    <div class="form-group  col-md-6 fanxiangContentDiv">
                                        <label>申请缘由</label>
                                        <input id="fanxiangContentupload" name="file" type="file">
                                        <script id="fanxiangContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var fanxiangContentUe = UE.getEditor('fanxiangContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="fanxiangContent" id="fanxiangContent-input">
                                    </div>
                                    <div class="form-group-1 col-md-6 mb-3" style="display: flex;flex-wrap: wrap;">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate/card.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js" type="text/javascript" charset="utf-8"></script>
<!-- <script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script> -->
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file = "../../static/utils.js" %>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var sessionTable = window.sessionStorage.getItem("accountTableName");//登录账户所在表名
    var role         = window.sessionStorage.getItem("role");//权限
    var userId       = window.sessionStorage.getItem("userId");//当前登录人的id
    var tableName = "fanxiang";
    var pageType = "add-or-update";
    var updateId = "";
    var ruleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var fanxiangTypesOptions = [];
    var fanxiangFangshiTypesOptions = [];
    var fanxiangYesnoTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var xueshengOptions = [];

    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#fanxiangFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('fanxiangFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('fanxiangFileName').innerHTML = "上传成功!";
            }
        });


        $('#fanxiangContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('fanxiangContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '学生'){//当前登录用户不为这个
                if($("#xueshengId") !=null){
                    var xueshengId = $("#xueshengId").val();
                    if(xueshengId == null || xueshengId =='' || xueshengId == 'null'){
                        layui.layer.msg("学生不能为空", {time: 2000,icon: 5});
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("fanxiang/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addfanxiang');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        layui.layer.msg(successMes, {time: 2000,icon: 5});
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            layui.layer.msg("表单未填完整或有错误", {time: 2000,icon: 5});
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function fanxiangTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fanxiang_types", "GET", {}, (res) => {
                if(res.code == 0){
                    fanxiangTypesOptions = res.data.list;
                }
            });
        }
        function fanxiangFangshiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fanxiang_fangshi_types", "GET", {}, (res) => {
                if(res.code == 0){
                    fanxiangFangshiTypesOptions = res.data.list;
                }
            });
        }
        function fanxiangYesnoTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fanxiang_yesno_types", "GET", {}, (res) => {
                if(res.code == 0){
                    fanxiangYesnoTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function xueshengSelect() {
            //填充下拉框选项
            http("xuesheng/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    xueshengOptions = res.data.list;
                }
            });
        }

        function xueshengSelectOne(id) {
            http("xuesheng/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                    ruleForm = res.data;
                    xueshengShowImg();
                    xueshengShowVideo();
                    xueshengDataBind();
                }
            });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationFanxiangTypesSelect(){
            var fanxiangTypesSelect = document.getElementById('fanxiangTypesSelect');
            if(fanxiangTypesSelect != null && fanxiangTypesOptions != null  && fanxiangTypesOptions.length > 0 ){
                fanxiangTypesSelect.options.length=0;
                for (var i = 0; i < fanxiangTypesOptions.length; i++) {
                    fanxiangTypesSelect.add(new Option(fanxiangTypesOptions[i].indexName,fanxiangTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationFanxiangFangshiTypesSelect(){
            var fanxiangFangshiTypesSelect = document.getElementById('fanxiangFangshiTypesSelect');
            if(fanxiangFangshiTypesSelect != null && fanxiangFangshiTypesOptions != null  && fanxiangFangshiTypesOptions.length > 0 ){
                fanxiangFangshiTypesSelect.options.length=0;
                for (var i = 0; i < fanxiangFangshiTypesOptions.length; i++) {
                    fanxiangFangshiTypesSelect.add(new Option(fanxiangFangshiTypesOptions[i].indexName,fanxiangFangshiTypesOptions[i].codeIndex));
                }
            }
        }
        function initializationFanxiangYesnoTypesSelect(){
            var fanxiangYesnoTypesSelect = document.getElementById('fanxiangYesnoTypesSelect');
            if(fanxiangYesnoTypesSelect != null && fanxiangYesnoTypesOptions != null  && fanxiangYesnoTypesOptions.length > 0 ){
                fanxiangYesnoTypesSelect.options.length=0;
                for (var i = 0; i < fanxiangYesnoTypesOptions.length; i++) {
                    fanxiangYesnoTypesSelect.add(new Option(fanxiangYesnoTypesOptions[i].indexName,fanxiangYesnoTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationxueshengSelect() {
            var xueshengSelect = document.getElementById('xueshengSelect');
            if(xueshengSelect != null && xueshengOptions != null  && xueshengOptions.length > 0 ) {
                for (var i = 0; i < xueshengOptions.length; i++) {
                        xueshengSelect.add(new Option(xueshengOptions[i].xueshengName, xueshengOptions[i].id));
                }

                $("#xueshengSelect").change(function(e) {
                        xueshengSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        var fanxiangTypesSelect = document.getElementById("fanxiangTypesSelect");
        if(fanxiangTypesSelect != null && fanxiangTypesOptions != null  && fanxiangTypesOptions.length > 0 ) {
            for (var i = 0; i < fanxiangTypesOptions.length; i++) {
                if (fanxiangTypesOptions[i].codeIndex == ruleForm.fanxiangTypes) {//下拉框value对比,如果一致就赋值汉字
                        fanxiangTypesSelect.options[i].selected = true;
                }
            }
        }
        var fanxiangFangshiTypesSelect = document.getElementById("fanxiangFangshiTypesSelect");
        if(fanxiangFangshiTypesSelect != null && fanxiangFangshiTypesOptions != null  && fanxiangFangshiTypesOptions.length > 0 ) {
            for (var i = 0; i < fanxiangFangshiTypesOptions.length; i++) {
                if (fanxiangFangshiTypesOptions[i].codeIndex == ruleForm.fanxiangFangshiTypes) {//下拉框value对比,如果一致就赋值汉字
                        fanxiangFangshiTypesSelect.options[i].selected = true;
                }
            }
        }
        var fanxiangYesnoTypesSelect = document.getElementById("fanxiangYesnoTypesSelect");
        if(fanxiangYesnoTypesSelect != null && fanxiangYesnoTypesOptions != null  && fanxiangYesnoTypesOptions.length > 0 ) {
            for (var i = 0; i < fanxiangYesnoTypesOptions.length; i++) {
                if (fanxiangYesnoTypesOptions[i].codeIndex == ruleForm.fanxiangYesnoTypes) {//下拉框value对比,如果一致就赋值汉字
                        fanxiangYesnoTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var xueshengSelect = document.getElementById("xueshengSelect");
            if(xueshengSelect != null && xueshengOptions != null  && xueshengOptions.length > 0 ) {
                for (var i = 0; i < xueshengOptions.length; i++) {
                    if (xueshengOptions[i].id == ruleForm.xueshengId) {//下拉框value对比,如果一致就赋值汉字
                        xueshengSelect.options[i+1].selected = true;
                        $("#xueshengSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.fanxiangContent != null && ruleForm.fanxiangContent != 'null' && ruleForm.fanxiangContent != '' && $("#fanxiangContentupload").length>0) {

            var fanxiangContentUeditor = UE.getEditor('fanxiangContentEditor');
            fanxiangContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.fanxiangContent != null){
                    mes = ''+ ruleForm.fanxiangContent;
                    mes= mes.replaceAll("src=\"upload/","src=\""+baseUrl+"upload/")
                    // mes = mes.replace(/\n/g, "<br>");
                }
                fanxiangContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {
        <!-- 获取当前表的富文本框内容 -->
        if($("#fanxiangContentupload").length>0) {
            var fanxiangContentEditor = UE.getEditor('fanxiangContentEditor');
            if (fanxiangContentEditor.hasContents()) {
                $('#fanxiangContent-input').attr('value', fanxiangContentEditor.getContent().replaceAll(baseUrl,""));
            }
        }
    }
    function jiaofei() {
        window.location.href = "../../pay.jsp";
    }
    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addfanxiang');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                xueshengId: "required",
                fanxiangUuidNumber: "required",
                fanxiangName: "required",
                fanxiangAddress: "required",
                fanxiangFile: "required",
                fanxiangTypes: "required",
                fanxiangFangshiTypes: "required",
                fanxiangLujing: "required",
                daoxiaoTime: "required",
                fanxiangContent: "required",
                fanxiangYesnoTypes: "required",
                fanxiangYesnoText: "required",
                fanxiangShenheTime: "required",
            },
            messages: {
                xueshengId: "学生不能为空",
                fanxiangUuidNumber: "返校申请编号不能为空",
                fanxiangName: "申请标题不能为空",
                fanxiangAddress: "现在地点不能为空",
                fanxiangFile: "附件不能为空",
                fanxiangTypes: "返校申请类型不能为空",
                fanxiangFangshiTypes: "返校方式不能为空",
                fanxiangLujing: "返校路径不能为空",
                daoxiaoTime: "预计到校日期不能为空",
                fanxiangContent: "申请缘由不能为空",
                fanxiangYesnoTypes: "申请状态不能为空",
                fanxiangYesnoText: "回复话语不能为空",
                fanxiangShenheTime: "审核时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addfanxiang = window.sessionStorage.getItem("addfanxiang");
        if (addfanxiang != null && addfanxiang != "" && addfanxiang != "null") {
            //注册表单验证
            $(validform());
            $("#fanxiangUuidNumber").val(new Date().getTime()+Math.ceil(Math.random()*10));//设置唯一号
                $(".fanxiangYesnoTypesDiv").remove();
                $(".fanxiangYesnoTextDiv").remove();

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            if(window.sessionStorage.getItem('accountTableName') =='fanxiang'){
                updateId = window.sessionStorage.getItem('userId');//登录用户查看自己的信息
            }else{
                updateId = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            }
            window.sessionStorage.removeItem('updateId');
            http("fanxiang/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {

    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        xueshengDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#xueshengId").val(ruleForm.xueshengId);
        $("#fanxiangUuidNumber").val(ruleForm.fanxiangUuidNumber);
        $("#fanxiangName").val(ruleForm.fanxiangName);
        $("#fanxiangAddress").val(ruleForm.fanxiangAddress);
        $("#fanxiangLujing").val(ruleForm.fanxiangLujing);
        $("#daoxiaoTime-input").val(ruleForm.daoxiaoTime);
        $("#fanxiangContent").val(ruleForm.fanxiangContent);
        $("#fanxiangYesnoText").val(ruleForm.fanxiangYesnoText);
        $("#fanxiangShenheTime-input").val(ruleForm.fanxiangShenheTime);

    }
    <!--  级联表的数据回显  -->
    function xueshengDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#xueshengId").val(ruleForm.id);

        $("#xueshengName").val(ruleForm.xueshengName);
        $("#xueshengPhone").val(ruleForm.xueshengPhone);
        $("#xueshengIdNumber").val(ruleForm.xueshengIdNumber);
        $("#xueyuanValue").val(ruleForm.xueyuanValue);
        $("#banjiValue").val(ruleForm.banjiValue);
        $("#xueshengEmail").val(ruleForm.xueshengEmail);
        $("#jinyongValue").val(ruleForm.jinyongValue);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        xueshengShowImg();
    }


    <!--  级联表的图片  -->

    function xueshengShowImg() {
        $("#xueshengPhotoImg").attr("src",baseUrl+ruleForm.xueshengPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        xueshengShowVideo();
    }


    <!--  级联表的视频  -->

    function xueshengShowVideo() {
        $("#xueshengPhotoV").attr("src",baseUrl+ruleForm.xueshengPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            fanxiangTypesSelect();
            fanxiangFangshiTypesSelect();
            fanxiangYesnoTypesSelect();

            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            xueshengSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationFanxiangTypesSelect();
            initializationFanxiangFangshiTypesSelect();
            initializationFanxiangYesnoTypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationxueshengSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addfanxiang');
    });

    function readonly() {
        $('#fanxiangUuidNumber').attr('disabled', 'disabled');
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '学生') {
            // $(".aaaaaa").remove();
            $(".xuesheng").remove();//删除当前用户的信息
            if(sessionTable=="fanxiang"){//个人中心修改
            }
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }


        layui.use(['layer' , 'jquery' , 'laydate'], function() {
            var layer = layui.layer;
            var jquery = layui.jquery;
            var laydate = layui.laydate;

        var daoxiaoTime = laydate.render({
            elem: '#daoxiaoTime-input'
            ,type: 'datetime'
        });
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
        var fanxiangShenheTime = laydate.render({
            elem: '#fanxiangShenheTime-input'
            ,type: 'datetime'
        });
			// layui.layer.msg("输入不合法", {time: 2000,icon: 5});
			//    5失败 6成功
        });


        //比较大小
        function compare() {
            var largerVal = null;
            var smallerVal = null;
            if (largerVal != null && smallerVal != null) {
                if (largerVal <= smallerVal) {
                    alert(smallerName + '不能大于等于' + largerName);
                    return false;
                }
            }
            return true;
        }
    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
