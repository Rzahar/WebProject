package pages;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet(urlPatterns = "/user-info")
public class UserInfo extends HttpServlet {
/**
 * Class Java qui va servir à l'affichage de l'utilisateur courant
 */
	public UserInfo() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");

			// Redirection du user s'il n'est pas connecté
		if (user == null) {
			response.sendRedirect(this.getServletContext().getContextPath() + "/session");
			return;
		}

		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Informations utilisateur</h1>");
		out.println("<p>UID : " + user.getUID() + "</p>");
		out.println("<p>Pseudo : " + user.getPseudo() + "</p>");
		out.println("<p>mail : " + user.getMail() + "</p>");
		out.println("<p>Status : " + user.getStatus() + "</p>");
		out.println("<a href='logout'>Me deconnecter</a>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
