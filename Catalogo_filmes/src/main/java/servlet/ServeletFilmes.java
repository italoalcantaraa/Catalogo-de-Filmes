package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmes.Filmes;
import filmes.ListFilmes;

@WebServlet("/ServeletFilmes")
public class ServeletFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeletFilmes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		try {
			String nome = request.getParameter("nome");
			String classificacao = request.getParameter("classificacao");
			String url= request.getParameter("url");
			
			String styleClassificacao = "";
			if(nome == null || nome == "" || url == null || url == "") {
				request.setAttribute("erro", "*Informe os campos*");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				return;
			}
			
			
			if(classificacao.equalsIgnoreCase("L"))
				styleClassificacao = "green";
			else if(classificacao.equalsIgnoreCase("10"))
				styleClassificacao = "blue";
			else if(classificacao.equalsIgnoreCase("12"))
				styleClassificacao = "yellow";
			else if(classificacao.equalsIgnoreCase("14"))
				styleClassificacao = "orange";
			else if(classificacao.equalsIgnoreCase("16"))
				styleClassificacao = "red";
			else 
				styleClassificacao = "black";
		
			// Adiciona o filme
			ListFilmes.filmesList.add(new Filmes(nome, url, classificacao, styleClassificacao));
		
			//Deixa os campos vazios após adicionar um filme
			nome = null;
			classificacao = null;
			url = null;
			
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}