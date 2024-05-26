package model;

public class Usuario {

	private int id;
	private String nombre;
	private String correo_electronico;
	private String contrasena;
	
	public Usuario() {

	}

	public Usuario(Integer user_id, String nombre, String correo_electronico, String contrasena) {
		this.id = user_id;
		this.nombre = nombre;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
	}

	public Integer getUser_id() {
		return id;
	}

	public void setUser_id(Integer user_id) {
		this.id = user_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}
