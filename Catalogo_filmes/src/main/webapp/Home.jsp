<%@page import="filmes.Filmes"%>
<%@page import="filmes.ListFilmes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleH.css">
</head>
<body>
	<div class="container">
		<div class="cabecalho">
			<h1>JavaWeb</h1>
		</div>
		<div class="pesquisa-">
		</div>
		<div class="conteudo">
			<div class="cadastro">
				<p id="titulo">Catálogo de Filmes</p>
				<form action="ServeletFilmes" method="post">
					<input type="text" name="nome" placeholder="Nome do Filme">
					
					<select style="padding: 8px; border: 2px solid #DFDFDF;border-radius: 3px; color: #606060;" name="classificacao">
						<option value="L">Livre</option>
						<option value="10">10</option>
						<option value="12">12</option>
						<option value="14">14</option>
						<option value="16">16</option>
						<option value="18">18</option>
					</select>
					<input type="text" name="url" placeholder="URL da capa"> <input
						id="enviar" type="submit" value="Adicionar">
						<div style="display: flex; justify-content: center; color: red; width: 100%; font-size: 15px;">
						<p>
							<% String nome = (String)request.getAttribute("erro"); 
							if(nome != null)	
							out.print(nome);
							%>
						<p/>
						</div>
				</form>
				 
			</div>
		</div>
	
		<div style="display: flex; flex-wrap: wrap; padding-left: 20px; gap: 24px">
		<%

			if(!ListFilmes.filmesList.isEmpty()) {
				for(Filmes f: ListFilmes.filmesList) {
					if(f != null) {
						out.print("<div class=\"filmes\">");
						out.print("<img src=\" " +f.getUrl() +"\" >");
						out.print("<div>");
						out.print("<p> "+ f.getNome() + "</p>");
						out.print("<p id=\"classificacao\" style=\"background-color: " + f.getCor()+ "\">" + f.getClassificacao() + "</p>");
						out.print("</div>");
						out.print("</div>");						
					}
				}
			}	
		%>
		</div>
	
		
	</div>
</body>
</html>