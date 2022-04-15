package ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticlesManager;
import bo.ArticleVendu;
import bo.Retrait;
import bo.Utilisateur;

@WebServlet("/Vendre")
public class VendreServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ArticlesManager artcilesManager;

    public void init() {
        artcilesManager = new ArticlesManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/public/securepage/vendre.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nomArticle = req.getParameter("nomArticle");
        String description = req.getParameter("description");
        int categorie = Integer.parseInt(req.getParameter("categorie"));
        int prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        Date dateDebutEnchere = new Date();

        try {
            dateDebutEnchere = dateFormat.parse(req.getParameter("dateDebutEnchere"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date dateFinEnchere = new Date();
        try {
            dateFinEnchere = dateFormat.parse(req.getParameter("dateFinEnchere"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String rue = req.getParameter("rue");
        String codePostal = req.getParameter("codePostal");
        String ville = req.getParameter("ville");

        if (nomArticle.isEmpty() || description.isEmpty() || categorie == 0 || prixInitial == 0 || rue.isEmpty()
                || codePostal.isEmpty() || ville.isEmpty()) {
            req.setAttribute("error", "les champs ne doivent pas etre vide");
            req.getRequestDispatcher("WEB-INF/public/securepage/vendreError.jsp").forward(req, resp);
        } else {

            ArticleVendu ArticleVendu = new ArticleVendu();
            ArticleVendu.setNomArticle(nomArticle);
            ArticleVendu.setDescription(description);
            ArticleVendu.setNoCategorie(categorie);
            ArticleVendu.setPrixInitial(prixInitial);
            ArticleVendu.setDateDebutEnchere(dateDebutEnchere);
            ArticleVendu.setDateFinEnchere(dateFinEnchere);
            //
            Utilisateur user = (Utilisateur) req.getSession().getAttribute("utilisateur");
            ArticleVendu.setNoUtilisateur(user.getNo_utilisateur());

            System.out.println(user.getNo_utilisateur());

            Retrait Retrait = new Retrait();

            Retrait.setRue(rue);
            Retrait.setCode_postal(codePostal);
            Retrait.setVille(ville);

            try {
                Boolean result = artcilesManager.insertArticle(ArticleVendu);
                if (result) {
                    HttpSession session = req.getSession();
                    session.setAttribute("ArticleVendu", ArticleVendu);
                    req.getRequestDispatcher("/Accueil").forward(req, resp);
                } else {
                    String message = "erreur vente format de données non valide";
                    req.setAttribute("error", message);
                    req.getRequestDispatcher("WEB-INF/public/securepage/vendreError.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("WEB-INF/public/securepage/vendreError.jsp").forward(req, resp);
            }
        }
    }
}
