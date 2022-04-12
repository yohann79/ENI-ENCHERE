package ihm;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleVenduError;
import bo.ArticleVendu;
import bo.Retrait;

@WebServlet("/Vendre")
public class VendreServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/vendre.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String nomArticle = req.getParameter("nomArticle");
        String description = req.getParameter("description");
        int categorie = Integer.parseInt(req.getParameter("categorie"));
        int prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        Date dateDebutEnchere = (Date) dateFormat.parse(req.getParameter("dateDebutEnchere"));
        Date dateFinEnchere = (Date) dateFormat.parse(req.getParameter("dateFinEnchere"));

        String rue = req.getParameter("rue");
        String codePostal = req.getParameter("codePostal");
        String ville = req.getParameter("ville");

        Calendar calendar = Calendar.getInstance();
        Date dateDuJour = (Date) dateFormat.parse(calendar);

        if (nomArticle.isEmpty() || description.isEmpty() || categorie == 0 || prixInitial == 0 || rue.isEmpty()
                || codePostal.isEmpty() || ville.isEmpty()) {
            req.setAttribute("error", "les champs ne doivent pas etre vide");
            req.getRequestDispatcher("WEB-INF/vendreError.jsp").forward(req, resp);
        } else if (dateDebutEnchere.before(dateDuJour)) {
            req.setAttribute("error", "La date de début ne peux pas etre avant ajourd'hui");
            req.getRequestDispatcher("WEB-INF/vendreError.jsp").forward(req, resp);
        } else if (dateFinEnchere.before(dateDuJour) || dateFinEnchere.before(dateDuJour)) {
            req.setAttribute("error", "La date de fin ne peux pas etre avant ajourd'hui ou avant la date de début");
            req.getRequestDispatcher("WEB-INF/vendreError.jsp").forward(req, resp);
        } else {

            ArticleVendu ArticleVendu = new ArticleVendu();
            ArticleVendu.setNomArticle(nomArticle);
            ArticleVendu.setDescription(description);
            ArticleVendu.setNoCategorie(categorie);
            ArticleVendu.setPrixInitial(prixInitial);
            ArticleVendu.setDateDebutEnchere(dateDebutEnchere);
            ArticleVendu.setDateFinEnchere(dateFinEnchere);

            Retrait Retrait = new Retrait();

            Retrait.setRue(rue);
            Retrait.setCode_postal(codePostal);
            Retrait.setVille(ville);

            try {

            } catch (ArticleVenduError e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("WEB-INF/vendreError.jsp").forward(req, resp);
            } catch (SQLException e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("WEB-INF/vendreError.jsp").forward(req, resp);
            }
        }
    }
}
