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
        req.getRequestDispatcher("/WEB-INF/public/securepage/modifProfil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        HttpSession session = req.getSession();
        Utilisateur utilisateur = new Utilisateur();
        Utilisateur utilisateur_avant_modif = (Utilisateur) session.getAttribute("utilisateur");
        String mpd = req.getParameter("motDePasse");
        String confirmMpd = req.getParameter("confirmMotDePasse");
        System.out.println(mpd + confirmMpd);
        if (mpd.equals(confirmMpd)) {
            System.out.println("test if");
            utilisateur.setNo_utilisateur(Integer.valueOf(utilisateur_avant_modif.getNo_utilisateur()));
            utilisateur.setPseudo(req.getParameter("pseudo"));
            utilisateur.setNom(req.getParameter("nom"));
            utilisateur.setPrenom(req.getParameter("prenom"));
            utilisateur.setEmail(req.getParameter("email"));
            utilisateur.setTelephone(req.getParameter("telephone"));
            utilisateur.setRue(req.getParameter("rue"));
            utilisateur.setCode_postal(req.getParameter("codePostal"));
            utilisateur.setVille(req.getParameter("ville"));
            utilisateur.setCredit(utilisateur_avant_modif.getCredit());
            utilisateur.setMot_de_passe(req.getParameter("motDePasse"));
            try {
                System.out.println("try");
                Boolean modifValider = utilisateurManager.modifierUtilisateur(utilisateur);
                if (modifValider) {
                    session.removeAttribute("utilisateur");
                    session.setAttribute("utilisateur", utilisateur);
                    req.getRequestDispatcher("/Accueil").forward(req, resp);
                } else {
                    System.out.println("catch");
                    req.getRequestDispatcher("WEB-INF/public/securepage/modifProfilError.jsp").forward(req, resp);
                }
            } catch (ErrorModifParameters e) {
                req.getRequestDispatcher("WEB-INF/public/securepage/modifProfilError.jsp").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher("WEB-INF/public/securepage/modifProfilError.jsp").forward(req, resp);
        }
    }

}
