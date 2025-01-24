<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content="order by mobanxiu.cn"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/common.css"/>
    <link rel="stylesheet" href="../../xznstatic/css/style.css"/>
    <link rel="stylesheet" href="../../xznstatic/css/animate.css"/><!-- 动画效果 -->
    <link rel="stylesheet" href="../../xznstatic/css/swiper.min.css"/>
    <script src="../../xznstatic/js/jquery-1.11.3.min.js"></script>
    <script src="../../xznstatic/js/jquery.SuperSlide.2.1.1.js"></script>
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="../../css/theme.css"/>
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
    }

    #test1 {
        overflow: hidden;
    }

    /*轮播图css*/
    #test1 .layui-carousel-ind li {
        width: 20px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0, 0, 0, .3);
        border-radius: 6px;
        background-color: #f7f7f7;
        box-shadow: 0 0 6px rgba(255, 0, 0, .8);
    }

    #test1 .layui-carousel-ind li.layui-this {
        width: 30px;
        height: 10px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(0, 0, 0, .3);
        border-radius: 6px;
    }

    .layui-carousel-ind{
        top: 0;

    }
    .layui-carousel-ind ul{
        position: absolute;

        bottom: 8px !important;
        z-index: 10;
    }

    .title {
        padding: 10px 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

   .title span {
        padding: 0 10px;
        line-height: 1.4;
    }

   .box .list {
        display: flex;
        flex-wrap: wrap;
    }




    .box .list img {
        width: 100%;
        height: 100px;
        display: block;
        margin: 0 auto;
        object-fit: cover;
        max-width: 100%;
    }

    .box .list .name {
        padding-top: 5px;
        color: red;
        font-size: 14px;
        text-align: center;
        box-sizing: border-box;
    }


    .box .list .list-item {
        flex: 0 0 25%;
        padding: 0 10px;
        box-sizing: border-box;
    }

    /*
   .box .list .list-item-body {
        border: 1px solid rgba(0, 0, 0, 3);
        padding: 5px;
        box-sizing: border-box;
        cursor: pointer;
   }
    .box .list .list-item .list-item-body {
        border: 1px solid rgba(0, 0, 0, 3);
        padding: 10px;
        box-sizing: border-box;
        display: flex;
        cursor: pointer;
    }

    .box .list .list-item .list-item-body img {
        width: 120px;
        height: 100%;
        display: block;
        margin: 0 auto;
        object-fit: cover;
        max-width: 100%;
    }

    .box .list .list-item .list-item-body .item-info {
        flex: 1;
        display: flex;
        justify-content: space-between;
        flex-direction: column;
        padding-left: 10px;
        box-sizing: border-box;
    }

    .box .list .list-item .list-item-body .item-info .name {
        padding-top: 5px;
        color: red;
        font-size: 14px;
        box-sizing: border-box;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }
    .box .list .list-item .list-item-body .item-info .time {
        padding-top: 5px;
        color: red;
        font-size: 14px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }
    #new-list-6 .swiper-wrapper {
        -webkit-transition-timing-function: linear;
        -moz-transition-timing-function: linear;
        -ms-transition-timing-function: linear;
        -o-transition-timing-function: linear;
        transition-timing-function: linear;
    }*/

    .list-item1 {
        flex: 0 0 100%;
    }
    .list-item2 {
        flex: 0 0 50%;
    }
    .list-item3 {
        flex: 0 0 33.3%;
    }
    .list-item4 {
        flex: 0 0 25%;
    }
    .list-item5 {
        flex: 0 0 20%;
    }
    /*限制内容长度*/
    .line1 {
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 1;
        overflow: hidden;
    }
    .line2 {
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
    }
    .line3 {
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 3;
        overflow: hidden;
    }
    /*轮播图css*/
    /*套装样式*/
    /*腰线*/
    /*home页面主要样式*/
    /*home页面普通数据样式*/
.probootstrap-animate {
	/*opacity: 0;
	visibility: hidden;*/
}
.probootstrap-thumbnail {
	position: relative;
	display: block;
	-webkit-transition: .3s all ease;
	-o-transition: .3s all ease;
	transition: .3s all ease;
	opacity: 1;
	width: 80%;
}
.probootstrap-thumbnail.sleep {
    opacity: .5;
}
.probootstrap-thumbnail img {
    position: relative;
    -webkit-transition: .3s all ease;
    -o-transition: .3s all ease;
    transition: .3s all ease;
    display: block;
    bottom: 0;
    z-index: 2;
	width: 100%;
	height: 290px;
}
.probootstrap-thumbnail h4 {
	z-index: 1;
	display: block;
	text-align: center;
	position: relative;
	-webkit-transition: .2s all ease;
	-o-transition: .2s all ease;
	transition: .2s all ease;
	opacity: 0;
	visibility: hidden;
	bottom: 30px;
	color: var(--publicMainColor,orange);
}
	@media (max-width: 991px) {
		.probootstrap-thumbnail h4 {
			font-size: 24px;
			bottom: 0;
			color: var(--publicMainColor,orange);
		}
	}
	@media (max-width: 767px) {
		.probootstrap-thumbnail h4 {
			opacity: 1;
			visibility: visible;
			bottom: 0;
			margin-top: 10px;
			color: var(--publicMainColor,orange);
		}
	}
.probootstrap-thumbnail:hover h4 {
	opacity: 1;
	visibility: visible;
	bottom: -5px;
	color: var(--publicMainColor,orange);
}
    @media (max-width: 991px) {
		.probootstrap-thumbnail:hover h4 {
			bottom: 0px;
			color: var(--publicMainColor,orange);
		}
	}
.probootstrap-thumbnail:hover img {
	-webkit-transform: scale(1.08);
	-ms-transform: scale(1.08);
	transform: scale(1.08);
	bottom: 20px;
	-webkit-box-shadow: 0 10px 20px -10px rgba(0, 0, 0, 0.2);
	box-shadow: 0 10px 20px -10px rgba(0, 0, 0, 0.2);
	width: 100%;
	height: 290px;
}
	@media (max-width: 991px) {
		.probootstrap-thumbnail:hover img {
			bottom: 20px;
			-webkit-transform: scale(1);
			-ms-transform: scale(1);
			transform: scale(1);
		}
	}
	@media (max-width: 767px) {
		.probootstrap-thumbnail:hover img {
			bottom: 0px;
			opacity: 1;
			visibility: visible;
		}
	}
.mb-3 {
	margin-bottom: 1rem !important;
}
.mb-4 {
	margin-bottom: 1.5rem !important;
}
.img-fluid {
	max-width: 100%;
	height: auto;
}
    /*home页面新闻数据样式*/
</style>
<body>
<div id="app" >
    <div class="banner">

        <div class="layui-carousel" id="test1" style="height: 800px !important;position: relative;" :style='{"boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"0 auto","borderColor":"rgba(0,0,0,.3)","borderRadius":"0px","borderWidth":"0","width":"100%","borderStyle":"solid"}'>
            <div carousel-item class="slideInLeft" style="visibility: visible; animation-duration: 3s; animation-name: slideInLeft;height: 800px">
                <div v-for="(item,index) in swiperList" :key="index">
                    <img style="width: 100%;height: 100%;object-fit:cover;" :src="baseUrl+item.img"/>
                </div>
            </div>
        </div>
    </div>

    <div id="content">
                <div style="display: flex;justify-content: center;background-repeat: no-repeat;background-position: center center;background-size: cover;">
                    <div class="box" style='width:100%;'>
                        <div style="width: 1200px;height: auto;margin:  0 auto;padding: 10px 0">
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div class="title" :style='{"isshow":true,"padding":"10px 0 10px 0","boxShadow":"#fff 0px 0px 6px","margin":"10px 0 10px 0","borderColor":"var(--publicMainColor)","color":"#000","borderRadius":"10px","alignItems":"flex-start","borderWidth":"0 0 0 6px","fontSize":"28px","borderStyle":"solid"}'>
     <span>NEWS</span>
    <span>新闻信息展示</span>
</div>                            </div>
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div v-if="newsList.length" class="new-list-10"  style="display: flex">
    <div v-if="newsList.length>0" @click="jump('../news/detail.jsp?id='+newsList[0].id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"3px","width":"46%","borderStyle":"solid","height":"360px"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;display: flex;overflow: hidden;width: 50%;flex-direction: column;">
        <img :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,.3)","margin":"0 0 10px 0","borderColor":"#ccc","backgroundColor":"#ccc","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"240px"}' style="object-fit: cover;" :src="baseUrl+newsList[0].newsPhoto" alt="">
        <div class="new9-list-body" style="display: flex;justify-content: space-between;align-items: center;">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{newsList[0].newsName}}</div>
            <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{newsList[0].insertTime.split(' ')[0]}}</div>
        </div>
        <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(newsList[0].newsContent)"></div>
        <div style="display: flex;height: 34px">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ newsList[0].newsValue}}</div>
        </div>
    </div>
    <div v-if="newsList.length>1" style="width: 50%;box-sizing: border-box;display: flex;flex-direction: column;justify-content: center;overflow: hidden;"  :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"0","width":"46%","borderStyle":"solid","height":"390px"}'>
        <div v-for="(item,index) in newsList" v-if="index<4 && index>0" :key="index" @click="jump('../news/detail.jsp?id='+item.id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, 0)","margin":"0","borderColor":"rgba(0,0,0, .3)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0 0 1px 0","width":"100%","borderStyle":"solid"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;flex: 1;display: flex;width: 100% !important;flex-direction: column;">
            <div class="new9-list-body" style="box-sizing: border-box;display: flex;justify-content: space-between;align-items: center;">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{ item.newsName }}</div>
                <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{ item.insertTime.split(' ')[0] }}</div>
            </div>
            <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(item.newsContent)"></div>
            <div style="box-sizing: border-box;display: flex">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ newsList[0].newsValue}}</div>
            </div>
        </div>
    </div>
