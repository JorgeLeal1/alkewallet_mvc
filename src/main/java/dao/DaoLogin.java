package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.CrudLogin;

public class DaoLogin implements CrudLogin {

	private Connection conexion;

	public DaoLogin(Connection conexion) {
		this.conexion = conexion;
	}

	//Verifica run y login ingresado por login
	@Override
	public boolean validarLogin(String run, String contrasena) {
        String consulta = "SELECT run_cliente, contrasena FROM usuario WHERE run_cliente = ? and contrasena = ?";
        try {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, run);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            //si existe usuario retorna un true sino un false
            if (rs.next()) {
            	return true;
            	// return new Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
            	//System.out.println( new Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price")));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el Producto: " + e.getMessage());
        }
        
        return false;

	}

}
