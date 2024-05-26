package model;

public class Moneda {

	private int id;
	private String nombre;
	private String simbolo;
	
	public Moneda() {
		super();
	}

	public Moneda(int id, String nombre, String simbolo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.simbolo = simbolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
