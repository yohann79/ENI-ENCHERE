package ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Utilisateur;
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet{
	Utilisateur utilisateur =new Utilisateur();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		session.setAttribute("utilisateur",utilisateur);
		req.getRequestDispatcher("WEB-INF/accueil.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	
	
	

}