</div>                                <div style="margin-top:40px;text-align: center;">
                                    <button @click="jump('../news/list.jsp')" style="display: block;cursor: pointer;" type="button" :style='{"padding":"0 15px","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"4px auto","borderColor":"#ccc","backgroundColor":"#fff","color":"rgba(160, 67, 26, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","fontSize":"14px","borderStyle":"solid","height":"34px"}'>
                                        查看更多
                                        <i :style='{"isshow":true,"padding":"0 0 0 1px","fontSize":"14px","color":"rgba(160, 67, 26, 1)"}' class="layui-icon layui-icon-next"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="display: flex;justify-content: center;background-repeat: no-repeat;background-position: center center;background-size: cover;">
                    <div class="box" style='width:100%;'>
                        <div style="width: 1200px;height: auto;margin:  0 auto;padding: 10px 0">
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div class="title" :style='{"isshow":true,"padding":"10px 0 10px 0","boxShadow":"#fff 0px 0px 6px","margin":"10px 0 10px 0","borderColor":"var(--publicMainColor)","color":"#000","borderRadius":"10px","alignItems":"flex-start","borderWidth":"0 0 0 6px","fontSize":"28px","borderStyle":"solid"}'>
        <span>DATA SHOW</span>
    <span>资讯展示</span>
