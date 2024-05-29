package model;

public class Cuenta {

	private int id;
	private int nroCuenta;
	private String alias;
	private String Banco;
	private double saldo;	

	//private Moneda moneda;
	private Cliente titular;

	// Constructor
	// ---------------------------------------------

	public Cuenta() {
	}


	public Cuenta( int nroCuenta, String alias, String banco, double saldo, Cliente titular) {
		super();
		this.nroCuenta = nroCuenta;
		this.alias = alias;
		this.Banco = banco;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public String getRun() {
		return titular.getRun();
	}
	
	public String getNombre1() {
		return titular.getNombre1();
	}
	
	public String getNombre2() {
		return titular.getNombre2();
	}
	
	public String getAppaterno() {
		return titular.getAppaterno();
	}
	
	public String getApmaterno() {
		return titular.getApmaterno();
	}
	
	// Metodos GET, SET
	// ---------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getBanco() {
		return Banco;
	}

	public void setBanco(String banco) {
		Banco = banco;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}


}
