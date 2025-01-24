<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="./xznstatic/css/common.css"/>
    <link rel="stylesheet" href="./xznstatic/css/style.css"/>

    <link rel="stylesheet" href="css/theme.css"/>
</head>
<body class='bodyClass' style="height: 100%;overflow: hidden">

<div id="header">
    <div v-if='true' class="nav-top">
        <img v-if='false' class="nav-top-img" src='http://codegen.caihongy.cn/20210122/43479e25bd0d45139de4e2e2eba0a312.jpg'>
        <div v-if="false" class="nav-top-title">{{projectName}}</div>
        <div class="nav-top-tel">欢迎来到{{projectName}}</div>
    </div>
    <div class="navs">
        <!-- <div class="logo" style="font-size: 20px;top: 32px;color: #fff;font-weight: bold;margin-left: -200px;width: 240px;" v-text="projectName"></div> -->
        <div class="title" v-if="true" v-text="projectName"></div>
        <div class="list">
            <ul>
                <li class='current'><a href="javascript:navPage('./pages/home/home.jsp')" class="menumain"><i v-if="false" class="layui-icon layui-icon-home"></i>首页</a></li>
                <li v-for="(item,index) in indexNav" v-bind:key="index"><a :href="'javascript:navPage(\''+item.url+'\')'" class="menumain" style="cursor: pointer;"><i v-if="false" class="layui-icon" :class="iconArr[index]"></i>{{item.name}}</a></li>
                <li><a href="javascript:centerPage();" class="menumain"><i v-if="false" class="layui-icon layui-icon-username"></i>个人中心</a></li>
            </ul>
        </div>
    </div>
</div>


<div style="height: 85vh" class="homeHeight">
    <iframe src="./pages/home/home.jsp" id="iframe" frameborder="0" scrolling="auto"style="width:100%;height: 100%;" onload="changeFrameHeight"></iframe>
</div>


<script src="./xznstatic/js/jquery-1.11.3.min.js"></script>
<script src="./layui/layui.js"></script>
<script src="./js/vue.js"></script>
<!-- 引入element组件库 -->
<script src="xznstatic/js/element.min.js"></script>
<!-- 引入element样式 -->
<link rel="stylesheet" href="xznstatic/css/element.min.css">
<script src="./js/config.js"></script>

<script>
    var vue1 = new Vue({el: '#tabbar'})

    var vue = new Vue({
        el: '#header',
        data: {
            iconArr: ['layui-icon-gift','layui-icon-email','layui-icon-logout','layui-icon-transfer','layui-icon-slider','layui-icon-print','layui-icon-cols','layui-icon-snowflake','layui-icon-note','layui-icon-flag','layui-icon-theme','layui-icon-website','layui-icon-console','layui-icon-face-surprised','layui-icon-template-1','layui-icon-app','layui-icon-read','layui-icon-component','layui-icon-file-b','layui-icon-unlink','layui-icon-tabs','layui-icon-form','layui-icon-chat'],
            indexNav: indexNav,
            adminurl: adminurl,
            projectName: projectName,
            url:"./pages/home/home.jsp",
        },
        mounted: function() {
            this.bindClickOnLi();
        },
        created() {
            this.iconArr.sort(()=>{
                return (0.5-Math.random())
        })
        },
        methods: {
            jump(url) {
                jump(url)
            },
            bindClickOnLi() {
                let list = document.getElementsByTagName("li");
                for(var i = 0;i<list.length;i++){
                    list[i].onclick = function(){
                        $(this).addClass("current").siblings().removeClass("current");
                    }
                }
            }
        }
    });

    layui.use(['element','layer', 'http'], function() {
        var element = layui.element;
        var layer = layui.layer;
        var http = layui.http;

        //用于跳转所需要的路径
        if(localStorage.getItem("goUtl") != null){
            vue.url = localStorage.getItem("goUtl")
            localStorage.removeItem("goUtl")
        }else if(http.getParam('url') != null){
            vue.url = http.getParam('url')
        }

        document.getElementById('iframe').src = vue.url;

    });

    function chatTap(){
        var userTable = localStorage.getItem('userTable');
        if (userTable) {
            layui.layer.open({
                type: 2,
                title: '客服',
                area: ['600px', '600px'],
                content: './pages/chat/list.jsp'
            });
        } else {
            window.location.href = './pages/login/login.jsp'
        }
    }

    // 导航栏跳转
    function navPage(url) {
        localStorage.setItem('iframeUrl', url);
        document.getElementById('iframe').src = url;
    }

    // 跳转到个人中心也
    function centerPage() {
        var userTable = localStorage.getItem('userTable');
        if (userTable) {
            localStorage.setItem('iframeUrl', './pages/' + userTable + '/center.jsp');
            document.getElementById('iframe').src = './pages/' + userTable + '/center.jsp';
        } else {
            window.location.href = './pages/login/login.jsp'
        }
    }

    var iframeUrl = localStorage.getItem('iframeUrl');
    document.getElementById('iframe').src = iframeUrl  || './pages/home/home.jsp';

    // var i = 0;
    setInterval(function(){
        // i++;
        // if(i<50) changeFrameHeight();
        changeFrameHeight();
    },200)

    function changeFrameHeight() {
        var iframe = document.getElementById('iframe');
        // iframe.height = 'auto';
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.body.scrollHeight;
            }
        }
    };

    //  窗口变化时候iframe自适应
    // function changeFrameHeight() {
    // var header = document.getElementById('header').scrollHeight;
    //     let isshow = true
    //     var tabbar = 0
    //     if(isshow) {
    //       tabbar = document.getElementById('tabbar').scrollHeight
    //     }
    // var ifm = document.getElementById("iframe");
    // ifm.height = document.documentElement.clientHeight - header - tabbar;
    // ifm.width = document.documentElement.clientWidth;
    // }

    // reasize 事件 窗口大小变化后执行的方法
    window.onresize = function() {
        changeFrameHeight();
    }
</script>
</body>
</html>
