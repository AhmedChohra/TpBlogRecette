<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<div id="global">
	<div id="categorie">
		<ul>
			<c:forEach items="${categories}" var="categorie">
				<li class="selected"><a
					href="categorie?idCategorie=<c:out value="${categorie.id}" />"><c:out
							value="${categorie.nom}" /></a></li>
			</c:forEach>
		</ul>
	</div>
	<c:forEach items="${recettes}" var="recette">
		<article>
			<header>
				<img class="imgRecette" src="img/<c:out value="${recette.photo}" />"
					width="300px" height="242px" alt="<c:out value="${recette.titre}" />" /> <a
					href="recette?id=<c:out value="${recette.id}" />">
					<h1 class="titreRecette"><c:out value="${recette.titre}" /></h1>
				</a>
				<time> <c:out value="${recette.dateCreation}" /> </time>
			</header>
			<p><c:out value="${recette.description}" /></p>
		</article>
	</c:forEach>
	<hr />
</div>







<%@ include file="footer.jsp"%>>
</html>