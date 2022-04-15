package filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = { "/Enchere", "/Profil", "/Vendre", "/ModifierProfil", "/Deconnexion" })
public class LoginFiltre implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        if (session.getAttribute("utilisateur") == null) {
            response.sendRedirect(request.getContextPath() + "/Accueil"); // Si utilisateur non trouv� on rediriger
                                                                          // vers la connexion
        } else {
            chain.doFilter(req, res); // utilisateur trouver -> continuer la requete
        }
    }

    @Override
    public void destroy() {

    }

}