</div>                            </div>
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div v-if="zixunList.length" class="new-list-10"  style="display: flex">
    <div v-if="zixunList.length>0" @click="jump('../zixun/detail.jsp?id='+zixunList[0].id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"3px","width":"46%","borderStyle":"solid","height":"360px"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;display: flex;overflow: hidden;width: 50%;flex-direction: column;">
        <img :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,.3)","margin":"0 0 10px 0","borderColor":"#ccc","backgroundColor":"#ccc","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"240px"}' style="object-fit: cover;" :src="baseUrl+zixunList[0].zixunPhoto" alt="">
        <div class="new9-list-body" style="display: flex;justify-content: space-between;align-items: center;">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{zixunList[0].zixunName}}</div>
            <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{zixunList[0].insertTime.split(' ')[0]}}</div>
        </div>
        <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(zixunList[0].zixunContent)"></div>
        <div style="display: flex;height: 34px">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ zixunList[0].zixunValue}}</div>
        </div>
    </div>
    <div v-if="zixunList.length>1" style="width: 50%;box-sizing: border-box;display: flex;flex-direction: column;justify-content: center;overflow: hidden;"  :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"0","width":"46%","borderStyle":"solid","height":"390px"}'>
        <div v-for="(item,index) in zixunList" v-if="index<4 && index>0" :key="index" @click="jump('../zixun/detail.jsp?id='+item.id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, 0)","margin":"0","borderColor":"rgba(0,0,0, .3)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0 0 1px 0","width":"100%","borderStyle":"solid"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;flex: 1;display: flex;width: 100% !important;flex-direction: column;">
            <div class="new9-list-body" style="box-sizing: border-box;display: flex;justify-content: space-between;align-items: center;">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{ item.zixunName }}</div>
                <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{ item.insertTime.split(' ')[0] }}</div>
            </div>
            <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(item.zixunContent)"></div>
            <div style="box-sizing: border-box;display: flex">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ zixunList[0].zixunValue}}</div>
            </div>
        </div>
    </div>
