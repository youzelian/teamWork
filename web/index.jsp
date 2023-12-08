<%@ page import="DTO.Game" %>
<%@ page import="utils.pageHelper" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/11/18 0018
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>aliali</title>
    <link rel="stylesheet" href="https://at.alicdn.com/t/c/font_3881267_wfv3iyzbijg.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<style>
    body {
        font-family: 'Open Sans', sans-serif;
        margin: 0;
        padding: 0;
        color: #fff;
        background-color: #1c1c1c;
    }

    h1, h2, h3 {
        font-weight: 700;
        padding: 0;
        margin: 0;
    }

    h1 {
        font-size: 48px;
        line-height: 1.2;
        color: #fff;
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);
        background: linear-gradient(to bottom right, #4c87ff, #a7b3ff);
        padding: 20px;
        text-align: center;
        background: linear-gradient(to bottom right, #ff3d00, #a30000);
    }

    h2 {
        font-size: 36px;
        line-height: 1.2;
        margin-top: 60px;
        margin-bottom: 40px;
        text-align: center;
        color: #ff3d00;
    }

    h3 {
        font-size: 24px;
        line-height: 1.2;
        margin-bottom: 20px;
    }

    p {
        font-size: 18px;
        line-height: 1.5;
        margin-bottom: 20px;
        text-align: justify;
    }

    a {
        color: #4c87ff;
        text-decoration: none;
        font-weight: 700;
        color: #ff3d00;
    }

    a:hover {
        color: #a7b3ff;
    }

    .container {
        display: flex;
        flex-wrap: wrap;
        max-width: 100%;
        margin: 0 auto;
        padding: 20px;
    }

    .game {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        margin: 20px;
        padding: 20px;
        width: calc(30% - 20px);
        max-height: 1000px;
        position: relative;
        overflow: hidden;
        transition: all 0.2s ease;
        background-color: #292929;
    }

    .game:hover {
        transform: translateY(-5px);

        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.4);
    }

    .game img {
        display: block;
        margin: 0 auto;
        max-width: 100%;
        border-radius: 5px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
    }

    .game-title {
        font-size: 24px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 10px;
        opacity: 0;
        transition: all 0.2s ease;
        color: #ff3d00;
    }

    .game:hover .game-title {
        opacity: 1;
        transform: translateY(-10px);
    }

    .game-description {
        margin-bottom: 10px;
        font-size: 18px;
        line-height: 1.5;
        text-align: justify;
    }

    .game-screenshots {
        display: flex;
        flex-wrap: wrap;
        margin-top: 20px;
        justify-content: space-between;
        max-height: 0;
        overflow: hidden;
        transition: all 0.2s ease;
    }

    .game:hover .game-screenshots {
        max-height: 300px;
    }

    .game-screenshot {
        margin: 10px;
        width: calc(50% - 20px);
        opacity: 0;
        transition: all 0.2s ease;
    }

    .game:hover .game-screenshot {
        opacity: 1;
        transform: translateY(10px);
    }

    .button {
        display: inline-block;
        padding: 15px 30px;
        border-radius: 5px;
        background-color: #4c87ff;
        color: #fff;
        font-weight: bold;
        text-align: center;
        text-decoration: none;
        transition: background-color 0.2s ease;
        position: relative;
        overflow: hidden;
        background-color: #ff3d00;
        color: #fff;
    }

    .button:hover {
        background-color: #a7b3ff;
        background-color: #a30000;
    }

    .sidebar {
        background-color: #fff;
        height: 100vh;
        position: fixed;
        top: 0;
        left: 0;
        padding: 20px;
        width: 200px;
        box-shadow: 2px 0 6px rgba(0, 0, 0, 0.2);
        background-color: #292929;
        box-shadow: 2px 0 6px rgba(0, 0, 0, 0.4);
    }

    .sidebar ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .navbar {
        overflow: hidden;
        background-color: #333;
        height: 70px; /* 调整导航栏高度 */
    }

    .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 20px 16px; /* 调整内边距 */
        text-decoration: none;
        font-size: 17px;
        transition: background-color 0.3s;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
        transform: scale(1.1); /* 悬停时放大 */
    }

    .navbar a.active {
        background-color: #04AA6D;
        color: white;
    }

    .button::before {
        content: "";
        position: absolute;
        top: 0;
        left: -100%;
        width: 100%;
        height: 100%;
        background-color: rgba(255, 255, 255, 0.3);
        transform: skewX(-20deg);
        transition: all 0.3s ease;
    }

    /* 搜索框样式 */
    .search-container {
        float: right;
        padding: 20px;
        display: flex; /* 让搜索框和按钮并排显示 */
        align-items: center; /* 垂直居中 */
    }

    .search-container input[type=text] {
        padding: 10px;
        margin-right: 10px; /* 调整搜索框和按钮之间的距离 */
        font-size: 17px;
        border: none;
        border-radius: 30px; /* 添加圆角 */
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
        width: 250px; /* 调整搜索框宽度 */
    }

    .search-container button {
        padding: 10px;
        background-color: #4CAF50; /* 设置按钮背景颜色 */
        color: white;
        border: none;
        border-radius: 30px; /* 添加圆角 */
        cursor: pointer;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
    }

    .slideshow-container {
        max-width: 1600px; /* 设置最大宽度 */
        position: relative;
        margin: auto; /* 设置左右外边距为auto */
        margin-top: 50px;
    }

    .mySlides {
        display: none;
        opacity: 0;
        transition: opacity 1s;
    }

    .mySlides.active {
        display: block;
        opacity: 1;
    }

    .slideshow-container img {

        width: 100%; /* 加长轮播图 */
        height: 500px; /* 调整高度 */
        object-fit: cover;
        position: static;
    }

    .prev, .next {
        cursor: pointer;
        position: absolute;
        top: 50%;
        width: auto;
        padding: 16px;
        margin-top: -22px;
        color: white;
        font-weight: bold;
        font-size: 18px;
        transition: 0.6s ease;
        border-radius: 0 3px 3px 0;
        user-select: none;
    }

    .next {
        right: 0;
        border-radius: 3px 0 0 3px;
    }

    .prev:hover, .next:hover {
        background-color: rgba(0, 0, 0, 0.8);
    }

    .text {
        color: #f2f2f2;
        font-size: 15px;
        padding: 8px 12px;
        position: absolute;
        bottom: 8px;
        width: 100%;
        text-align: center;
    }

    .button:hover::before {
        left: 100%;
    }

    .menu {
        position: absolute;
        top: 120px;
        left: 0;
        height: 20%;
        width: 200px;
        background-color: #222;
        color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        transform: translateX(-200px);
        transition: transform 0.3s ease-in-out;
        margin-left: 20px;
    }

    /* 菜单按钮 */
    .menu-btn {
        position: absolute;
        top: 90px;
        left: 20px;
        background-color: #222;
        color: #fff;
        border: none;
        outline: none;
        font-size: 24px;
        cursor: pointer;
        transition: transform 0.3s ease-in-out;
    }

    /* 菜单链接 */
    .menu ul li a {
        color: #fff;
        text-decoration: none;
        padding: 10px;
        display: block;
        transition: background-color 0.2s ease-in-out;
    }

    /* 鼠标悬停在菜单链接上时 */
    .menu ul li a:hover {
        background-color: #333;
    }

    /* 显示菜单 */
    .menu.active {
        transform: translateX(0);
    }

    .menu-btn.active {
        transform: translateX(200px);
    }


    .game-categories a {
        color: #fff;
        display: block;
        padding: 6px 12px;
        text-decoration: none;
        transition: background-color 0.2s ease-in-out;
    }


