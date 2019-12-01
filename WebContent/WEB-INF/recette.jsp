<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<div id="global">
	<c:choose>
		<c:when test="${not empty sessionScope.membre}">
			<a class="primaryBtn ajoutRecette" href="modifierRecette">Modifier</a>
		</c:when>
	</c:choose>
	<article>
		<header>
			<img class="imgRecette" src="img/<c:out value="${recette.photo}" />"
				alt="<c:out value="${recette.titre}" />" />
			<h1 class="titreRecette">
				<c:out value="${recette.titre}" />
			</h1>
			<c:forEach var="i" begin="1" end="${noteAverage}">
				<span class="fa fa-star checked"></span>
			</c:forEach>
			<c:forEach var="i" begin="${noteAverage + 1}" end="5">
				<span class="fa fa-star "></span>
			</c:forEach>
			</br>
			<c:forEach items="${tags}" var="tag">
				<span><a href="recette-by-tag?id=<c:out value="${tag.id}" />"
					name="rTag" id="rTag" style="color: white;">#${tag.nom}</a> <a
					href="delete-tag-from-recipe?tag_id=${tag.id}&recette_id=${recette.id}">
						<span class="iconify" data-icon="fa-regular:trash-alt"
						data-inline="false" style="color: white;"></span>
				</a> </span>
			</c:forEach>
			</br> </br>
			<form name="tag" method="post"
				action="recette?id=<c:out value="${recette.id}" />">
				<SELECT name="tag" id="tag" class="select">
					<c:forEach items="${allTags}" var="allTag">
						<OPTION value="${allTag.id}"><c:out value="${allTag.nom}" />
					</c:forEach>
				</SELECT> <input type="submit" value="Ajouter" class="submitBtn" />

			</form>

			</br>
			<time>
				<c:out value="${recette.dateCreation}" />
			</time>
		</header>
		<p>
			<c:out value="${recette.description}" />
		</p>
	</article>

	<hr />
	<header>
		<h2 id="titreIngredient">Ingrédients</h2>
		</br>
		</br>
		<c:choose>
			<c:when test="${not empty sessionScope.membre}">
				<a class="primaryBtn ajoutIngredient" href="ajout-ingredient?id=${recette.id}">Ajouter
					un ingredient</a>
			</c:when>
		</c:choose>
		</br>
			</br>
		<ul>
			<c:forEach items="${ingredients}" var="ingredient">
				<li><c:out value="${ingredient.quantite}" /> <c:out
						value="${ingredient.unit}" /> <c:out value="${ingredient.nom}" /></li>
			</c:forEach>
		</ul>
	</header>
	<h2 id="titreCommentaire">Commentaires</h2>
	<div class="divCommentaire">
		<c:forEach items="${commentaires}" var="commentaire">
			<p>
				<c:out value="${commentaire.auteur}" />
				:
				<c:out value="${commentaire.contenu}" />
			</p>
			<p>
				Note :
				<c:out value="${commentaire.note}" />
				/5
			</p>
			<p>
				<c:out value="${commentaire.dateCreation}" />
			</p>
			<hr>
		</c:forEach>
	</div>
	<form method="post" action="recette?id=<c:out value="${recette.id}" />">
		<input id="auteur" name="auteur" type="text"
			placeholder="Votre
nom *" class="inputChamp" /><br />
		<textarea id="txtCommentaire" name="contenu" rows="4"
			placeholder="Votre commentaire *" class="inputTextArea"></textarea>
		<br /> <label for="note">Note</label><br /> <select name="note"
			id="note" class="select">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select> <br /> <input type="submit" value="Commenter" class="submitBtn" />
	</form>
	<div id="erreur">
		<p>${erreur}</p>
	</div>
</div>





<%@ include file="footer.jsp"%>