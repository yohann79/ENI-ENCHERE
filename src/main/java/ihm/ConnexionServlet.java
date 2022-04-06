package ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateurManager;
import bll.UtilisateurNotFound;
import bo.Utilisateur;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;

	public void init() {
		utilisateurManager = new UtilisateurManager();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);
	}

	/*
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String mpd = req.getParameter("password");
		try {
			Utilisateur utilisateur = utilisateurManager.seConnecter(user, mpd);
			HttpSession session = req.getSession();
			session.setAttribute("utilisateur", utilisateur);
			resp.sendRedirect(req.getContextPath() + "/Accueil");
		} catch (UtilisateurNotFound e) {
			this.doGet(req, resp);
		}

	}

}
