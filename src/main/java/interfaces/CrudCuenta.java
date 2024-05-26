package interfaces;

import java.util.List;

import model.Cuenta;

public interface CrudCuenta {

	public List<Cuenta> obtenerTodoCuenta();

	public Double consultarSaldoPorRun(String run);

	public void insertarCuenta(Cuenta cuenta);

	public void actualizarCuenta(Cuenta cuenta);
	
	public void actualizarSaldoCuenta(String run, Double saldo);

	public void eliminarCuenta(int id);
}
