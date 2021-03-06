<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div id="global">
	<h1>Ajouter une recette</h1>
	<div id="ajout">
		<form method="post" enctype="multipart/form-data"
			action="ajout-recette">

			<input id="titre" name="titre" type="text" class="inputChamp"
				placeholder="Titre de la recette *" /><br /> <br /> <SELECT
				name="categorie" id="categorie" class="select">
				<c:forEach items="${categories}" var="categorie">
					<OPTION value="${categorie.id}"><c:out
							value="${categorie.nom}" />
				</c:forEach>
			</SELECT><br /> <br />
			<textarea id="description" name="description" rows="4"
				placeholder="Description de la recette *" class="inputTextArea"></textarea>
			<br /> <br /> <label for="avatar">Ajouter une photo de la
				recette :</label> <input type="file" name="file"> <br /> <br />
			<input type="submit" value="Ajout" class="submitBtn" />
		</form>
	</div>
	<div id="erreur">
		<p>${erreur}</p>
	</div>
</div>
<%@ include file="footer.jsp"%>