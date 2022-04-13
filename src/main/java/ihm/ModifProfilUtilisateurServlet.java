package ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ErrorModifParameters;
import bll.UtilisateurManager;
import bo.Utilisateur;

@WebServlet("/ModifierProfil")
public class ModifProfilUtilisateurServlet extends HttpServlet {
    private UtilisateurManager utilisateurManager;

    public void init() {
        utilisateurManager = new UtilisateurManager();
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/public/securepage/modifProfil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNo_utilisateur(Integer.valueOf(req.getParameter("no_utilisateur")));
        utilisateur.setPseudo(req.getParameter("pseudo"));
        utilisateur.setNom(req.getParameter("nom"));
        utilisateur.setPrenom(req.getParameter("prenom"));
        utilisateur.setEmail(req.getParameter("email"));
        utilisateur.setTelephone(req.getParameter("telephone"));
        utilisateur.setRue(req.getParameter("rue"));
        utilisateur.setCode_postal(req.getParameter("code_postal"));
        utilisateur.setVille(req.getParameter("ville"));
        utilisateur.setCredit(Integer.parseInt(req.getParameter("credit")));
        utilisateur.setMot_de_passe(req.getParameter("mot_de_pass"));

        try {
            Boolean modifValider = utilisateurManager.modifierUtilisateur(utilisateur);
        } catch (ErrorModifParameters e) {
            HttpSession session = req.getSession();
            session.setAttribute("error", e.getMessage());
            session.setAttribute("champ", e);
            req.getRequestDispatcher("WEB-INF/public/securepage/modifProfilError.jsp").forward(req, resp);
        }

    }

}
