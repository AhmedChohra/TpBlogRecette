
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div id="global">
	<h1>Creer un tag</h1>
	<div id="tag">
		<form method="post" action="tag">
			<input id="tag" name="nom" type="text" class="inputChamp"
				placeholder="Votre tag *" /><br /> <input type="submit"
				value="J'ajoute un tag!" class="primaryBtn" />
		</form>

		<c:forEach items="${allTags}" var="allTag">
					<ul>
						<li style="color:white;">#${allTag.nom} <a href="delete-tag?id=${allTag.id}" style="color:white;"> <span class="iconify" data-icon="fa-regular:trash-alt" data-inline="false"></a> </li>
					</ul>
					</c:forEach>
		
	</div>
	<div id="erreur">
		<p>${erreur}</p>
	</div>
</div>

