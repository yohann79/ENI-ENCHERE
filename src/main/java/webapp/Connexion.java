package webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.Utilisateur;

@RestController
public class Connexion{

	
	@GetMapping("/test")
	public  String testConnexion() {
	return "test";
}
	@GetMapping("/error")
	public String error() {
		return "erreur";
		
	}
}
