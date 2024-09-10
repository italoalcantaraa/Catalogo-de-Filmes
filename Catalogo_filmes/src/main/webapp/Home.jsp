<%@page import="filmes.Filmes"%>
<%@page import="filmes.ListFilmes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleHome.css">
</head>
<body>
	<div class="container">
		<div class="cabecalho">
			<h1>JavaWeb</h1>
		</div>
		<div class="conteudo">
			<div class="cadastro">
				<p id="titulo">Catálogo de Filmes</p>
				<form action="Home.jsp" method="post">
					<input type="text" name="nome" placeholder="Nome do Filme">
					<input type="text" name="classificacao" placeholder="Classificação">
					<input type="text" name="url" placeholder="URL da capa"> <input
						id="enviar" type="submit" value="Adicionar">
				</form>
			</div>

		</div>
		<div
			style="display: flex; flex-wrap: wrap; padding-left: 20px; gap: 15px">

			<%
			try {
				String nome = request.getParameter("nome");
				String classificacao = request.getParameter("classificacao");
				String url = request.getParameter("url");

				if (nome != null && classificacao != null && url != null && nome.length() > 0 && classificacao.length() > 0)
					ListFilmes.filmesList.add(new Filmes(nome, url, classificacao));

				if (!ListFilmes.filmesList.isEmpty()) {
					for (Filmes f : ListFilmes.filmesList) {
				out.print(
						"<div  style=\"display: flex;  flex-direction: column;align-items: center; justfy-content:center; cursor: pointer; border-radius: 10px;box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2); background-color: white;padding: 10px;\" >");
				out.print("<img style=\"width: 160px\" alt=\"\" src=\"" + f.getUrl() + "\">");
				out.print("<p style=\"font-weight: bold; padding: 5px;\"> " + f.getNome() + "</p>");
				out.print("</div>");
					}

				}
			} catch (Exception e) {

			}
			%>
		</div>
	</div>
</body>
</html>