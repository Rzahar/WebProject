package filters;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "filterTestExo", urlPatterns = "/session")
public class Admin implements Filter {


	public Admin() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Admin init");
	}

	/*
	 * if (user != null) { request.getSession().setAttribute("user", user);
	 * response.sendRedirect(request.getContextPath() + "/home"); return;
	 */
	public void destroy() {
		// Destructeur
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpSession Session = ((HttpServletRequest)req).getSession();
		HttpServletRequest request = (HttpServletRequest) req;
		String servletPath = request.getServletPath();

		filterChain.doFilter(req, res);
		// Je récupère le statut de l'utilisateur
		String status = request.getParameter("status");
		// S'il n'est pas admin, je le redirige vers la page Home
		if (status != "admin") {
			HttpServletResponse httpResponse = (HttpServletResponse) res;
			httpResponse.sendRedirect("/Home");
			return;
		}

	}
}