</div>                                <div style="margin-top:40px;text-align: center;">
                                    <button @click="jump('../zixun/list.jsp')" style="display: block;cursor: pointer;" type="button" :style='{"padding":"0 15px","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"4px auto","borderColor":"#ccc","backgroundColor":"#fff","color":"rgba(160, 67, 26, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","fontSize":"14px","borderStyle":"solid","height":"34px"}'>
                                        查看更多
                                        <i :style='{"isshow":true,"padding":"0 0 0 1px","fontSize":"14px","color":"rgba(160, 67, 26, 1)"}' class="layui-icon layui-icon-next"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="display: flex;justify-content: center;background-repeat: no-repeat;background-position: center center;background-size: cover;">
                    <div class="box" style='width:100%;'>
                        <div style="width: 1200px;height: auto;margin:  0 auto;padding: 10px 0">
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div class="title" :style='{"isshow":true,"padding":"10px 0 10px 0","boxShadow":"#fff 0px 0px 6px","margin":"10px 0 10px 0","borderColor":"var(--publicMainColor)","color":"#000","borderRadius":"10px","alignItems":"flex-start","borderWidth":"0 0 0 6px","fontSize":"28px","borderStyle":"solid"}'>
        <span>DATA SHOW</span>
    <span>通知展示</span>
