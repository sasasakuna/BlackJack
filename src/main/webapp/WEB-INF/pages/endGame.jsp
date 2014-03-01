<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blackjack</title>
</head>
<body>

<div>
    <h1>Dealers</h1>
    <table>
       <tr>
       <c:forEach var="image" items="${game.dealers.getImages()}">
       <td>
       <img src="<c:url value='${image}'/>"/>
       </td>
       </c:forEach>
       </tr>
     </table>

    <h2>Totals</h2>
    ${game.dealers.finalTotal()}

    ${game.dealers.result()}

</div>

<div>
    <h1>Players</h1>
    <table>
           <tr>
           <c:forEach var="image" items="${game.players.getImages()}">
           <td>
           <img src="<c:url value='${image}'/>"/>
           </td>
           </c:forEach>
           </tr>
    </table>

    <h2>Totals</h2>
    ${game.players.finalTotal()}

    ${game.players.result()}

</div>

<div>
    <h1>Result</h1>
    ${game.result()}
</div>

<div>
    <form method="POST">
        <input value="Deal" name="deal" type="submit" id="dealButton" class="submit_button">
    </form>
</div>

</body>
</html>