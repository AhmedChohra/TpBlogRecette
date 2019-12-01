<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div id="global">
	<a href="recette?id=${recette.id}" style="color: white;">Retour à la recette</a>
	<h1>Ajouter un ingredient</h1>
	<div id="ajout">
		<form method="post" action="ajout-ingredient?id=${recette.id}">
			<input id="nom" name="nom" type="text" class="inputChamp"
				placeholder="Nom de l'ingredient *" /><br /> <br />
			<input id="quantite" name="quantite" type="text" class="inputChamp"
				placeholder="Quantité *" /><br /> <br />	
			<input id="unite" name="unite" type="text" class="inputChamp"
				placeholder="Unité (kg, g, cc, cs, u...) *" /><br /> <br />	
			<br /> <br /> <input type="submit" value="Ajout" class="submitBtn" />
		</form>
	</div>
	<h2>Liste des ingredients</h2>
	<div id="listIngredient">
		<ul>
			<c:forEach items="${ingredients}" var="ingredient">
				<li><c:out value="${ingredient.quantite}" /> <c:out
						value="${ingredient.unit}" /> <c:out value="${ingredient.nom}" /></li>
			</c:forEach>
		</ul>
	</div>
	<div id="erreur">
		<p>${erreur}</p>
	</div>
	<%@ include file="footer.jsp"%>