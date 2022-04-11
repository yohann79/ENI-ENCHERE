package ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ErrorInsertUtilisateur;
import bll.UtilisateurManager;
import bo.Utilisateur;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;

	public void init() {
		utilisateurManager = new UtilisateurManager();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/inscription.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pseudo = req.getParameter("pseudo");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String tel = req.getParameter("telephone");
		String rue = req.getParameter("rue");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		String motDePasse = req.getParameter("motDePasse");
		String verifMotDePasse = req.getParameter("confirmMotDePasse");

		if (pseudo.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || tel.isEmpty() || rue.isEmpty()
				|| codePostal.isEmpty() || ville.isEmpty() || motDePasse.isEmpty() || verifMotDePasse.isEmpty()) {
			req.setAttribute("error", "les champs ne doivent pas etre vide");
			req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
		} else {
			if (motDePasse.compareTo(verifMotDePasse) != 0) {
				req.setAttribute("error", "erreur mots de passe different");
				req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
			} else {

				String regExpression = "[\\p{Alpha}\\p{Digit}]";
				boolean pseudoNonConforme = pseudo.matches(regExpression);

				if (pseudoNonConforme) {
					req.setAttribute("error", "Le pseudo ne peut pas contenir de caractere spéciaux");
					req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
				} else {

					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setPseudo(pseudo);
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setEmail(email);
					utilisateur.setTelephone(tel);
					utilisateur.setRue(rue);
					utilisateur.setCode_postal(codePostal);
					utilisateur.setVille(ville);
					utilisateur.setMot_de_passe(motDePasse);
					try {
						try {
							Boolean result = utilisateurManager.insertUtilisateur(utilisateur);
							if (result) {
								HttpSession session = req.getSession();
								session.setAttribute("utilisateur", utilisateur);
								req.getRequestDispatcher("/Accueil").forward(req, resp);
							} else {
								String message = "erreur inscription format de données non valide";
								req.setAttribute("error", message);
								req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
							}
						} catch (ErrorInsertUtilisateur e) {
							req.setAttribute("error", e.getMessage());
							req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
						}
					} catch (SQLException e) {
						req.setAttribute("error", e.getMessage());
						req.getRequestDispatcher("WEB-INF/inscriptionError.jsp").forward(req, resp);
					}
				}
			}
		}

	}
}