</div>                            </div>
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div v-if="tongzhiList.length" class="new-list-10"  style="display: flex">
    <div v-if="tongzhiList.length>0" @click="jump('../tongzhi/detail.jsp?id='+tongzhiList[0].id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"3px","width":"46%","borderStyle":"solid","height":"360px"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;display: flex;overflow: hidden;width: 50%;flex-direction: column;">
        <img :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,.3)","margin":"0 0 10px 0","borderColor":"#ccc","backgroundColor":"#ccc","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"240px"}' style="object-fit: cover;" :src="baseUrl+tongzhiList[0].tongzhiPhoto" alt="">
        <div class="new9-list-body" style="display: flex;justify-content: space-between;align-items: center;">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{tongzhiList[0].tongzhiName}}</div>
            <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{tongzhiList[0].insertTime.split(' ')[0]}}</div>
        </div>
        <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(tongzhiList[0].tongzhiContent)"></div>
        <div style="display: flex;height: 34px">
            <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ tongzhiList[0].tongzhiValue}}</div>
        </div>
    </div>
    <div v-if="tongzhiList.length>1" style="width: 50%;box-sizing: border-box;display: flex;flex-direction: column;justify-content: center;overflow: hidden;"  :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0, .3)","margin":"5px 2%","borderColor":"#fff","backgroundColor":"#fff","borderRadius":"10px","borderWidth":"0","width":"46%","borderStyle":"solid","height":"390px"}'>
        <div v-for="(item,index) in tongzhiList" v-if="index<4 && index>0" :key="index" @click="jump('../tongzhi/detail.jsp?id='+item.id)" :style='{"padding":"10px","boxShadow":"0 0 6px rgba(0,0,0, 0)","margin":"0","borderColor":"rgba(0,0,0, .3)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0 0 1px 0","width":"100%","borderStyle":"solid"}' class="new10-list-item" style="box-sizing: border-box;cursor: pointer;flex: 1;display: flex;width: 100% !important;flex-direction: column;">
            <div class="new9-list-body" style="box-sizing: border-box;display: flex;justify-content: space-between;align-items: center;">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":" 0","borderColor":"#ccc","backgroundColor":"rgba(255,0,0,0)","color":"rgba(0, 0, 0, 1)","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"28px","fontSize":"16px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-title line1">{{ item.tongzhiName }}</div>
                <div :style='{"padding":"0 6px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 10px 0 0","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"#fff","borderRadius":"4px","borderWidth":"0","width":"auto","lineHeight":"21px","fontSize":"12px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-time">{{ item.insertTime.split(' ')[0] }}</div>
            </div>
            <div :style='{"padding":"0","boxShadow":"0 0 6px rgba(0,0,0,0)","margin":"5px 0 0 10px","borderColor":"#ccc","backgroundColor":"rgba(0,0,0,0)","color":"#333","borderRadius":"0","borderWidth":"0","width":"100%","lineHeight":"21px","fontSize":"14px","borderStyle":"solid"}' style="box-sizing: border-box;" class="new9-list-item-descript line2" v-html="myFilters(item.tongzhiContent)"></div>
            <div style="box-sizing: border-box;display: flex">
                <div :style='{"padding":"0 10px","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"15px 0 0 10px","borderColor":"#ccc","backgroundColor":"var(--publicSubColor)","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","borderWidth":"1px","width":"auto","lineHeight":"18px","fontSize":"12px","text":"资讯","borderStyle":"solid"}' class="new9-list-item-identification">{{ tongzhiList[0].tongzhiValue}}</div>
            </div>
        </div>
    </div>
</div>                                <div style="margin-top:40px;text-align: center;">
                                    <button @click="jump('../tongzhi/list.jsp')" style="display: block;cursor: pointer;" type="button" :style='{"padding":"0 15px","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"4px auto","borderColor":"#ccc","backgroundColor":"#fff","color":"rgba(160, 67, 26, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","fontSize":"14px","borderStyle":"solid","height":"34px"}'>
                                        查看更多
                                        <i :style='{"isshow":true,"padding":"0 0 0 1px","fontSize":"14px","color":"rgba(160, 67, 26, 1)"}' class="layui-icon layui-icon-next"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="display: flex;justify-content: center;background-repeat: no-repeat;background-position: center center;background-size: cover;">
                    <div class="box" style='width:100%;'>
                        <div style="width: 1200px;height:auto;margin:  0 auto;padding: 10px 0">
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
<div class="title" :style='{"isshow":true,"padding":"10px 0 10px 0","boxShadow":"#fff 0px 0px 6px","margin":"10px 0 10px 0","borderColor":"var(--publicMainColor)","color":"#000","borderRadius":"10px","alignItems":"flex-start","borderWidth":"0 0 0 6px","fontSize":"28px","borderStyle":"solid"}'>
        <span>DATA SHOW</span>
    <span>学校文件展示</span>
