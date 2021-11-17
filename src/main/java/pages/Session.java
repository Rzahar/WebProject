package pages;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.User;

@WebServlet(urlPatterns = "/session")
public class Session extends HttpServlet{
	
	public Session(){}
	
	
	@Override 
	protected void doGet(
				HttpServletRequest request,
				HttpServletResponse response) 
				throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = new User("KPO52L","Toto","toto@toto.fr","Admin");
		session.setAttribute("USER", user);
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Page de connexion</h1>");
		out.println("<h3>Bienvenu " + user.getPseudo());
		out.println("<h3>Vous etes bien connecté sur notre site</h3>");
		out.println("<a href='user-info'>Voir mes infos utilisateur</a>");
		out.println("<a href='liste-des-articles'>Consulter les articles</a>");
		out.println("<a href='/ExoWebProject2'>Retour à l'accueil</a>");

		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	

}
