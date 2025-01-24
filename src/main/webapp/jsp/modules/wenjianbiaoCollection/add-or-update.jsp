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
                    <h3 class="block-title">编辑学校文件收藏</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">学校文件收藏管理</li>
                        <li class="breadcrumb-item active">编辑学校文件收藏</li>
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
                        <h3 class="widget-title">学校文件收藏信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa wenjianbiao">
                                        <label>学校文件</label>
                                        <div>
                                            <select style="width: 450px" id="wenjianbiaoSelect" name="wenjianbiaoSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 wenjianbiao">
                                        <label>文件名称</label>
                                        <input style="width: 450px" id="wenjianbiaoName" name="wenjianbiaoName" placeholder="文件名称" class="form-control" readonly>
                                    </div>
                                    <div class="form-group col-md-6 wenjianbiao">
                                        <label>文件照片</label>
                                        <img id="wenjianbiaoPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 wenjianbiao">
                                        <label>学校文件类型</label>
                                        <input style="width: 450px" id="wenjianbiaoValue" name="wenjianbiaoValue" placeholder="学校文件类型" class="form-control" readonly>
                                    </div>
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
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="wenjianbiaoId" name="wenjianbiaoId" type="hidden">
                                <input id="xueshengId" name="xueshengId" type="hidden">
                                    <div class="form-group col-md-6 wenjianbiaoCollectionTypesDiv">
                                        <label>类型</label>
                                        <select style="width: 450px" id="wenjianbiaoCollectionTypesSelect" name="wenjianbiaoCollectionTypes" class="form-control"></select>
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
    var tableName = "wenjianbiaoCollection";
    var pageType = "add-or-update";
    var updateId = "";
    var ruleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var wenjianbiaoCollectionTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var wenjianbiaoOptions = [];
    var xueshengOptions = [];

    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '学校文件'){//当前登录用户不为这个
                if($("#wenjianbiaoId") !=null){
                    var wenjianbiaoId = $("#wenjianbiaoId").val();
                    if(wenjianbiaoId == null || wenjianbiaoId =='' || wenjianbiaoId == 'null'){
                        layui.layer.msg("学校文件不能为空", {time: 2000,icon: 5});
                        return;
                    }
                }
            }
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
            httpJson("wenjianbiaoCollection/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addwenjianbiaoCollection');
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
        function wenjianbiaoCollectionTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=wenjianbiao_collection_types", "GET", {}, (res) => {
                if(res.code == 0){
                    wenjianbiaoCollectionTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function wenjianbiaoSelect() {
            //填充下拉框选项
            http("wenjianbiao/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    wenjianbiaoOptions = res.data.list;
                }
            });
        }

        function wenjianbiaoSelectOne(id) {
            http("wenjianbiao/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                    ruleForm = res.data;
                    wenjianbiaoShowImg();
                    wenjianbiaoShowVideo();
                    wenjianbiaoDataBind();
                }
            });
        }
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
        function initializationWenjianbiaoCollectionTypesSelect(){
            var wenjianbiaoCollectionTypesSelect = document.getElementById('wenjianbiaoCollectionTypesSelect');
            if(wenjianbiaoCollectionTypesSelect != null && wenjianbiaoCollectionTypesOptions != null  && wenjianbiaoCollectionTypesOptions.length > 0 ){
                wenjianbiaoCollectionTypesSelect.options.length=0;
                for (var i = 0; i < wenjianbiaoCollectionTypesOptions.length; i++) {
                    wenjianbiaoCollectionTypesSelect.add(new Option(wenjianbiaoCollectionTypesOptions[i].indexName,wenjianbiaoCollectionTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationwenjianbiaoSelect() {
            var wenjianbiaoSelect = document.getElementById('wenjianbiaoSelect');
            if(wenjianbiaoSelect != null && wenjianbiaoOptions != null  && wenjianbiaoOptions.length > 0 ) {
                for (var i = 0; i < wenjianbiaoOptions.length; i++) {
                        wenjianbiaoSelect.add(new Option(wenjianbiaoOptions[i].wenjianbiaoName, wenjianbiaoOptions[i].id));
                }

                $("#wenjianbiaoSelect").change(function(e) {
                        wenjianbiaoSelectOne(e.target.value);
                });
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
        var wenjianbiaoCollectionTypesSelect = document.getElementById("wenjianbiaoCollectionTypesSelect");
        if(wenjianbiaoCollectionTypesSelect != null && wenjianbiaoCollectionTypesOptions != null  && wenjianbiaoCollectionTypesOptions.length > 0 ) {
            for (var i = 0; i < wenjianbiaoCollectionTypesOptions.length; i++) {
                if (wenjianbiaoCollectionTypesOptions[i].codeIndex == ruleForm.wenjianbiaoCollectionTypes) {//下拉框value对比,如果一致就赋值汉字
                        wenjianbiaoCollectionTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var wenjianbiaoSelect = document.getElementById("wenjianbiaoSelect");
            if(wenjianbiaoSelect != null && wenjianbiaoOptions != null  && wenjianbiaoOptions.length > 0 ) {
                for (var i = 0; i < wenjianbiaoOptions.length; i++) {
                    if (wenjianbiaoOptions[i].id == ruleForm.wenjianbiaoId) {//下拉框value对比,如果一致就赋值汉字
                        wenjianbiaoSelect.options[i+1].selected = true;
                        $("#wenjianbiaoSelect" ).selectpicker('refresh');
                    }
                }
            }
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
    }
    // 获取富文本框内容
    function getContent() {
        <!-- 获取当前表的富文本框内容 -->
    }
    function jiaofei() {
        window.location.href = "../../pay.jsp";
    }
    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addwenjianbiaoCollection');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                wenjianbiaoId: "required",
                xueshengId: "required",
                wenjianbiaoCollectionTypes: "required",
            },
            messages: {
                wenjianbiaoId: "学校文件不能为空",
                xueshengId: "学生不能为空",
                wenjianbiaoCollectionTypes: "类型不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addwenjianbiaoCollection = window.sessionStorage.getItem("addwenjianbiaoCollection");
        if (addwenjianbiaoCollection != null && addwenjianbiaoCollection != "" && addwenjianbiaoCollection != "null") {
            //注册表单验证
            $(validform());

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            if(window.sessionStorage.getItem('accountTableName') =='wenjianbiaoCollection'){
                updateId = window.sessionStorage.getItem('userId');//登录用户查看自己的信息
            }else{
                updateId = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            }
            window.sessionStorage.removeItem('updateId');
            http("wenjianbiaoCollection/info/" + updateId, "GET", {}, (res) => {
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
        wenjianbiaoDataBind();
        xueshengDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#wenjianbiaoId").val(ruleForm.wenjianbiaoId);
        $("#xueshengId").val(ruleForm.xueshengId);

    }
    <!--  级联表的数据回显  -->
    function wenjianbiaoDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#wenjianbiaoId").val(ruleForm.id);

        $("#wenjianbiaoName").val(ruleForm.wenjianbiaoName);
        $("#wenjianbiaoUuidNumber").val(ruleForm.wenjianbiaoUuidNumber);
        $("#zanNumber").val(ruleForm.zanNumber);
        $("#caiNumber").val(ruleForm.caiNumber);
        $("#wenjianbiaoValue").val(ruleForm.wenjianbiaoValue);
        $("#wenjianbiaoContent").val(ruleForm.wenjianbiaoContent);
        $("#shangxiaValue").val(ruleForm.shangxiaValue);
    }

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
        wenjianbiaoShowImg();
        xueshengShowImg();
    }


    <!--  级联表的图片  -->

    function wenjianbiaoShowImg() {
        $("#wenjianbiaoPhotoImg").attr("src",baseUrl+ruleForm.wenjianbiaoPhoto);
    }


    function xueshengShowImg() {
        $("#xueshengPhotoImg").attr("src",baseUrl+ruleForm.xueshengPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        wenjianbiaoShowVideo();
        xueshengShowVideo();
    }


    <!--  级联表的视频  -->

    function wenjianbiaoShowVideo() {
        $("#wenjianbiaoPhotoV").attr("src",baseUrl+ruleForm.wenjianbiaoPhoto);
    }

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
            wenjianbiaoCollectionTypesSelect();

            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            wenjianbiaoSelect();
            xueshengSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationWenjianbiaoCollectionTypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationwenjianbiaoSelect();
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
        window.sessionStorage.removeItem('addwenjianbiaoCollection');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '学生') {
            // $(".aaaaaa").remove();
            $(".xuesheng").remove();//删除当前用户的信息
            if(sessionTable=="wenjianbiaoCollection"){//个人中心修改
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

        var insertTime = laydate.render({
            elem: '#insertTime-input'
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
