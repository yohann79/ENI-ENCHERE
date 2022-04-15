package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {

    private static DataSource dataSource;

    static {
        try {
        	//set up du pool de connexion en récupérant les infos depuis le contextet.xml
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("Impossible d'acc�der � la base de donn�es.");
        }

    }

    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

}
