<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学校文件详情页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css">
</head>
<style>
    /*padding-bottom 属性设置元素的下内边距（底部空白）*/
    .pb-120 {
        padding-bottom: 50px;
    }
    /*padding-top 属性设置元素的上内边距（头部空白）*/
    .pt-120 {
        padding-top: 20px;
    }

    .cmn-accordion .card-header .acc-btn .plus-icon::after {
        position: absolute;
        content: '';
        top: 50%;
        left: 50%;
        height: 25px;
        width: 1px;
        background-color: #bec452;
        -webkit-transform: translate(-50%, -50%) rotate(90deg);
        -ms-transform: translate(-50%, -50%) rotate(90deg);
        transform: translate(-50%, -50%) rotate(90deg);
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    .cmn-accordion .card-body {
        padding: 0;
    }

    blockquote {
        padding: 0 50px;
    }

    @media (max-width: 767px) {
        blockquote {
            padding: 0 30px;
        }
    }

    blockquote p {
        font-size: 24px;
        font-style: italic;
        text-align: center;
        font-family: "Playfair Display", serif;
    }

    @media (max-width: 767px) {
        blockquote p {
            font-size: 20px;
        }
    }


    /* 评论样式 和文本框样式 */
    body {
        font-family: "Raleway", sans-serif;
        font-size: 16px;
        padding: 0;
        margin: 0;
        font-weight: 400;
        position: relative;
        overflow-x: hidden;
    }

    img {
        max-width: 100%;
        height: auto;
    }

    ul, ol {
        padding: 0;
        margin: 0;
        list-style: none;
    }

    button {
        border: none;
    }

    input, textarea {
        padding: 10px 20px;
        border: 1px solid #e5e5e5;
        width: 100%;
        background-color: #ffffff;
    }


    textarea {
        min-height: 150px;
        resize: none;
    }

    /* 标题下面的蓝色字体 删除就会换行 */

    .post-meta {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        margin: 0 -8px;
        margin-top: 5px;
    }

    .post-meta li {
        margin: 3px 8px;
    }

    .post-meta li a {
        font-size: 12px;
    }


    .blog-single-classic .content {
        margin-top: 25px;
    }



    /* 博客详情部分 css start */
    .blog-details-wrapper .blog-details-header {
        margin-top: 25px;
        padding-bottom: 15px;
        border-bottom: 1px solid #e5e5e5;
    }



    .comments-area {
        margin-top: 50px;
    }

    .comments-area .title {
        text-transform: capitalize;
        margin-bottom: 30px;
    }

    .comments-list .single-comment {
        display: flex;
        flex-wrap: wrap;
        padding: 30px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    .comments-list .single-comment:first-child {
        padding-top: 0;
    }

    .comments-list .single-comment:last-child {
        padding-bottom: 0;
        border-bottom: none;
    }

    .comments-list .single-comment .thumb {
        flex: 0 0 80px;
        -ms-flex: 0 0 80px;
        max-width: 80px;
        height: 80px;
        border-radius: 50%;
        -webkit-border-radius: 50%;
        -moz-border-radius: 50%;
        -ms-border-radius: 50%;
        -o-border-radius: 50%;
        overflow: hidden;
    }

    .comments-list .single-comment .content {
        flex: 0 0 calc(100% - 80px);
        -ms-flex: 0 0 calc(100% - 80px);
        max-width: calc(100% - 80px);
        padding-left: 20px;
    }



    .comments-list .single-comment .content .date {
        font-size: 14px;
    }

    .comments-list .single-comment .content p {
        margin-top: 5px;
    }

    .comments-list .single-comment .content .comment-action {
        margin-top: 3px;
    }

    .comment-form-area {
        margin-top: 50px;
    }

    .comment-form-area .title {
        margin-bottom: 30px;
    }

    .comment-form-area .comment-form .form-group {
        margin-bottom: 30px;
    }

    .sidebar .widget + .widget {
        margin-top: 50px;
    }


    .sidebar .widget-title {
        font-size: 24px;
        text-transform: capitalize;
        margin-bottom: 30px;
        position: relative;
        padding-left: 15px;
    }

    .sidebar .widget-title::before {
        position: absolute;
        content: '';
        top: 4px;
        left: 0;
        width: 5px;
        height: 23px;
        background-color: var(--publicMainColor);
    }

    .sidebar .category-list li {
        padding: 10px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    /*位置为 Latest Blog Post 意思 最新博客 样式*/
    .small-post-list .small-post-single:first-child {
        padding-top: 0;
    }
    .small-post-list .small-post-single {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        padding: 20px 0;
        border-bottom: 1px solid #e5e5e5;
    }

    .small-post-list .small-post-single .content {
        width: calc(100% - 65px);
        padding-left: 15px;
    }



    /* 侧边栏 css end */

    .cmn-btn-border {
        padding: 13px 35px;
        font-size: 18px;
        text-transform: capitalize;
        color: #ffffff;
        background-color: var(--publicMainColor);
        position: relative;
        z-index: 1;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
        border-radius: 3px;
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        -ms-border-radius: 3px;
        -o-border-radius: 3px;
    }

    .cmn-btn-border:hover {
        color: #ffffff;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.15);
    }

    .cmn-btn-border:hover::before {
        top: 0;
        left: 0;
    }

    .cmn-btn-border::before {
        position: absolute;
        content: '';
        top: -5px;
        left: -5px;
        width: 100%;
        height: 100%;
        background-color: var(--publicMainColor);
        z-index: -10;
        border: 2px solid #ffffff;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }

    .cmn-btn-border::after {
        position: absolute;
        content: '';
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: var(--publicMainColor);
        z-index: -10;
        border: 2px solid #ffffff;
    }

    .blog-details-wrapper .blog-details-footer {
        padding: 20px 20px;
        border: 1px solid #f2f2f2;
        margin-top: 40px;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        justify-content: space-between;
    }</style>
<body>

    <div id="app">
    <section class="blog-details-section pt-120 pb-120">
        <div class="sub_backgroundColor data-detail-breadcrumb" style="width: 1110px;"
             :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"20px auto","borderColor":"rgba(135, 206, 250, 1)","borderRadius":"4px","borderWidth":"0","borderStyle":"solid","height":"54px"}'>
                <span class="layui-breadcrumb">
                    <a class="first"
                       :style='{"padding":"8px 10px","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"0 5px","borderColor":"rgba(255,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(14, 14, 14, 1)","borderRadius":"0","borderWidth":"0","fontSize":"16px","borderStyle":"solid"}'
                       href="../home/home.jsp">
                        首页
                    </a>
                    <a>
                        <cite :style='{"padding":"8px 15px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 15px","borderColor":"rgba(255,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(129, 84, 118, 1)","borderRadius":"4px","borderWidth":"0","fontSize":"16px","borderStyle":"solid"}'>
                            {{title}}
                        </cite>
                    </a>
                </span>
                <a v-if='storeupFlag' class="main_backgroundColor"
                   :style='{"padding":"0 12px","boxShadow":"0 0 0px rgba(255,0,0,.3)","borderColor":"rgba(255,0,0,.3)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"0","fontSize":"16px","lineHeight":"34px","borderStyle":"solid"}'
                   @click="addWenjianbiaoCollection()" href="javascript:void(0)">
                    <i class="layui-icon" style="font-size: 20px;color: red;" v-if='true'
                       :style='{"color":"rgba(255, 255, 255, 1)","padding":"0 2px 0 0","fontSize":"18px"}'>&#xe67a;</i>取消收藏
                </a>
                <a v-if='!storeupFlag' class="main_backgroundColor"
                   :style='{"padding":"0 12px","boxShadow":"0 0 0px rgba(255,0,0,.3)","borderColor":"rgba(255,0,0,.3)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"0","fontSize":"16px","lineHeight":"34px","borderStyle":"solid"}'
                   @click="addWenjianbiaoCollection()" href="javascript:void(0)">
                    <i class="layui-icon" style="font-size: 20px;color: red;" v-if='true'
                       :style='{"color":"rgba(255, 255, 255, 1)","padding":"0 2px 0 0","fontSize":"18px"}'>&#xe67b;</i>点我收藏
                </a>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="blog-details-wrapper">
                        <div class="thumb">
                            <img :src="baseUrl+detail.wenjianbiaoPhoto" alt="image">
                        </div>
                        <div class="blog-details-header">
                            <h3 class="blog-details-title">{{title}}</h3>
                            <ul class="post-meta">
                                <li v-if="detail.wenjianbiaoUuidNumber">学校文件编号：
                                    {{detail.wenjianbiaoUuidNumber}}
                                </li>
                                <li v-if="detail.zanNumber">赞：
                                    {{detail.zanNumber}}
                                </li>
                                <li v-if="detail.caiNumber">踩：
                                    {{detail.caiNumber}}
                                </li>
                                <li v-if="detail.wenjianbiaoTypes">学校文件类型：
                                    {{detail.wenjianbiaoValue}}
                                </li>
                            </ul>

                            <ul class="post-meta">
                                <li>
                                                                        <a style="color: var(--publicMainColor)"
                                       @click="jump(baseUrl+detail.wenjianbiaoFile)">
                                        文件下载
                                    </a>
                                </li>
                            </ul>

                        <!-- <div style="padding: 20px;border: 0px solid #f2f2f2;margin-top: 20px;display: flex">
                                 <div class="num-picker">
                                     <button @click="wenjianbiaoYuyue()" style="height:auto;" :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(255,0,0,.3)","margin":"0 5px","borderColor":"rgba(0,0,0,.3)","backgroundColor":"rgba(23, 124, 176, 1)","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","lineHeight":"40px","fontSize":"16px","borderStyle":"solid"}' type="button" class="layui-btn btn-submit">
                                         立即预约
                                     </button>
                                 </div>
                             </div>-->
                        </div>
                        <div class="blog-details-content" v-html="myFilters(detail.wenjianbiaoContent)">
                        </div>
                        <div class="blog-details-footer">
                            <!-- 没有赞 没有踩 -->
                            <button v-if="zanFlag == 0 && caiFlag == 0" class="post-tags-list" @click="zanNumberClick"
                                    style="background-color: #a8e95b;margin:0px 5%;width: 40%;height: 50px">
                                赞 &nbsp; {{detail.zanNumber}}
                            </button>
                            <button v-if="zanFlag == 0 && caiFlag == 0" class="post-share-links" @click="caiNumberClick"
                                    style="background-color: #ffcf61;margin:0px 5%;width: 40%;height: 50px">
                                踩 &nbsp; {{detail.caiNumber}}
                            </button>

                            <!-- 已赞 -->
                            <button v-if="zanFlag == 1" class="post-tags-list" @click="zanNumberClick"
                                    style="background-color: #a8e95b;margin:0px 5%;width: 40%;height: 50px">
                                已赞 &nbsp; {{detail.zanNumber}}
                            </button>

                            <!-- 已踩 -->
                            <button v-if="caiFlag == 1" class="post-share-links" @click="caiNumberClick"
                                    style="background-color: #ffcf61;margin:0px 5%;width: 40%;height: 50px">
                                已踩 &nbsp; {{detail.caiNumber}}
                            </button>
                        </div>
                    </div>

                </div>
                <div class="col-lg-4" v-if="wenjianbiaoRecommendList">
                    <div class="sidebar">
                        <div class="widget">
                            <h3 class="widget-title">系统推荐</h3>
                            <ul class="small-post-list">
                                <li class="small-post-single" v-for="(item,index) in wenjianbiaoRecommendList"
                                    v-bind:key="index"
                                    @click="jump('../wenjianbiao/detail.jsp?id='+item.id)">
                                    <div class="thumb"><img width="65px" :src="baseUrl+item.wenjianbiaoPhoto"
                                                            alt="image">
                                    </div>
                                    <div class="content">
                                        <a class="main_color" class="date">{{item.wenjianbiaoName}}</a>
                                        <h6 v-if="item.wenjianbiaoNewMoney" class="post-title"><a
                                                style="color: red">{{item.wenjianbiaoNewMoney}}</a>RMB</h6>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>    </div>


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

    <script>
        Vue.prototype.myFilters= function (msg) {
            if(msg != null){
                return msg.replace(/\n/g, "<br>");
            }else{
                return "";
            }
        };
        var vue = new Vue({
            el: '#app',
            data: {
                userId: localStorage.getItem("userid"),//当前登录人的id
                sessionTable: localStorage.getItem("userTable"),//登录账户所在表名
                role: localStorage.getItem("role"),//权限
                user:{},//当前登录用户信息
                // 轮播图
                swiperList: [],//用于当前表的图片
                // 数据详情
                detail: {
                    id: 0
                },
                // 商品标题
                title: '',
                totalScore: 0,//评分
                baseUrl:"",//路径
                storeupFlag: 0,//收藏 [0为收藏 1已收藏]
                zanFlag: 0,//赞 [0 未赞 1 已赞]
                caiFlag: 0,//踩 [0 未踩 1 已踩]
                //系统推荐
                wenjianbiaoRecommendList: [],
                    // 当前详情页表
                detailTable: 'wenjianbiao',
            },
            methods: {
                //分享
                share(){
                    let element = createElement("http://localhost:8080/yqxueshengxinxi/front/index.jsp?url="+"./pages/wenjianbiao/detail.jsp?id="+this.id);
                    element.select();
                    element.setSelectionRange(0, element.value.length);
                    document.execCommand('copy');
                    element.remove();
                    layui.layer.msg('复制分享页面成功,快去分享吧!', {time: 2000,icon: 6});
                },

                jump(url) {
                    jump(url)
                },
                isAuth(tablename, button) {
                    return isFrontAuth(tablename, button)
                },
                //预约
                wenjianbiaoYuyue(){
                    let _this = this;
                    var mymessage = confirm("确定要预约吗？");if(!mymessage){return false;}
                    // localStorage.setItem('wenjianbiaoId', _this.detail.id);
                    // _this.jump("../wenjianbiaoOrder/add.jsp");

                    let data={
                        wenjianbiaoId:_this.detail.id,
                        xueshengId:localStorage.getItem("userid"),
                        wenjianbiaoOrderYesnoTypes:1,
                    }
                    // 提交数据
                    layui.http.requestJson('wenjianbiaoOrder/add', 'post', data, function (res) {
                        if(res.code == 0) {
                            layui.layer.msg('预约成功', {
                                time: 2000,
                                icon: 6
                            }, function () {
                                _this.jump("../wenjianbiaoOrder/list.jsp");
                            });
                        }else{
                            layui.layer.msg(res.msg, {
                                time: 5000,
                                icon: 5
                            });
                        }
                    });
                },
                // 收藏商品
                addWenjianbiaoCollection() {
                    let _this = this;
                    layui.http.request('wenjianbiaoCollection/list', 'get', {
                        page: 1,
                        limit: 1,
                        wenjianbiaoId: _this.detail.id,
                        wenjianbiaoCollectionTypes: 1,
                        xueshengId: localStorage.getItem('userid'),
                    }, (res) => {
                        if (res.data.list.length == 1) {
                            layui.http.requestJson('wenjianbiaoCollection/delete', 'post', [res.data.list[0].id], function (res) {
                                layui.layer.msg('取消成功', {
                                    time: 1000,
                                    icon: 5
                                }, function () {
                                    window.location.reload();
                                });
                            });
                            return false;
                        }
                        layui.http.requestJson('wenjianbiaoCollection/add', 'post', {
                            xueshengId: localStorage.getItem('userid'),
                            wenjianbiaoId: _this.detail.id,
                            wenjianbiaoCollectionTypes: 1,
                        }, function (res) {
                            layui.layer.msg('收藏成功', {
                                time: 1000,
                                icon: 6
                            }, function () {
                                window.location.reload();
                            });
                        });
                    });
                },
                // 赞
                zanNumberClick() {
                    let _this = this;
                    layui.http.request('wenjianbiaoCollection/list', 'get', {
                        page: 1,
                        limit: 1,
                        wenjianbiaoId: _this.detail.id,
                        wenjianbiaoCollectionTypes: 2,
                        xueshengId: localStorage.getItem('userid'),
                    }, (res) => {
                        if (res.data.total == 1) {
                            layui.http.requestJson('wenjianbiaoCollection/delete', 'post', [res.data.list[0].id], function (res) {
                                _this.detail.zanNumber = _this.detail.zanNumber - 1;
                                layui.http.requestJson(`wenjianbiao/update`, 'POST', _this.detail, (res1) => {
                                    if(res1.code==0){
                                        layui.layer.msg('取消点赞成功', {
                                            time: 1000,
                                            icon: 6
                                        }, function () {
                                            _this.zanFlag =0;
                                        });
                                    }else{
                                        layui.layer.msg('取消点赞失败', {
                                            time: 1000,
                                            icon: 5
                                        }, function () {
                                            return false;
                                        });
                                    }
                                });
                            });
                        }else{
                            layui.http.requestJson('wenjianbiaoCollection/add', 'post', {
                                    xueshengId: localStorage.getItem('userid'),
                                    wenjianbiaoId: _this.detail.id,
                                    wenjianbiaoCollectionTypes: 2,
                            }, function (res) {
                                _this.detail.zanNumber = _this.detail.zanNumber + 1;
                                layui.http.requestJson(`wenjianbiao/update`, 'POST', _this.detail, (res1) => {
                                    if(res1.code==0){
                                        layui.layer.msg('点赞成功', {
                                            time: 1000,
                                            icon: 6
                                        }, function () {
                                            _this.zanFlag =1;
                                        });
                                    }else{
                                        layui.layer.msg('点赞失败', {
                                            time: 1000,
                                            icon: 5
                                        }, function () {
                                            return false;
                                        });
                                    }
                                });
                            });
                        }
                    });
                },

                // 踩
                caiNumberClick() {
                    let _this = this;
                    layui.http.request('wenjianbiaoCollection/list', 'get', {
                        page: 1,
                        limit: 1,
                            wenjianbiaoId: _this.detail.id,
                            wenjianbiaoCollectionTypes: 3,
                            xueshengId: localStorage.getItem('userid'),
                    }, (res) => {
                        if (res.data.total == 1) {
                            layui.http.requestJson('wenjianbiaoCollection/delete', 'post', [res.data.list[0].id], function (res) {

                                _this.detail.caiNumber = _this.detail.caiNumber - 1;
                                layui.http.requestJson(`wenjianbiao/update`, 'POST',_this.detail , (res1) => {
                                    if(res1.code==0){
                                        layui.layer.msg('取消点踩成功', {
                                            time: 1000,
                                            icon: 6
                                        }, function () {
                                            _this.caiFlag =0;
                                        });
                                    }else{
                                        layui.layer.msg('取消点踩失败', {
                                            time: 1000,
                                            icon: 5
                                        }, function () {
                                            return false;
                                        });
                                    }
                                });
                            });
                        }else{
                            layui.http.requestJson('wenjianbiaoCollection/add', 'post', {
                                    xueshengId: localStorage.getItem('userid'),
                                    wenjianbiaoId: _this.detail.id,
                                    wenjianbiaoCollectionTypes: 3,
                            }, function (res) {
                                _this.detail.caiNumber = _this.detail.caiNumber + 1;
                                layui.http.requestJson(`wenjianbiao/update`, 'POST', _this.detail, (res1) => {
                                    if(res1.code==0){
                                        layui.layer.msg('点踩成功', {
                                            time: 1000,
                                            icon: 6
                                        }, function () {
                                            _this.caiFlag =1;
                                        });
                                    }else{
                                        layui.layer.msg('点踩失败', {
                                            time: 1000,
                                            icon: 5
                                        }, function () {
                                            return false;
                                        });
                                    }
                                });
                            });
                        }
                    });
                },

                }
        });

        layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage', 'util'], function () {
            var layer = layui.layer;
            var util = layui.util;
            var element = layui.element;
            var form = layui.form;
            var carousel = layui.carousel;
            var http = layui.http;
            var jquery = layui.jquery;
            var laypage = layui.laypage;
            vue.baseUrl = http.baseurl

            localStorage.setItem("goUtl","./pages/wenjianbiao/detail.jsp?id="+ http.getParam('id'))

            var limit = 10;

            let table = localStorage.getItem("userTable");
            if(table){
                http.request(table+"/session", 'get', {}, function (data) {
                    vue.user = data.data;
                });
            }

            // 数据ID
            var id = http.getParam('id');
            vue.detail.id = id;
            // 数据信息
            http.request(`${vue.detailTable}/detail/` + id, 'get', {}, function (res) {
                // 详情信息
                vue.detail = res.data;
                vue.title = vue.detail.wenjianbiaoName;
                vue.detail.wenjianbiaoContent = vue.detail.wenjianbiaoContent.replaceAll("src=\"upload/","src=\""+vue.baseUrl+"upload/");
                // 轮播图片
                vue.swiperList = vue.detail.wenjianbiaoPhoto ? vue.detail.wenjianbiaoPhoto.split(",") : [];
                // 轮播图
                vue.$nextTick(() => {
                    carousel.render({
                        elem: '#swiper',
                        width: '420px',
                        height: '400px',
                        arrow: 'hover',
                        anim: 'default',
                        autoplay: 'true',
                        interval: '3000',
                        indicator: 'inside'
                    });
                });

            });


            // 系统推荐
            http.request(`wenjianbiao/gexingtuijian`, 'get', {
                page: 1,
                limit: 5,
                wenjianbiaoTypes: vue.detail.wenjianbiaoTypes,
                wenjianbiaoDelete: 1,
                shangxiaTypes: 1,//上架的
            }, function (res) {
                vue.wenjianbiaoRecommendList = res.data.list;
            });

            if (localStorage.getItem('userid')) {
                http.request('wenjianbiaoCollection/list', 'get', {
                    page: 1,
                    limit: 1,
                    wenjianbiaoId: vue.detail.id,
                    xueshengId: localStorage.getItem('userid'),
                }, function (res) {
                    if(res.data.total >0){
                        res.data.list.forEach(element => {
                            if (element.wenjianbiaoCollectionTypes == 1) {
                                vue.storeupFlag = 1;
                            }
                            if (element.wenjianbiaoCollectionTypes == 2) {
                                vue.zanFlag = 1;
                            }
                            if (element.wenjianbiaoCollectionTypes == 3) {
                                vue.caiFlag = 1;
                            }
                        });

                    }
                });
            }
        });
    </script>
</body>
</html>
