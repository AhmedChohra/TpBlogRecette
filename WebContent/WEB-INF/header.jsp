<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<script src="https://code.iconify.design/1/1.0.3/iconify.min.js"></script>
</head>
<body>
	<header id="header">
		<a href="index"><h1 id="titreBlog">Mon Blog de Recettes</h1></a>
		<div style="width: 300px; margin: 20px auto;">Bienvenue sur mon
			blog de recettes</div>
		<div id="loginBar">

			<c:choose>
				<c:when test="${empty sessionScope.membre.nom}">

					<div class="insciption">
						<a class="primaryBtn inscription" href="inscription">Inscription</a>
					</div>
					<div class="login">
						<a class="primaryBtn login" href="login">Se connecter</a>
					</div>
				</c:when>
				<c:otherwise>
					<span class="erreur">Bienvenu
						${sessionScope['membre'].pseudo}
						<div class="deconnection">
							<a class="primaryBtn login" href="deconnection">Se
								deconnecter</a>
						</div>
						<div class="login">
							<a class="primaryBtn deconnection" href="tag">Administration
								des tags</a>
						</div>
				</c:otherwise>
			</c:choose>

		</div>
	</header>