</div>                            </div>
                            <div class="wow " data-wow-duration="2s" data-wow-delay="1s">
                            <div class="row mb-4" style="display: flex;justify-content: space-around;">
                                <div v-for="(item,index) in wenjianbiaoList" v-bind:key="index" class="list-item4 list-item3B">
                                    <a @click="jumpCheck('../wenjianbiao/detail.jsp?id='+item.id , item.aaaaaaaaaa == null?'':item.aaaaaaaaaa , item.shangxiaTypes == null?'':item.shangxiaTypes)">
                                        <img :src="item.wenjianbiaoPhoto?baseUrl+item.wenjianbiaoPhoto.split(',')[0]:''" class="img-fluid" style="height: 350px;width:100%;" />
                                        <h4 style="background-color: #fff;border-radius: 20%">
                                            {{item.wenjianbiaoName}}
                                            <br />
                                            <p v-if="item.wenjianbiaoNewMoney != null" style="color: red">￥{{item.wenjianbiaoNewMoney}}</p>
                                        </h4>
                                    </a>
                                </div>
                            </div>
                                <div style="text-align: center;margin-top: 40px;">
                                    <button @click="jump('../wenjianbiao/list.jsp')" style="display: block;cursor: pointer;" type="button"
                                            :style='{"padding":"0 15px","boxShadow":"0 0 6px rgba(255,0,0,0)","margin":"4px auto","borderColor":"#ccc","backgroundColor":"#fff","color":"rgba(160, 67, 26, 1)","borderRadius":"6px","borderWidth":"0","width":"auto","fontSize":"14px","borderStyle":"solid","height":"34px"}'>
                                        查看更多
                                        <i :style='{"isshow":true,"padding":"0 0 0 1px","fontSize":"14px","color":"rgba(160, 67, 26, 1)"}' class="layui-icon layui-icon-next"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    </div>
</div>

