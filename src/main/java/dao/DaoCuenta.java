package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interfaces.CrudCuenta;
import model.Cliente;
import model.Cuenta;

public class DaoCuenta implements CrudCuenta {

	private Connection conexion;

	public DaoCuenta(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public List<Cuenta> obtenerTodoCuenta() {

		// selecciona todos los registros de la bd ordenado por run cliente
		String consultaSQL = "SELECT id, nroCuenta, alias, banco, saldo, run_cliente FROM cuenta order by run_cliente";
		List<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(consultaSQL);

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String run_cliente = resultSet.getString("run_cliente");
				int nroCuenta = resultSet.getInt("nroCuenta");
				String alias = resultSet.getString("alias");
				String banco = resultSet.getString("banco");
				Double saldo = resultSet.getDouble("saldo");

				//Crea objeto cliente
				Cliente cliente = new Cliente();
				//setea run cliente
				cliente.setRun(run_cliente); 
				
				//crea objeto cuenta
				Cuenta c = new Cuenta(nroCuenta, alias, banco, saldo, cliente);

				// se muestran por consola el resultado
				// System.out.println("ID: " + id + ", saldo: " + saldo + ", nroCuenta: " +
				// nroCuenta);

				// Se añaden en cada ciclo los objetos al listado
				c.setId(id);
				c.getTitular().getRun();
				c.setNroCuenta(nroCuenta);
				c.setAlias(alias);
				c.setBanco(banco);
				c.setSaldo(saldo);

				lista.add(c);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta: " + e.getMessage());
		}
		return lista;
	}

	@Override
	public Double consultarSaldoPorRun(String run) {
		
		//obtiene los registros por run ingresado
        String consulta = "SELECT * FROM cuenta WHERE run_cliente = ?";
        try {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, run);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            
            	//Cliente cliente = new Cliente();
            	//return new Cuenta(rs.getInt("nroCuenta"), rs.getString("alias"), rs.getString("banco"),  rs.getDouble("saldo"), cliente);
            	//System.out.println( new Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price")));
            	
            	//retorna el saldo
            	return rs.getDouble("saldo");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el Producto: " + e.getMessage());
        }
		return 0.0;

	}
	
	
	@Override
	public void insertarCuenta(Cuenta cuenta) {
		// Cuenta cuenta = new Cuenta(nroCuenta, alias, banco, saldo, cliente);

		//Inserta cuenta 
		String consulta_cuenta = "INSERT INTO cuenta (nroCuenta, alias, banco, saldo, run_cliente) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(consulta_cuenta);

			ps.setInt(1, cuenta.getNroCuenta());
			ps.setString(2, cuenta.getAlias());
			ps.setString(3, cuenta.getBanco());
			ps.setDouble(4, cuenta.getSaldo());
			ps.setString(5, cuenta.getTitular().getRun());

			ps.executeUpdate();

			System.out.println("Cuenta creada correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear el Producto: " + e.getMessage());
		}

		// public Cliente(String run, String nombre1, String nombre2, String appaterno,
		// String apmaterno) {
		
		//Inserta cliente 
		String consulta_cliente = "INSERT INTO cliente (run, nombre1, nombre2, appaterno, apmaterno) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps2 = conexion.prepareStatement(consulta_cliente);

			ps2.setString(1, cuenta.getTitular().getRun());
			ps2.setString(2, cuenta.getTitular().getNombre1());
			ps2.setString(3, cuenta.getTitular().getNombre2());
			ps2.setString(4, cuenta.getTitular().getAppaterno());
			ps2.setString(5, cuenta.getTitular().getApmaterno());

			ps2.executeUpdate();

			System.out.println("Cliente creado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear el Producto: " + e.getMessage());
		}

	}

	/*
	 * public Producto consultarUsuarioPorId(int id) { String consulta =
	 * "SELECT id, name, price FROM product WHERE id = ?"; try { PreparedStatement
	 * ps = conexion.prepareStatement(consulta); ps.setInt(1, id); ResultSet rs =
	 * ps.executeQuery(); if (rs.next()) { // return new Producto(rs.getInt("id"),
	 * rs.getString("name"), rs.getString("price")); System.out.println( new
	 * Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price"))); } }
	 * catch (SQLException e) {
	 * System.err.println("Error al consultar el Producto: " + e.getMessage()); }
	 * return null; }
	 */

	@Override
	public void actualizarCuenta(Cuenta cuenta) {

		/*
		 * String consulta = "UPDATE product SET name = ?, price = ? WHERE id = ?"; try
		 * { PreparedStatement ps = conexion.prepareStatement(consulta); ps.setString(1,
		 * producto.getName()); ps.setString(2, producto.getPrice()); ps.setInt(3,
		 * producto.getId()); ps.executeUpdate();
		 * System.out.println("Producto actualizado correctamente."); } catch
		 * (SQLException e) { System.err.println("Error al actualizar el Producto: " +
		 * e.getMessage()); }
		 */

	}

	@Override
	public void actualizarSaldoCuenta(String run, Double saldo) {
		
		//Actualiza saldo por run cliente
        String consulta = "UPDATE cuenta SET saldo = ? WHERE run_cliente = ?";
        try
        {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
        	ps.setDouble(1, saldo);
            ps.setString(2, run);
            ps.executeUpdate();
            System.out.println("Saldo actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el Producto: " + e.getMessage());
        }
	};
	
	@Override
	public void eliminarCuenta(int id) {
		/*
		 * String consulta = "DELETE FROM product WHERE id = ?"; try { PreparedStatement
		 * ps = conexion.prepareStatement(consulta); ps.setInt(1, id);
		 * ps.executeUpdate(); System.out.println("Producto eliminado correctamente.");
		 * } catch (SQLException e) {
		 * System.err.println("Error al eliminar el Producto: " + e.getMessage()); }
		 */

	}

}
