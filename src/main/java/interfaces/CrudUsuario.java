package interfaces;

import java.util.List;
import model.Usuario;

public interface CrudUsuario {

	public List<Usuario> obtenerTodoCuenta();

	public Double consultarUsuarioPorRun(String run);

	public void insertarUsuario(Usuario usuario);

	public void actualizarUsuario(Usuario usuario);

	public void eliminarUsuario(int id);

}
