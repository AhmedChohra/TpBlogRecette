<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div id="global">
 <h1>Connection</h1>
 <div id="login">
 <form method="post" action="login" >
 
 <input id="pseudoEmail" name="pseudoEmail" type="text"
class="inputChamp" placeholder="Votre pseudo ou votre email *" /><br />
 <br />
 <input id="mdp" name="mdp" type="password"
class="inputChamp" placeholder="Votre mot de passe *" /><br />
 <br />
 <input type="submit" value="Connection"
class="submitBtn" />
 </form>
 </div>
 <div id="erreur">
 <p> ${erreur} </p>
 </div>
 </div>










 <%@ include file="footer.jsp" %>