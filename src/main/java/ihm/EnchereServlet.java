package ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticlesManager;
import bll.BusinessException;
import bll.EnchereManager;
import bll.ErrorModifArticle;
import bll.ErrorModifParameters;
import bll.UtilisateurManager;
import bo.ArticleVendu;
import bo.Enchere;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletEncherir
 */
@WebServlet("/Enchere")
public class EnchereServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/public/securepage/detailVente.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
        int currentCredit = connectedUser.getCredit();

        int prixEnchere = Integer.parseInt(request.getParameter("mPrix"));
        int idArticle = Integer.parseInt(request.getParameter("idArticle"));

        ArticleVendu articleAffiche = null;
        try {
            articleAffiche = ArticlesManager.selectArticleById(idArticle);
        } catch (BusinessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (articleAffiche != null && prixEnchere > articleAffiche.getPrixInitial()
                && connectedUser.getCredit() >= prixEnchere) {
            Enchere enchere = new Enchere(LocalDate.now(), prixEnchere, articleAffiche, connectedUser);
            articleAffiche.setPrixvente(prixEnchere);

            try {
                EnchereManager.ajoutEnchere(enchere);
                request.setAttribute("mPrix", prixEnchere);
                request.setAttribute("meilleureEnchere", enchere);
                try {
                    ArticlesManager.getModifArticle(articleAffiche);
                } catch (ErrorModifArticle | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                connectedUser.setCredit(currentCredit - prixEnchere);
                UtilisateurManager.modifierUtilisateur(connectedUser);
            } catch (BusinessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ErrorModifParameters e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.getRequestDispatcher("WEB-INF/public/home/Accueil.jsp").forward(request, response);
        }

    }

}