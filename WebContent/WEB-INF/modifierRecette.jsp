<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div id="global">
	<h1>Modifier une recette</h1>
	<div id="ajout">
		<form method="post" action="modifierRecette">

			<input id="titre" name="titre" type="text" class="inputChamp"
				placeholder="Titre de la recette *" /><br /> <br />
			<textarea id="description" name="description" rows="4"
				placeholder="Description de la recette *" class="inputTextArea"></textarea><br /> <br />
			<input id="photo" name="photo" type="text" class="inputChamp"
				placeholder="Photo de la recette *" /><br /> <br />
				 <input type="submit" value="Ajout" class="submitBtn" />
		</form>
	</div>
	<div id="erreur">
		<p>${erreur}</p>
	</div>
	<%@ include file="footer.jsp"%>