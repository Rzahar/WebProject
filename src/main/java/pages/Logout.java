package pages;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{
	
	public Logout(){}
	
	
	@Override 
	protected void doGet(
				HttpServletRequest request,
				HttpServletResponse response) 
				throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("USER", null);
		
		response.sendRedirect(this.getServletContext().getContextPath() 
					+ "/showMe");
		return;
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	

}
