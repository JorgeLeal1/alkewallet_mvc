package model;

public class Cliente {

	private String run;
	private String nombre1;
	private String nombre2;
	private String appaterno;
	private String apmaterno;

	public Cliente() {

	}

	public Cliente(String run, String nombre1, String nombre2, String appaterno, String apmaterno) {
		this.run = run;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.appaterno = appaterno;
		this.apmaterno = apmaterno;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getAppaterno() {
		return appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	
}
