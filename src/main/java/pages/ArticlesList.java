package pages;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Articles;
import models.User;

@WebServlet(urlPatterns = "/liste-des-articles")

public class ArticlesList extends HttpServlet {
	
	
	public ArticlesList() {
	}
	
	Articles PHP = new Articles ("Promo sur les formations PHP", "prog", 1);
	Articles PP = new Articles ("Distribution de petits pains gratuits", "Scam",2);
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("USER");

			if (user == null) {
				response.sendRedirect(this.getServletContext().getContextPath() + "/session");
				return;
			}
			ServletOutputStream out = response.getOutputStream();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Liste des articles</h1>");
			out.println("<h2>" + PHP.getTitle() + "</h2>");
			out.println("<h3> Tag associé : " + PHP.getTag() + "</h3>");
			out.println("<h3> Numéro de l'article : " + PHP.getID() + "</h3>");
			
			out.println("<h2>" + PP.getTitle() + "</h2>");
			out.println("<h3> Tag associé : " + PP.getTag() + "</h3>");
			out.println("<h3> Numéro de l'article : " + PP.getID() + "</h3>");
			
			out.println("<a href='logout'>Me deconnecter</a>");
			out.println("</body>");
			out.println("</html>");

		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		}		
			
	}