<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../xznstatic/js/echarts.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 引入element组件库 -->
<script src="../../xznstatic/js/element.min.js"></script>
<!-- 引入element样式 -->
<link rel="stylesheet" href="../../xznstatic/css/element.min.css">
<script src="../../xznstatic/js/swiper.min.js"></script>
<script src="../../js/config.js"></script>
<script src="../../modules/config.js"></script>
<script src="../../js/utils.js"></script>
<script src="../../xznstatic/js/wow.min.js"></script>
<script type="text/javascript">
    // 动画效果
    new WOW().init();

    Vue.prototype.myFilters = function (msg) {
        if(msg==null || msg==""){
            return "";
        }else if (msg.length>20){
            msg.replace(/\n/g, "<br>");
            return msg.substring(0,20)+"......";
        }else{
            return msg.replace(/\n/g, "<br>");
        }
    };
    var vue = new Vue({
        el: '#app',
        data: {
            swiperList: [],
            baseUrl:"",
            // dianyingRecommend: [],
            newsList: [],
            newsTypesList: [],
            zixunList: [],
            zixunTypesList: [],
            tongzhiList: [],
            tongzhiTypesList: [],
            wenjianbiaoList: [],
            wenjianbiaoTypesList: [],
            //类型查询条件
            newsTypes: "",
            zixunTypes: "",
            tongzhiTypes: "",
            wenjianbiaoTypes: "",
        },
        filters: {
            newsDesc: function (val) {
                if (val) {
                    val = val.replace(/<[^<>]+>/g, '').replace(/undefined/g, '');
                    if (val.length > 60) {
                        val = val.substring(0, 60);
                    }

                    return val;
                }
                return '';
            }
        },
        methods: {
            jump(url) {
                jump(url)
            }
            , jumpCheck(url, check1, check2) {
                if (check1 == "2" || check1 == 2) {//级联表的逻辑删除字段[1:未删除 2:已删除]
                    layui.layer.msg("已经被删除", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                if (check2 == "2" || check2 == 2) {//是否下架[1:上架 2:下架]
                    layui.layer.msg("已经下架", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                this.jump(url);
            }
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        vue.baseUrl = http.baseurl

        localStorage.setItem("goUtl","./pages/home/home.jsp")

        // 获取轮播图 数据
        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function (res) {
            if (res.data.list.length > 0) {
                let swiperList = [];
                res.data.list.forEach(element => {
                    if (element.value != null
                    ) {
                        swiperList.push({
                            img: element.value
                        });
                    }
                })
                ;

                vue.swiperList = swiperList;

                vue.$nextTick(() => {
                    carousel.render({
                        elem: '#test1',
                        width: '100%',
                        height: '100%',
                        arrow: 'hover',
                        anim: 'default',
                        autoplay: 'true',
                        interval: '3000',
                        indicator: 'inside'
                    });

                })

                // vue.$nextTick(()=>{
                //   window.xznSlide();
                // });
            }
        });

        newsSelect();
        //类型动态搜索
        $(document).on("click", ".newsTypes-search", function(e) {
            vue.newsTypes = $(this).attr('index');
            newsSelect();
        });
        newsTypesSelect();//类型查询
        zixunSelect();
        //类型动态搜索
        $(document).on("click", ".zixunTypes-search", function(e) {
            vue.zixunTypes = $(this).attr('index');
            zixunSelect();
        });
        zixunTypesSelect();//类型查询
        tongzhiSelect();
        //类型动态搜索
        $(document).on("click", ".tongzhiTypes-search", function(e) {
            vue.tongzhiTypes = $(this).attr('index');
            tongzhiSelect();
        });
        tongzhiTypesSelect();//类型查询
        wenjianbiaoSelect();
        //类型动态搜索
        $(document).on("click", ".wenjianbiaoTypes-search", function(e) {
            vue.wenjianbiaoTypes = $(this).attr('index');
            wenjianbiaoSelect();
        });
        wenjianbiaoTypesSelect();//类型查询

        function newsTypesSelect() {//类型查询
            http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=news_types",'get',{},function(res) {
                if (res.code == 0) {vue.newsTypesList = res.data.list;}
            });
        }
        function newsSelect(){//数据查询
            http.request('news/list', 'get', {
                page: 1,
                limit: 8,
                newsTypes: vue.newsTypes,//类型
                order: "desc",//asc desc
            },function (res) {
                vue.newsList = res.data.list;
            })
        };
        function zixunTypesSelect() {//类型查询
            http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=zixun_types",'get',{},function(res) {
                if (res.code == 0) {vue.zixunTypesList = res.data.list;}
            });
        }
        function zixunSelect(){//数据查询
            http.request('zixun/list', 'get', {
                page: 1,
                limit: 8,
                zixunTypes: vue.zixunTypes,//类型
                order: "desc",//asc desc
            },function (res) {
                vue.zixunList = res.data.list;
            })
        };
        function tongzhiTypesSelect() {//类型查询
            http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=tongzhi_types",'get',{},function(res) {
                if (res.code == 0) {vue.tongzhiTypesList = res.data.list;}
            });
        }
        function tongzhiSelect(){//数据查询
            http.request('tongzhi/list', 'get', {
                page: 1,
                limit: 8,
                tongzhiTypes: vue.tongzhiTypes,//类型
                order: "desc",//asc desc
            },function (res) {
                vue.tongzhiList = res.data.list;
            })
        };
        function wenjianbiaoTypesSelect() {//类型查询
            http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=wenjianbiao_types",'get',{},function(res) {
                if (res.code == 0) {vue.wenjianbiaoTypesList = res.data.list;}
            });
        }
        function wenjianbiaoSelect(){//数据查询
            http.request('wenjianbiao/gexingtuijian', 'get', {
                page: 1,
                limit: 8,
                shangxiaTypes: 1,
                wenjianbiaoDelete: 1,
                wenjianbiaoTypes: vue.wenjianbiaoTypes,//类型
                order: "desc",//asc desc
            },function (res) {
                vue.wenjianbiaoList = res.data.list;
            })
        };

    });

    window.xznSlide = function () {
        // jQuery(".banner").slide({mainCell:".bd ul",autoPlay:true,interTime:5000});
        jQuery("#ifocus").slide({
            titCell: "#ifocus_btn li",
            mainCell: "#ifocus_piclist ul",
            effect: "leftLoop",
            delayTime: 200,
            autoPlay: true,
            triggerTime: 0
        });
        jQuery("#ifocus").slide({titCell: "#ifocus_btn li", mainCell: "#ifocus_tx ul", delayTime: 0, autoPlay: true});
        jQuery(".product_list").slide({
            mainCell: ".bd ul",
            autoPage: true,
            effect: "leftLoop",
            autoPlay: true,
            vis: 5,
            trigger: "click",
            interTime: 4000
        });
    };
</script>
<script src="../../xznstatic/js/index.js"></script>
</body>
</html>
