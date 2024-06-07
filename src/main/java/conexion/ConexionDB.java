package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	//variables para conectarse a mysql con base de datos wallet
	private String url = "jdbc:mysql://localhost:3306/wallet";
	private String usuario = "root";
	private String pass = "";

	public Connection establecerConexion() {
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     return DriverManager.getConnection(url, usuario, pass);
		} catch (ClassNotFoundException | SQLException e) {
		     e.printStackTrace();
		     return null;
		}
	}
}
