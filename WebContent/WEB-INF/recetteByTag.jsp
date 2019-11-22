<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<div id="global">
	<div id="categorie">
		<h1>#${tag.nom}</h1>
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