</style>
<body>
<div id="mainBody">
    <%
        pageHelper<Game> gamePageHelper = (pageHelper<Game>) application.getAttribute("gamePageHelper");
        List<Game> list = gamePageHelper.getList();
    %>
    <div class="navbar">
        <a href="test.html">主页</a>
        <a href="#news">留言</a>
        <a href="#home">我的主页</a>
        <a href="#home">关于我们</a>
        <div class="search-container">
            <input type="text" placeholder="搜索游戏、新闻...">
            <button type="submit" onclick="alert('进行搜索操作')">搜索</button>
        </div>
    </div>
    <button class="menu-btn" onclick="toggleMenu()">☰</button>
    <div class="menu">
        <ul>
            <li><a href="#">菜单项1</a></li>
            <li><a href="#">菜单项2</a></li>
            <li><a href="#">菜单项3</a></li>
            <li><a href="#">菜单项4</a></li>
            <li><a href="#">菜单项5</a></li>
        </ul>
    </div>
    <div class="slideshow-container">
        <div class="mySlides fade">
            <img src="https://tse4-mm.cn.bing.net/th/id/OIP-C.e_GMU1gzm_jkPJjHKj16RwHaEF?w=269&h=180&c=7&r=0&o=5&dpr=1.7&pid=1.7">
            <div class="text">Caption Text 1</div>
        </div>

        <div class="mySlides fade">
            <img src="data:image/jpeg;base64,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">
            <div class="text">Caption Text 2</div>
        </div>

        <div class="mySlides fade">
            <img src="https://tse4-mm.cn.bing.net/th/id/OIP-C.54Frc7vEQ8tBcuqkakc9VwHaEo?w=250&h=180&c=7&r=0&o=5&dpr=1.7&pid=1.7">
            <div class="text">Caption Text 3</div>
        </div>

        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
    </div>
    <div class="container">
        <div class="game">
            <c:forEach items="<%=gamePageHelper.getList()%>}" var="game">
                <img src="<%=%>" alt="游戏1封面">
                <div class="game-title">${game.gameName}</div>
                <div class="game-description">${game.gameDetail}</div>
                <div class="game-screenshots">
                    <div class="game-screenshot"><img src="${game.gameImgOne}" alt="游戏1截图1"></div>
                    <div class="game-screenshot"><img src="${game.gameImgTwo}" alt="游戏1截图2"></div>
                </div>
            </c:forEach>
        </div>
        <!-- 添加更多游戏 -->
    </div>
</div>
</body>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].classList.remove('active');
        }
        slides[slideIndex - 1].classList.add('active');
    }

    // 自动切换轮播图
    setInterval(function () {
        plusSlides(1);
    }, 3000);

    const navLinks = document.querySelectorAll('.navbar a');
    navLinks.forEach(link => {
        link.addEventListener('mouseover', () => {
            link.style.transform = 'scale(1.1)';
        });
        link.addEventListener('mouseout', () => {
            link.style.transform = 'scale(1)';
        });
    });

    // 页面加载完成后执行动画

    function toggleMenu() {
        var menu = document.querySelector('.menu');
        var btn = document.querySelector('.menu-btn');
        menu.classList.toggle('active');
        btn.classList.toggle('active');
    }
</script>
</html>
