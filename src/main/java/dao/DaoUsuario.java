package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import interfaces.CrudUsuario;
import model.Cuenta;
import model.Usuario;

public class DaoUsuario implements CrudUsuario {

	private Connection conexion;

	public DaoUsuario(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public List<Usuario> obtenerTodoCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double consultarUsuarioPorRun(String run) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		//Inserta usuario
		// 	public Usuario(String nombre, String correo_electronico, String contrasena) {
		String consulta_cliente = "INSERT INTO usuario (nombre, correo_electronico, contrasena, run_cliente) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(consulta_cliente);

			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getCorreo_electronico());
			ps.setString(3, usuario.getContrasena());
			ps.setString(4, usuario.getRun());

			ps.executeUpdate();

			System.out.println("usuario creado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear el Producto: " + e.getMessage());
		}

	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarUsuario(int id) {
		// TODO Auto-generated method stub

	}

}
