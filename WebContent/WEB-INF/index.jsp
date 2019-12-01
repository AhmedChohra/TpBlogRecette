<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>



<div id="global">
	<c:choose>
		<c:when test="${not empty sessionScope.membre}">
			<a class="primaryBtn ajoutRecette" href="ajout-recette">Ajouter
				une recette</a>
		</c:when>
	</c:choose>
	<div id="categorie">
		<ul>
			<c:forEach items="${categories}" var="categorie">
				<li><a
					href="categorie?idCategorie=<c:out value="${categorie.id}" />"><c:out
							value="${categorie.nom}" /></a></li>
			</c:forEach>
		</ul>
	</div>
	<c:forEach items="${recettes}" var="recette">
		<article>
			<header>
				<a href="recette?id=<c:out value="${recette.id}" />"><img
					class="imgRecette" src='img/<c:out value="${recette.photo}" />' /></a>

				<a href="recette?id=<c:out value="${recette.id}" />">
					<h1 class="titreRecette">
						<c:out value="${recette.titre}" />
					</h1>
				</a>
				<time>
					<c:out value="${recette.dateCreation} " />
				</time>
			</header>
			<p>
				<c:out value="${recette.description} " />
			</p>
		</article>
		<br>
	</c:forEach>
	<hr />
</div>






<%@ include file="footer.jsp"%>