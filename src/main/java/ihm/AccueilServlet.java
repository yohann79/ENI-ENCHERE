package ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticlesManager;
import bll.ArticlesNotFound;
import bo.ArticleVendu;
import bo.Utilisateur;

@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	Utilisateur utilisateur;
	ArticlesManager articlesManager;
	private static final long serialVersionUID = 1L;

	public void init() {
		articlesManager = new ArticlesManager();
		utilisateur = new Utilisateur();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();
			utilisateur = (Utilisateur) session.getAttribute("utilisateur");

			ArrayList<ArticleVendu> articles = new ArrayList<>();
			articles = articlesManager.getAllArticles();
			req.setAttribute("articles", articles);
			req.getRequestDispatcher("WEB-INF/accueil.jsp").forward(req, resp);
		} catch (ArticlesNotFound e) {
			req.getRequestDispatcher("WEB-INF/accueilAucuneEnchere.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
