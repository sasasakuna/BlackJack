<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blackjack</title>
     <link rel="stylesheet" href="inProgress.css">
         <script type="text/javascript" src="jquery.1.10.2.min.js"></script>
         <script type="text/javascript" src="inProgress.js"></script>
</head>
<body>
<div id="top">
      <h1>Black  Jack  <small>Go rock it</small></h1>
</div>

<div class = "role">
     <div class = "dealer_title">Dealer</div>
     <div class = "dealer_img">
    <table>
       <tr>
       <c:forEach var="image" items="${game.getDealers().getImages()}">
       <td>
       <img src="<c:url value='${image}'/>"/>
       </td>
       </c:forEach>
       </tr>
     </table>
      </div>


</div>

<div class = "role">
    <div class = "player_title">Player</div>
         <div class = "player_img">
    <table>
           <tr>
           <c:forEach var="image" items="${game.getPlayers().getImages()}">
           <td>
           <img src="<c:url value='${image}'/>"/>
           </td>
           </c:forEach>
           </tr>
    </table>

      </div>

</div>

<div class = "score">
  <div class = "score_title">Scores</div>
  <h2>Dealer Totals</h2>
     ${game.dealers.finalTotal()}

        ${game.dealers.result()}

   <h2>Player Totals</h2>
     ${game.players.finalTotal()}

        ${game.players.result()}


    <h1>Result</h1>
    ${game.result()}
</div>

<div class = "left">
    <form method="POST">
        <input value="Deal" name="deal" type="submit" id="dealButton" class="submit_button">
    </form>
</div>

</body>
</html>