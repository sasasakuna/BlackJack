<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blackjack</title>
</head>
<body>
             <%
                 String realPath=getServletContext().getRealPath("/");
                  %>
                  项目根目录的绝对路径为：<%=realPath %>
<div>
    <h1>Dealers</h1>
    ${game.dealersHand.getImages()}

    <h2>Totals</h2>
    ${game.dealersHand.totals}
</div>

<div>
    <h1>Players</h1>
    ${game.playersHand.getImages()}

    <h2>Totals</h2>
    ${game.playersHand.totals}
</div>

<div>
    <form method="POST">
        <input value="Hit" name="hit" type="submit" id="hitButton" class="submit_button">
        <input value="Stand" name="stand" type="submit" id="standButton" class="submit_button">
    </form>
</div>

</body>
</html>