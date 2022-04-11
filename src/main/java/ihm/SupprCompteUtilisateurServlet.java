package ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletDeleteProfil
 */
@WebServlet("/SupprimerProfil")
public class SupprCompteUtilisateurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprCompteUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateur connectedUser = (Utilisateur) session.getAttribute("utilisateur");

        try {

            // On supprime l'utilisateur
            UtilisateurManager.SupprUtilisateur(Utilisateur);

            // On supprime la session
            session.invalidate();

            // On redirige vers la page d'accueil
            this.getServletContext().getRequestDispatcher("/Accueil").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}