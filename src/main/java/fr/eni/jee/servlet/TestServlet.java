package fr.eni.jee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eniEncheres.bo.Utilisateur;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see est appelé lorsqu'on effectue une requete de type GET sur l'url : http://localhost:8080/TestServlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: localhost:8080/TestServlet ").append(request.getMethod());
		response.getWriter().append("test");
		 bo.Utilisateur utilisateur= new bo.Utilisateur(1,"nom","prenom"
				 ,"pseudo","email","telephone",
         		"rue",
         		"code_postal",
         		"ville",
         		"mot_de_passe",
         		200,
         		true);
		 response.getWriter().append(utilisateur.getNom());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
