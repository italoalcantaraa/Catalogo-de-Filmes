package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

		try (PrintWriter out = response.getWriter()) {
			out.print("<!DOCTYPE html>");
			out.print("<html lang=\"pt-BR\">");
			out.print("<head>");

			out.print("<meta charset=\"UTF-8\">");
			out.print("<title>ViaCep</title>");
			out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"\">");
			out.print("</head>");
			out.print("<body>");

			try {
				ListFilmes listFilmes = new ListFilmes();

				String nome = request.getParameter("nome");
				String url = request.getParameter("url");
				String classificacao = request.getParameter("classificacao");

			} catch (Exception e) {

			}

			out.print("</body>");
			out.print("</html>");

		}
	}

}
