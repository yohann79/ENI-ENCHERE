package ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.Util;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletDeleteProfil
 */
@WebServlet("/SupprimerProfil")
public class SupprCompteUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager;

	public void init() {
		utilisateurManager = new UtilisateurManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("utilisateur");

		try {

			// On supprime l'utilisateur
			Boolean result = utilisateurManager.supprUtilisateur(connectedUser);
			if (result) {
				// On supprime la session
				session.invalidate();

				// On redirige vers la page d'accueil
				req.getRequestDispatcher("/Accueil").forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			req.getRequestDispatcher("WEB-INF/profil.jsp").forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);

	}
}